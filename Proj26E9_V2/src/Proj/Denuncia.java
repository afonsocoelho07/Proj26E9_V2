package Proj;
import java.time.LocalDate;

public class Denuncia {
	private String nomeUtilizador;
    private String tipo; 
    private String equipa; 
    private String tituloOcorrencia;
    private String descricao;
    private LocalDate data;
	/**
	 * @return the nomeUtilizador
	 */
	public String getNomeUtilizador() {
		return nomeUtilizador;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @return the equipa
	 */
	public String getEquipa() {
		return equipa;
	}
	public Denuncia(String nomeUtilizador, String tipo, String equipa, String tituloOcorrencia, String descricao,
			LocalDate data) {
		this.nomeUtilizador = nomeUtilizador;
		this.tipo = tipo;
		this.equipa = equipa;
		this.tituloOcorrencia = tituloOcorrencia;
		this.descricao = descricao;
		this.data = data;
	}
	/**
	 * @return the tituloOcorrencia
	 */
	public String getTituloOcorrencia() {
		return tituloOcorrencia;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}
	@Override
	public String toString() {
		if(tipo.equals("EQUIPA")) {
			return "Denuncia :" + nomeUtilizador + "| Tipo: " + tipo + "| Equipa: " + equipa + "| Descricao: " + descricao + "| Data: " + data;
	
		}else {
			return "Denuncia :" + nomeUtilizador + "| Tipo: " + tipo + "| TituloOcorrencia: " + tituloOcorrencia + "| Descricao: " + descricao + "| Data: " + data;
			
		}
	}
    

}