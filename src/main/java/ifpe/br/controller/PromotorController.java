package ifpe.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ifpe.br.model.Promotor;
import ifpe.br.model.RequestLogin;
import ifpe.br.model.dto.PromotorDTO;
import ifpe.br.model.dto.UsuarioPromotorDTO;
import ifpe.br.service.impl.PromotorServiceImpl;

@RestController
@RequestMapping("api/v1")
public class PromotorController {
	
	@Autowired
	PromotorServiceImpl service;
	

	@GetMapping("/promotor/codigoPromotor")
	@CrossOrigin()
	public ResponseEntity<Promotor> retornaPromotorPorId(@PathVariable(value = "codigoPromotor")Long codigoPromotor) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.getPromotorById(codigoPromotor));
	}
	
	@PostMapping("/auth/promotor")
	@CrossOrigin()
	public ResponseEntity<UsuarioPromotorDTO> retornaUsuarioEmpresa(@RequestBody RequestLogin request){
		return ResponseEntity.status(HttpStatus.OK).body(service.retornaUsuarioPromotorByLoginAndPassword(request));
	}

	@PostMapping("/promotor")
	@CrossOrigin()
	public ResponseEntity<PromotorDTO> criaEmpresa(@RequestBody Promotor promotor) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.createPromotor(promotor));
	}
	
	@PutMapping("/promotor/{codigoPromotor}")
	@CrossOrigin()
	public ResponseEntity<PromotorDTO> atualizaPromotorPorId(@PathVariable(value = "codigoPromotor") Long codigoPromotor,
			@RequestBody Promotor promotor) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.updatePromotor(promotor, codigoPromotor));
	}
	
	@DeleteMapping("/promotor/{codigoPromotor}")
	@ResponseStatus(value = HttpStatus.OK)
	@CrossOrigin()
	public void deletaPromotorPorId (@PathVariable(value = "codigoPromotor") Long codigoPromotor){
		 service.deletaPromotor(codigoPromotor);
	}
	
	@GetMapping("promotores/{codigoEmpresa}")
	@CrossOrigin()
	public List<PromotorDTO> retornaListaPromotoresPorCodigoEmpresa(@PathVariable(value="codigoEmpresa") Long codigoEmpresa){
		return service.retornaListaPromotoresByCodigoEmpresa(codigoEmpresa);
				
	}
}
