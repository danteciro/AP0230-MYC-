package gob.osinergmin.myc.domain.ui;
/**
 *
 * @author mdiosesf
 */
public class ConfFiltroEmpSupFilter {
    private Long idFiltroEmpSup;
    private Long idUnidadOrganica;
    private Long idFiltro;
    private String estado;

    public ConfFiltroEmpSupFilter(){
    }

	public Long getIdFiltroEmpSup() {
		return idFiltroEmpSup;
	}

	public void setIdFiltroEmpSup(Long idFiltroEmpSup) {
		this.idFiltroEmpSup = idFiltroEmpSup;
	}

	public Long getIdUnidadOrganica() {
		return idUnidadOrganica;
	}

	public void setIdUnidadOrganica(Long idUnidadOrganica) {
		this.idUnidadOrganica = idUnidadOrganica;
	}

	public Long getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(Long idFiltro) {
		this.idFiltro = idFiltro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
