package ifpe.br.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "promotor")
public class Promotor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoPromotor;
	@Column(name = "fk_empresa")
	private Long codigoEmpresa;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;

	public Promotor() {
	}

	public Promotor(Long codigoPromotor, Long codigoEmpresa, String cpf, String nome, String telefone, String email,
			String endereco) {
		super();
		this.codigoPromotor = codigoPromotor;
		this.codigoEmpresa = codigoEmpresa;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	public Long getCodigoPromotor() {
		return codigoPromotor;
	}

	public void setCodigoPromotor(Long codigoPromotor) {
		this.codigoPromotor = codigoPromotor;
	}

	public Long getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(Long codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoEmpresa, codigoPromotor, cpf, email, endereco, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promotor other = (Promotor) obj;
		return Objects.equals(codigoEmpresa, other.codigoEmpresa)
				&& Objects.equals(codigoPromotor, other.codigoPromotor) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}

}
