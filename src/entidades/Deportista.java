package entidades;

import java.util.Vector;

public class Deportista extends Persona{
	
	Persona entrenador; // DEBERÍA SER ENTRENADOR NO!?!?!?
	
	//public Vector<String> marcas = new Vector<String>(); // VECTOR QUE CONTENDRA LAS MARCAS DEL DEPORTISTA
	
	
	// METODOS CONSTRUCTORES DE DEPORTISTAS
	
	public Deportista() {} // CONSTRUCTOR VACIO
	public  Deportista(String correo, String nombre,String apellidos, String pass , Persona entrenador, String roll) { // EL ENTRENADOR ENTRA A NULL PRIMERO 
		super(correo,nombre, apellidos, pass, roll);
		this.entrenador = entrenador;	
	}
	
	
	
	// GETTERS
	public String getCorreo() {return correo;}
	
	public String getNombre() {return nombre;}
	public String getApellidos() {return apellidos;}
	public String getPass() {return pass;}
	public String getNombreEntrenador() {return entrenador.getNombre();}
	public String getRoll() {return roll;}
	
	
	
	
	
	
	// SETTERS
	

	
	public String toString() {
		
		String salida = 
				"Correo: " + correo +
				
				"\nNombre: " + nombre +
				"\nApellidos: " + apellidos;
		
		return salida;
	}

}