<%-- 
    Document   : navegator
    Created on : 16/11/2017, 02:05:15 PM
    Author     : XavierContla
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<header>
    <div class="navbar navbar-fixed-top">
        <!--div style="background-color:#3B4042;color:white;padding:40px;" class="bannerOpacity"-->
        <div style="background-color:#394042;color:white;" class="row-fluid">
            <!--div class="span2"></div>
            <div class="span10">
                <img class="d-inline-block align-top" height="auto" src="${pageContext.request.contextPath}/resources/img/encabezado.jpg">
            </div-->
        </div>
        <div ng-init="getName()">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div>
                        <a class="brand" href="http://www.dgoae.unam.mx/">
                            <img class="d-inline-block align-top"  width="85" height="auto" src="${pageContext.request.contextPath}/resources/img/dgoae/LogoDGOAEBlanco.png">
                            <!--b>DGOAE</b-->
                        </a>
                    </div>
                    <div class="nav-collapse collapse">
                        
                        <ul class="nav">
                            <li id="navHome" ng-class="{'active': navHome}"><a href="${pageContext.request.contextPath}/usuario/home.dgoae">Mis Instrumentos</a></li>
                        </ul>
                        
                        <ul class="nav pull-right">
                            <li ><a><i class="icon-user"></i><span>  </span>{{navname}}</a></li>
                            <li role="separator" class="divider-vertical"></li>
                            <li><a href="<c:url value='/perform_logout'/>">Salir</a></li>
                        </ul>
                        
                    </div><!-- .nav-collapse -->
                </div>		
            </div>
        </div>
    </div>
</header>