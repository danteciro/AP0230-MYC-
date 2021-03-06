/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.myc.service.dao.impl;

import gob.osinergmin.myc.domain.PghObligacionTipificacion;
import gob.osinergmin.myc.domain.PghTipificacion;
import gob.osinergmin.myc.domain.builder.ObligacionTipificacionBuilder;
import gob.osinergmin.myc.domain.builder.TipificacionBuilder;
import gob.osinergmin.myc.domain.builder.TipificacionSancionBuilder;
import gob.osinergmin.myc.domain.dto.ObligacionTipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionDTO;
import gob.osinergmin.myc.domain.dto.TipificacionSancionDTO;
import gob.osinergmin.myc.domain.dto.UsuarioDTO;
import gob.osinergmin.myc.service.dao.CrudDAO;
import gob.osinergmin.myc.service.dao.ObligacionTipificacionDAO;
import gob.osinergmin.myc.util.Constantes;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lbarboza
 */
@Service
@Transactional
public class ObligacionTipificacionDAOImpl implements ObligacionTipificacionDAO{
    private static final Logger log = LoggerFactory.getLogger(ObligacionTipificacionDAOImpl.class);
    
    @Inject
    private CrudDAO crud;

    @Override
    public ObligacionTipificacionDTO create(ObligacionTipificacionDTO obligacionTipificacionDTO, UsuarioDTO usuarioDTO) {
        log.info("Registro Obligacion Base Legal DAO Impl");
        ObligacionTipificacionDTO retorno = null;
        try{
            PghObligacionTipificacion obligacionTipificacion = ObligacionTipificacionBuilder.getObligacionTipificacion(obligacionTipificacionDTO);
            obligacionTipificacion.setDatosAuditoria(usuarioDTO);
            
            if(obligacionTipificacion.getCodTrazabilidad()!=null && !obligacionTipificacion.getCodTrazabilidad().equals("")){
                crud.createWithHistory(obligacionTipificacion);
            }else{
                crud.create(obligacionTipificacion);
            }
            
            retorno = ObligacionTipificacionBuilder.toObligacionTipificacionDto(obligacionTipificacion);
            log.info("(Registro Obligacion Tipificacion DAO Impl) retorno: "+retorno.toString());
        }catch(Exception ex){
            log.error("",ex);
        }
        return retorno;
    }

    @Override
    public ObligacionTipificacionDTO changeState(ObligacionTipificacionDTO obligacionTipificacionDTO) {
        log.info("Registro Obligacion Base Legal DAO Impl -- changeState");
//        log.info("-- IdObliTipi = "+obligacionTipificacionDTO.getIdObliTipi());
//        log.info("-- IdOblifacion = "+obligacionTipificacionDTO.getIdObligacion());
//        log.info("-- IdTificacion = "+obligacionTipificacionDTO.getIdTipificacion());
        ObligacionTipificacionDTO retorno = null;
        try{
//            StringBuilder jpql = new StringBuilder();
//            jpql.append(" select ot ");
//            jpql.append(" from PghObligacionTipificacion ot ");
//            jpql.append(" where 1=1 ");
//            jpql.append(" and ot.estado=1 ");
//            jpql.append(" and ot.idObliTipi = ").append(obligacionTipificacionDTO.getIdObliTipi());
//            jpql.append(" and ot.idObligacion.idObligacion = ").append(obligacionTipificacionDTO.getIdObligacion());
//            jpql.append(" and ot.idTipificacion.idTipificacion = ").append(obligacionTipificacionDTO.getIdTipificacion());
//            String queryString = jpql.toString();
//            Query query = crud.getEm().createQuery(queryString);
//            PghObligacionTipificacion obligacionTipificacion = (PghObligacionTipificacion)query.getSingleResult();
            PghObligacionTipificacion obligacionTipificacion = crud.find(obligacionTipificacionDTO.getIdObliTipi(), PghObligacionTipificacion.class);
            obligacionTipificacion.setEstado(obligacionTipificacionDTO.getEstado());
            obligacionTipificacion.setCodTrazabilidad(obligacionTipificacionDTO.getCodTrazabilidad());
            if(obligacionTipificacion.getCodTrazabilidad()!=null && !obligacionTipificacion.getCodTrazabilidad().equals("")){
                crud.updateWithHistory(obligacionTipificacion);
            }else{
                crud.update(obligacionTipificacion);
            }
            
            retorno = ObligacionTipificacionBuilder.toObligacionTipificacionDto(obligacionTipificacion);
        }catch(Exception ex){
            log.error("",ex);
        }
        return retorno;
    }

