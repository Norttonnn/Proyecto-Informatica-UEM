package control;

import java.util.Vector;

import entidades.Deportista;
import entidades.Entrenamientos;

public class ControladorArchivosEntrenador {
	
	static String dirFile = "disponibilidadesDeportistas.json";
	static String dirFile1 = "entrenamientos.json";
	static ControladorJSON c = new ControladorJSON();
	static Vector	<Deportista> 	vectorDeportistasDispos 		= new Vector<Deportista>();
	static Vector	<Deportista> 	vectorDeportistasEntrenos		= new Vector<Deportista>();
	
	
	public static String listaDeportistas() {
		
		vectorDeportistasDispos = c.JsonA_Deportista(dirFile);
		String n = "";
		for(int i = 0; i < vectorDeportistasDispos.size(); i++) {
			n += vectorDeportistasDispos.get(i).nombre + "\n";
		}
		
		return n;
	}
	
public static String listaEntrenamientos() {
		
		Vector	<Entrenamientos> 	vectorEntrenamientos 		= new Vector<Entrenamientos>();
		vectorEntrenamientos = c.JsonA_Entrenamientos(dirFile1);
		String n = "";
		for(int i = 0; i < vectorEntrenamientos.size(); i++) {
			n += 	vectorEntrenamientos.get(i).nombreEntreno + 
					"\n\tCorrer: " + vectorEntrenamientos.get(i).carrera +
					"\n\tEmpujes: " + vectorEntrenamientos.get(i).empujes + 
					"\n\tTracciones: " + vectorEntrenamientos.get(i).tracciones +
					"\n\tPierna: " + vectorEntrenamientos.get(i).pierna + "\n";
		}
		
		return n;
	}

/*public static Vector<Deportista> asignaEntreno(String n) {
	 Vector	<Deportista> 	vectorDeportistasEntrenosAUX		= new Vector<Deportista>();
	
	vectorDeportistasEntrenos = c.JsonA_Deportista("deportistasEntreno.json");
	vectorDeportistasEntrenosAUX = vectorDeportistasEntrenos;
	
	for(int i = 0; i < vectorDeportistasEntrenos.size(); i++) {
		if(n.equals(vectorDeportistasEntrenos.get(i).nombre) && (vectorDeportistasEntrenos.get(i).entrenamiento.equals("no"))) {
			vectorDeportistasEntrenosAUX.get(i).correo = vectorDeportistasEntrenos.get(i).correo;
			vectorDeportistasEntrenosAUX.get(i).id = vectorDeportistasEntrenos.get(i).id;
			vectorDeportistasEntrenosAUX.get(i).nombre = vectorDeportistasEntrenos.get(i).nombre;
			vectorDeportistasEntrenosAUX.get(i).apellidos = vectorDeportistasEntrenos.get(i).apellidos;
			vectorDeportistasEntrenosAUX.get(i).pass = vectorDeportistasEntrenos.get(i).pass;
			vectorDeportistasEntrenosAUX.get(i).edad = vectorDeportistasEntrenos.get(i).edad;
			vectorDeportistasEntrenosAUX.get(i).entrenamiento = "si";
		}
	}
	
	// c.vectorDeportistaAJSON(vectorDeportistasDispos, n);
	
	return vectorDeportistasEntrenosAUX;
}*/

}
