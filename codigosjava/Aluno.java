package aula;

public class Aluno { //substantivo letra maiuscula
	private String nome;//substantivo letra minuscula
	private String ra;
	
	public Aluno(String nome, String ra) {
		this.nome = nome;
		this.ra = ra;
	}
	
	public String getNome() {
		return nome;
	}
}
