package entidades;

public class Entrenador extends Persona{
	

	public Entrenador() {
		super();
	}
	
	public Entrenador(String correo, String nombre, String apellidos, String pass, String roll) {
		super(correo,nombre,apellidos,pass, roll);
		
	}
	
	// GETTERS
	public String getCorreo() {return correo;}
	
	public String getNombre() {return nombre;}
	public String getApellidos() {return apellidos;}
	public String getPass() {return pass;}
	public String getRoll() {return roll;}
	
	
	
	// MÉTODO TOSTRING PARA LA LECTURA DE LOS DATOS
	public String toString() {
		String salida = 
				"Correo: " + correo +
			
				"\nNombre: " + nombre +
				"\nApellidos: " + apellidos;
		return salida;
	}
	

}
