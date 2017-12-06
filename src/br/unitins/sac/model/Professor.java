package br.unitins.sac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Professor extends Model<Professor> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4810569963385531540L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidprofessor")
	@SequenceGenerator(name = "seqidprofessor", sequenceName = "seqidprofessor", allocationSize = 1)
	private Integer id;
	private String experiencia;

	private String nome;
	private String cpf;
	private String Rg;
	private String endereco;
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "idCidade", nullable = true)
	private Cidade cidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return Rg;
	}

	public void setRg(String rg) {
		Rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
