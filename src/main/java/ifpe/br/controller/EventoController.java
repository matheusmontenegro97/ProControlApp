package ifpe.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifpe.br.model.Evento;
import ifpe.br.service.impl.EventoServiceImpl;

@RestController
@RequestMapping("api/v1")
public class EventoController {
	
	@Autowired
	EventoServiceImpl eventoService;

	@PostMapping("/evento/empresa")
	@CrossOrigin()
	public ResponseEntity<Evento> createEventoByEmpresa(@RequestBody Evento evento) throws Exception{
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.createEventoByEmpresa(evento));
	}
	
	@PostMapping("/evento/promotor")
	@CrossOrigin()
	public ResponseEntity<Evento> createEventoByPromotor(@RequestBody Evento evento) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.createEventoByPromotor(evento));
	}
	
	@GetMapping("/eventos/empresa/{codigoEmpresa}")
	@CrossOrigin()
	public ResponseEntity<List<Evento>> retornaEventoPorCodigoEmpresa(@PathVariable(value = "codigoEmpresa") Long codigoEmpresa)
			throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.getEventoByCodigoEmpresa(codigoEmpresa));
	}
	
	@GetMapping("eventos/promotor/{codigoPromotor}")
	@CrossOrigin()
	public ResponseEntity<List<Evento>> retornaEventoPorCodigoPromotor(@PathVariable(value = "codigoPromotor") Long codigoPromotor)
			throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.getEventoByCodigoPromotor(codigoPromotor));
	}
}
