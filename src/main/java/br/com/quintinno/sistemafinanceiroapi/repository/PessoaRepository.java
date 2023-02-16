package br.com.quintinno.sistemafinanceiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quintinno.sistemafinanceiroapi.model.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> { }
