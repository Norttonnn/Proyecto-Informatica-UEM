package control;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entidades.Deportista;
import entidades.Entrenador;
import entidades.Medico;
import entidades.Persona;



public class ControladorJSONPyt { // SERIALIZAR == ESCRIBIR -- - -- DESERIALIZAR == LEER
	
	// DEPORTISTAS
	public void serializarArrayAJsonDeportistas(Vector<Deportista> listaDeportista) { // ESCRIBE
		
		Vector<Deportista> listDeportistas = listaDeportista; // PASA LA LISTA DE DEPORTISTAS CON LA QUE TRABAJAMOS (args)
		Gson prettyGson = mostrarVectorDeportistas(listDeportistas);
		try(FileWriter writer = new FileWriter("deportistas.json")){
			prettyGson.toJson(listDeportistas, writer); // ESCRIBE LOS DATOS EN EL JSON
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public Vector<Deportista> desserializarJsonAArrayDeportista() { // LEE
		
		Vector<Deportista> listDeportistas = new Vector<Deportista>();
		try (Reader reader = new FileReader("deportistas.json")) {
			Gson gson = new Gson();
			Type tipoListaEmpleados = new TypeToken<Vector<Deportista>>(){}.getType();
			listDeportistas = gson.fromJson(reader, tipoListaEmpleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return listDeportistas;
	}
	
	public Gson mostrarVectorDeportistas(Vector<Deportista> listDeportistas) { // FUNCIÓN TEMPORAL CON FUNCIONALIDAD DE PRACTICA --> FUTURO BORRAR
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create(); // INSTANCIA EL ARCHIVO CON FORMATO SIMILAR A HTML
		String representacionBonita = prettyGson.toJson(listDeportistas); // CONVIERTE LOS DATOS DEL VECTOR EN JSON
		System.out.println(representacionBonita); // IMPRIME LOS DATOS
		
		return prettyGson;
	}
	
	/*
	public static Deportista deportistaExisteEnLaLista(int id, Vector<Deportista> listaDeportistas) { // COMPRUEBA SI EL DEPORTISTA EXISTE EN EL JSON
		Deportista coincidenciaDeportista= new Deportista();
		for(int i = 0; i<listaDeportistas.size(); ++i){
			if(listaDeportistas.get(i).getId()==id){
				coincidenciaDeportista= listaDeportistas.get(i);
			}
		}
		return coincidenciaDeportista; // DEVUELVE EL DEPORTISTA 
	}
	*/
	
	public boolean CoincicenciaEnLaListaDeportista(String emailUsuario, Vector<Deportista> listaDeportistas) { // COMPRUEBA SI EL DEPORTISTA EXISTE EN EL JSON
		
		boolean coincidencia = false;	
		
		for(int i = 0; i<listaDeportistas.size(); ++i){
			if(listaDeportistas.get(i).getCorreo()==emailUsuario){
				coincidencia=true;
			}
		}
		return coincidencia; // DEVUELVE UN BOOLEAN CON EL RESULTADO 
	}
	

	
	
	
	
	
	
	
	// PERSONAS
	public void serializarArrayAJsonPersona(Vector<Persona> listaPersona) { // ESCRIBE
		
		Vector<Persona> listPersonas = listaPersona; // PASA LA LISTA DE PERSONAS CON LA QUE TRABAJAMOS (args)
		Gson prettyGson = mostrarVectorPersona(listPersonas);
		try(FileWriter writer = new FileWriter("personas.json")){
			prettyGson.toJson(listPersonas, writer); // ESCRIBE LOS DATOS QUE HAY 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public Vector<Persona> desserializarJsonArrayPersona() { // LEE
		
		Vector<Persona> listPersona = new Vector<Persona>();
		try (Reader reader = new FileReader("personas.json")) {
			Gson gson = new Gson();
			Type tipoListaPersona = new TypeToken<Vector<Persona>>(){}.getType();
			listPersona = gson.fromJson(reader, tipoListaPersona);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return listPersona;
	}
	
	public Gson mostrarVectorPersona(Vector<Persona> listPersona) {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create(); // INSTANCIA EL ARCHIVO CON FORMATO SIMILAR A HTML
		String representacionBonita = prettyGson.toJson(listPersona); // CONVIERTE LOS DATOS DEL VECTOR EN JSON
		System.out.println(representacionBonita); // IMPRIME LOS DATOS
		
		return prettyGson;
	}
	
	/*
	public static Persona PersonaExisteEnLaLista(int id, Vector<Persona> listaPersona) { // COMPRUEBA SI LA PERSONA EXISTE EN EL JSON
		
		Persona coincidenciaPersona= new Persona();
		
		for(int i = 0; i<listaPersona.size(); ++i){
			if(listaPersona.get(i).getId()==id){
				coincidenciaPersona= listaPersona.get(i);
			}
		}
		return coincidenciaPersona; // DEVUELVE LA PERSONA
	}
	*/
	
	
	public boolean CoincicenciaEnLaListaPersona(String emailUsuario, Vector<Persona> listaPersonas) {
		
		boolean coincidencia = false;		
		
		for(int i = 0; i<listaPersonas.size(); ++i){
			if(listaPersonas.get(i).getCorreo()==emailUsuario){
				coincidencia=true;
			}
		}
		return coincidencia; // DEVUELVE UN BOOLEAN CON EL RESULTADO 
	}

	
	
	
	
	
	
	
	
	
	
	// ENTRENADORES
	public void serializarArrayAJsonEntrenador(Vector<Entrenador> listaEntrenador) { // ESCRIBE
		
		Vector<Entrenador> listEntrenador = listaEntrenador; // PASA LA LISTA DE ENTRENADORES CON LA QUE TRABAJAMOS (args)
		
		Gson prettyGson = mostrarVectorEntrenador(listEntrenador);
		try(FileWriter writer = new FileWriter("entrenadores.json")){
			prettyGson.toJson(listEntrenador, writer); // ESCRIBE LOS DATOS QUE HAY 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public Vector<Entrenador> desserializarJsonArrayEntrenador() { // LEE
		
		Vector<Entrenador> listEntrenador = new Vector<Entrenador>();
		
		try (Reader reader = new FileReader("entrenadores.json")) {
			Gson gson = new Gson();
			Type tipoListaEntrenador = new TypeToken<Vector<Entrenador>>(){}.getType();
			listEntrenador = gson.fromJson(reader, tipoListaEntrenador);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		return listEntrenador;
	}
	
	public Gson mostrarVectorEntrenador(Vector<Entrenador> listEntrenador) {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create(); // INSTANCIA EL ARCHIVO CON FORMATO SIMILAR A HTML
		String representacionBonita = prettyGson.toJson(listEntrenador); // CONVIERTE LOS DATOS DEL VECTOR EN JSON
		System.out.println(representacionBonita); // IMPRIME LOS DATOS		
		return prettyGson;
	}
	
	
	/*
	public static Entrenador EntrenadorExisteEnLaLista(int id, Vector<Entrenador> listaEntrenador) {
		Entrenador coincidenciaPersona= new Entrenador();
		for(int i = 0; i<listaEntrenador.size(); ++i){
			if(listaEntrenador.get(i).getId()==id){
				coincidenciaPersona= listaEntrenador.get(i);
			}
		}
		return coincidenciaPersona; // DEVUELVE EL ENTRENADOR
	}
	*/
	
	public boolean CoincicenciaEnLaListaEntrenador(String emailUsuario, Vector<Entrenador> listaEntrenador) {
		boolean coincidencia = false;		
		for(int i = 0; i<listaEntrenador.size(); ++i){
			if(listaEntrenador.get(i).getCorreo()==emailUsuario){
				coincidencia=true;
			}
		}
		return coincidencia; // DEVUELVE UN BOOLEAN CON EL RESULTADO
	}
	

	
	
	
	
	
	
	
	
	
	// MEDICOS
	public void serializarArrayAJsonMedico(Vector<Medico> listaMedicos) { // ESCRIBE
		Vector<Medico> listMedicos = listaMedicos;  // PASA LA LISTA DE MEDICOS CON LA QUE TRABAJAMOS (args)
	
	
		Gson prettyGson = mostrarVectorMedicos(listMedicos);
		try(FileWriter writer = new FileWriter("medicos.json")){
			prettyGson.toJson(listMedicos, writer); // ESCRIBE LOS DATOS QUE HAY 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Vector<Medico> desserializarJsonArrayMedicos() { // LEE
		Vector<Medico> listMedico = new Vector<Medico>();

		try (Reader reader = new FileReader("medicos.json")) {
			Gson gson = new Gson();
			Type tipoListaPersona = new TypeToken<Vector<Medico>>(){}.getType();
			listMedico = gson.fromJson(reader, tipoListaPersona);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listMedico;
	}

	public Gson mostrarVectorMedicos(Vector<Medico> listMedicos) {
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create(); // INSTANCIA EL ARCHIVO CON FORMATO SIMILAR A HTML
		String representacionBonita = prettyGson.toJson(listMedicos); // CONVIERTE LOS DATOS DEL VECTOR EN JSON
		System.out.println(representacionBonita); // IMPRIME LOS DATOS
	
		return prettyGson;
	}

	/*
	public static Medico MedicoExisteEnLaLista(int id, Vector<Medico> listaMedico) {
		
		Medico coincidenciaMedico= new Medico();
		
		for(int i = 0; i<listaMedico.size(); ++i){
			if(listaMedico.get(i).getId()==id){
				coincidenciaMedico= listaMedico.get(i);
			}
		}
		return coincidenciaMedico;
	}
	*/

	public boolean CoincicenciaEnLaListaMedico(String emailUsuario, Vector<Persona> listaPersonas) {

		boolean coincidencia = false;		
		
		for(int i = 0; i<listaPersonas.size(); ++i){
			if(listaPersonas.get(i).getCorreo()==emailUsuario){
				coincidencia=true;
			}
		}
		return coincidencia; // DEVUELVE UN BOOLEAN CON EL RESULTADO
	}
}
