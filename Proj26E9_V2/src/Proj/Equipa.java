package Proj;
import java.util.ArrayList;


public class Equipa {
	private String nome;
	private String categoria;
	private int lotacao;
	private ArrayList<Utilizador>membros;
	
	/**
	 * @param nome
	 * Construtor de equipa
	 */
	public Equipa(String nome, String categoria, int lotacao ) {
		this.nome = nome;
		this.categoria = categoria;
		this.lotacao = lotacao;
		this.membros = new ArrayList<Utilizador>();
	}

	public String getNome() {
		return nome;
	}
	
	
	public String getCategoria() {
		return categoria;
	}

	public int getLotacao() {
		return lotacao;
	}


	/**
	 * 
	 * Adicionar membro e verifica se ja tem esse membro
	 */
	 public void adicionarMembro(Utilizador u) {
	        for (Utilizador m : membros) {
	            if (m.getNome().equals(u.getNome())) {
	                return; 
	            }
	        }
	        membros.add(u);
	    }
	 
	 /**
		 * Listrar membros
		 */
	 public void listarMembros() {
	        System.out.println("Equipa: " + nome);
	        for (Utilizador u : membros) {
	            System.out.println("Nome: " + u.getNome());
	        }
	    }
	

}
