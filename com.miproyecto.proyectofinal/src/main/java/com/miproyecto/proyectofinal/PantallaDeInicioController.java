package com.miproyecto.proyectofinal;

import java.io.IOException;
import javafx.fxml.FXML;

public class PantallaDeInicioController {

	@FXML
	private void jugar() throws IOException {
		App.setRoot("pantallaDeSeleccion");
	}

	@FXML
	private void salir() throws IOException {
		System.exit(1);
	}

}
