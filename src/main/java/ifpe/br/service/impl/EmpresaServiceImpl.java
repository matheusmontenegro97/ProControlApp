package ifpe.br.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.mappers.EmpresaDTOMapper;
import ifpe.br.mappers.UsuarioEmpresaDTOMapper;
import ifpe.br.model.Empresa;
import ifpe.br.model.RequestLogin;
import ifpe.br.model.UsuarioEmpresa;
import ifpe.br.model.dto.EmpresaDTO;
import ifpe.br.model.dto.UsuarioEmpresaDTO;
import ifpe.br.repository.EmpresaRepository;
import ifpe.br.repository.UsuarioRepositoryEmpresa;

@Service
public class EmpresaServiceImpl {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private UsuarioRepositoryEmpresa loginEmpresa;
	
	@Autowired
	private UsuarioEmpresaDTOMapper usuarioEmpresaDTOMapper;
	
	@Autowired
	private EmpresaDTOMapper empresaDTOMapper;

	public EmpresaDTO retornaEmpresaById(Long codigoEmpresa) throws Exception {

		Empresa empresa = empresaRepository.findById(codigoEmpresa)
				.orElseThrow(() -> new Exception("Id não encontrado"));

		return empresaDTOMapper.map(empresa);
	}

	public UsuarioEmpresaDTO retornaUsuarioEmpresaByLoginAndPassword(RequestLogin request) {
		UsuarioEmpresa usuarioEmpresa = loginEmpresa.findByLoginAndPassword(request.getLogin(), request.getPassword());
			
		return usuarioEmpresaDTOMapper.map(usuarioEmpresa);
	}

	@Transactional
	public EmpresaDTO createEmpresa(Empresa empresa) throws Exception {
		Empresa empresaSaved = empresaRepository.save(empresa);

		UsuarioEmpresa usuario = new UsuarioEmpresa();
		usuario.setLogin(empresa.getLogin());
		usuario.setPassword(empresa.getPassword());
		usuario.setEmpresa(empresa);

		loginEmpresa.save(usuario);

		return empresaDTOMapper.map(empresaSaved);
	}

	@Transactional
	public EmpresaDTO updateEmpresa(Empresa empresa, Long codigoEmpresa) throws Exception {
		Optional<Empresa> empresaOptional = empresaRepository.findById(codigoEmpresa);

		if (empresaOptional.isPresent()) {
			empresa.setCodigoEmpresa(empresaOptional.get().getCodigoEmpresa());
			empresa.setLogin(empresaOptional.get().getLogin());
			empresa.setPassword(empresaOptional.get().getPassword());
		}

		else {
			throw new Exception("Id não encontrado!");
		}
		
		Empresa empresaSaved = empresaRepository.save(empresa);

		return empresaDTOMapper.map(empresaSaved);
	}

	public Optional<Empresa> findByIdEmpresa(Long codigoEmpresa) {
		return empresaRepository.findById(codigoEmpresa);
	}
	
	public boolean existEmpresById(Long codigoEmpresa) {
		return empresaRepository.existsById(codigoEmpresa);
	}
}
