package br.com.quintinno.sistemafinanceiroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintinno.sistemafinanceiroapi.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<PessoaModel> findAll() {
		return this.pessoaService.findAll();
	}
	
	@PostMapping
	public PessoaModel saveOne(@RequestBody PessoaModel pessoaModel) {
		return this.pessoaService.saveOne(pessoaModel);
	}

}
