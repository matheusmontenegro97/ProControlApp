package ifpe.br.service.impl;

import java.util.List;

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
				
		evento.setCodigoPromotor(promotorEvento.getCodigoPromotor());
		evento.setEventoRealizado(false);
		evento.setImgEventoRealizado("");
		evento.setLatitude("");
		evento.setLongitude("");
		
		Evento eventoSaved = eventoRepository.save(evento);
		
		return eventoSaved;
	}
	
	public List<Evento> getEventoByCodigoEmpresa(Long codigoEmpresa) {
		return eventoRepository.findByCodigoEmpresa(codigoEmpresa);
	}
	
	public List<Evento> getEventoByCodigoPromotor(Long codigoPromotor) {
		return eventoRepository.findByCodigoPromotor(codigoPromotor);
	}

	public Evento createEventoByPromotor(Evento evento) throws Exception {
		Evento eventoPromotor = eventoRepository.findById(evento.getCodigoEvento()).orElseThrow( () -> new Exception("Evento não encontrado") );
		
		evento.setEventoRealizado(true);
		evento.setCodigoPromotor(eventoPromotor.getCodigoPromotor());
		evento.setCodigoEvento(eventoPromotor.getCodigoEvento());
		evento.setCodigoEmpresa(eventoPromotor.getCodigoEmpresa());
		evento.setTitulo(eventoPromotor.getTitulo());
		evento.setEndereco(eventoPromotor.getEndereco());
		evento.setImgEmpresa(eventoPromotor.getImgEmpresa());
		evento.setData(eventoPromotor.getData());
		evento.setHorario(eventoPromotor.getHorario());
		
		Evento eventoPromotorSaved = eventoRepository.save(evento);
		
		return eventoPromotorSaved;
	}
}
