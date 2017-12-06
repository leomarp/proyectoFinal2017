package logic;

import java.io.Serializable;

public class MemoriaRam extends Componente implements Serializable{

	private String capacidad;
	private String velocidad;
	private String tipo;
	
	public MemoriaRam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}