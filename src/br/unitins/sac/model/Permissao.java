package br.unitins.sac.model;

public enum Permissao {
 ROLE_ADMINISTRADOR("admin"),
 ROLE_SECRETARIA("secretaria");
	
	private String nome;
	
	private Permissao(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	
	
	
}