    @Override
    public List<TipificacionDTO> findTificacion(ObligacionTipificacionDTO obligacionTipificacion){
        log.info("-- ObligacionTipificacionDAO - findTificacion --");
        log.info("-- parametros idObligacion : " + obligacionTipificacion.getIdObligacion());
        log.info("-- parametros idTipificacion : " + obligacionTipificacion.getIdTipificacion());
        List<TipificacionDTO> listaTipificacion = new ArrayList<TipificacionDTO>();
		try {
        StringBuilder jpql = new StringBuilder();
        jpql.append(" select t ");
        jpql.append(" from PghObligacionTipificacion ot "
                + " inner join ot.idTipificacion t");
        jpql.append(" where 1=1 ");
        jpql.append(" and ot.estado=1 ");
        jpql.append(" and t.estado=1 ");
        if(obligacionTipificacion.getIdObligacion() != null){
            jpql.append(" and ot.idObligacion.idObligacion = ").append(obligacionTipificacion.getIdObligacion());
        }
        if(obligacionTipificacion.getIdTipificacion() != null){
            jpql.append(" and ot.idTipificacion.idTipificacion = ").append(obligacionTipificacion.getIdTipificacion());
        }
        if(obligacionTipificacion.getIdActividad() != null){
        	jpql.append(" and ot.idActividad = ").append(obligacionTipificacion.getIdActividad());
        }
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<PghTipificacion> lstTipificacion = query.getResultList();
        if(lstTipificacion!=null){
        listaTipificacion = TipificacionBuilder.toListTipificacionDto(lstTipificacion);        
	        for(TipificacionDTO reg:listaTipificacion){
	            jpql = new StringBuilder();
	            jpql.append(" select ts ");
	            jpql.append(" from PghTipificacionSancion ts ");
	            jpql.append(" where ts.estado=1 ");
	            jpql.append("and ts.nivel= (select mc.idMaestroColumna from MdiMaestroColumna mc where mc.estado='1' and mc.mdiMaestroTabla.mdiMaestroTablaPK.dominio='NIVEL_TIPIFICACION' and mc.mdiMaestroTabla.mdiMaestroTablaPK.aplicacion='MYC') ");
	            jpql.append("and ts.pghTipificacion.idTipificacion=").append(reg.getIdTipificacion());
	            queryString = jpql.toString();
	            query = crud.getEm().createQuery(queryString);
	            List<TipificacionSancionDTO> lista = TipificacionSancionBuilder.getListaTipificacionSancion(query.getResultList());	            
	            reg.setListaTipificacionSancion(lista);
	            String abreviaturaConcatenada="";
		        if(!lista.isEmpty()){
		            String[] s = new String[lista.size()];
		            int cont=0;
		            for(TipificacionSancionDTO maestra : lista){
		            	s[cont]=maestra.getTipoSancion().getAbreviatura()==null?"":maestra.getTipoSancion().getAbreviatura().toString();cont++;}
		            abreviaturaConcatenada = StringUtils.join(s, ",");
		        }
		        reg.setSancionEspecifica(abreviaturaConcatenada);
	        }
        
        }
        
        
		} catch (Exception e) {
			e.printStackTrace();
		}	
        return listaTipificacion;
    }
    
