package ifpe.br.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.mappers.PromotorDTOMapper;
import ifpe.br.mappers.UsuarioPromotorDTOMapper;
import ifpe.br.model.Promotor;
import ifpe.br.model.RequestLogin;
import ifpe.br.model.UsuarioPromotor;
import ifpe.br.model.dto.PromotorDTO;
import ifpe.br.model.dto.UsuarioPromotorDTO;
import ifpe.br.repository.PromotorRepository;
import ifpe.br.repository.UsuarioRepositoryPromotor;

@Service
public class PromotorServiceImpl {

	@Autowired
	PromotorRepository promotorRepository;

	@Autowired
	EmpresaServiceImpl empresaService;
	
	@Autowired
	UsuarioRepositoryPromotor loginPromotor;
	
	@Autowired
	UsuarioPromotorDTOMapper usuarioPromotorDTOMapper;
	
	@Autowired
	PromotorDTOMapper promotorDTOMapper;

	public Promotor getPromotorById(Long codigoPromotor) throws Exception {
		Promotor promotor = promotorRepository.findById(codigoPromotor)
				.orElseThrow(() -> new Exception("Código não encontrado"));
		
		return promotor;
	}

	public UsuarioPromotorDTO retornaUsuarioPromotorByLoginAndPassword(RequestLogin request) {
		UsuarioPromotor usuarioPromotor = loginPromotor.findByLoginAndPassword(request.getLogin(), request.getPassword());
		
		return usuarioPromotorDTOMapper.map(usuarioPromotor);
	}
	
	@Transactional
	public PromotorDTO createPromotor(Promotor promotor) {
		Promotor promotorSaved = promotorRepository.save(promotor);
		
		UsuarioPromotor usuario = new UsuarioPromotor();
		usuario.setLogin(promotor.getLogin());
		usuario.setPassword(promotor.getPassword());
		usuario.setPromotor(promotor);
		
		loginPromotor.save(usuario);

		return promotorDTOMapper.map(promotorSaved);
	}

	@Transactional
	public PromotorDTO updatePromotor(Promotor promotor, Long codigoPromotor) throws Exception {
		Optional<Promotor> promotorOptional = promotorRepository.findById(codigoPromotor);

		if (promotorOptional.isPresent()) {
			promotor.setCodigoEmpresa(promotorOptional.get().getCodigoEmpresa());
		}

		else {
			throw new Exception("Id não encontrado!");
		}
		
		Promotor promotorSaved = promotorRepository.save(promotor);

		return promotorDTOMapper.map(promotorSaved);
	}

	public Optional<Promotor> findByIdPromotor(Long codigoPromotor) {
		return promotorRepository.findById(codigoPromotor);
	}

	public void deletaPromotor(Long codigoPromotor) {
		Optional<Promotor> optionalPromotor = findByIdPromotor(codigoPromotor);

		if (optionalPromotor.isPresent()) {
			promotorRepository.deleteById(codigoPromotor);
		}
	}

	public List<PromotorDTO> retornaListaPromotoresByCodigoEmpresa(Long codigoEmpresa) {
		List<Promotor> promotores = promotorRepository.findPromotoresByCodigoEmpresa(codigoEmpresa);
		List<PromotorDTO> promotoresDTO = new ArrayList<>();
		
		promotores.forEach(promotor -> promotoresDTO.add(promotorDTOMapper.map(promotor)));
		
		return promotoresDTO;
	}
	
}
