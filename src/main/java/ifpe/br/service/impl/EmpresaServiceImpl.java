package ifpe.br.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.model.Empresa;
import ifpe.br.model.Promotor;
import ifpe.br.repository.EmpresaRepository;
import ifpe.br.repository.PromotorRepository;

@Service
public class EmpresaServiceImpl {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	PromotorRepository promotorRepository;

	public Empresa retornaEmpresaById(Long codigoEmpresa) throws Exception {

		Empresa empresa = empresaRepository.findById(codigoEmpresa)
				.orElseThrow(() -> new Exception("Id não encontrado"));

		return empresa;
	}

	@Transactional
	public Empresa createEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Transactional
	public Empresa updateEmpresa(Empresa empresa, Long codigoEmpresa) throws Exception {
		Optional<Empresa> empresaOptional = empresaRepository.findById(codigoEmpresa);

		if (empresaOptional.isPresent()) {
			empresa.setCodigoEmpresa(empresaOptional.get().getCodigoEmpresa());
		}

		else {
			throw new Exception("Id não encontrado!");
		}

		return empresaRepository.save(empresa);
	}
	
	public Optional<Empresa> findByIdEmpresa(Long codigoEmpresa){
		return empresaRepository.findById(codigoEmpresa);
	}

	public void updatePromotores (Long codigoEmpresa, Promotor promotor) {
		Optional<Empresa> empresaOptional = empresaRepository.findById(codigoEmpresa);
		List<Promotor> promotores = promotorRepository.findAll();
		
		promotores.add(promotor);

		if(empresaOptional.isPresent()) {
			empresaOptional.get().setPromotores(promotores);
		}

	}
}
