package com.miproyecto.proyectofinal;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import metodosDeControladores.MetodosPantallaFinal;

public class PantallaFinalController extends JFrame {

	@FXML
	private Button verGrafica;

	@FXML
	private Button descargarWord;

	@FXML
	private Button descargarPdf;

	@FXML
	private Button reiniciarBoton;

	@FXML
	private Button salirDelPrograma;

	private int contadorAtaques;
	private int contadorCuras;
	private int contadorSuerte;

	public void setContadores(int contadorAtaques, int contadorCuras, int contadorSuerte) {
		this.contadorAtaques = contadorAtaques;
		this.contadorCuras = contadorCuras;
		this.contadorSuerte = contadorSuerte;
	}

	@FXML
	private void verGrafica() throws IOException {
		MetodosPantallaFinal.verGraficaCombate(contadorAtaques, contadorCuras, contadorSuerte);
	}

	@FXML
	private void descargarWord() throws IOException {
		MetodosPantallaFinal.descargarWordComabate(contadorAtaques, contadorCuras, contadorSuerte);
	}

	@FXML
	private void descargarPdf() throws IOException {
		MetodosPantallaFinal.descargarPdfCombate(contadorAtaques, contadorCuras, contadorSuerte);
	}

	@FXML
	private void salirDelPrograma() throws IOException {
		System.exit(1);
	}

}