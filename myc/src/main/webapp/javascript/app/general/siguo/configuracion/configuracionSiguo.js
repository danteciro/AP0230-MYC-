$(function() {	
    initInicioFiltroEmpSupe();
    confirm.start();
    procesarModulo();
});
function initInicioFiltroEmpSupe() {	
    $('#btnRegresar').click(function() {
        window.location.href = baseURL + 'pages/principal/mantenimientoGeneral';
    });
    $('#cmbGerencia').change(function() {  
        listarDivisiones();
    });
    $('#cmbDivision').change(function() {  

    });
    $('#btnBuscar').click(function(){procesarModulo();});
    $('#btnLimpiar').click(function(){limpiar();});
    $('#btnNuevoModulo').click(function(){abrirMantModulo("new");});
      
}
function abrirMantModulo(tipo,rowid,item){
	// &Oacute
	var row = $('#gridModulo').jqGrid('getRowData', rowid);
    var title="CONSULTAR ACTIVIDAD - COMPONENTE - SECCIÓN";
    if(tipo=='edit'){
        title="EDITAR ACTIVIDAD - COMPONENTE - SECCIÓN";
    }else if(tipo=='new'){
        title="NUEVO ACTIVIDAD - COMPONENTE - SECCIÓN";
        item = $("#gridModulo").jqGrid('getGridParam', 'records')+1;
    }
    $.ajax({
        url:baseURL + "pages/mantenimientoConfiguracionSiguo/abrirMantModulo", 
        type:'get',
        async:false,
        data:{
            tipo:tipo,
            item:item,
            idOrgaActiModuSecc:rowid
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogMantModulo").html(data);
            $("#dialogMantModulo").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: title,
                closeText:"Cerrar"
            });
            if(tipo=="view"){
                $('#frmMantModulo').find('input,select,textarea').attr('disabled',true);
            }
            if(tipo=='edit' || tipo=='view'){
            	listarDivisionesModal(); 
            	$('#cmbDivisionModal').val($('#txtIdDivisionModal').val());
            }
        },
        error:errorAjax
    });
}
function limpiar(){
	$("#cmbGerencia").val('');
    $("#cmbDivision").val('');
    $("#txtIdActivP1").val('');
    $('#txtActivP1').val('');
    $('#cmbComponente').val(''); 
}
function listarDivisiones() {
    fill.clean("#cmbDivision");
    $('#cmbDivision').trigger('change');
    if($('#cmbGerencia').val()!=''){
        $.ajax({
            url:baseURL + "pages/unidadOrganica/listarUnidadOrganica",
            type:'post',
            async:false,
            data:{ 
                idUnidadOrganicaSuperior:$('#cmbGerencia').val()
            },
            beforeSend:muestraLoading,
            success:function(data){
                ocultaLoading();
                fill.combo(data.listaUnidadOrganica,"idUnidadOrganica","descripcion","#cmbDivision");        
            },
            error:errorAjax
        });
    }
}
function abrirPopupBusqActividad() {
    $.ajax({
        url:baseURL + "pages/commonRequisitos/abrirPopupBusqActividad", 
        type:'get',
        async:false,
        data:{
            seleccion:"individual"
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogBusqActividad").html(data);
            $("#dialogBusqActividad").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: "Seleccione Rubro"
            });
        },
        error:errorAjax
    });
}
function abrirPopupBusqActividadModal() {
    $.ajax({
        url:baseURL + "pages/commonRequisitos/abrirPopupBusqActividadModal", 
        type:'get',
        async:false,
        data:{
            seleccion:"individual"
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            $("#dialogBusqActividadModal").html(data);
            $("#dialogBusqActividadModal").dialog({
                resizable: false,
                draggable: true,
                autoOpen: true,
                height:"auto",
                width: "auto",
                modal: true,
                dialogClass: 'dialog',
                title: "Seleccione Rubro"
            });
        },
        error:errorAjax
    });
}
function procesarModulo(flg_load) {
    if (flg_load === undefined) {
        flg_load = 1;
    }
    
    $("#gridContenedorModulo").html("");
    var grid = $("<table>", {
        "id": "gridModulo"
    });
    var pager = $("<div>", {
        "id": "paginacionModulo"
    });
    $("#gridContenedorModulo").append(grid).append(pager);

    var nombres = ['Nro','Nro','GERENCIA','DIVISI&OacuteM;N','Gerencia/Divisi&oacute;n','ID_ACTIVIDAD','Actividad','Orden Componente','ID_COMPONENTE','Componente','Orden Secci&oacute;n','ID_SECCION','Secci&oacute;n'];
    var columnas = [
        {name: "idOrgaActiModuSecc", width: 40, sortable: false, hidden: true, align: "center"},
        {name: "item", width: 40, sortable: false, hidden: false, align: "center"},
        {name: "idUnidadOrganicaSuperior.descripcion", width: 120, sortable: false, hidden: true, align: "center"},
        {name: "idUnidadOrganica.descripcion", width: 100, sortable: false, hidden: true, align: "center"},
        {name: "GerDiv", width: 140, sortable: false, hidden: false, align: "left",formatter:"concatenaGerenciaDivision"},
        {name: "idActividad.idActividad", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "idActividad.descripcionActividad", width: 120, sortable: false, hidden: false, align: "left"},
        {name: "ordenComponente", width: 100, sortable: false, hidden: false, align: "center"},
        {name: "idModulo.idModulo", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "idModulo.descripcion", width: 100, sortable: false, hidden: false, align: "left"},
        {name: "ordenSeccion", width: 100, sortable: false, hidden: false, align: "center"},
        {name: "idSeccion.idSeccion", width: 100, sortable: false, hidden: true, align: "left"},
        {name: "idSeccion.descripcion", width: 100, sortable: false, hidden: false, align: "left"}
    ];
    grid.jqGrid({
       url: baseURL + "pages/mantenimientoConfiguracionSiguo/findActividadComponenteSeccion",
       datatype: "json",
       mtype: 'POST',
       postData: {
            flg_load: flg_load,
            'idUnidadOrganicaSuperior.idUnidadOrganica': $("#cmbGerencia").val(),
            'idUnidadOrganica.idUnidadOrganica':$("#cmbDivision").val(),
            'idActividad.idActividad':$("#txtIdActivP1").val(),
            'idModulo.idModulo':$('#cmbComponente').val() 
        },
        hidegrid: false,
        rowNum: global.rowNumPrinc,
        pager: "#paginacionModulo",
        emptyrecords: "No se encontraron resultados",
        loadtext: "Cargando",
        colNames: nombres,
        colModel: columnas,
        height: "auto",
        viewrecords: true,
        caption: "Listado de Actividades-Componente-Secci&oacute;n",
        autowidth: true,
        jsonReader: {
            root: "filas",
            page: "pagina",
            total: "total",
            records: "registros",
            repeatitems: false,
            id: "idOrgaActiModuSecc"
        },
        onSelectRow: function(rowid, status) {
            grid.resetSelection();
        },
        onRightClickRow: function(rowid, iRow, iCol, e) {
            var row = grid.jqGrid('getRowData', rowid);
            //item = row.item;
            var item = row['item'];
            console.info('item : - >'+item);
            
            
            $('#linkVerModulo').attr('onClick', 'abrirMantModulo("view","' + rowid + '","'+item+'")');
            $('#linkEditarModulo').attr('onClick', 'abrirMantModulo("edit","' + rowid + '","'+item+'")');
            $('#linkEliminarModulo').attr('onClick', 'eliminarModulo("' + rowid + '")');
            
            if($('#divEnlaceTagVerModulo input').html()!=null){
                $('#contextMenuModulo li a[value="CO-MODULO"]').html($('#divEnlaceTagVerModulo').html());
             } else {  
                $('#contextMenuModulo li a[value="CO-MODULO"]').remove();
             }
            if($('#divEnlaceTagEditarModulo input').html()!=null){
                $('#contextMenuModulo li a[value="MO-MODULO"]').html($('#divEnlaceTagEditarModulo').html());
             } else {  
                $('#contextMenuModulo li a[value="MO-MODULO"]').remove();
             }            
            if($('#divEnlaceTagEliminarModulo input').html()!=null){
                $('#contextMenuModulo li a[value="EL-MODULO"]').html($('#divEnlaceTagEliminarModulo').html());
             } else {  
                $('#contextMenuModulo li a[value="EL-MODULO"]').remove();
             }
        },
        loadComplete: function(data) {
            $('#contextMenuModulo').parent().remove();
            $('#divContextMenuModulo').html("<ul id='contextMenuModulo'>"
            		+ "<li> <a value='CO-MODULO'>Ver</a> </li>"
            		+ "<li> <a value='MO-MODULO'>Editar</a> </li>"
                    + "<li> <a value='EL-MODULO'>Eliminar</a></li>"
                    + "</ul>");
            $('#contextMenuModulo').puicontextmenu({
                target: $('#gridModulo')
            });

        }
    });
}
jQuery.extend($.fn.fmatter, {
	concatenaGerenciaDivision: function(cellvalue, options, rowdata) {
        var nombreGerencia=rowdata.idUnidadOrganicaSuperior.descripcion;
        var nombreDivision=rowdata.idUnidadOrganica.descripcion;
        var sel = '';
        if (nombreGerencia != null && nombreDivision != '' && nombreDivision != undefined && nombreDivision != undefined){     
        	sel = nombreGerencia+'/'+nombreDivision;
        }
        return sel;
    }
});
//PROC NUEVO - INICIO 
function btnGuardarConfiguracionSiguo(){
    if ( $('#frmMantModulo').validateAllForm("#divMensajeValidaModulo") ) {
            confirm.open("¿Ud est&aacute; seguro de Guardar?","procGuardarConfiguracionSiguo()");
    }
}
function procGuardarConfiguracionSiguo(){
    $.ajax({
        url:baseURL + "pages/mantenimientoConfiguracionSiguo/registrarConfiguracionSiguo",
        type:'post',
        async:false,
        data:$('#frmMantModulo').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.save, "");
                procesarModulo();
                $('#dialogMantModulo').dialog('close');
            }else if(data.resultado == '3'){
            	mensajeGrowl("warn", data.mensaje, "");
            }
            else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//PROC EDITAR - INICIO 
function btnEditarConfiguracionSiguo(){
	if ( $('#frmMantModulo').validateAllForm("#divMensajeValidaModulo") ) {
        confirm.open("¿Ud est&aacute; seguro de Guardar?","procEditarConfiguracionSiguo()");
	}
}
function procEditarConfiguracionSiguo(){
    $.ajax({
        url:baseURL + "pages/mantenimientoConfiguracionSiguo/editarConfiguracionSiguo",
        type:'post',
        async:false,
        data:$('#frmMantModulo').serialize(),
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.edit, "");
                procesarModulo();
                $('#dialogMantModulo').dialog('close');
            }else if(data.resultado == '3'){
            	mensajeGrowl("warn", data.mensaje, "");
            }else{
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}
//PROC ELIMINAR - INICIO 
function eliminarModulo(rowid) {
    confirm.open("¿Ud. est&aacute; seguro de eliminar este registro?","procEliminarModulo('"+rowid+"')");
}

function procEliminarModulo(id){
    $.ajax({
        url:baseURL + "pages/mantenimientoConfiguracionSiguo/eliminarConfiguracionSiguo",
        type:'post',
        async:false,
        data:{
        	idOrgaActiModuSecc:id
        },
        beforeSend:muestraLoading,
        success:function(data){
            ocultaLoading();
            if(data.resultado=="0"){
                mensajeGrowl("success", global.confirm.delete, "");
                procesarModulo();
            }else {
                mensajeGrowl("error", data.mensaje, "");
            }
        },
        error:errorAjax
    });
}