package ifpe.br.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpe.br.mappers.PromotorDTOMapper;
import ifpe.br.model.Evento;
import ifpe.br.model.Promotor;
import ifpe.br.repository.EventoRepository;

@Service
public class EventoServiceImpl {

	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	EmpresaServiceImpl empresaService;
	
	@Autowired
	PromotorServiceImpl promotorService;
	
	@Autowired
	PromotorDTOMapper promotorMapper;
	
	public Evento createEventoByEmpresa(Evento evento) throws Exception {
		Promotor promotorEvento = promotorService.findByIdPromotor(evento.getCodigoPromotor()).orElseThrow(() -> new Exception("Promotor não encontrado!"));
		
		try {
			empresaService.existEmpresById(evento.getCodigoEmpresa());
		} catch (Exception e) {
			throw new Exception("Empresa inexistente!");
		}
				
		evento.setPromotor(promotorEvento);
		evento.setEventoRealizado(false);
		evento.setImgEventoRealizado("");
		evento.setLatitude("");
		evento.setLongitude("");
		
		Evento eventoSaved = eventoRepository.save(evento);
		
		return eventoSaved;
	}
	
	public Evento getEventoByCodigoEmpresa(Long codigoEmpresa) {
		return null;
	}
	
	public Evento createEventoByPromotor(Evento evento) {
		return null;
	}
}
