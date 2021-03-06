package gob.osinergmin.myc.util;

import gob.osinergmin.myc.util.Constantes;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jpiro
 */
public class ConstantesWeb {
    public static final int VV_EXITO = 0;
    public static final int VV_ERROR = 1;
    public static final int VV_ADVERTENCIA = 2;
    public static final int VV_ADVERTENCIA_EXISTENCIA = 3;
    
    public static final String VV_RESULTADO = "resultado";
    public static final String VV_MENSAJE = "mensaje";
    
    public static String FECHA="";
    public static String USUARIO="";
    
    private ConstantesWeb() {
    }
    public static Long getIDPERSONAL(HttpServletRequest request) {
        Long idPersonal = (Long) request.getSession().getAttribute("idPersonal");
        Constantes.IDPERSONAL=idPersonal;
        return Constantes.IDPERSONAL;
    } 
    public static String getFECHA() {
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
        String prefix = DATE_FORMAT.format(today);
        ConstantesWeb.FECHA=prefix;
        return ConstantesWeb.FECHA;
    }
    public static String getUSUARIO(HttpServletRequest request) {
        String usuario = ((String) request.getSession().getAttribute("j_username"));
        ConstantesWeb.USUARIO=usuario;
        return ConstantesWeb.USUARIO;
    }
    
    public static class Navegacion{
        public static final String PAGE_GENERAL_INICIO="principal";
        public static final String PAGE_GENERAL_INICIO_MANTENIMIENTO="mantenimiento";
        public static final String PAGE_GENERAL_INICIO_CONFIGURACION="configuracion";
        
        //requisitos
        public static final String PAGE_REQUISITOS_MANT="requisitos/mantenimiento";
        public static final String PAGE_REQUISITOS_MANT_PARAMETRO="requisitos/parametro/mantenimiento";
        public static final String PAGE_REQUISITOS_MANT_ZONIFICACION="general/mantenimiento/zonificacion";
        public static final String PAGE_REQUISITOS_MANT_ZONIFICACION_DETALLE="general/mantenimiento/zonificacionDetalle";
        
        public static final String PAGE_REQUISITOS_MANT_MAESTRO_COLUMNA="general/maestroColumna/mantenimiento";
        public static final String PAGE_REQUISITOS_MANT_FRM_MAESTRO_COLUMNA="general/maestroColumna/mantFrmMaestroColumna";
        public static final String PAGE_REQUISITOS_MANT_MAESTRO_TABLA="general/maestroTabla/mantFrmMaestroTabla";
        
        public static final String PAGE_REQUISITOS_MANT_PROCEDIMIENTO="requisitos/procedimiento/mantenimiento";
        public static final String PAGE_REQUISITOS_MANT_FRM_PROCEDIMIENTO="requisitos/procedimiento/mantFrmProcedimiento";
        public static final String PAGE_REQUISITOS_MANT_REQUISITO="requisitos/requisito/mantenimiento";
        public static final String PAGE_REQUISITOS_MANT_FRM_REQUISITO="requisitos/requisito/mantFrmRequisito";
        
        public static final String PAGE_REQUISITOS_CONF="requisitos/configuracion";
        public static final String PAGE_REGISTRO_CONF="registro/configuracion";
        public static final String PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO="requisitos/requisitoProcedimiento/busqueda";
       
        public static final String PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO_NUEVO="requisitos/requisitoProcedimiento/nuevo";
        public static final String PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO_CONSULTA="requisitos/requisitoProcedimiento/consultabkp";        
        public static final String PAGE_REQUISITOS_CONF_REQUISITOXPROCEDIMIENTO_FRM_AGREGAR_REQUISITO="requisitos/requisitoProcedimiento/common/frmAgregarRequisito";        
        
        public static final String PAGE_REQUISITOS_FRM_SELECT_ACTIVIDADES="requisitos/common/actividad/popupBusqActividad";
        public static final String PAGE_GENERAL_FRM_SELECT_DISTRITO="general/common/distrito/popupBusqDistrito";
        public static final String PAGE_GENERAL_FRM_SELECT_SANC_ADM="general/common/sancionAdministrativa/popupBusqSancAdm";
        
        //Oficina Regional
        
