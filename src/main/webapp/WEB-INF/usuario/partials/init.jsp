<%-- 
    Document   : init
    Created on : 12/06/2018, 05:59:28 PM
    Author     : UNAM
--%>

<div>
    
    
    <h1>
       Bienvenido!
       
    
    </h1>
    <div class="row"
         <div class="span12">
             <p style="text-align: justify">Este es un sitio para que puedas saber un poco más sobre tus Aptitudes e Intereses</p>
        </div>
         <div ng-init="verExamenes()">
            <table class="table ">
                    <thead  class="thead-dark">
                        <tr>
                            <th scope="col">Nombre</th>
                            <!--th scope="col"></th-->
                            <th scope="col">Descripción</th>
                            <th scope="col">Observación</th>
                            <th scope="col">Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <!--th scope="row" >HERRERA Y MONTES</th-->
                            <td scope="row" ><img ng-src="${pageContext.request.contextPath}/resources/img/logo/hym.png"></td>
                            
                            <td><p p style="text-align: justify"> <a class="btn btn-info" href="#/herreraYmontesInfo">¿Quieres saber más de este examen?</a><p> </td>
                            <td>
                                <div ng-show="existe">Fecha de Aplicación: <strong>{{examenesHyM.examenes[0].fechaAplicacion}} </strong></div>
                                <div ng-show="!existe">Ninguna</div>
                            </td>
                            <td>
                                <div ng-show="existe"><a class="btn btn-primary" ng-href="/ComunidadMED/usuario/home.dgoae#/resultadosHyM">Resultados</a></div>
                                <div ng-show="!existe"><a class="btn btn-warning" ng-href="/ComunidadMED/usuario/examen.dgoae#/hymInstrucciones">Aplicar</a></div>
                            </td>
                        </tr>
                    </tbody>
                </table>
        </div> 
    </div>
</div>
