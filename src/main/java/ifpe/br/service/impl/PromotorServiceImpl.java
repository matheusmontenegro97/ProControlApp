package ifpe.br.service.impl;

import java.util.List;
import java.util.Optional;

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

	public Promotor getPromotorById(Long codigoPromotor) throws Exception {
		Promotor promotor = promotorRepository.findById(codigoPromotor)
				.orElseThrow(() -> new Exception("Código não encontrado"));
		
		return promotor;
	}

	@Transactional
	public Promotor createPromotor(Promotor promotor) {

		return promotorRepository.save(promotor);
	}

	@Transactional
	public Promotor updatePromotor(Promotor promotor, Long codigoPromotor) throws Exception {
		Optional<Promotor> promotorOptional = promotorRepository.findById(codigoPromotor);

		if (promotorOptional.isPresent()) {
			promotor.setCodigoEmpresa(promotorOptional.get().getCodigoEmpresa());
		}

		else {
			throw new Exception("Id não encontrado!");
		}

		return promotorRepository.save(promotor);
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

	public List<Promotor> retornaListaPromotoresByCodigoEmpresa(Long codigoEmpresa) {
		return promotorRepository.findPromotoresByCodigoEmpresa(codigoEmpresa);
	}

}
