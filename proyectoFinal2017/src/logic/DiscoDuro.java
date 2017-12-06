package logic;

import java.io.Serializable;

public class DiscoDuro extends Componente implements Serializable{

	
	private String capacidad;
	private String tipoConexion;
	private String velocidad;
	
	
	public DiscoDuro() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}


	public String getTipoConexion() {
		return tipoConexion;
	}


	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}


	public String getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}
	
	
}
