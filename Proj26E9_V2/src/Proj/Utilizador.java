
public class Utilizador {
	private String nome;
	private String tipo_utilizador;
	/**
	 * @param nome
	 * @param tipo_utilizador
	 * Contrutor de utilizador 
	 */
	public Utilizador(String nome, String tipo_utilizador) {
		this.nome = nome;
		this.tipo_utilizador = tipo_utilizador;
	}
	public String getNome() {
		return nome;
	}
	public String getTipo_utilizador() {
		return tipo_utilizador;
	}
	
}
