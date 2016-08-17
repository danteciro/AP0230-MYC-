/**
* Resumen		
* Objeto		: PghUnidObliSubTipo.java
* Descripci�n		: Clase del modelo de dominio PghUnidObliSubTipo
* Fecha de Creaci�n	: 
* PR de Creaci�n	: OSINE_SFS-480
* Autor			: Julio Piro Gonzales
* ---------------------------------------------------------------------------------------------------
* Modificaciones
* Motivo            Fecha           Nombre                              Descripci�n
* ---------------------------------------------------------------------------------------------------
* OSINE_SFS-480     24/05/2016      Giancarlo Villanueva Andrade        Crear componente de selecci�n de "subtipo de supervisi�n".Relacionar y adecuar el subtipo de supervisi�n, el cual deber� depender del tipo de supervisi�n seleccionado.
* 
*/ 

package gob.osinergmin.myc.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gvillanueva
 */
@Entity
@Table(name = "PGH_UNID_OBLI_SUB_TIPO")
@NamedQueries({
    @NamedQuery(name = "PghUnidObliSubTipo.findAll", query = "SELECT p FROM PghUnidObliSubTipo p"),
    @NamedQuery(name = "PghUnidObliSubTipo.findByPeriodoBySubTipo", query = "SELECT p FROM PghUnidObliSubTipo p " +
    		"where p.estado= :estado " +
    		"and p.idObligacionSubTipo.idObligacionSubTipo= :idObligacionSubTipo " +
    		"and p.periodo= :periodo"),
    @NamedQuery(name = "PghUnidObliSubTipo.findByParameters", query = "SELECT p FROM PghUnidObliSubTipo p " +
    	    " where p.estado= :estado " +
    	    " and p.idUnidadSupervisada.idUnidadSupervisada =:idUnidadSupervisada" +
    	    " and p.flagSupOrdenServicio =:flagSupOrdenServicio " +
    	    " and p.periodo= :periodo")		
    })
public class PghUnidObliSubTipo extends Auditoria {

    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="ID_UNID_OBLI_SUB_TIPO_SEQ",sequenceName="PGH_UNID_OBLI_SUB_TIPO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ID_UNID_OBLI_SUB_TIPO_SEQ")
    @Column(name = "ID_UNID_OBLI_SUB_TIPO")
    private Long idUnidObliSubTipo;
    @Size(max = 10)
    @Column(name = "PERIODO")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private String estado;
    /* OSINE_SFS-480 - RSIS27 Inicio*/
    @JoinColumn(name = "TIPO_SELECCION")
    @ManyToOne(optional = false)
    private MdiMaestroColumna tipoSeleccion;
    @Column(name = "FLAG_SUP_ORDEN_SERVICIO")
    private String flagSupOrdenServicio;
    /* OSINE_SFS-480 - RSIS27 Fin*/
    @JoinColumn(name = "ID_OBLIGACION_SUB_TIPO", referencedColumnName = "ID_OBLIGACION_SUB_TIPO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PghObligacionSubTipo idObligacionSubTipo;
    @JoinColumn(name = "ID_UNIDAD_SUPERVISADA", referencedColumnName = "ID_UNIDAD_SUPERVISADA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MdiUnidadSupervisada idUnidadSupervisada;

    public PghUnidObliSubTipo() {
    }

    public PghUnidObliSubTipo(Long idUnidObliSubTipo) {
        this.idUnidObliSubTipo = idUnidObliSubTipo;
    }

    public PghUnidObliSubTipo(Long idUnidObliSubTipo, String estado, String usuarioCreacion, Date fechaCreacion, String terminalCreacion) {
        this.idUnidObliSubTipo = idUnidObliSubTipo;
        this.estado = estado;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.terminalCreacion = terminalCreacion;
    }

    public Long getIdUnidObliSubTipo() {
        return idUnidObliSubTipo;
    }

    public void setIdUnidObliSubTipo(Long idUnidObliSubTipo) {
        this.idUnidObliSubTipo = idUnidObliSubTipo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PghObligacionSubTipo getIdObligacionSubTipo() {
        return idObligacionSubTipo;
    }

    public void setIdObligacionSubTipo(PghObligacionSubTipo idObligacionSubTipo) {
        this.idObligacionSubTipo = idObligacionSubTipo;
    }

    public MdiUnidadSupervisada getIdUnidadSupervisada() {
        return idUnidadSupervisada;
    }

    public void setIdUnidadSupervisada(MdiUnidadSupervisada idUnidadSupervisada) {
        this.idUnidadSupervisada = idUnidadSupervisada;
    }    
    /* OSINE_SFS-480 - RSIS27 Inicio*/

    public MdiMaestroColumna getTipoSeleccion() {
        return tipoSeleccion;
    }

    public void setTipoSeleccion(MdiMaestroColumna tipoSeleccion) {
        this.tipoSeleccion = tipoSeleccion;
    }
	
	public String getFlagSupOrdenServicio() {
		return flagSupOrdenServicio;
	}

	public void setFlagSupOrdenServicio(String flagSupOrdenServicio) {
		this.flagSupOrdenServicio = flagSupOrdenServicio;
	}
	/* OSINE_SFS-480 - RSIS27 Fin*/
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidObliSubTipo != null ? idUnidObliSubTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PghUnidObliSubTipo)) {
            return false;
        }
        PghUnidObliSubTipo other = (PghUnidObliSubTipo) object;
        if ((this.idUnidObliSubTipo == null && other.idUnidObliSubTipo != null) || (this.idUnidObliSubTipo != null && !this.idUnidObliSubTipo.equals(other.idUnidObliSubTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Z.PghUnidObliSubTipo[ idUnidObliSubTipo=" + idUnidObliSubTipo + " ]";
    }
    
}
