package ifpe.br.mappers;

import org.springframework.stereotype.Component;

import ifpe.br.model.UsuarioEmpresa;
import ifpe.br.model.dto.UsuarioEmpresaDTO;

@Component
public class UsuarioEmpresaDTOMapper {
	public UsuarioEmpresaDTO map(UsuarioEmpresa usuarioEmpresa) {
		UsuarioEmpresaDTO usuario = new UsuarioEmpresaDTO();
		usuario.setCodigoEmpresa(usuarioEmpresa.getEmpresa().getCodigoEmpresa());
		usuario.setCnpj(usuarioEmpresa.getEmpresa().getCnpj());
		usuario.setEndereco(usuarioEmpresa.getEmpresa().getEndereco());
		usuario.setRazaoSocial(usuarioEmpresa.getEmpresa().getRazaoSocial());
		usuario.setTelefone(usuarioEmpresa.getEmpresa().getTelefone());
		
		return usuario;
		
	}
}
