package control;
import java.util.Vector;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import entidades.Deportista;
import entidades.Entrenamientos;
import entidades.Marcas;
import entidades.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorPantallaVerDatosDeportista {

    @FXML
    private Button botonBack;

    @FXML
    private Label labelNombre;

    @FXML
    private Button botonEntreno;

    @FXML
    private Button botonMarcas;
    
    
    
    static ControladorJSON c = new ControladorJSON();
    
    Vector	<Deportista> 		vectorDeportistas 		= new Vector<Deportista>();
    Vector	<Entrenamientos> 	vectorEntrenamientos	= new Vector<Entrenamientos>();
    Vector	<Marcas> 			vectorMarcas			= new Vector<Marcas>();
    
    String dirFileDeportista 		= "deportistas.json";
    String dirFileEntrenamientos 	= "entrenamientos.json";
    String dirFileMarcas 			= "marcas.json";

    
    
    	

    public void  mostrarInfo(String correo, String nombre, String Apellido){
    	System.out.println(nombre);
    	
    	
    	labelNombre.setText("Usuario: " + correo + "/n" + 
				"Nombre: " + nombre + "/n" +
				"Apellido: "+ Apellido); 
    };
    
    
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
    
    
    
    
    @FXML
    void initialize() {

    }
    
    @FXML
    void verEntreno(ActionEvent event) { 

    }
    
   

    @FXML
    void verMarcas(ActionEvent event) {
    	
    }

}
