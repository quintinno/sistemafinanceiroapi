package br.com.quintinno.sistemafinanceiroapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PESSOA")
	private TipoPessoaModel tipoPessoaModel;
	
	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;
	
	public PessoaModel() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoPessoaModel getTipoPessoaModel() {
		return tipoPessoaModel;
	}

	public void setTipoPessoaModel(TipoPessoaModel tipoPessoaModel) {
		this.tipoPessoaModel = tipoPessoaModel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
