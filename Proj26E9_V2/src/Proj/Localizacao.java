package Proj;

public class Localizacao {
	private String edificio;
	private int piso;
	private String loc;
	private int sala;
	
	/**
	 * @param edificio
	 * @param piso
	 * @param loc
	 * @param sala
	 * construtor
	 */
	public Localizacao(String edificio, int piso, String loc, int sala) {
		this.edificio = edificio;
		this.piso = piso;
		this.loc = loc;
		this.sala = sala;
	}

	public String getEdificio() {
		return edificio;
	}

	public int getPiso() {
		return piso;
	}

	@Override
	public String toString() {
		if(sala!=0) {
		return "| Edifio: " + edificio + "| Piso: " + piso + "| Local: " + loc + "| Sala: " + sala;
		}
		return "| Edifio: " + edificio + "| Piso: " + piso + "| Local: " + loc;
	}

	public String getLoc() {
		return loc;
	}

	public int getSala() {
		return sala;
	}
	
	
	

}