package Proj;
import java.time.LocalDate;
import java.util.ArrayList;
public class Ocorrencia {
	private ArrayList<Categoria> lista_categoria;
	private String nome_autor;
	private String titulo;
	private String descricao;
	private String estado;
	private LocalDate data_inicial;
	private LocalDate data_final;
	private String localizacao;
	private int nivel_urgencia;
	private String categoria;
	private String nomeEquipaAtribuida = "Nenhuma";

	
	
	public String getNomeEquipaAtribuida() {
	    return nomeEquipaAtribuida;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setNomeEquipaAtribuida(String nomeEquipaAtribuida) {
	    this.nomeEquipaAtribuida = nomeEquipaAtribuida;
	}
	
	
	
	
	/**
	 * @param nome_autor
	 * @param titulo
	 * @param descricao
	 * @param estado
	 * @param data_inicial
	 * @param data_final
	 * @param localizacao
	 * @param nivel_urgencia
	 * contrutor ocorrencia
	 */
	public Ocorrencia(String nome_autor, String titulo, String descricao, String estado, LocalDate data_inicial,
			LocalDate data_final, String localizacao, int nivel_urgencia,String categoria) {
		this.nome_autor = nome_autor;
		this.titulo = titulo;
		this.descricao = descricao;
		this.estado = estado;
		this.data_inicial = data_inicial;
		this.data_final = data_final;
		this.localizacao = localizacao;
		this.nivel_urgencia = nivel_urgencia;
		this.categoria=categoria;
	}
	public String getNome_autor() {
		return nome_autor;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @return the data_inicial
	 */
	public LocalDate getData_inicial() {
		return data_inicial;
	}
	/**
	 * @return the data_final
	 */
	public LocalDate getData_final() {
		return data_final;
	}
	/**
	 * @return the localizacao
	 */
	public String getLocalizacao() {
		return localizacao;
	}
	/**
	 * @return the nivel_urgencia
	 */
	public int getNivel_urgencia() {
		return nivel_urgencia;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @param localizacao the localizacao to set
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	/**
	 * @param nivel_urgencia the nivel_urgencia to set
	 */
	public void setNivel_urgencia(int nivel_urgencia) {
		this.nivel_urgencia = nivel_urgencia;
	}
	
	@Override
	public String toString() {
		if(estado.equals("Concluido")) {
			return "Ocorrencia/Occurrence: " + titulo + " | Estado/State: " + estado + " | Data de registo/Registration date:" + data_inicial + " | Data Final/End date: "+data_final;
		}
		return "Ocorrencia/Occurrence: " + titulo + " | Estado/State: " + estado + " | Data de registo/Registration date:" + data_inicial ;
	}
	
	public String detalhes() {
		for(Categoria c:lista_categoria) {
			if(estado.equals("Concluido")) {
				
				return "Ocorrencia/Occurrence: "+titulo+" | Descrição/Description: "+descricao+" | Estado/State: "+estado+" | Categoria/Category: "+c.getNome() +" | Data de registo/Registration date:" + data_inicial + " | Data final/End date: "+data_final;
			
			}else {
				
				return "Ocorrencia/Occurrence: "+titulo+" | Descrição/Description: "+descricao+" | Estado/State: "+estado+" | Categoria/Category: "+c.getNome() +" | Data de registo/ Registration date:" + data_inicial;
			
			}
		}
		return null;
		
	}
	public void setData_final(LocalDate data_final) {
		this.data_final = data_final;
	}
	
	
}
