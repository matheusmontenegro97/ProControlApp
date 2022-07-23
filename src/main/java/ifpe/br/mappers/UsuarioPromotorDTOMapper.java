package ifpe.br.mappers;

import ifpe.br.model.UsuarioPromotor;
import ifpe.br.model.dto.UsuarioPromotorDTO;

public class UsuarioPromotorDTOMapper {
	
	public UsuarioPromotorDTO map (UsuarioPromotor usuarioPromotor) {
		UsuarioPromotorDTO usuario = new UsuarioPromotorDTO();
		usuario.setCodigoEmpresa(usuarioPromotor.getPromotor().getCodigoEmpresa());
		usuario.setCodigoPromotor(usuarioPromotor.getPromotor().getCodigoPromotor());
		usuario.setCpf(usuarioPromotor.getPromotor().getCpf());
		usuario.setEmail(usuarioPromotor.getPromotor().getEmail());
		usuario.setEndereco(usuarioPromotor.getPromotor().getEndereco());
		usuario.setNome(usuarioPromotor.getPromotor().getNome());
		usuario.setTelefone(usuarioPromotor.getPromotor().getTelefone());
		
		return usuario;
	}
}
