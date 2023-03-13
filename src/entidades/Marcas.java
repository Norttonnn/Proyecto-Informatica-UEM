package entidades;

public class Marcas {
	
	String correo; // COMPROBAR
	
	String ritmo;
	String aceleracion;
	int pulsaciones;
	String distancia;
	
	
	// MÉTODOS CONSTRUCTORES DE LA CLASE MARCAS
	public Marcas() {}
	public Marcas(String correo, String ritmo , String aceleracion , int pulsaciones , String distancia) {
		
		this.correo 		= correo; // ESTO ASÍ NO SE SI ESTÁ BIEN
		
		this.ritmo 			= ritmo;
		this.aceleracion 	= aceleracion;
		this.pulsaciones 	= pulsaciones;
		this.distancia 		= distancia;
	}
	
	// GETTERS
	public String getDepor() {return correo;}
	
	public String getRitmo() {return ritmo;}
	public String getAceleracion() {return aceleracion;}
	public int getPulsaciones(){return pulsaciones;}
	public String getDistancia() {return distancia;}
	
	public String toString() {
		String salida = 
						"\nRitmo medio: " 			+ ritmo 		+
						"\nAceleracion media: " 	+ aceleracion 	+
						"\nMedia de pulsaciones: " 	+ pulsaciones 	+
						"Distancia media: " 		+ distancia;
		return salida;
	}

}
