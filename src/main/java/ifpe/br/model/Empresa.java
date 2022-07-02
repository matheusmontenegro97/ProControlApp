package ifpe.br.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empresa {

	@Id
	@Column(name = "userId", columnDefinition = "BINARY(16)")
	@GeneratedValue
	private UUID codigoEmpresa;
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private Endereco endereco;

}
