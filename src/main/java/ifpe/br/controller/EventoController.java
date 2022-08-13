package ifpe.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@PostMapping("/evento")
	@CrossOrigin()
	public ResponseEntity<Evento> createEventoByEmpresa(@RequestBody Evento evento) throws Exception{
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.createEventoByEmpresa(evento));
	}
}
