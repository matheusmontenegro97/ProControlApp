package ifpe.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Promotor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoPromotor;
	private Long codigoEmpresa;
	private String matricula;
	private String nomeCompleto;
	
}