        public static final String PAGE_REGISTRO_CONF_OFICINASREGICONALES="registro/oficinasRegionales/busqueda";
        public static final String PAGE_REGISTRO_CONF_FRM_OFICINASREGICONALES="registro/oficinasRegionales/mantFrmOficinaRegional";
        public static final String PAGE_REGISTRO_CONF_FRM_REGION="registro/oficinasRegionales/configuracionRegion";
        public static final String PAGE_REGISTRO_CONF_OFICINASREGICONALES_FRM_BUSQUEDARESPONSABLE="registro/oficinasRegionales/popupBusqResponsable";
        public static final String PAGE_REGISTRO_CONF_OFICINASREGICONALES_FRM_ASIGNACION_UBIGEO="registro/oficinasRegionales/popupAsignacionUbigeo";
        public static final String PAGE_REGISTRO_CONF_OFICINASREGICONALES_FRM_ASIGNACION_OFICINA_REGIONAL="registro/oficinasRegionales/popupAsignacionOficinaRegional";
        public static final String PAGE_REGISTRO_CONF_OFICINASREGICONALES_NUEVO="registro/oficinasRegionales/nuevo";
        
        //obligaciones
        public static final String PAGE_INICIO_INDICE="indicemo";
        public static final String PAGE_INICIO_MANTENIMIENTOS="mantenimientosmo";
        public static final String PAGE_INICIO_MANTENIMIENTO_BASE_LEGAL="moduloObligaciones/baseLegal/inicio";
        public static final String PAGE_INICIO_MANTENIMIENTO_OBLIGACION="moduloObligaciones/Obligacion/obligacion";
        public static final String PAGE_INICIO_MANTENIMIENTO_OBLIGACIONNORMATIVA="moduloObligaciones/Obligacion/obligacionNormativa";
        
        
        //formularios comunes obligaciones
        public static final String PAGE_OBLIGACIONES_FORM_ARBOLACTIVIDADES="moduloObligaciones/common/formArbolActividades";
        public static final String PAGE_OBLIGACIONES_FORM_ARBOLPRODUCTOS="moduloObligaciones/common/formArbolProductos";
        public static final String PAGE_OBLIGACIONES_FORM_BUSQUEDA_AVANZADA_BASE_LEGAL="moduloObligaciones/common/formBusqAvanzadaBaseLegal";
        
        //paginas de edicion
        public static final String PAGE_OBLIGACIONES_BASE_LEGAL_NUEVO="moduloObligaciones/baseLegal/nuevo";
        
        //Actividades
        public static final String PAGE_REGISTRO_CONF_BUSQ_ACTIVIDAD="registro/actividad/busqueda";
        public static final String PAGE_REGISTRO_CONF_REG_ASIGNACION="registro/actividad/popupAsignacion";
        public static final String PAGE_REGISTRO_CONF_FRM_SELECT_ACTIVIDADES="registro/actividad/popupBusqActividad";
        
        //Mantenimiento General
        public static final String PAGE_GENERAL_MANT="general/mantenimiento";
        
        //Tramite Actividad
        public static final String PAGE_GENERAL_MANT_TRAMITE_ACTIV="general/tramiteActividad/mantenimiento";
        public static final String PAGE_GENERAL_MANT_FRM_TRAMITE_ACTIV="general/tramiteActividad/mantFrmTramiteActividad";
        public static final String PAGE_GENERAL_MANT_FRM_EDIT_TRAMITE_ACTIV="general/tramiteActividad/mantEditFrmTramiteActividad";
        
        //Rubro - Opcion
        public static final String PAGE_GENERAL_MANT_RUBRO_OPCION="general/rubroOpcion/mantenimiento";
        public static final String PAGE_GENERAL_MANT_FRM_RUBRO_OPCION="general/rubroOpcion/mantFrmRubroOpcion";
        public static final String PAGE_GENERAL_MANT_EDIT_FRM_RUBRO_OPCION="general/rubroOpcion/mantEditFrmRubroOpcion";
        
        //Concurso
        public static final String PAGE_GENERAL_MANT_CONSURSO="general/concurso/mantenimiento";
        public static final String PAGE_GENERAL_MANT_CONSURSO_ADJUNTOS="general/concurso/mantFrmArchivo";
        
        //Proceso Obligaciones
        public static final String PAGE_GENERAL_MANT_PROCESO_OBLI="general/procesoObligacionTipo/mantenimiento";
        public static final String PAGE_GENERAL_MANT_FRM_OBLIGACION_PROCESO="general/procesoObligacionTipo/mantFrmProcesoObligacionTipo";
        public static final String PAGE_GENERAL_MANT_FRM_EDIT_OBLIGACION_PROCESO="general/procesoObligacionTipo/mantEditFrmObligacionProceso";
        
        //Obligacion Tipo
        public static final String PAGE_GENERAL_MANT_OBLI_TIPO="general/obligacionTipo/mantenimiento";
        public static final String PAGE_GENERAL_MANT_FRM_OBLIGACION_TIPO="general/obligacionTipo/mantFrmObligacionTipo";
        public static final String PAGE_GENERAL_MANT_FRM_NUEVO_OBLIGACION_TIPO="general/obligacionTipo/mantFrmNuevoObligacionTipo";
        
