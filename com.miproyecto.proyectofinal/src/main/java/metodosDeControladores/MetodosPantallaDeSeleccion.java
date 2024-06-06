package metodosDeControladores;

import com.miproyecto.clases.Arma;
import com.miproyecto.clases.Individuo;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class MetodosPantallaDeSeleccion {

	public static void establecerNombre(Individuo jugador, TextField introducirNombre, Button aceptarNombre,
			ChoiceBox<String> seleccionArmasJugador) {
		jugador.setNombre(introducirNombre.getText());
		Alert alertaInformativaNombre = new Alert(AlertType.INFORMATION);
		alertaInformativaNombre.setTitle("RogueFX");
		alertaInformativaNombre.setHeaderText("Has establecido tu nombre");
		alertaInformativaNombre.setContentText("Bienvenido/a " + jugador.getNombre());
		alertaInformativaNombre.show();
		introducirNombre.setDisable(true);
		aceptarNombre.setDisable(true);
		seleccionArmasJugador.setDisable(false);
	}

	public static void handleChoiceBoxSelection(ChoiceBox<String> seleccionArmasJugador, Individuo jugador,
			Button jugar) {
		seleccionArmasJugador.setDisable(true);
		asignacionArmas(seleccionArmasJugador, jugador);
		System.out.println("Se seleccionó: " + seleccionArmasJugador.getValue());
		jugar.setDisable(false);
	}

	public static boolean asignacionArmas(ChoiceBox<String> seleccionArmas, Individuo jugador) {
		if (seleccionArmas.getValue().equals("Espada")) {
			jugador.setArma(Arma.ES);
		} else if (seleccionArmas.getValue().equals("Arco")) {
			jugador.setArma(Arma.AR);
		} else if (seleccionArmas.getValue().equals("Pistola")) {
			jugador.setArma(Arma.PI);
		} else if (seleccionArmas.getValue().equals("Hacha")) {
			jugador.setArma(Arma.HA);
		} else if (seleccionArmas.getValue().equals("Sartén")) {
			jugador.setArma(Arma.SA);
		} else {
			jugador.setArma(Arma.MA);
		}
		return true;
	}

}
