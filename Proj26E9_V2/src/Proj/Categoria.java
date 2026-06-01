package Proj;
import java.util.ArrayList;
public class Categoria {
	private ArrayList<Ocorrencia> ocorrencias;
	private String nome;
	/**
	 * @param nome
	 * Construtor de categoria
	 */
	public Categoria(String nome) {
		this.ocorrencias = new ArrayList<Ocorrencia>();
		this.nome = nome;
	}
	public ArrayList<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public String toString() {
		return "Categoria " + nome ;
	}
	
}

