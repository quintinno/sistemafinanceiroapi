package br.com.quintinno.sistemafinanceiroapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintinno.sistemafinanceiroapi.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<PessoaModel> findAll() {
		return this.pessoaRepository.findAll();
	}
	
	public PessoaModel saveOne(PessoaModel pessoaModel) {
		return this.pessoaRepository.save(pessoaModel);
	}

}