        //Etapa
        //public static final String PAGE_REQUISITOS_MANT_ETAPA_TRAMITE="general/etapaTramite/etapaTramite";
        public static final String PAGE_REQUISITOS_MANT_ETAPA_TRAMITE="general/mantenimiento/etapaTramite";
        public static final String PAGE_GENERAL_MANT_ETAPA="general/etapaTramite/mantFrmEtapa";
        public static final String PAGE_GENERAL_MANT_TRAMITE="general/etapaTramite/mantFrmTramite";
        
        //Tipo Sancion
        public static final String PAGE_GENERAL_MANT_TIPO_SANCION="general/tipoSancion/mantFrmTipoSancion";
        //tipificacion
        public static final String PAGE_GENERAL_MANT_TIPIFICACION="general/tipificacion/mantenimiento";
        public static final String PAGE_GENERAL_MANT_FRM_TIPIFICACION="general/tipificacion/mantFrmTipificacion";
        //autoayuda
        public static final String PAGE_GENERAL_MANT_AUTOAYUDA="general/autoayuda/mantenimiento";
        //criterio
        public static final String PAGE_GENERAL_MANT_CRITERIO="general/criterio/mantCriterio";
        public static final String PAGE_GENERAL_MANT_FRM_CRITERIO="general/criterio/mantFrmCriterio";
        //sanciones
        public static final String PAGE_GENERAL_MANT_SANCIONES="general/criterio/mantSanciones";
        //Unidad Organica
        public static final String PAGE_GENERAL_MANT_UNIDAD_ORGANICA="general/unidadOrganica/mantUnidadOrganica"; /* OSINE_SFS-480 - RSIS10 - mdiosesf */
        //inps
        public static final String PAGE_GENERAL_MANT_INPS="general/inps/mantenimiento"; /* OSINE_SFS-480 - RSIS10 - mdiosesf */
        public static final String PAGE_GENERAL_MANT_FILTROEMPSUPERVISORAS_INPS="general/inps/filtroEmpSupervisoras/mantfiltroEmpSupervisoras"; /* OSINE_SFS-480 - RSIS10 - mdiosesf */
        public static final String PAGE_GENERAL_MANT_SELECCION_MUESTRAL="general/inps/seleccionMuestral/mantSeleccionMuestral"; /* OSINE_SFS-480 - RSIS23 */
    	public static final String PAGE_MYC_VISTA_DESAUTORIZADA = "/unauthorized";

		/* OSINE_SFS-600 - REQF-0011 - Inicio */
        public static final String PAGE_GENERAL_MANT_PRIORIDAD_NORMA_AGENTE="general/prioridadNormaAgente/mantenimiento";
        public static final String PAGE_GENERAL_MANT_FRM_PRIORIDAD_NORMA_AGENTE="general/prioridadNormaAgente/mantFrmPrioridadNormaAgente";
        /* OSINE_SFS-600 - REQF-0011 - Fin */
        /* OSINE_SFS-600 - REQF-0005 - Inicio */
        // actividad
        public static final String PAGE_GENERAL_MANT_ACTIVIDAD_AGENTE_INSTALACION="general/actividad/mantenimientoActividad";
        public static final String PAGE_GENERAL_FRM_ACTIVIDAD="general/actividad/mantFrmActividad";
        public static final String PAGE_GENERAL_FRM_ACTIVIDAD_AGENTE="general/actividad/mantFrmActividadAgente";
        // agente
        public static final String PAGE_GENERAL_FRM_BUSQ_AGENTE="general/actividad/mantFrmBusqAgente";
        public static final String PAGE_GENERAL_FRM_AGENTE="general/actividad/mantFrmAgente";
        /* OSINE_SFS-600 - REQF-0005 - Fin */
        /* OSINE_ */
        public static final String PAGE_GENERAL_MANT_CONFIGURACION_SIGUO="general/siguo/configuracion/mantConfiguracionSiguo";
        public static final String PAGE_GENERAL_MANT_FRM_CONFIGURACION_SIGUO="general/siguo/configuracion/mantFrmConfiguracionSiguo";
        public static final String PAGE_REQUISITOS_FRM_SELECT_ACTIVIDADES_MODAL="general/siguo/configuracion/popupBusqActividadModal";
        /**/
	
