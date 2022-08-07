package ifpe.br.mappers;

import org.springframework.stereotype.Component;

import ifpe.br.model.Empresa;
import ifpe.br.model.dto.EmpresaDTO;

@Component
public class EmpresaDTOMapper {
	public EmpresaDTO map(Empresa empresa) {
		
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setCodigoEmpresa(empresa.getCodigoEmpresa());
		empresaDTO.setCnpj(empresa.getCnpj());
		empresaDTO.setRazaoSocial(empresa.getRazaoSocial());
		empresaDTO.setEndereco(empresa.getEndereco());
		empresaDTO.setTelefone(empresa.getTelefone());
		
		return empresaDTO;
	}
}
