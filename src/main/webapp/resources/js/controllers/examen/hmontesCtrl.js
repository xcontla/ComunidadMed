/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




indexINSTR.controller("hmontesCtrl", function ($scope, $location, blockUI, indexSvc, examenSvc, hmontesSeccion) {

    $scope.alumnohome = true;
    $scope.staticRole = "Alumno";
    $scope.hmontesPreguntas = {};
    console.log($location.absUrl());

    $scope.getName = function(){
        
        alumnoSvc.getName().then(
                function (data) {
                    $scope.navname = data.username;
                },
                function (error) {
                    $scope.navname = "";
                    console.log("getName->Error: ", error);
                });
        $scope.navHome = true;
    };


    $scope.showHmontesData = function (examen) {

        var nombre = hmontesSeccion[examen].nombre; 
        var idex = hmontesSeccion[examen].id;
        var tiempo = hmontesSeccion[examen].tiempo;
        var nreactivos = hmontesSeccion[examen].nReactivos;
        var sigSeccion = hmontesSeccion[examen].sigseccion;
        $scope.acronimo = hmontesSeccion[examen].acronimo;

        console.log(nombre, idex, tiempo, nreactivos, sigSeccion);

        $scope.curPage = 0;
        $scope.pageSize = 15;

        $scope.datalength = 1;
        $scope.respuestasHmontes = new Array(nreactivos);

        $scope.deadlineMillis = 0;
        $scope.timerRunning = false;

        $scope.hmontesPreguntas = examenSvc.getHmontesByIds(idex).then(function (data) {
            console.log(data);
            $scope.hmontesPreguntas = data;
            llenaRespuestas();
            $scope.getTimeStarted(tiempo);
        }, function (error) {
            console.log("getProunamByIds->Error: ", error);
        });

        var llenaRespuestas = function () {

            if (isEmpty($scope.hmontesPreguntas)) {
                $scope.respuestasHmontes = new Array(nreactivos);
                return;
            }
            var i = 0;
            for (i = 0; i < nreactivos; i++) {
                $scope.respuestasHmontes[i] = { 'preguntaExamenId': $scope.hmontesPreguntas.preguntas[i].preguntaExamenId, 
                                                'preguntaId': $scope.hmontesPreguntas.preguntas[i].preguntaId, 
                                                'opcionId': null, 
                                                'opcionIndice': null, 
                                                'idExamen': 1, 
                                                'acronimo': $scope.acronimo};
            }

            console.log("queRespuestas ->" , $scope.respuestasHmontes);
        };

        $scope.numberOfPages = function () {
            if ($scope.hmontesPreguntas !== null)
                $scope.datalength = $scope.hmontesPreguntas.preguntas.length;
            return Math.ceil($scope.datalength / $scope.pageSize);
        };


        var salvarRespuestas = function () {
            console.log("Salvando respuestas");
            examenSvc.saveHmontesAnswersByExamenId($scope.respuestasHmontes).then(
                    function (data) {
                        console.log(data);
                        
                    },
                    function (error) {
                        $location.path("/myHome");
                        console.log("examenSvc.saveHmontesAnswersByExamenId()->Error: ", error);
                    });

            $location.path(sigSeccion);
            if (idex === 13) {
                console.log("Calificar");
            }
        };

        $scope.getRespuestasHyM = function () {
            console.log("Respuestas !!!!!!!!!", $scope.respuestasHmontes);
            var i;
            for (i = 0; i < nreactivos; i++) {
                console.log("Respuesta " + i + " :" + $scope.respuestasHmontes[i]);
                if ($scope.respuestasHmontes[i].opcionId === null) {
                    alert("Tienes actividades sin responder en la página " + (Math.floor(i / $scope.pageSize) + 1));
                    return;
                }
            }
            console.log("mandar las respuestas a la base");
            salvarRespuestas();
        };

        $scope.getTimeStarted = function (deadline) {
            $scope.$broadcast('timer-start');
            $scope.timerRunning = true;
            $scope.deadlineMillis += deadline * 1000 * 60;
        };

        $scope.getTimeFinished = function () {
            $scope.$broadcast('timer-stop');
            $scope.deadlineMillis = 0;
            $scope.timerRunning = false;

        };
        $scope.$on('timer-tick', function (event, data) {
            if ($scope.timerRunning && data.millis >= $scope.deadlineMillis) {
                $scope.$apply($scope.timeOver);
            }
        });
        $scope.timeOver = function () {
            $scope.getTimeFinished();
            salvarRespuestas();

        };
        $scope.skipToNext = function () {
            $location.path(sigSeccion);
        };
    };

});

