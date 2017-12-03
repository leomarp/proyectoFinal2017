package logic;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;



public class Tienda {
	private ArrayList<Cliente>misClientes;
	private ArrayList<Factura>misFacturas;
	private ArrayList<Componente>misComponentes;
	private ArrayList<Combo> misCombos;
	private static Tienda tienda;
	
	
	private Tienda() {
		super();
		this.misClientes = new ArrayList<Cliente>();
		this.misFacturas = new ArrayList<Factura>();
		this.misComponentes = new ArrayList<Componente>();
		this.misCombos=new ArrayList<Combo>();
	
	}


	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}


	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}


	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}


	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}


	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}


	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}


	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}


	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}
	
	
	//singleton
		public static Tienda getInstance(){
			if(tienda==null){
				tienda = new Tienda();
			}
			return tienda;
		}
	
		
		
		
	public void AgregarCliente(Cliente cliente) {
		if(!misClientes.contains(cliente)) {
			misClientes.add(cliente);
		}
	}	
		
		
	public void AgregarComponentes(Componente componente) {
		misComponentes.add(componente);
		
	}	
		
	
	public int CantidadDiscosDuros() {
		int cant=0;
		 for (Componente aux : misComponentes) {
			 if(aux instanceof DiscoDuro ) {
				 cant++;
			 }
			
		}
		
		 return cant;
	}
		
	public int CantidadMemoriasRam() {
		int cant=0;
		 for (Componente aux : misComponentes) {
			 if(aux instanceof MemoriaRam ) {
				 cant++;
			 }
			
		}
		
		 return cant;
	}	
		
	
	public int CantidadProcesadores() {
		int cant=0;
		 for (Componente aux : misComponentes) {
			 if(aux instanceof Procesador ) {
				 cant++;
			 }
			
		}
		
		 return cant;
	}
	
	public int CantidadTarjetasMadre() {
		int cant=0;
		 for (Componente aux : misComponentes) {
			 if(aux instanceof TarjetaMadre ) {
				 cant++;
			 }
			
		}
		
		 return cant;
	}	
		
	
	public Cliente BuescarCliente(String cedula) {
		Cliente cliente=null;
		for (Cliente aux : misClientes) {
			if(aux.getCedula().equalsIgnoreCase(cedula)) {
				cliente=aux;
			}
		}
		return cliente;
	}
	
	public void VerificarListaDeOrden() {
		
		for(int i=0;i<misComponentes.size();i++) {
			if(misComponentes.get(i).getCantidad()<=5) {
				misComponentes.get(i).setCantidad(misComponentes.get(i).getCantidad()+10);
			}
		}
		
		
	}
	
	public ArrayList<Componente> LLlenarListaDeOrdenes(){
		ArrayList<Componente> componentes=new ArrayList<Componente>();
		for(int i=0;i<misComponentes.size();i++) {
			if(misComponentes.get(i).getCantidad()<=5) {
				componentes.add(misComponentes.get(i));
			}
		}
		return componentes;
	}
	public ArrayList<Componente> LLlenarListaDeOrdenes2(){
		ArrayList<Componente> componentes=new ArrayList<Componente>();
		for (Componente aux : misComponentes) {
			if(aux.getCantidad()<=5 ) {
				componentes.add(aux);
			}
		}
		return componentes;
	}
	
	public Componente BuescarCodigoComponente(String cod) {
		Componente com=new Componente();
		for (Componente aux : misComponentes) {
			if(aux.getCodigo().equalsIgnoreCase(cod)) {
				com=aux;
			}
			
		}
		return com;
	}
	
	public Factura BuscarFactura(String cod) {
		Factura fac=null;
		for(Factura aux: misFacturas) {
			if(aux.getCodigo().equalsIgnoreCase(cod)) {
				fac=aux;
			}
		}
		
	return fac;	
		
	}
	
	public float TodasLasVentas() {
		float todas=0;
		for (Factura aux: misFacturas) {
			todas=todas+aux.getPrecioVenta();
		}
		return todas;
		
	}
	
	public boolean VerificarCantidadMinima(Componente com) {
		boolean veri=false;
		if(com.getCantidad()<=5) {
			veri=true;
		}
		return veri;
	}
	
}
