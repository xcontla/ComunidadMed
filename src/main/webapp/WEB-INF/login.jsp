<%-- 
    Document   : login
    Created on : 4/06/2018, 06:42:16 PM
    Author     : UNAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html  ng-app="indexINSTR" ng-cloak ng-init="portalOAE = '${pageContext.request.contextPath}'">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="">
        <meta name="keywords" content="UNAM,DGOAE,orientacion,asesoria,carrera,posgrado,psicologia,dudas">
        <meta name="author" content="XavierContla">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"><!-- Angular y Controllers -->
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular-sanitize2.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular-route.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular-block-ui.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/controllers/index.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/additionals/Chart.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular-chart.js"></script>
        <title>INICIO SESION</title>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/angular/angular-block-ui.css" rel="stylesheet"/>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/favicon.ico" type="image/x-icon" />
    </head>
    <body ng-controller="indexCtrl" ng-cloak>
            
            <div class="container">
                <div class="span12">
                    <br/>
                    <div class="jumbotron"><h1>Inicio de Sesión</h1></div>      
                    <c:if test="${not empty result}">
                        <h2 class="text-success">${result}</h2>
                    <h2 class="text-success">${curp}</h2>
                    <h2 class="text-success">${pass}</h2>
                    </c:if>
                    <form action="${pageContext.request.contextPath}/perform_login" method="post">
                        <table style="width: 650px" class="table table-striped">
                            <tr><td>Identificador:</td>
                                <td><input type="text" name="username" value="${username}" required autofocus/></td>
                            </tr>
                            <tr>
                                <td>Contraseña:</td>
                                <td> <input type="password" name="password" value="${pass}" required /></td>
                            </tr>
                            <tr>
                                <td colspan="2"><button type="submit" class="btn btn-default">Ingresar</button></td>
                                <td></td>
                            </tr>
                        </table>
                    </form><hr>
                </div>
            </div>
                    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    </body>
</html>
