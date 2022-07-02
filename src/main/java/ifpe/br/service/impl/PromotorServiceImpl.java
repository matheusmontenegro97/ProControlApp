package ifpe.br.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.model.Promotor;
import ifpe.br.repository.PromotorRepository;

@Service
public class PromotorServiceImpl {

	@Autowired
	PromotorRepository promotorRepository;
	
	@Autowired
	EmpresaServiceImpl empresaService;
	
	@Transactional
	public Promotor createPromotor(Promotor promotor) {
		empresaService.updatePromotores(promotor.getCodigoEmpresa(), promotor);
	
		return promotorRepository.save(promotor);
	}
	
}
