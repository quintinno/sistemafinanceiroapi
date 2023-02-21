package br.com.quintinno.sistemafinanceiroapi.service;

import java.io.File;
import java.util.HashMap;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class RelatorioService {
	
	public ResponseEntity<Resource> gerarRelatorioInstituicaoFinanceira() throws JRException { 
		try {
			File file = ResourceUtils.getFile("classpath:relatorio_instituicao_bancaria.jasper");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
			HashMap<String, Object> parametroHashMap = new HashMap<>();
				parametroHashMap.put("nome", "Banco do Brasil");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametroHashMap, new JREmptyDataSource());
			byte[] arquivoByte = JasperExportManager.exportReportToPdf(jasperPrint);
			ContentDisposition contentDisposition = ContentDisposition.builder("attachment").filename("RELATORIO_INSTITUICAO_FINANCEIRA.pdf").build();
			HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.setContentDisposition(contentDisposition);
			return ResponseEntity.ok().contentLength(arquivoByte.length)
					.contentType(MediaType.APPLICATION_PDF)
					.headers(httpHeaders)
					.body(new ByteArrayResource(arquivoByte));
		} catch (Exception e) {
			if (e.getMessage().contains("class path resource")) {
				System.out.println("Error: Não encontrado o arquivo .JASPER no CLASSPATH!");
			}
			if (e.getMessage().contains("The byte array is not a recognized imageformat")) {
				System.out.println("Error: Não foi possível converter o arquivo para o formado selecionado!");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
