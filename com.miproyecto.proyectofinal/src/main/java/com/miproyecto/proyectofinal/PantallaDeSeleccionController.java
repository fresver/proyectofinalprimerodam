package com.miproyecto.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.miproyecto.clases.Individuo;
import com.miproyecto.clases.Arma;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import metodosDeControladores.MetodosPantallaDeSeleccion;

public class PantallaDeSeleccionController implements Initializable {

	private Individuo jugador = new Individuo("Jugador 1", 75., 75., 5.);

	private Arma a1 = Arma.ES;
	private Arma a2 = Arma.AR;
	private Arma a3 = Arma.PI;
	private Arma a4 = Arma.HA;
	private Arma a5 = Arma.SA;
	private Arma a6 = Arma.MA;

	@FXML
	private TextField introducirNombre;

	@FXML
	private Button aceptarNombre;

	@FXML
	private Label armasDeJugador;

	@FXML
	private Label habilidadEs;

	@FXML
	private Label habilidadAr;

	@FXML
	private Label habilidadPi;

	@FXML
	private Label habilidadHa;

	@FXML
	private Label habilidadSa;

	@FXML
	private Label habilidadMa;

	@FXML
	private ChoiceBox<String> seleccionArmasJugador;

	@FXML
	private Button jugar;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		habilidadEs.setText(a1.getNombre().toUpperCase() + ": " + a1.getHabilidad().toUpperCase());
		habilidadAr.setText(a2.getNombre().toUpperCase() + ": " + a2.getHabilidad().toUpperCase());
		habilidadPi.setText(a3.getNombre().toUpperCase() + ": " + a3.getHabilidad().toUpperCase());
		habilidadHa.setText(a4.getNombre().toUpperCase() + ": " + a4.getHabilidad().toUpperCase());
		habilidadSa.setText(a5.getNombre().toUpperCase() + ": " + a5.getHabilidad().toUpperCase());
		habilidadMa.setText(a6.getNombre().toUpperCase() + ": " + a6.getHabilidad().toUpperCase());
		Platform.runLater(() -> {
			aceptarNombre.requestFocus();
		});
		seleccionArmasJugador.getItems().addAll(a1.getNombre(), a2.getNombre(), a3.getNombre(), a4.getNombre(),
				a5.getNombre(), a6.getNombre());
		seleccionArmasJugador.setOnAction(event -> handleChoiceBoxSelection());
		seleccionArmasJugador.setDisable(true);
		jugar.setDisable(true);
	}

	@FXML
	private void establecerNombre() {
		MetodosPantallaDeSeleccion.establecerNombre(jugador, introducirNombre, aceptarNombre, seleccionArmasJugador);
	}

	@FXML
	private void handleChoiceBoxSelection() {
		MetodosPantallaDeSeleccion.handleChoiceBoxSelection(seleccionArmasJugador, jugador, jugar);
	}

	@FXML
	private void irAJugar() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaDeJuego.fxml"));
		Parent root = loader.load();
		PantallaDeJuegoController controller = loader.getController();
		controller.setJugadores(jugador);
		Stage currentStage = (Stage) jugar.getScene().getWindow();
		currentStage.setWidth(900);
		currentStage.setHeight(800);
		currentStage.setScene(new Scene(root));
		currentStage.setTitle("RogueFX");
		currentStage.show();
	}

}
