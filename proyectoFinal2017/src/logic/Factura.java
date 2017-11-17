package logic;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	
	private String codigo;
	private float precioVenta;
	private Date fecha;
	private Cliente cliente;
	private ArrayList<Componente>misComponentes;
	

	public Factura() {
		super();
		this.misComponentes = new ArrayList<Componente>();
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public float getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}


	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}	
	

	
}