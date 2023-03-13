package entidades;



public class Persona {
	
	// ATRIBUTOS DE LA CLASE PERSONA
	public String correo;
	public String nombre;
	public String apellidos;
	public String pass;
	public String roll;
	
	
	// MÉTODOS CONSTRUCTORES DE LA CLASE PERSONA
	public Persona() {} // CONSTRUCTOR VACIO
	public Persona(String correo, String nombre, String apellidos, String pass , String roll) { // CONSTRUCTOR 
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.pass = pass;
		this.roll = roll;
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
				"\nApellidos: " + apellidos +
				"\nEdad: " + roll;
		
		return salida;
		
	}
	
	
	

}
