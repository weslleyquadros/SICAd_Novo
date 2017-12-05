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
	private static final long serialVersionUID = 5608278203795408342L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidprofessor")
	@SequenceGenerator(name = "seqidprofessor", sequenceName = "seqidprofessor", allocationSize = 1)
	private Integer id;
	private String experiencia;
	


	@ManyToOne
	@JoinColumn(name = "idCidade", nullable = true)
	private Cidade cidade;
	@JoinColumn(name = "idPessoas", nullable = true)
	private Pessoas pessoas;

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
	
	public Pessoas getPessoas() {
		return pessoas;
	}

	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}
	
	

}
