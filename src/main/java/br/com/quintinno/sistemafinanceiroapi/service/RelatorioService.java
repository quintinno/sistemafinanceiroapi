package br.com.quintinno.sistemafinanceiroapi.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class RelatorioService {
	
	public void gerarRelatorioInstituicaoFinanceira() throws JRException {
		String enderecoRelatorio = "C:\\Desenvolvimento\\sistemafinanceiroapi\\src\\main\\resources\\report\\relatorio_instituicao_bancaria.jrxml";
		Map<String, Object> parametroMap = new HashMap<>();
			parametroMap.put("nome", "Banco do Brasil");
			parametroMap.put("data_cadastro", new Date());
		JasperReport jasperReport = JasperCompileManager.compileReport(enderecoRelatorio);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametroMap);
		JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Desenvolvimento\\sistemafinanceiroapi\\src\\main\\resources\\report\\relatorio_instituicao_bancaria.pdf");
	}

}
