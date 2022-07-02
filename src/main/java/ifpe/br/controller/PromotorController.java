package ifpe.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifpe.br.model.Promotor;
import ifpe.br.service.impl.PromotorServiceImpl;

@RestController
@RequestMapping("api/v1")
public class PromotorController {
	
	@Autowired
	PromotorServiceImpl service;

	@PostMapping("/promotor")
	public ResponseEntity<Promotor> criaEmpresa(@RequestBody Promotor promotor) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.createPromotor(promotor));
	}
}
