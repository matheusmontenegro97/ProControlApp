package ifpe.br.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifpe.br.model.Empresa;
import ifpe.br.service.impl.EmpresaServiceImpl;

@RestController
@RequestMapping("api/v1")
public class EmpresaController {

	@Autowired
	private EmpresaServiceImpl service;
	
	@GetMapping("/{codigoEmpresa}")
	public ResponseEntity<Empresa> retornaEmpresaPorId(@PathVariable(value="codigoEmpresa") UUID codigoEmpresa) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(service.retornaEmpresaById(codigoEmpresa));
	}

	@PostMapping
	public ResponseEntity<Empresa> criaEmpresa(@RequestBody Empresa empresa) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmpresa(empresa));
	}

	@PutMapping("/{codigoEmpresa}")
	public ResponseEntity<Empresa> atualizaEmpresa(@PathVariable(value = "codigoEmpresa") UUID codigoEmpresa,
			@RequestBody Empresa empresa) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).body(service.updateEmpresa(empresa, codigoEmpresa));
	}

}
