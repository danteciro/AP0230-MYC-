/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.business;

import gob.osinergmin.myc.domain.dto.ActividadDTO;
import gob.osinergmin.myc.domain.dto.ProcesoObligacionTipoDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.domain.ui.ActividadFilter;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jpiro
 */
public interface ActividadServiceNeg {
    public List<ActividadDTO> listarActividad(ActividadFilter filtro, int[] cuenta);
    public List<ActividadDTO> findActividadByFilter(ActividadFilter filtro);
    public List<ProcesoObligacionTipoDTO> listarActividadConfigurada();
	public ActividadDTO listarActividadxCodigo(ActividadFilter filtro);/*OSINE_SFS-480 - RSIS25 */
	public List<ProcesoObligacionTipoDTO> listarActividadConfigurada(ActividadFilter filtro);
	
	
	/* OSINE_SFS-600 - REQF-0009 - Inicio */
    public List<ActividadDTO> listarAgentesIntalacion(ActividadFilter filtro);
    public List<ActividadDTO> listarActividad(ActividadFilter filtro);
    public List<ActividadDTO> listarAgente(ActividadFilter filtro);
    public Map<String, Object> guardarActividad (ActividadDTO actividad, UsuarioDTO usuario, boolean forzarOrdenamiento);
    public Map<String, Object> editarActividad (ActividadDTO actividad, UsuarioDTO usuario, boolean forzarOrdenamiento);
    public ActividadDTO eliminarActividad (Long idActividad, String estado,UsuarioDTO usuario);
    public Map<String, Object> verificarEliminarActividad (ActividadFilter filtro);
    /* OSINE_SFS-600 - REQF-0009 - Fin */
}
