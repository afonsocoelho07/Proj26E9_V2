package Proj;
import java.util.ArrayList;


public class Equipa {
	private String nome;
	private String categoria;
	private int lotacao;
	private ArrayList<Utilizador>membros;
	private int lotacao_ocupada;
	

	/**
	 * @param nome
	 * @param categoria
	 * @param lotacao
	 * @param membros
	 * contrutor equipa
	 */
	public Equipa(String nome, String categoria, int lotacao, int lotacao_ocupada) {
		this.nome = nome;
		this.categoria = categoria;
		this.lotacao = lotacao;
		this.membros = new ArrayList<Utilizador>();
		this.lotacao_ocupada=lotacao_ocupada;
	}


	


	public int getLotacao_ocupada() {
		return lotacao_ocupada;
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





	public ArrayList<Utilizador> getMembros() {
		return membros;
	}





	
    /**
     * aumenta lotacao ocupada 
     */
    public void incrementarLotacaoOcupada() {
        this.lotacao_ocupada++;
    }

    
    /**
     * @param u
     * adiciona mebros ah equipa 
     */
    public void adicionarMembro(Utilizador u) {
        for (Utilizador m : membros) {
            if (m.getNome().equals(u.getNome())) {
                return; // se existir não faz nada
            }
        }
        this.membros.add(u);
    }





	public void setLotacao_ocupada(int lotacao_ocupada) {
		this.lotacao_ocupada = lotacao_ocupada;
	}
	

}
