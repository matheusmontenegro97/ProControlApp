package ifpe.br.mappers;

import org.springframework.stereotype.Component;

import ifpe.br.model.Promotor;
import ifpe.br.model.dto.PromotorDTO;

@Component
public class PromotorDTOMapper {

	public PromotorDTO map(Promotor promotor) {

		PromotorDTO promotorDTO = new PromotorDTO();
		promotorDTO.setCodigoPromotor(promotor.getCodigoPromotor());
		promotorDTO.setCodigoEmpresa(promotor.getCodigoEmpresa());
		promotorDTO.setCpf(promotor.getCpf());
		promotorDTO.setEmail(promotor.getEmail());
		promotorDTO.setEndereco(promotor.getEndereco());
		promotorDTO.setNome(promotor.getNome());
		promotorDTO.setTelefone(promotor.getTelefone());

		return promotorDTO;
	}

}
