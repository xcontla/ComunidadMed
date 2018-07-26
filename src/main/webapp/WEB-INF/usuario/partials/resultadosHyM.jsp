<%-- 
    Document   : resultadosHyM
    Created on : 15/06/2018, 03:12:18 PM
    Author     : UNAM
--%>

<div ng-init="resultados()">
    <h1>
        Resultados
    </h1>
    <div class="row">
        <div class ="span12">

        </div>
    </div>

    <div class="row">
        <div class="span6">
            <h3>{{resutladosHyMI.series}}</h3>
        </div>
        <div class="span12">
            <canvas id="intereses" class="chart-base" chart-type="grtype" chart-colors="resutladosHyMI.colors" chart-options="options"
                    chart-data="resutladosHyMI.data" chart-labels="resutladosHyMI.labels" chart-series="resutladosHyMI.series">
            </canvas>
        </div>
    </div>
    <hr>
    <h4>Interpretaci�n</h4>
    <div class="row">
        
        <div class="span3">
            <p style="text-align: justify"> <strong>0 al 25%:</strong> Cualquier barra de tu perfil que se ubique en este rango significa <strong>FALTA DE MOTIVACI�N</strong>, 
            es decir, que no te encuentras interesado en esas actividades. Esto se asocia regularmente con actividades o experiencias pasadas que no fueron agradables
            en su momento y que ahora no te motivan lo suficiente para llevarlas a cabo.</p>
        </div>
        <div class="span3">
            <p style="text-align: justify"><strong>26 al 50%:</strong> Se refiere a los <strong>INTERESES COMUNES</strong> que cualquier persona puede tener, son todas aquellas actividades
            en las que probablemente a�n no identificas el grado de preferencia, ya sea porque nunca las has experimentado o si lo hiciste alguna vez, no tuvieron la fuerza suficiente
            para llamarte la atenci�n; sin embargo, est�n presentes (ni te gustan, ni te disgustan).</p>
        </div>
        <div class="span3">
            <p style="text-align: justify"><strong>51 al 75%: INTERESES SUBPROFESIONALES</strong>; en este rango se incluyen las actividades que te llaman la atenci�n, que te gustan y pueden
            ser muy diversas; aqu� podr�an estar tus pasatiempos y todas aquellas actividades que desear�as realizar y que probablemente te interesar�an llevar a cabo
            como una profesi�n.</p>
        </div>
        <div class="span3">
            <p style="text-align: justify"><strong>76 al 100%:</strong> Este rango se refiere a tus <strong>INTERESES PROFESIONALES</strong>, es decir, las actividades que son de tu preferencia
            y deber�as considerarlas como inclinaciones hacia determinadas carreras.</p>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="span2">
            <table class="table table-striped">
                <tbody>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionInteres('SS')"> Servicio Social </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionInteres('EP')"> Ejecutiva-Persuasiva</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionInteres('V')"> Verbal </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionInteres('AP')"> Art�stico Pl�stico </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionInteres('MS')"> Musical </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionInteres('OG')"> Organizaci�n </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionInteres('CT')"> Cient�fica </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionInteres('CL')"> C�lculo </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionInteres('MC')"> Mec�nico Constructivo</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionInteres('AL')"> Aire Libre</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="span5">
            <table>
                <thead>
                    <tr>
                        <th>Explicacion</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <strong>{{it.nombre}}</strong>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div style="text-align: justify" ng-bind-html="it.interpretacion"></div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="span5">
            <table>
                <thead>
                    <tr>
                        <th>Profesiones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><div style="text-align: justify" ng-bind-html="it.profesiones"></div></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="span6">
            <h3>{{resutladosHyMA.series}}</h3>
        </div>
        <div class="span12">
            <canvas id="aptitudes" class="chart-base" chart-type="grtype" chart-colors="resutladosHyMA.colors" chart-options="options"
                    chart-data="resutladosHyMA.data" chart-labels="resutladosHyMA.labels" chart-series="resutladosHyMA.series">
            </canvas>
        </div>
    </div>
    <hr>

    <h4>Interpretaci�n</h4>
    <div class="row">
        <div class="span3">
            <p style="text-align: justify"><strong>0 al 25%:</strong> Corresponde a la <strong>FALTA DE PR�CTICA</strong>; en este rubro se encuentran todas las actividades que no has
            experimentado y por lo tanto desconoces si tienes la habilidad.</p>
        </div>
        <div class="span3">
            <p style="text-align: justify"><strong>26 al 50%:</strong> Se refiere a tus <strong>APTITUDES COMUNES</strong>, es decir, seg�n tu apreciaci�n no tienes desarrollada esa habilidad,
            por lo tanto, es necesario practicar m�s para dominarla.</p>
        </div>
        <div class="span3">
            <p style="text-align: justify"><strong>51 al 75%:</strong> Aqu� se encuentran tus <strong>APTITUDES NORMALES</strong>, lo cual quiere decir que tienes desarrollada esa habilidad
            pero no lo suficiente para dominarla.</p>
        </div>
        <div class="span3">
            <p style="text-align: justify"><strong>76 al 100%:</strong> En este rango est�n tus <strong>APTITUDES DESARROLLADAS</strong>, las cuales dominas segu�n tu apreciaci�n. </p>
        </div>
    </div>
    <hr>

    <div class="row">
        <div class="span2">
            <table class="table table-striped">
                <tbody>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionAptitud('SS')"> Servicio Social </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionAptitud('EP')"> Ejecutiva-Persuasiva</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionAptitud('V')"> Verbal </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionAptitud('AP')"> Art�stico Pl�stico </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionAptitud('MS')"> Musical </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionAptitud('OG')"> Organizaci�n </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionAptitud('CT')"> Cient�fica </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionAptitud('CL')"> C�lculo </button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionAptitud('MC')"> Mec�nico Constructivo</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn btn-small" ng-click="getExplicacionAptitud('DT')"> Destreza Manual</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="span5">
            <table>
                <thead>
                    <tr>
                        <th>Explicacion</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <strong> {{apt.nombre}} </strong>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p style="text-align: justify">{{apt.interpretacion}}</p>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="span5">
            <table>
                <thead>
                    <tr>
                        <th>Profesiones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <p style="text-align: justify">{{apt.profesiones}}</p></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class ="span12">
            <a href="#/myHome">Regresar</a>
        </div>
    </div>
</div>
