package Proj;

public class Localizacao {
	private String edificio;
	private int piso;
	private String loc;
	private int sala;
	
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

	public String getLoc() {
		return loc;
	}

	public int getSala() {
		return sala;
	}
	
	
	

}
