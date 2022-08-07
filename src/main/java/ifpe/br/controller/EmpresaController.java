package ifpe.br.controller;

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
import ifpe.br.model.RequestLogin;
import ifpe.br.model.dto.EmpresaDTO;
import ifpe.br.model.dto.UsuarioEmpresaDTO;
import ifpe.br.service.impl.EmpresaServiceImpl;

@RestController
@RequestMapping("api/v1")
public class EmpresaController {

	@Autowired
	private EmpresaServiceImpl service;

	@GetMapping("/{codigoEmpresa}")
	public ResponseEntity<EmpresaDTO> retornaEmpresaPorId(@PathVariable(value = "codigoEmpresa") Long codigoEmpresa)
			throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(service.retornaEmpresaById(codigoEmpresa));
	}

	@PostMapping("/auth/empresa")
	public ResponseEntity<UsuarioEmpresaDTO> retornaUsuarioEmpresa(@RequestBody RequestLogin request){
		return ResponseEntity.status(HttpStatus.OK).body(service.retornaUsuarioEmpresaByLoginAndPassword(request));
	}
	
	@PostMapping
	public ResponseEntity<EmpresaDTO> criaEmpresa(@RequestBody Empresa empresa) throws Exception {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmpresa(empresa));
	}

	@PutMapping("/{codigoEmpresa}")
	public ResponseEntity<EmpresaDTO> atualizaEmpresa(@PathVariable(value = "codigoEmpresa") Long codigoEmpresa,
			@RequestBody Empresa empresa) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).body(service.updateEmpresa(empresa, codigoEmpresa));
	}

}
