package control;
import java.util.Vector;

import entidades.Deportista;
import entidades.Medico;
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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControladorPantallaVerDatosMedico {

    @FXML
    private Label labelNombre;

//    @FXML
//    private Label labelCorreo;

    @FXML
    private Button botonCitas;

    @FXML
    private Button botonHistorial;

//    @FXML
//    private Label labelistaUsuarios;
//
    @FXML
    private Label listaUsuarios;

//    @FXML
//    private Label labelhorasDispo;

    @FXML
    private Label horasDispo;

    @FXML
    private TextField cajaNombre; 

    @FXML
    private TextField cajaDia;
    
    @FXML
    private Button botonBack;
    
    
    static ControladorArchivosMedico cam = new ControladorArchivosMedico();
    static ControladorJSON c = new ControladorJSON();
	static String dirFile = "medicos.json";
	static Vector	<Medico> 	vectorMedicos 		= new Vector<Medico>();
	
	
	@FXML
	void volver(ActionEvent event) {
		try {
			FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/view/PantallaPrincipal.fxml")); // NOS LLEVA A LA NUEVA VENTANA
			ControladorPantallaPrincipal control = new ControladorPantallaPrincipal(); 
			loader3.setController(control);
			Parent root2 = loader3.load();

			// CIERRA LA VENTANA ANTERIOR
			Stage myStage = (Stage) this.botonBack.getScene().getWindow();
			myStage.close();

			Stage stage = new Stage();
			stage.setScene(new Scene(root2));
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node) (event.getSource())).getScene().getWindow()); // ESTO HACE QUE NO PUEDAS VOLVER A SUBMIT HASTA QUE CIERRES LA VENTANA
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	// ENTIENDO QUE ES PARA EL INICIALITE. *** ESTO ESTA COMENTADO EN EL REGISTRO Y EN LA PANTALLA PRINCIPAL
	public void  mostrarInfo(String correo, String nombre, String Apellido){
    	System.out.println(nombre);
    	
    	
    	labelNombre.setText("Usuario: " + correo + "/n" + 
				"Nombre: " + nombre + "/n" +
				"Apellido: "+ Apellido); 
    };
    
    @FXML
    void asignarCita(ActionEvent event) { // Ó RESERVA 

    }
    
    

    @FXML
    void verHistorial(ActionEvent event) { // LLAMEMOSLO MEJOR VER PERSONAS Y HORARIOS
 
    }

}
