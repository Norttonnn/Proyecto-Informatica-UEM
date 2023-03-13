package entidades;

public class Medico extends Persona{
	
	
	
	public Medico() {}
	
	public Medico(String correo, String nombre, String apellidos, String pass , String roll) {
		super(correo,nombre,apellidos,pass,roll);
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
				"\nNombre: " + nombre +
				"\nApellidos: " + apellidos /*+
				"\nEdad: " + edad +
				"\nEspecialidad: " + especialidad + 
				"\nNumero Colegiado: " + numeroColegiado*/;
		return salida;
		
	}

}
