package control;

import control.ControladorJSONPyt;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorPantallaLogIn {

	@FXML
	private JFXTextField fxtfEmail;

	@FXML
	private JFXTextField fxtfNombre;

	@FXML
	private JFXTextField fxtfApellido;

	@FXML
	private JFXPasswordField fxtfContrasena;

	@FXML
	private Button botonRegistro;

	@FXML
	private JFXPasswordField fxtfConfirmCont;

	@FXML
	private Label miLabel;

	@FXML
	private DatePicker fechaRegistro;

	@FXML
	private TextField especialityRegistro;

	@FXML
	private Label labelName;

	@FXML
	private Label labelSurname;

	@FXML
	private Label labelPassword;

	@FXML
	private Label labelCompletado;

	@FXML
	private Button backButton;

	@FXML
	private RadioButton rbDeportista;

	@FXML
	private ToggleGroup tgRoll;

	@FXML
	private RadioButton rbEntrenador;

	@FXML
	private RadioButton rbMedico;

	@FXML
	private Label lbErrorRoll;

	@FXML
	private Label lbErrCampos;
	
	
	
	
	
	
	@FXML
	void volver(ActionEvent event) {
		try {
			FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/view/PantallaPrincipal.fxml")); // NOS LLEVA A LA NUEVA VENTANA
			ControladorPantallaPrincipal control = new ControladorPantallaPrincipal(); 
			loader3.setController(control);
			Parent root2 = loader3.load();

			// CIERRA LA VENTANA ANTERIOR
			Stage myStage = (Stage) this.backButton.getScene().getWindow();
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
	void registraEsto(ActionEvent event) { // ACCIÓN QUE OCURRIRÁ AL PULSAR BOTON DE REGISTRAR 
		
		ControladorJSONPyt controlJson = new ControladorJSONPyt();
		Vector	<Persona> listUsuarios = controlJson.desserializarJsonArrayPersona();
		
		
		// FUNCIONES DE VALIDACIÓN QUE SE REALIZARÁN ANTES DE REGISTRAR AL USUARIO
		comprobarRoll();	comprobarCampoNombre();		comprobarCampoApellido();		
		validarEmail();		validarContrasena();		validarPassword2();		existeUsuarioYa();
		
		
		
		
		
			try {
				
				String mail 			= fxtfEmail.getText();
				String nombre 			= fxtfNombre.getText();
				String apellido 		= fxtfApellido.getText();
				String contrasena 		= fxtfContrasena.getText();
				
				Persona entrenador 		= null;
				Persona nuevoUsuario 	= null;
				
				
				
				// AQUÍ SE CREA EL NUEVO USUARIO EN FUNCIÓN DEL ROLL QUE SE HAYA SELECCIONADO CON LOS BOTONES. SOLO SE CREARÁ UNO
				if(rbDeportista.isSelected()) {
					nuevoUsuario 	= new Persona(mail, nombre, apellido, contrasena, "Deportista");	// TIPO PERSONA
				} else if(rbEntrenador.isSelected()) {
					nuevoUsuario 	= new Persona(mail, nombre, apellido, contrasena, "Entrenador");	// TIPO PERSONA
				} else if(rbMedico.isSelected()) {
					nuevoUsuario 	= new Persona(mail, nombre, apellido, contrasena, "Medico");		// TIPO PERSONA
				}
	
				listUsuarios.add(nuevoUsuario); // AÑADE EL USUARIO AL VECTOR
				controlJson.serializarArrayAJsonPersona(listUsuarios); // METE LA LISTA EN EL JSON
				
				
				

				if (rbDeportista.isSelected()) {
					
					Vector	<Deportista> listDeportistas = controlJson.desserializarJsonAArrayDeportista(); // SACA LOS DATOS DEL JSON
					Deportista nuevoDeportista = new Deportista(mail, nombre, apellido, contrasena, null, "Deportista"); // CREA DEPORTISTA
					listDeportistas.add(nuevoDeportista); // METE EL DEPORTISTA EN EL ARRAY
					controlJson.serializarArrayAJsonDeportistas(listDeportistas); // LO MANDA AL JSON
					

					FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaVerDatosDeportista.fxml"));
					ControladorPantallaVerDatosDeportista controlPantDeportista = new ControladorPantallaVerDatosDeportista();
					loader.setController(controlPantDeportista);
					Parent root = loader.load();
					
					// controlPantDeportista.mostrarInfo(mail, nombre, apellido);
					
					
					// CIERRA LA VENTANA ANTERIOR
					Stage myStage = (Stage) this.backButton.getScene().getWindow();
					myStage.close();

					// INICIA LA VENTANA
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.initModality(Modality.WINDOW_MODAL);
					stage.initOwner(((Node) (event.getSource())).getScene().getWindow()); 
					stage.show();

					

				} else if (rbEntrenador.isSelected()) {
					Vector	<Entrenador> listEntrenadores = controlJson.desserializarJsonArrayEntrenador();
					Entrenador nuevoEntrenador = new Entrenador(mail, nombre, apellido, contrasena, "Entrenador");
					listEntrenadores.add(nuevoEntrenador);
					controlJson.serializarArrayAJsonEntrenador(listEntrenadores);
					


					FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaVerDatosEntrenador.fxml")); // CARGA																			// PRINCIPAL
					ControladorPantallaVerDatosEntrenador controlPantEntrenador = new ControladorPantallaVerDatosEntrenador();
					// controlPantEntrenador.mostrarInfo(mail, nombre, apellido);
					loader.setController(controlPantEntrenador);
					Parent root = loader.load();

					// CIERRA LA VENTANA ANTERIOR
					Stage myStage = (Stage) this.backButton.getScene().getWindow();
					myStage.close();

					// INICIA LA VENTANA
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.initModality(Modality.WINDOW_MODAL);
					stage.initOwner(((Node) (event.getSource())).getScene().getWindow()); 
					stage.show();

				} else if (rbMedico.isSelected()) {
					Vector<Medico> listMedicos = controlJson.desserializarJsonArrayMedicos();
					Medico nuevoMedico = new Medico(mail, nombre, apellido, contrasena, "Medico");
					listMedicos.add(nuevoMedico);
					controlJson.serializarArrayAJsonMedico(listMedicos);
							

					FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaVerDatosMedico.fxml"));
					ControladorPantallaVerDatosMedico controlPantMedico = new ControladorPantallaVerDatosMedico();
					// controlPantMedico.mostrarInfo(mail, nombre, apellido);
					loader.setController(controlPantMedico);
					Parent root = loader.load();
					
					// CIERRA LA VENTANA ANTERIOR
					Stage myStage = (Stage) this.backButton.getScene().getWindow();
					myStage.close();

					// INICIA LA VENTANA
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.initModality(Modality.WINDOW_MODAL);
					stage.initOwner(((Node) (event.getSource())).getScene().getWindow()); 
					stage.show();
					
					

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	
	
	
	
	
	
	
	// ******************************************************************* FUNCIONES *******************************************************************
	
	
	// FUNCIÓN COMPROBAR SELECCIÓN CORRECTA DE ROL 
	public void comprobarRoll() {
		if ((rbDeportista.isSelected() == false) && (rbMedico.isSelected() == false) && (rbEntrenador.isSelected() == false)) { // SI NADA ESTA SELECCIONADO
			lbErrorRoll.setText("No se ha seleccionado el roll correctamente"); // SALE MENSAJE
			lbErrorRoll.setVisible(true);
			
		} else {
			lbErrorRoll.setVisible(false);

		}

	}

		
	// FUNCION COMPROBAR EL CAMPO DEL NOMBRE
	public void comprobarCampoNombre() { // **** METER FUNCIONALIDAD PARA QUE NO HAYA NÚMEROS EN EL NOMBRE *****
		if (fxtfNombre.getText().equals("")) {
			System.out.println("No se ha rellenado el campo nombre");
			fxtfNombre.setStyle("-fx-prompt-text-fill: red; -jfx-unfocus-color: red;");
		} else {
			fxtfNombre.setStyle("-fx-prompt-text-fill: black; -jfx-unfocus-color: black;");
		}
	}
	
	
	
	
	// FUNCIÓN COMPROBAR EL CAMPO DEL APELLIDO
	public void comprobarCampoApellido() {
		if (fxtfApellido.getText().equals("")) {
			System.out.println("No se ha rellenado el campo Apellido");
			fxtfApellido.setStyle("-fx-prompt-text-fill: red; -jfx-unfocus-color: red;");
		} else {
			fxtfApellido.setStyle("-fx-prompt-text-fill: black; -jfx-unfocus-color: black;");
		}
	}

	
	
	// FUNCIÓN COMPROBAR EMAIL PARA QUE SEA VALIDO
	public void validarEmail() {
		
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); // PATRÓN PARA VALIDAR EL EMAIL
		String email = fxtfEmail.getText(); // VARIAVLE PARA GUARDAR EL EMAIL QUE SE VA A VALIDAR
		Matcher mather = pattern.matcher(email); // "BOOLEAN" QUE COMPRUEBA 

		if (mather.find() == true) {
			System.out.println("El email ingresado es válido.");
			fxtfEmail.setStyle("-fx-prompt-text-fill: black; -jfx-unfocus-color: black;");
		} else {
			fxtfEmail.setStyle("-fx-prompt-text-fill: red; -jfx-unfocus-color: red;");
			System.out.println("El email ingresado es inválido.");
		}
	}

	
	
	
	// FUNCÍO PARA VALIDAR LAS CONTRASEÑAS
	public void validarContrasena() {
		int tamCont = fxtfContrasena.getText().length(); // HACE QUE LA LONGITUD DE LA CONTRASEÑA SEA MÍNIMO 8
		if (tamCont < 8) {
			System.out.println("Tamano de la contrasena es menor a 8 caracteres");
			fxtfContrasena.setStyle("-fx-prompt-text-fill: red; -jfx-unfocus-color: red;");
			
		} else {
			fxtfContrasena.setStyle("-fx-prompt-text-fill: black; -jfx-unfocus-color: black;");
		}
	}

	
	
	// FUNCIÓN PARA VALIDAR CONTRASEAÑS (COMPROBANTE)
	public void validarPassword2() {
		String pass = fxtfContrasena.getText();
		String confirmPass = fxtfConfirmCont.getText();
		if (!pass.equals(confirmPass)) {
			System.out.println("Los campos de las contrasenas no coinciden");
			fxtfConfirmCont.setStyle("-fx-prompt-text-fill: red; -jfx-unfocus-color: red;");
		} else {
			fxtfConfirmCont.setStyle("-fx-prompt-text-fill: black; -jfx-unfocus-color: black;");
		}
	}

	
	
	// FUNCIÓN QUE COMPRUEBA SI EL USUARIO YA ESTA REGITRADO
	public void existeUsuarioYa() {
		ControladorJSONPyt controladorJson = new ControladorJSONPyt();
		Vector<Persona> vUsuariosPersonas = controladorJson.desserializarJsonArrayPersona();

		if (controladorJson.CoincicenciaEnLaListaPersona(fxtfEmail.getText(), vUsuariosPersonas) == true) {
			System.out.println("El correo ya existe");
		}

	}
}
