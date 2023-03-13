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
import entidades.Entrenamientos;
import entidades.Marcas;
import entidades.Medico;
import entidades.Persona;

public class ControladorJSON {
	
	String dirFileDeportista 	= "deportistas.json";
	String dirFilePersonas 		= "personas.json"; 
	String dirFileMedicos 		= "medicos.json";
	String dirFileEntrenadores 	= "entrenadores.json";
	String dirFileEntrenamientos 	= "entrenamientos.json";
	
	Vector	<Deportista> 	vectorDeportistas 		= new Vector<Deportista>();
	Vector	<Persona> 		vectorPersonas 			= new Vector<Persona>();
	Vector	<Medico> 		vectorMedicos 			= new Vector<Medico>();
	Vector	<Entrenador> 	vectorEntrenadores 		= new Vector<Entrenador>();
	Vector	<Entrenamientos> vectorEntrenamientos	= new Vector<Entrenamientos>();
	
	
	// PROBANDO PROBANDO
	Vector	<Marcas> vectorMarcas	= new Vector<Marcas>();
	String dirFileMarcas 	= "marcas.json";
	public Vector<Marcas> JsonA_Marcas(String dirJson) { // SACA INFOR DEL JSON Y LO METE EN EL VECTOR
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(Reader reader = new FileReader(dirJson)) {
			Type tipoListaMarcas = new TypeToken<Vector<Marcas>>(){}.getType();
			vectorMarcas = gson.fromJson(reader, tipoListaMarcas);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return vectorMarcas;
	}
	
	
	
	
	// MÉTODOS PARA SACAR INFORMACIÓN DEL JSON Y METERLO EN SU CORRESPONDIENTE VECTOR
	public Vector<Deportista> JsonA_Deportista(String dirJson) { // SACA INFOR DEL JSON Y LO METE EN EL VECTOR
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(Reader reader = new FileReader(dirJson)) {
			Type tipoListaDeportistas = new TypeToken<Vector<Deportista>>(){}.getType();
			vectorDeportistas = gson.fromJson(reader, tipoListaDeportistas);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return vectorDeportistas;
	}
	
	public Vector<Entrenamientos> JsonA_Entrenamientos(String dirJson) { // SACA INFOR DEL JSON Y LO METE EN EL VECTOR
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(Reader reader = new FileReader(dirJson)) {
			Type tipoListaEntrenamientos = new TypeToken<Vector<Entrenamientos>>(){}.getType();
			vectorEntrenamientos = gson.fromJson(reader, tipoListaEntrenamientos);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return vectorEntrenamientos;
	}
	
	public Vector<Persona> JsonA_Personas(String dirJson) { // SACA INFOR DEL JSON Y LO METE EN EL VECTOR
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(Reader reader = new FileReader(dirJson)) {
			Type tipoListaPersonas = new TypeToken<Vector<Persona>>(){}.getType();
			vectorPersonas = gson.fromJson(reader, tipoListaPersonas);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return vectorPersonas;
	}
	
	public Vector<Medico> JsonA_Medicos(String dirJson) { // SACA INFOR DEL JSON Y LO METE EN EL VECTOR

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(Reader reader = new FileReader(dirJson)) {
			Type tipoListaMedicos = new TypeToken<Vector<Medico>>(){}.getType();
			vectorMedicos = gson.fromJson(reader, tipoListaMedicos);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return vectorMedicos;
	}
	
	public Vector<Entrenador> JsonA_Entrenadores(String dirJson) { // SACA INFOR DEL JSON Y LO METE EN EL VECTOR
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(Reader reader = new FileReader(dirJson)) {
			Type tipoListaEntrenadores = new TypeToken<Vector<Entrenador>>(){}.getType();
			vectorEntrenadores = gson.fromJson(reader, tipoListaEntrenadores);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return vectorEntrenadores;
	}
	
	
	// PRUEBITA
	public static void vectorDeportistaAJSON(Vector<Deportista> v, String dirJson) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		
		try(FileWriter writer = new FileWriter(dirJson)) {
			gson.toJson(v,writer);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	// SACO EL DEPORTISTA DEL JSON PARA LUEGO CREAR UN OBJETO ÚNICO
	public static Deportista JsonA_DeportistaUnico (String dirJson) { // COGE EL DEPORTISTA DEL JSON PARA LUEGO CREAR EL OBJETO
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Deportista deportista = new Deportista();
		try(Reader reader = new FileReader(dirJson)) {
			deportista = gson.fromJson(reader, Deportista.class);
		} catch(IOException e) {
			e.printStackTrace();
		}	
		return deportista;
	}
	
	public static Entrenador JsonA_EntrenadorUnico (String dirJson) { // COGE EL DEPORTISTA DEL JSON PARA LUEGO CREAR EL OBJETO
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Entrenador entrenador = new Entrenador();
		try(Reader reader = new FileReader(dirJson)) {
			entrenador = gson.fromJson(reader, Entrenador.class);	
		} catch(IOException e) {
			e.printStackTrace();
		}	
		return entrenador;
	}
	
	public static Medico JsonA_MedicoUnico (String dirJson) { // COGE EL DEPORTISTA DEL JSON PARA LUEGO CREAR EL OBJETO
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Medico medico = new Medico();
		try(Reader reader = new FileReader(dirJson)) {
			medico = gson.fromJson(reader, Medico.class);	
		} catch(IOException e) {
			e.printStackTrace();
		}
		return medico;
	}
	
	
	
	
	
	
	
	// METE EL DEPORTISTA EN EL JSON TEMPORAL PARA PODER LUEGO TRABAJAR CON LOS DATOS TRAS EL LOGIN 
	public static void deportistaEnJson(Deportista deportista, String dirJson) { // METE EL DEPORTISTA EN EL JSON -----------------------	ESTE BORRA LO DEMÁS
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter writer = new FileWriter(dirJson)) {
			gson.toJson(deportista,writer);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void MedicoEnJson(Medico medico, String dirJson) { // METE EL DEPORTISTA EN EL JSON ------------------------	ESTE BORRA LO DEMÁS
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter writer = new FileWriter(dirJson)) {
			gson.toJson(medico,writer);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void EntrenadorEnJson(Entrenador entrenador, String dirJson) { // METE EL DEPORTISTA EN EL JSON ----------------------	ESTE BORRA LO DEMÁS
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileWriter writer = new FileWriter(dirJson)) {
			gson.toJson(entrenador,writer);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	// MÉTODOS PARA METER UN VECTOR DENTRO DEL JSON
	public void meterDeportistaEnJSON(Deportista deportista) {
		
		Deportista d = deportista;
		vectorDeportistas = JsonA_Deportista(dirFileDeportista);
		vectorDeportistas.add(d);
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
//		String representacionBonita = prettyGson.toJson(vectorDeportistas);
//		System.out.println(representacionBonita);
		
		try(FileWriter writer = new FileWriter(dirFileDeportista)){
			prettyGson.toJson(vectorDeportistas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void meterPersonaaEnJSON(Persona persona) {
		
		Persona p = persona;
		vectorPersonas = JsonA_Personas(dirFilePersonas);
		vectorPersonas.add(p);
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
//		String representacionBonita = prettyGson.toJson(vectorPersonas);
//		System.out.println(representacionBonita);
		
		try(FileWriter writer = new FileWriter(dirFilePersonas)){
			prettyGson.toJson(vectorPersonas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void meterMedicoaEnJSON(Medico medico) {
		
		Medico m = medico;	
		vectorMedicos = JsonA_Medicos(dirFileMedicos);
		vectorMedicos.add(m);
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
//		String representacionBonita = prettyGson.toJson(vectorMedicos);
//		System.out.println(representacionBonita);
		
		try(FileWriter writer = new FileWriter(dirFileMedicos)){
			prettyGson.toJson(vectorMedicos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void meterEntrenadoraEnJSON(Entrenador entrenador) {
		
		Entrenador en = entrenador;		
		vectorEntrenadores = JsonA_Entrenadores(dirFileEntrenadores);
		vectorEntrenadores.add(en);
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
//		String representacionBonita = prettyGson.toJson(vectorEntrenadores);
//		System.out.println(representacionBonita);
		
		try(FileWriter writer = new FileWriter(dirFileEntrenadores)){
			prettyGson.toJson(vectorEntrenadores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	
	
	
	
	
	

}