    @Override
    public List<TipificacionDTO> findTipificacionPorObligacion(ObligacionTipificacionDTO obligacionTipificacion){
        log.info("-- ObligacionTipificacionDAO - findTificacion --");
        log.info("-- parametros idObligacion : " + obligacionTipificacion.getIdObligacion());
        log.info("-- parametros idTipificacion : " + obligacionTipificacion.getIdTipificacion());
        List<TipificacionDTO> listaTipificacion = new ArrayList<TipificacionDTO>();
		try {
		StringBuilder jpql = new StringBuilder();
        jpql.append("select ot.id_tipificacion,t.cod_tipificacion,t.descripcion,t.sancion_monetaria,ot.id_obli_tipi,ot.id_actividad,ot.id_obligacion,(select a.nombre from mdi_actividad a where a.id_actividad = ot.id_actividad and a.estado = '1') ");
        jpql.append("from pgh_obligacion_tipificacion ot ");
        jpql.append("inner join pgh_tipificacion t on t.id_tipificacion = ot.id_tipificacion ");
        jpql.append("where ot.id_obligacion = " + obligacionTipificacion.getIdObligacion() + " and ot.estado = '1' ");
        jpql.append("and t.estado = '1'");
        System.out.println("QUERY : " + jpql.toString());
        Query queryObliTipi = crud.getEm().createNativeQuery(jpql.toString());
   	    List<Object[]> resultado = queryObliTipi.getResultList(); 
        System.out.println(resultado.size());
        
        for (Object[] objeto : resultado) {
        	TipificacionDTO tipificacion = new TipificacionDTO();
        	tipificacion.setIdTipificacion(Long.parseLong(objeto[0].toString()));
        	tipificacion.setCodTipificacion(objeto[1].toString());
        	tipificacion.setDescripcion(objeto[2].toString());
        	tipificacion.setSancionMonetaria(objeto[3].toString());
        	tipificacion.setIdObliTipi(Long.parseLong(objeto[4].toString()));
        	tipificacion.setIdActividad(Long.parseLong(objeto[5] == null ? Constantes.CONSTANTE_VALOR_CERO : objeto[5].toString()));
        	tipificacion.setDescripcionActividad(objeto[7] == null ? Constantes.CONSTANTE_VACIO : objeto[7].toString());
        	listaTipificacion.add(tipificacion);
		}
        
	        for(TipificacionDTO reg:listaTipificacion){
	            jpql = new StringBuilder();
	            jpql.append(" select ts ");
	            jpql.append(" from PghTipificacionSancion ts ");
	            jpql.append(" where ts.estado=1 ");
	            jpql.append("and ts.nivel= (select mc.idMaestroColumna from MdiMaestroColumna mc where mc.estado='1' and mc.mdiMaestroTabla.mdiMaestroTablaPK.dominio='NIVEL_TIPIFICACION' and mc.mdiMaestroTabla.mdiMaestroTablaPK.aplicacion='MYC') ");
	            jpql.append("and ts.pghTipificacion.idTipificacion=").append(reg.getIdTipificacion());
	            String queryString = jpql.toString();
	            Query query = crud.getEm().createQuery(queryString);
	            List<TipificacionSancionDTO> lista = TipificacionSancionBuilder.getListaTipificacionSancion(query.getResultList());	            
	            reg.setListaTipificacionSancion(lista);
	            String abreviaturaConcatenada="";
		        if(!lista.isEmpty()){
		            String[] s = new String[lista.size()];
		            int cont=0;
		            for(TipificacionSancionDTO maestra : lista){
		            	s[cont]=maestra.getTipoSancion().getAbreviatura()==null?"":maestra.getTipoSancion().getAbreviatura().toString();cont++;}
		            abreviaturaConcatenada = StringUtils.join(s, ",");
		        }
		        reg.setSancionEspecifica(abreviaturaConcatenada);
	        }
        
		} catch (Exception e) {
			e.printStackTrace();
		}	
        return listaTipificacion;
    }
    
    @Override
    public List<ObligacionTipificacionDTO> findObligacionTipificacion(ObligacionTipificacionDTO obligacionTipificacion){
        log.info("-- ObligacionTipificacionDAO - findObligacionTipificacion --");
        log.info("-- parametros idObligacion : " + obligacionTipificacion.getIdObligacion());
        log.info("-- parametros idTipificacion : " + obligacionTipificacion.getIdTipificacion());
        log.info("-- parametros idActividad : " + obligacionTipificacion.getIdActividad());
        StringBuilder jpql = new StringBuilder();
        jpql.append(" select ot ");
        jpql.append(" from PghObligacionTipificacion ot ");
        jpql.append(" where 1=1 ");
        jpql.append(" and ot.estado=1 ");
        if(obligacionTipificacion.getIdObligacion() != null){
            jpql.append(" and ot.idObligacion.idObligacion = ").append(obligacionTipificacion.getIdObligacion());
        }
        if(obligacionTipificacion.getIdTipificacion() != null){
            jpql.append(" and ot.idTipificacion.idTipificacion = ").append(obligacionTipificacion.getIdTipificacion());
        }
        if(obligacionTipificacion.getIdActividad() != null){
            jpql.append(" and ot.idActividad = ").append(obligacionTipificacion.getIdActividad());
        }
        String queryString = jpql.toString();
        Query query = crud.getEm().createQuery(queryString);
        List<PghObligacionTipificacion> lstObligacionTipificacion = query.getResultList();
        List<ObligacionTipificacionDTO> listaObligacionTipificacion = ObligacionTipificacionBuilder.toListObligacionTipificacionDto(lstObligacionTipificacion);
        return listaObligacionTipificacion;
    }
}