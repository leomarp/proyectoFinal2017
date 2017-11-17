package logic;

public class Procesador extends Componente {

	private String tipoSocket;
	private String velocidad;
	
	public Procesador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTipoSocket() {
		return tipoSocket;
	}

	public void setTipoSocket(String tipoSocket) {
		this.tipoSocket = tipoSocket;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}
	

}
