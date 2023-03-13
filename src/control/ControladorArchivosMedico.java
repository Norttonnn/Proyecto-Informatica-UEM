package control;

import java.util.Vector;

import entidades.Deportista;

public class ControladorArchivosMedico {
	
	static String dirFile = "deportistas.json";
	static ControladorJSON c = new ControladorJSON();
	static Vector	<Deportista> 	vectorDeportistasDispos 		= new Vector<Deportista>();
	
	/*public String dameDispos() {
		
		vectorDeportistasDispos = c.JsonA_Deportista(dirFile);
		String dispos = "";
		for(int i = 0; i < vectorDeportistasDispos.size(); i++) {
			dispos = dispos + vectorDeportistasDispos.get(i).dispo + "\n";	
		}	
		return dispos;	
	}*/
	
	public String dameNombres() {
	
		vectorDeportistasDispos = c.JsonA_Deportista(dirFile);
		String nombres = "";
		for(int i = 0; i < vectorDeportistasDispos.size(); i++) {
			nombres = nombres + vectorDeportistasDispos.get(i).nombre + "\n";
		}
		
		return nombres;
	}
	
	
	/*public String dameNombreYDispo() {
		
		vectorDeportistasDispos = c.JsonA_Deportista(dirFile);
		String combo = "";
		for(int i = 0; i < vectorDeportistasDispos.size(); i++) {
			combo = combo + vectorDeportistasDispos.get(i).nombre + ": " + vectorDeportistasDispos.get(i).dispo + "\n";	
		}	
		return combo;
		
	}*/
	
	/*public Boolean dameCita(String n) {
		Boolean cita = true; // de primeras puedes tener cita 
		
		vectorDeportistasDispos = c.JsonA_Deportista(dirFile);
		
		
		for(int i = 0; i < vectorDeportistasDispos.size(); i++) { // si la dispo es - no puedes tener cita
			if(vectorDeportistasDispos.get(i).dispo.equals("-") && n.equals(vectorDeportistasDispos.get(i).nombre)) {
				cita = false;
				i = vectorDeportistasDispos.size()+1;
			}	
		}	
		return cita;	
	}*/
	
	
	// HAY QUE CAMBIAR COSAS AQUÍ PORQUE COMO LO ESTABA HACIENDO ANTES SIN MÁS ESTABA BIEN
	/*public Vector<Deportista> quitarDispo(String n, String d) { // NECESITO BORRAR EL QUE YA ESTABA Y METERLO OTRA VEZ PERO CON OTRO DATO

		vectorDeportistasDispos = c.JsonA_Deportista(dirFile);
		
		for(int i = 0; i < vectorDeportistasDispos.size(); i++) {
			if((d.equals(vectorDeportistasDispos.get(i).dispo)) && (n.equals(vectorDeportistasDispos.get(i).nombre))) {
				vectorDeportistasDispos.get(i).dispo 	= "-";
			} 
		}
		return vectorDeportistasDispos;
	}*/

}
