package control;

import java.util.Vector;

import com.jfoenix.controls.JFXTextField;

import entidades.Deportista;
import entidades.Entrenador;
import entidades.Medico;
import entidades.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorPantallaPrincipal {
	
	
	
    @FXML
    private JFXTextField fxtfUsuarioPantP;

    @FXML
    private JFXTextField fxtfContrasenaPantP;

    @FXML
    private Button miBotonLogin;

    @FXML
    private Label miLabel1;

    @FXML
    private Label miLabel2;

    @FXML
    private Button miBotonRegister;
    
    // DIRECCIONES DE LOS ARCHIVOS A UTILIZAR
    String dirFileDeportista 	= "deportistas.json";
	String dirFilePersonas 		= "personas.json"; 
	String dirFileMedicos 		= "medicos.json";
	String dirFileEntrenadores 	= "entrenadores.json";
	String dirFileTemportal		= "temportal.json"; // maybe out
	
    
    // VECTORES DE DATOS
    Vector	<Deportista> 	vectorDeportistas 		= new Vector<Deportista>();
	Vector	<Persona> 		vectorPersonas 			= new Vector<Persona>();
	Vector	<Medico> 		vectorMedicos 			= new Vector<Medico>();
	Vector	<Entrenador> 	vectorEntrenadores 		= new Vector<Entrenador>();
	
	
	
	


    @FXML
    void accedeLogIn(ActionEvent event) { // VERIFICA LAS CREDENCIALES DEL USUARIO
    	
    	// CONTROLADOR DE LA CLASE JSON PARA LUEGO LLAMAR A LOS MÉTODOS DE DICHA CLASE QUE ES DONDE SE ENCUENTRAN LAS FUNCIONES PARA SACAR LOS DATOS DEL JSON Y METERLOS
    	ControladorJSON c = new ControladorJSON();
    	
    	
    	// CREAMOS ENTIDADES VACÍAS PARA LUEGO RELLENARLAS
    	Entrenador entrenador 	= null;		Medico medico 			= null;		Deportista deportista 	= null;
    	
    	// SACAMOS LA INFORMACIÓN DE LOS JSON Y LO METEMOS EN VECTORES
    	vectorPersonas 		= c.JsonA_Personas(dirFilePersonas);
    	vectorDeportistas 	= c.JsonA_Deportista(dirFileDeportista);
    	vectorEntrenadores 	= c.JsonA_Entrenadores(dirFileEntrenadores);
    	vectorMedicos 		= c.JsonA_Medicos(dirFileMedicos);
    	   	
    	
		// ALMACENAMOS LO OBTENIDOS POR LOS TEXTFIELDS EN LAS SIGUIENTES VARIABLES PARA REALIZAR LA COMPROBACIÓN
		String correo = fxtfUsuarioPantP.getText();		String pass = fxtfContrasenaPantP.getText();
		
		

		for(int i = 0; i < vectorPersonas.size(); i++) {
			if(correo.equals(vectorPersonas.get(i).correo) && pass.equals(vectorPersonas.get(i).pass) && vectorPersonas.get(i).roll.equals("Deportista")) {
				try {
					// CREAMOS LOS OBJETOS
					FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/view/PantallaVerDatosDeportista.fxml")); // NOS LLEVA A LA NUEVA VENTANA
					ControladorPantallaVerDatosDeportista control4 = new ControladorPantallaVerDatosDeportista(); // IMPORTANTE CAMBIAR ESTO
					loader4.setController(control4);
					Parent root4 = loader4.load();
					
					// CIERRA LA VENTANA ANTERIOR
					Stage myStage = (Stage)this.miBotonLogin.getScene().getWindow();
					myStage.close();
					
					// INICIA LA VENTANA
					Stage stage = new Stage();
					stage.setScene(new Scene(root4));
					stage.initModality(Modality.WINDOW_MODAL);
					stage.initOwner(((Node)(event.getSource())).getScene().getWindow()); // ESTO HACE QUE NO PUEDAS VOLVER A SUBMIT HASTA QUE CIERRES LA VENTANA
					stage.show();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			} else if(correo.equals(vectorPersonas.get(i).correo) && pass.equals(vectorPersonas.get(i).pass) && vectorPersonas.get(i).roll.equals("Entrenador")) {
				try {
					// CREAMOS LOS OBJETOS
					FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/view/PantallaVerDatosEntrenador.fxml")); // NOS LLEVA A LA NUEVA VENTANA
					ControladorPantallaVerDatosEntrenador control4 = new ControladorPantallaVerDatosEntrenador(); // IMPORTANTE CAMBIAR ESTO
					loader4.setController(control4);
					Parent root4 = loader4.load();  
					
					// CIERRA LA VENTANA ANTERIOR
					Stage myStage = (Stage)this.miBotonLogin.getScene().getWindow();
					myStage.close();
					
					// INICIA LA VENTANA
					Stage stage = new Stage();
					stage.setScene(new Scene(root4));
					stage.initModality(Modality.WINDOW_MODAL);
					stage.initOwner(((Node)(event.getSource())).getScene().getWindow()); // ESTO HACE QUE NO PUEDAS VOLVER A SUBMIT HASTA QUE CIERRES LA VENTANA
					stage.show();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(correo.equals(vectorPersonas.get(i).correo) && pass.equals(vectorPersonas.get(i).pass) && vectorPersonas.get(i).roll.equals("Medico")) {
				try {
					// CREAMOS LOS OBJETOS
					FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/view/PantallaVerDatosMedico.fxml")); // NOS LLEVA A LA NUEVA VENTANA
					ControladorPantallaVerDatosMedico control4 = new ControladorPantallaVerDatosMedico(); // IMPORTANTE CAMBIAR ESTO
					loader4.setController(control4);
					Parent root4 = loader4.load();
					
					// CIERRA LA VENTANA ANTERIOR
					Stage myStage = (Stage)this.miBotonLogin.getScene().getWindow();
					myStage.close();
					
					// INICIA LA VENTANA
					Stage stage = new Stage();
					stage.setScene(new Scene(root4));
					stage.initModality(Modality.WINDOW_MODAL);
					stage.initOwner(((Node)(event.getSource())).getScene().getWindow()); // ESTO HACE QUE NO PUEDAS VOLVER A SUBMIT HASTA QUE CIERRES LA VENTANA
					stage.show();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
}
    
    
    
    @FXML
    void registraUsuario(ActionEvent event) { // PERMITE ACCEDER AL MENÚ DE REGISTRACIÓN
    	
    	try {
    		// CREAMOS LOS OBJETOS
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/PantRegistroSave.fxml")); // NOS LLEVA A LA NUEVA VENTANA
			ControladorPantallaLogIn control = new ControladorPantallaLogIn(); // IMPORTANTE CAMBIAR ESTO
			loader2.setController(control);
			Parent root2 = loader2.load();
				
			// CIERRA LA VENTANA ANTERIOR
			Stage myStage = (Stage)this.miBotonLogin.getScene().getWindow();
			myStage.close();
			
			// INICIA LA VENTANA
			Stage stage = new Stage();
			stage.setScene(new Scene(root2));
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)(event.getSource())).getScene().getWindow()); // ESTO HACE QUE NO PUEDAS VOLVER A SUBMIT HASTA QUE CIERRES LA VENTANA
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	

    }

}
