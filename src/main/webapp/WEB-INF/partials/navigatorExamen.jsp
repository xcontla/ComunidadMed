<%-- 
    Document   : navegator
    Created on : 16/11/2017, 02:05:15 PM
    Author     : XavierContla
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<header>
    <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <div>
                        <a class="brand">
                            <img class="d-inline-block align-top"  width="85" height="auto" src="${pageContext.request.contextPath}/resources/img/dgoae/LogoDGOAEBlanco.png">
                            <!--b>DGOAE</b-->
                        </a>
                    </div>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li ng-init="getName()"><a><img class="d-inline-block align-top" width="32" height="auto" ng-src="${pageContext.request.contextPath}/resources/img/dgoae/user/usuario{{genero}}.png">{{navname}}</a></li>
                        </ul>
                    </div><!-- .nav-collapse -->
                </div>		
            </div>
        </div>
    </div>
</header>