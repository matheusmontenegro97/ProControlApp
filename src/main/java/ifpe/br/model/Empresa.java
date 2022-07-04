package ifpe.br.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo_empresa")
	private Long codigoEmpresa;
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private String cep;
	private String endereco;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_empresa",referencedColumnName = "codigo_empresa")
	private List<Promotor> promotores;

	public Empresa() {
	}

	public Empresa(Long codigoEmpresa, String razaoSocial, String cnpj, String telefone, String cep, String endereco,
			List<Promotor> promotores) {
		super();
		this.codigoEmpresa = codigoEmpresa;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.cep = cep;
		this.endereco = endereco;
		this.promotores = promotores;
	}

	public Long getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(Long codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Promotor> getPromotores() {
		return promotores;
	}

	public void setPromotores(List<Promotor> promotores) {
		this.promotores = promotores;
	}

}
