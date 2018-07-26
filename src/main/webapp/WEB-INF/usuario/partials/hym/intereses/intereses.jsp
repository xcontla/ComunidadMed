<%-- 
    Document   : intereses
    Created on : 30/05/2018, 06:01:43 PM
    Author     : UNAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div ng-init="showHmontesData(0)">
    <div ng-if="hmontesPreguntas.preguntas">
        <div class="row">
            <div class="span12">
                <div class="pagination pagination-centered" >
                    <h2>Herrera y Montes - Página {{curPage + 1}}</h2>
                    <ul class="pagination-controle pagination">
                        <li>
                            <button type="button" class="btn btn-primary" ng-disabled="curPage == 0"
                                    ng-click="curPage = curPage - 1"> &lt; Prev </button>
                        </li>
                        <li>
                            <button class="btn btn-default disabled">Página {{curPage + 1}} de {{numberOfPages()}}</button>
                        </li>
                        <li>
                            <button type="button" class="btn btn-primary" ng-disabled="curPage >= datalength / pageSize - 1"
                                    ng-click="curPage = curPage + 1">Sig &gt;</button>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <table class="table table-bordered table-striped">
            <tbody>
                <tr class="paginationclass" ng-repeat="pregunta in hmontesPreguntas.preguntas |
                    pagination: curPage * pageSize | limitTo: pageSize" >
                    <td>{{pregunta.preguntaIndice}}</td>
                    <td  width="250">
                        <div ng-if="pregunta.preguntaTipo == 1">
                            <div ><strong>{{pregunta.preguntaTexto}}</strong></div>
                        </div>
                    </td>
                    <td></td>
                    <td ng-repeat="opcion in pregunta.opciones">
                        <div class="radio">
                            <label><input type="radio" ng-click="respuestasHmontes[curPage * pageSize + $parent.$index] = {'preguntaExamenId':pregunta.preguntaExamenId,'preguntaId':pregunta.preguntaId,'opcionId':opcion.opcionId,'opcionIndice':opcion.opcionIndice, 'idExamen': 4}"
                                          ng-checked="respuestasHmontes[curPage * pageSize + $parent.$index].opcionIndice == opcion.opcionIndice"  
                                          name="{{pregunta.preguntaIndice}}">
                                <div ng-if="opcion.opcionTipo == 1">{{opcion.opcionTexto}} </div>
                            </label>
                        </div>

                    </td>
                </tr>
            </tbody>
        </table>
        <div class="pagination pagination-centered" >
            <h2>Herrera y Montes - Página {{curPage + 1}}</h2>
            <ul class="pagination-controle pagination   ">
                <li>
                    <button type="button" class="btn btn-primary" ng-disabled="curPage == 0"
                            ng-click="curPage = curPage - 1"> &lt; Prev </button>
                </li>
                <li>
                    <button class="btn btn-default disabled">Página {{curPage + 1}} de {{numberOfPages()}}</button>
                </li>
                <li>
                    <button type="button" class="btn btn-primary" ng-disabled="curPage >= datalength / pageSize - 1"
                            ng-click="curPage = curPage + 1">Sig &gt;</button>
                </li>
            </ul>
            <hr>
        </div>
        <div>
            <div class="row text-center">
                <div class="span4">
                    <button class="btn btn-primary" ng-click="getRespuestasHyM()"> Enviar </button>
                </div>
                <div class="span4"></div>
                <div class="span4 ">
                    
                        <p class="alert-danger ">Uso Exclusivo para testers</p>
                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/usuario/examen.dgoae#/hymAptitudesInstrucciones"> Saltar a siguiente sección</a>

                </div>
            </div>
        </div>
        <hr>
    </div>
    <div ng-if="!hmontesPreguntas.preguntas">
        <div class="row">
            <div class="span12">
                <div class="loader" ></div>

            </div>
        </div>
    </div>
</div>