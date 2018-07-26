/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global consol */

var name = "indexINSTR";
var requires = ["ngSanitize","ngRoute", "blockUI",  "chart.js"];
var indexINSTR = null;

indexINSTR = angular.module(name, requires);


indexINSTR.constant('mainURL', {
    contextPath: "/ComunidadMED",
    usuarioPath: "/usuario/home.dgoae",
    usuarioDataPath: "/usuario/home.dgoae/data",
    hymPath: "/usuario/home.dgoae/hym",
    herrerymontes: "/getExamenByIds/ide/1/idp/1/ids/",
});


indexINSTR.constant('hmontesSeccion', [
    {nombre: "intereses", id: 2, tiempo: 25, nReactivos: 60, sigseccion: "/hymAptitudesInstrucciones", acronimo: "APT"},
    {nombre: "aptitudes", id: 3, tiempo: 25, nReactivos: 60, sigseccion: "/finalHerreraYmontes", acronimo: "INT"}
]);



indexINSTR.config(function ($routeProvider, mainURL) {

    $routeProvider
            .when("/myHome", {
                templateUrl: function () {
                    return mainURL.contextPath + mainURL.usuarioPath + "/principal";
                },
                controller: "indexCtrl"
            })
            .when("/herreraYmontesInfo", {
                templateUrl: mainURL.contextPath + mainURL.hymPath + "/herreraYmontesInfo",
                controller: "hmontesCtrl"
            }).when("/hymInstrucciones", {
        templateUrl: mainURL.contextPath + mainURL.hymPath + "/hymInstrucciones",
        controller: "hmontesCtrl"
    }).when("/hymAptitudesInstrucciones", {
        templateUrl: mainURL.contextPath + mainURL.hymPath + "/hymAptitudesInstrucciones",
        controller: "hmontesCtrl"
    }).when("/hymInteresesInstrucciones", {
        templateUrl: mainURL.contextPath + mainURL.hymPath + "/hymInteresesInstrucciones",
        controller: "hmontesCtrl"
    }).when("/hymAptitudes", {
        templateUrl: mainURL.contextPath + mainURL.hymPath + "/hymAptitudes",
        controller: "hmontesCtrl"
    }).when("/hymIntereses", {
        templateUrl: mainURL.contextPath + mainURL.hymPath + "/hymIntereses",
        controller: "hmontesCtrl"
    }).when("/finalHerreraYmontes", {
        templateUrl: mainURL.contextPath + mainURL.hymPath + "/finalHerreraYmontes",
        controller: "hmontesCtrl"
    }).when("/resultadosHyM", {
        templateUrl: mainURL.contextPath + mainURL.usuarioPath + "/resultadosHyM",
        controller: "indexCtrl"
    }).otherwise({redirectTo: "/myHome"});
});

/**
 * Declarar los servicios
 */


indexINSTR.factory("indexSvc", function ($http, $q, mainURL) {
    var saveData = {};
    function set(data) {
        saveData = data;
    }
    function get() {
        return saveData;
    }
    return {
        set: set,
        get: get,
        getName: function () {

            var deffered = $q.defer();
            $http.get(mainURL.contextPath + mainURL.usuarioDataPath + '/getName')
                    .success(function (data) {
                        deffered.resolve(data);
                    })
                    .error(function (error) {
                        console.log(error);
                        deffered.reject(error);

                    });
            return deffered.promise;
        },

        getExamenesHyM: function () {
            var deffered = $q.defer();
            $http.get(mainURL.contextPath + mainURL.usuarioDataPath + '/getExamenes').success(
                    function (data) {
                        deffered.resolve(data);
                    }).error(
                    function (error) {
                        deffered.reject(error);
                    });
            return deffered.promise;
        },
        getResultadosHyM: function(postData){
            var deffered = $q.defer();
            $http.post(mainURL.contextPath + mainURL.hymPath + '/getResultados', postData).success(
                    function (data) {
                        deffered.resolve(data);
                    }).error(
                    function (error) {
                        deffered.reject(error);
                    });
            return deffered.promise;
            
        },
        getExplicacionInteres: function(postData){
            var deffered = $q.defer();
            $http.get(mainURL.contextPath + mainURL.hymPath + '/getInterpretacionInteres/interes/'+ postData).success(
                    function (data) {
                        deffered.resolve(data);
                    }).error(
                    function (error) {
                        deffered.reject(error);
                    });
            return deffered.promise;
            
        },
        getExplicacionAptitud: function(postData){
            var deffered = $q.defer();
            $http.get(mainURL.contextPath + mainURL.hymPath + '/getInterpretacionAptitud/aptitud/'+ postData).success(
                    function (data) {
                        deffered.resolve(data);
                    }).error(
                    function (error) {
                        deffered.reject(error);
                    });
            return deffered.promise;
            
        }

    };
});

