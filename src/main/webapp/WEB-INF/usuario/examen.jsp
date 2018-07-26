<%-- 
    Document   : index2.jsp
    Created on : 24/10/2017, 01:19:19 PM
    Author     : XavierContla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html ng-app="indexINSTR" ng-cloak="" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="">
        <meta name="keywords" content="UNAM,DGOAE,orientacion,asesoria,carrera,posgrado,psicologia,dudas">
        <meta name="author" content="XavierContla">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Angular y Controllers -->
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular-sanitize2.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular-route.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular-block-ui.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular-timer.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/additionals/Chart.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/angular/angular-chart.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/additionals/humanize-duration.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/additionals/moment.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/controllers/index.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/controllers/examen/hmontesCtrl.js"></script>
        <title>ComunidadMED DGOAE</title>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/resources/css/angular/angular-block-ui.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/resources/css/examenes/pagination.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/resources/css/loader.css" rel="stylesheet"/>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/favicon.ico" type="image/x-icon" />
    </head>

    <body ng-controller="indexCtrl" ng-cloak>
    <ng-include  src="'${pageContext.request.contextPath}/navigatorExamen'"></ng-include>
    <div class="">
        <div class="container examen" id="main_div">
            <hr>
            <div ng-view></div>

        </div>

    </div>

    <ng-include src="'${pageContext.request.contextPath}/footer'"></ng-include>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    <!--script src="${pageContext.request.contextPath}/resources/js/sideMenu.js"></script-->
</body>
</html>