        /* OSINE_SFS-1232 - REQF- - Inicio */
    	public static final String PAGE_GENERAL_MANTENIMIENTO_ETAPAS = "general/etapaSubEtapa/mantenimientoEtapa";
    	public static final String PAGE_GENERAL_NUEVA_CONFIGURACION_ETAPA = "general/etapaSubEtapa/nuevaConfiguracion";
    	public static final String PAGE_GENERAL_MODIFICAR_CONFIGURACION_ETAPA = "general/etapaSubEtapa/modificarConfiguracion";
    	public static final String PAGE_GENERAL_NUEVA_ETAPA_TRAMITE = "general/etapaSubEtapa/nuevaEtapaTramite";
    	public static final String PAGE_GENERAL_NUEVA_SUBETAPA_ETAPATRAMITE = "general/etapaSubEtapa/nuevaSubEtapaEtapaTramite";
    	public static final String PAGE_GENERAL_NUEVA_ETAPA = "general/etapaSubEtapa/nuevaEtapa";
    	public static final String PAGE_GENERAL_NUEVA_SUBETAPA = "general/etapaSubEtapa/nuevaSubEtapa";
    	public static final String PAGE_GENERAL_MODIFICAR_SUBETAPA = "general/etapaSubEtapa/modificarSubEtapa";
    	public static final String PAGE_GENERAL_MODIFICAR_ETAPA_TRAMITE = "general/etapaSubEtapa/modificarEtapaTramite";
    	public static final String PAGE_SUBETAPAS_MODIFICAR_SUBETAPA_TRAMITE = "general/etapaSubEtapa/modificarSubEtapaTramite";    	
    	   /* OSINE_SFS-1232 - REQF- - Inicio */
    
    }
    
    public static class mensajes{
    	//Mensajes 
        //Mensajes Base Legal
        public static final String MSG_OPERATION_SUCCESS_CREATE="Se guard\u00F3 satisfactoriamente: ";
        public static final String MSG_OPERATION_FAILED_CREATE_ETAPA="El plazo ingreso no puede ser menor que la suma de los plazos actuales de las sub etapas";
        public static final String MSG_OPERATION_SUCCESS_UPDATE="Se actualiz\u00F3 satisfactoriamente:";
        public static final String MSG_OPERATION_SUCCESS_DELETE="Se elimin\u00F3 satisfactoriamente:";
        
        public static final String MSG_OPERATION_FAIL_CREATE="Fallo al guardar: ";
        public static final String MSG_OPERATION_FAIL_UPDATE="Fallo al actualizar: ";
        public static final String MSG_OPERATION_FAIL_DELETE="Fallo al eliminar: ";
        
        public static final String MSG_OPERATION_FAIL_CREATE_DUPLICATE="Ya Existe ";
        
        public static final String MSG_OPERATION_SUCCESS_CREATE_RELATION="Se asign\u00F3 satisfactoriamente: ";
        public static final String MSG_OPERATION_SUCCESS_DELETE_RELATION="Se elimin\u00F3 satisfactoriamente: ";
        
        public static final String MSG_OPERATION_FAIL_CREATE_RELATION="Fallo al asignar: ";
        public static final String MSG_OPERATION_FAIL_DELETE_RELATION="Fallo al desasignar: ";
        
        //Mensajes Unidad Organica
        public static final String MSG_OPERATION_FAIL_HAS_NODE="No se puede eliminar, contiene dependencias.";
        public static final String MSG_OPERATION_FAIL_HAS_PERSONAL="No se puede eliminar, el registro se encuentra asignado a un Personal.";
        
        //Entidades
        public static final String MSG_ENTITY_OBLIGACION="Obligaci\u00F3n";
        /*Rrsis 14 - inicio*/
        public static final String MSG_ENTITY_INFRACCION="Infracci\u00F3n";
        public static final String MSG_ENTITY_INCUMPLIMIENTO="Incumplimiento";
        /*Rsis 14 - fin*/
        public static final String MSG_ENTITY_BASELEGAL="Base Legal";
        public static final String MSG_ENTITY_TIPIFICACION="Tipificaci\u00F3n";
        public static final String MSG_ENTITY_CONFIGURACION="Configuraci\u00F3n";
        public static final String MSG_ENTITY_TEMA="Tema";
        public static final String MSG_ENTITY_CRITERIO="Criterio";
        
        //Mensajes de validacion
        public static final String MSG_OPERATION_FAIL_EXISTS="No se puede crear, Configuraci\u00F3n por Tramite ya existente.";
        public static final String MSG_OPERATION_FAIL_EXISTS_CONF="No existe Configuraci\u00F3n de Actividad por Unidad Organica";
        
    	
        public static final String MSG_OPERATION_FAIL_ETAPA = "La SubEtapa que intenta eliminar esta asociada a mas de 1 una configuraci\u00F3n";
    }
    
}