indexINSTR.factory("examenSvc", function ($http, $q, mainURL) {
    return {

        getHmontesByIds: function (ids) {
            var deferred = $q.defer();
            $http.get(mainURL.contextPath + mainURL.hymPath + mainURL.herrerymontes + ids)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        deferred.reject(error);
                    });
            return deferred.promise;
        },
        saveHmontesAnswersByExamenId: function (postData) {
            var deferred = $q.defer();
            $http.post(mainURL.contextPath + mainURL.hymPath + '/saveHyMAnswersByExamenId', postData)
                    .success(function (data) {
                        console.log(data);
                        deferred.resolve(data);
                    })
                    .error(function (error) {
                        console.log(error);
                        deferred.reject(error);
                    });
            return deferred.promise;
        }
    };
});


/**
 * Declarar a los controladores
 * Esto puede separarse!!! o separar los partiales de div
 */
indexINSTR.controller("indexCtrl", function ($scope, indexSvc) {


    $scope.getName = function () {

        indexSvc.getName().then(
                function (data) {
                    $scope.navname = data.username;
                },
                function (error) {
                    $scope.navname = "";
                    console.log("getName->Error: ", error);
                });

        $scope.navHome = true;
    };

    $scope.verExamenes = function () {
        indexSvc.getExamenesHyM().then(
                function (data) {
                    console.log(data);
                    $scope.examenesHyM = data;
                    $scope.existe = data.existe;
                    indexSvc.set(data);
                },
                function (error) {
                    console.log("getExamenes->Error: ", error);

                });
    };
    
    $scope.resultados = function(){
       $scope.examenesHyM = indexSvc.get();
       var intereses = $scope.examenesHyM.examenes[0];
       var aptitudes = $scope.examenesHyM.examenes[1];
       console.log(intereses);
       console.log(aptitudes);
       
        $scope.grtype = 'bar';
        $scope.colors = ['#FF1700', '#FF2E00', '#FF4500', '#FF5C00', '#FF7300', '#FF8B00', '#FFA200', '#FFB900', '#FFD000', '#FFE700'];
        $scope.colors2 = [ '#316BB2', '#4D8AD7','#6FAFFF','#8FD2D0', '#6DAEAC', '#57918F','#545556', '#7A7F84', '#9FA8B4', '#BFCBDB'];
        $scope.options = {
            scales: {
                yAxes: [{
                        ticks: {
                            beginAtZero: true,
                            max: 100
                        }
                    }],
                xAxes: [{
                        ticks: {
                            beginAtZero: true,
                            max: 100
                        }
                    }]
            }
        };
       
        indexSvc.getResultadosHyM(intereses).then(
                function (data) {
                    //console.log(data);
                    $scope.resutladosHyMI = data.res;
                    console.log($scope.resutladosHyMI);
                },
                function (error) {
                    console.log("getExamenes->Error: ", error);

                });
       
        indexSvc.getResultadosHyM(aptitudes).then(
                function (data) {
                    //console.log(data);
                    $scope.resutladosHyMA = data.res;
                    console.log($scope.resutladosHyMA);
                },
                function (error) {
                    console.log("getExamenes->Error: ", error);

                });
                

        $scope.toggle = function () {

            $scope.grtype = $scope.grtype === 'horizontalBar' ?
                    'radar' : 'horizontalBar';
        };
        
        $scope.getExplicacionInteres = function(interes){
            indexSvc.getExplicacionInteres(interes).then(
                function (data) {
                    console.log(data);
                    $scope.it = data;
                },
                function (error) {
                    console.log("getExplicacionInteres->Error: ", error);

                });
        };
        
        $scope.getExplicacionAptitud = function(aptitud){
            indexSvc.getExplicacionAptitud(aptitud).then(
                function (data) {
                    console.log(data);
                    $scope.apt = data;
                    
                },
                function (error) {
                    console.log("getExplicacionAptitud->Error: ", error);

                });
        };
    };
});



indexINSTR.filter('pagination', function ()
{
    return function (input, start)
    {
        start = +start;
        return input.slice(start);
    };
});

indexINSTR.filter('capitalize', function () {
    return function (input) {
        return (!!input) ? input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : '';
    };
});

function isEmpty(obj) {
    for (var key in obj) {
        if (obj.hasOwnProperty(key))
            return false;
    }
    return true;
}