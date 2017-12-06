package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;



public class Tienda implements Serializable{
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

	
	public ArrayList<Componente> getComboComponentes(int indice){
		ArrayList<Componente> c= null;
		if(misCombos.isEmpty()){
			return null;
		}
		c=misCombos.get(indice).getMiCombo();
				
			
		
		
		return c;
	}
	public boolean existeCombo(String c){
		
		for (int i = 0; i < misCombos.size(); i++) {
			if(misCombos.get(i).getNombre().equalsIgnoreCase(c)){
				return true;
			}
		}
		
		return false;
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
	
		public boolean guardar(){
			if(crearDatos(Tienda.getInstance())){	
				return true;
			}else{return false;}
		}
		
		public boolean crearDatos(Tienda emp) {
			
		FileOutputStream f;
		try {
			f = new FileOutputStream ("Tienda.dat");
			ObjectOutputStream oos 	= new ObjectOutputStream (f);
			
			oos.writeObject(emp);
			f.close();
			return true;
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
		}
			
			
		public boolean abrirDatos() {
		FileInputStream f;
		try {
			f = new FileInputStream ("Tienda.dat");
			ObjectInputStream oos = new ObjectInputStream(f);
			Tienda emp=null;
			emp=(Tienda)oos.readObject();
			f.close();
			tienda=emp;
			return true;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
			
		}	
		
		
	public void AgregarCliente(Cliente cliente) {
		
			misClientes.add(cliente);
			guardar();
	}	
			
	public void AgregarComponentes(Componente componente) {
		misComponentes.add(componente);
		guardar();
	}	
	public void AgregarFactura(Factura factura) {
		misFacturas.add(factura);
		actualizarInventario(factura.getMisComponentes());
		
		guardar();
	}	
	
	private void actualizarInventario(ArrayList<Componente> componentes){
		
		for (int i = 0; i < componentes.size(); i++) {
			for (int j = 0; j < misComponentes.size(); j++) {
				if(misComponentes.get(j).getCodigo().equalsIgnoreCase( componentes.get(i).getCodigo() )){
					int cantidad=misComponentes.get(j).getCantidad();
					cantidad= cantidad-componentes.get(i).getCantidad();
					misComponentes.get(j).setCantidad(cantidad);
					
				}
			}
			
		}
		
		
		
	}
	
	public void AgregarCombo(Combo combo) {
		misCombos.add(combo);
		guardar();
	}	
	
	public String tipoDeComponente(Componente aux){
		if(aux instanceof DiscoDuro ) {
			 return "Disco Duro";
		 }
		if(aux instanceof MemoriaRam ) {
			 return "Memoria Ram";
		 }
		if(aux instanceof Procesador ) {
			 return "Procesador";
		 }
		if(aux instanceof TarjetaMadre ) {
			 return "Tarjeta Madre";
		 }
		return null;
		
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
		
	
	public Cliente BuscarCliente(String cedula) {
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
	
	public ArrayList<Componente> LlenarListaDeOrdenes(){
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
	
	public ArrayList<Componente> eliminarCantidadArticulo(ArrayList<Componente> listaComponentes,String cod,int Cantidad){
		ArrayList<Componente> listaDevuelta =listaComponentes;
		for (int i = 0; i <listaComponentes.size(); i++) {
			if(listaComponentes.get(i).getCodigo().equalsIgnoreCase(cod)){
				
				listaComponentes.get(i).setCantidad(listaComponentes.get(i).getCantidad() - Cantidad );
			}
			
		}
		
		return listaDevuelta;
	}
	
	public Componente BuscarCodigoComponente(ArrayList<Componente> listaComponentes,String cod) {
		Componente com=null;
		for (Componente aux : listaComponentes) {
			if(aux.getCodigo().equalsIgnoreCase(cod)) {
				com=aux;
			}
			
		}
		
		return com;
	}
	public boolean existeComponente(String cod){
		for (Componente aux : misComponentes) {
			if(aux.getCodigo().equalsIgnoreCase(cod)) {
				return true;
			}
			
		}
		
		return false;
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
	
	public void addArrayComponentesAOtroArray(ArrayList<Componente> origen,ArrayList<Componente> destino){
		
		for (int i = 0; i < origen.size(); i++) {
			destino.add(origen.get(i));
		}
		
	}
	
	
	public boolean VerificarCantidadMinima(Componente com) {
		boolean veri=false;
		if(com.getCantidad()<=5) {
			veri=true;
		}
		return veri;
	}
	
	public float precioTotalCantidad(Componente c) {
		
		float total= c.getPrecioVenta() * c.getCantidad();
		
		return total;
	}
	
	public boolean siExisteDisponibilidadSegunCantidadAComprar(ArrayList<Componente> listacomp,String c, int cantidad){
		
		for (int i = 0; i < listacomp.size(); i++) {
			if(listacomp.get(i).getCodigo().equalsIgnoreCase(c)){
				if(listacomp.get(i).getCantidad() >= cantidad){
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	public boolean existeArticuloEnArreglo(ArrayList<Componente> lista,String codigo ){
		
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo().equalsIgnoreCase(codigo)){
				return false;
			}
			
			
		}
		return true;
	}
	
	
	
	
	
	
	
}
