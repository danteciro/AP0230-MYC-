<%-- 
    Document   : Distritos
    Created on : 17/10/2014, 12:12:37 PM
    Author     : dmedrano
--%>

<%@ include file="/common/taglibs.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
     <script type="text/javascript" src='<c:url value="/javascript/app/general/common/distrito/popupBusqDistrito.js" />' charset="utf-8"></script>
    </head>
    <body>
<!--    <form id="frmBusqActividad">-->
     			  <input type="hidden" id="idDepartamento" value="${idDepartamento}" >
                  <input type="hidden" id="idProvincia"  value="${idProvincia}">
                  <input type="hidden" id="idZonificacion"  value="${idZonificacion}">
			     <div class="pui-panel-content" >
                        <div class="filaFormMarg">
                            <input type="hidden" id="idDistritosSelecEspe"/>
                            <div id="arbolDistritosEspe" style="height:300px;width:700px;" seleccion="${seleccion}">
                            </div>
                        </div>
                    </div>
                    
	                 
            <br/>
            <div align="center">
                <button id="btnSeleccionarDist" title="Seleccionar" type="button">Seleccionar</button>
            </div>
<!--        </form>  -->
</body>                    