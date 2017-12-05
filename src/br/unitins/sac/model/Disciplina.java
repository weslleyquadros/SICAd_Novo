package br.unitins.sac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Disciplina extends Model<Disciplina> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8035768902216933717L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqiddisciplina")
	@SequenceGenerator(name = "seqiddisciplina", sequenceName = "seqiddisciplina", allocationSize = 1)
	private Integer id;
	private String nome;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
