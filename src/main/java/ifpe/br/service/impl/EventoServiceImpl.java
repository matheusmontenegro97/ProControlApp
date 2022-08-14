package ifpe.br.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
		
		evento.setNomePromotor(promotorEvento.getNome());
		evento.setCodigoPromotor(promotorEvento.getCodigoPromotor());
		evento.setEventoRealizado(false);
		evento.setImgEventoRealizado("");
		evento.setLatitude("");
		evento.setLongitude("");
		
		Evento eventoSaved = eventoRepository.save(evento);
		
		return eventoSaved;
	}
	
	@Transactional
	public Evento updateEventoByEmpresa(Evento evento,Long codigoEvento) throws Exception {
		Optional<Evento> eventoOptional = eventoRepository.findById(codigoEvento);
		
		if(eventoOptional.isPresent()) {
			evento.setCodigoEvento(eventoOptional.get().getCodigoEvento());
			evento.setCodigoEmpresa(eventoOptional.get().getCodigoEmpresa());
			evento.setCodigoPromotor(eventoOptional.get().getCodigoPromotor());
			evento.setNomePromotor(eventoOptional.get().getNomePromotor());
			evento.setEventoRealizado(eventoOptional.get().getEventoRealizado());
			evento.setDataRealizacaoEvento(eventoOptional.get().getDataRealizacaoEvento());
			evento.setImgEmpresa(eventoOptional.get().getImgEmpresa());
			evento.setLongitude(eventoOptional.get().getLongitude());
			evento.setLatitude(eventoOptional.get().getLatitude());
			evento.setImgEventoRealizado(eventoOptional.get().getImgEventoRealizado());
		}
		else {
			throw new Exception("Evento não encontrado!");
		}
		
		Evento eventoSaved = eventoRepository.save(evento);
		
		return eventoSaved;
	}
	
	public Evento updateEventoByPromotor(Evento evento,Long codigoEvento) throws Exception{
		Optional<Evento> eventoOptional = eventoRepository.findById(codigoEvento);
		
		if(eventoOptional.isPresent()) {
			evento.setCodigoEvento(eventoOptional.get().getCodigoEvento());
			evento.setCodigoEmpresa(eventoOptional.get().getCodigoEmpresa());
			evento.setCodigoPromotor(eventoOptional.get().getCodigoPromotor());
			evento.setNomePromotor(eventoOptional.get().getNomePromotor());
			evento.setTitulo(eventoOptional.get().getTitulo());
			evento.setImgEmpresa(eventoOptional.get().getImgEmpresa());
			evento.setData(eventoOptional.get().getData());
			evento.setEndereco(eventoOptional.get().getEndereco());
			evento.setEventoRealizado(eventoOptional.get().getEventoRealizado());
		}
		else {
			throw new Exception("Evento não encontrado!");
		}
		
		Evento eventoSaved = eventoRepository.save(evento);
		
		return eventoSaved;
	}
	
	public Evento atualizaPromotorDeEvento(Long codigoEvento, Long codigoPromotor) throws Exception {
		Promotor promotorEvento = promotorService.findByIdPromotor(codigoPromotor).orElseThrow(() -> new Exception("Promotor não encontrado!"));
		Evento eventoOptional = eventoRepository.findById(codigoEvento).orElseThrow( () -> new Exception("Evento não encontrado") );
		
		eventoOptional.setCodigoPromotor(promotorEvento.getCodigoPromotor());
		eventoOptional.setNomePromotor(promotorEvento.getNome());

		Evento eventoSaved = eventoRepository.save(eventoOptional);
		
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
		evento.setNomePromotor(eventoPromotor.getNomePromotor());
		evento.setCodigoEvento(eventoPromotor.getCodigoEvento());
		evento.setCodigoEmpresa(eventoPromotor.getCodigoEmpresa());
		evento.setTitulo(eventoPromotor.getTitulo());
		evento.setEndereco(eventoPromotor.getEndereco());
		evento.setImgEmpresa(eventoPromotor.getImgEmpresa());
		evento.setData(eventoPromotor.getData());
		
		Evento eventoPromotorSaved = eventoRepository.save(evento);
		
		return eventoPromotorSaved;
	}
}
