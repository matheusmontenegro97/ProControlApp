package ifpe.br.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import ifpe.br.enums.Estados;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Endereco {
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	@Enumerated(EnumType.STRING)
	private Estados uf;

}
