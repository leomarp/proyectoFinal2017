package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Combo implements Serializable{
	
	private String nombre;
	private ArrayList<Componente> miCombo;
	
	
	public Combo() {
		super();
		this.miCombo=new ArrayList<Componente>();
	}

	public ArrayList<Componente> getMiCombo() {
		return miCombo;
	}

	public void setMiCombo(ArrayList<Componente> miCombo) {
		this.miCombo = miCombo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	


}
