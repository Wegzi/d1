package model;

public class Comentario {

	private int id;
	private String nome;
	private String texto;
	private int fkId;

	public Comentario() {
	}

	public Comentario(int id, String nome, String text, int fkId) {
		super();
		this.setId(id);
		this.setTexto(text);
		this.setNome(nome);
		this.setFkId(fkId);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFkId() {
		return fkId;
	}

	public void setFkId(int fkId) {
		this.fkId = fkId;
	}

}
