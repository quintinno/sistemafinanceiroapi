package br.com.quintinno.sistemafinanceiroapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.sistemafinanceiroapi.service.RelatorioService;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {
	
	@Autowired
	public RelatorioService relatorioService;
	
	@GetMapping
	public ResponseEntity<Resource> gerarRelatorioInstituicaoFinanceira() throws JRException {
		return this.relatorioService.gerarRelatorioInstituicaoFinanceira();
	}

}
