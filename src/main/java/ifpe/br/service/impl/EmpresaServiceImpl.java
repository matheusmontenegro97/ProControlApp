package ifpe.br.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.mappers.UsuarioEmpresaDTOMapper;
import ifpe.br.model.Empresa;
import ifpe.br.model.RequestLogin;
import ifpe.br.model.UsuarioEmpresa;
import ifpe.br.model.dto.UsuarioEmpresaDTO;
import ifpe.br.repository.EmpresaRepository;
import ifpe.br.repository.UsuarioRepositoryEmpresa;

@Service
public class EmpresaServiceImpl {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private UsuarioRepositoryEmpresa loginEmpresa;

	public Empresa retornaEmpresaById(Long codigoEmpresa) throws Exception {

		Empresa empresa = empresaRepository.findById(codigoEmpresa)
				.orElseThrow(() -> new Exception("Id não encontrado"));

		return empresa;
	}

	public UsuarioEmpresaDTO retornaUsuarioEmpresaByLoginAndPassword(RequestLogin request) {
		UsuarioEmpresa usuarioEmpresa = loginEmpresa.findByLoginAndPassword(request.getLogin(), request.getPassword());
		UsuarioEmpresaDTOMapper usuarioEmpresaDTOMapper = new UsuarioEmpresaDTOMapper();
			
		return usuarioEmpresaDTOMapper.map(usuarioEmpresa);
	}

	@Transactional
	public Empresa createEmpresa(Empresa empresa) throws Exception {
		Empresa empresaSaved = empresaRepository.save(empresa);

		UsuarioEmpresa usuario = new UsuarioEmpresa();
		usuario.setLogin(empresa.getLogin());
		usuario.setPassword(empresa.getPassword());
		usuario.setEmpresa(empresa);

		loginEmpresa.save(usuario);

		return empresaSaved;
	}

	@Transactional
	public Empresa updateEmpresa(Empresa empresa, Long codigoEmpresa) throws Exception {
		Optional<Empresa> empresaOptional = empresaRepository.findById(codigoEmpresa);

		if (empresaOptional.isPresent()) {
			empresa.setCodigoEmpresa(empresaOptional.get().getCodigoEmpresa());
			empresa.setLogin(empresaOptional.get().getLogin());
			empresa.setPassword(empresaOptional.get().getPassword());
		}

		else {
			throw new Exception("Id não encontrado!");
		}

		return empresaRepository.save(empresa);
	}

	public Optional<Empresa> findByIdEmpresa(Long codigoEmpresa) {
		return empresaRepository.findById(codigoEmpresa);
	}
}
