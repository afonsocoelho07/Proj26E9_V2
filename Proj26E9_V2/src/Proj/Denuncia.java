package Proj;
import java.time.LocalDate;
import java.util.ArrayList;

public class Denuncia {
	private String nomeUtilizador;
    private String tipo; //  "EQUIPA", "OCORRENCIA"
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
		return "Denuncia :" + nomeUtilizador + "| Tipo: " + tipo + "| Equipa: " + equipa+ "| TituloOcorrencia: " + tituloOcorrencia + "| Descricao: " + descricao + "| Data: " + data;
	}
    
    

}