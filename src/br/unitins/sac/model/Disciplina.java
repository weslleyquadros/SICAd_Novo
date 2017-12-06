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
public class Disciplina extends Model<Disciplina> {



	/**
	 * 
	 */
	private static final long serialVersionUID = -4835321672104035994L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqiddisciplina")
	@SequenceGenerator(name = "seqiddisciplina", sequenceName = "seqiddisciplina", allocationSize = 1)
	private Integer id;
	private String nome;
	private String carga_horaria;
	private String descricao;


	@ManyToOne
	@JoinColumn(name = "idProfessor", nullable = true)
	private Professor professor;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
