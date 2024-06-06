package com.miproyecto.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metodosDeControladores.MetodosPantallaDeJuego;
import java.io.IOException;
import com.miproyecto.clases.Individuo;

public class PantallaDeJuegoController {

	private Individuo jugador;
	private Individuo enemigo;
	private static int contadorAtaques = 0;
	private static int contadorCuras = 0;
	private static int contadorSuerte = 0;
	
	private Image enemigo1=new Image(getClass().getResource("/img/midir.gif").toExternalForm());
	private Image enemigo2=new Image(getClass().getResource("/img/delincuente.gif").toExternalForm());
	private Image enemigo3=new Image(getClass().getResource("/img/espectro.gif").toExternalForm());

	@FXML
	private Button empezarJuego;

	@FXML
	private Button atacaJugador;

	@FXML
	private Button curarse;

	@FXML
	private Button probarSuerte;

	@FXML
	private Label probarSuerteMensaje;

	@FXML
	private Label vidaAlMaximo;

	@FXML
	private Label mensaje;

	@FXML
	private Label nombreJugadorLabel;
	
	@FXML
	private Label nombreEnemigoLabel;
	
	@FXML
	private Label vidaRestanteJugador;

	@FXML
	private Label ataqueDeJugador;

	@FXML
	private Label informacionArma;

	@FXML
	private Label vidaRestanteEnemigo;

	@FXML
	private Label ataqueDeEnemigo;
	
	@FXML
	private ImageView imagenEnemigo;

	public void setJugadores(Individuo jugador) {
		this.jugador = jugador;
		enemigo = MetodosPantallaDeJuego.generarEnemigo();
		MetodosPantallaDeJuego.habilidadArco(this.jugador);
		MetodosPantallaDeJuego.habilidadSarten(jugador, enemigo);
		mensaje.setText("Juego de " + jugador.getNombre() + " contra " + enemigo.getNombre() + " iniciado");
		MetodosPantallaDeJuego.mostrarInformacion(jugador, enemigo, vidaRestanteJugador, ataqueDeJugador,
				informacionArma, vidaRestanteEnemigo, ataqueDeEnemigo, nombreJugadorLabel, nombreEnemigoLabel);
		MetodosPantallaDeJuego.cambiarImagenesEnemigos(enemigo, imagenEnemigo, enemigo1, enemigo2, enemigo3);
	}

	@FXML
	private void empezarJuego() throws IOException {
		MetodosPantallaDeJuego.empezarJuego(atacaJugador, curarse, probarSuerte, empezarJuego);
		MetodosPantallaDeJuego.mostrarInformacion(jugador, enemigo, vidaRestanteJugador, ataqueDeJugador,
				informacionArma, vidaRestanteEnemigo, ataqueDeEnemigo, nombreJugadorLabel, nombreEnemigoLabel);
	}

	@FXML
	private void atacaJugador() throws IOException {
		MetodosPantallaDeJuego.atacaJugador(jugador, enemigo, vidaAlMaximo);
		contadorAtaques++;
		terminarJuego();
		MetodosPantallaDeJuego.accionAleatoriaDelEnemigo(jugador, enemigo, mensaje);
		terminarJuego();
		MetodosPantallaDeJuego.mostrarInformacion(jugador, enemigo, vidaRestanteJugador, ataqueDeJugador,
				informacionArma, vidaRestanteEnemigo, ataqueDeEnemigo, nombreJugadorLabel, nombreEnemigoLabel);
	}

	@FXML
	private void curarse() throws IOException {
		MetodosPantallaDeJuego.curarse(jugador, vidaAlMaximo);
		contadorCuras++;
		MetodosPantallaDeJuego.accionAleatoriaDelEnemigo(jugador, enemigo, mensaje);
		terminarJuego();
		MetodosPantallaDeJuego.mostrarInformacion(jugador, enemigo, vidaRestanteJugador, ataqueDeJugador,
				informacionArma, vidaRestanteEnemigo, ataqueDeEnemigo, nombreJugadorLabel, nombreEnemigoLabel);
	}

	@FXML
	private void probarSuerte() throws IOException {
		MetodosPantallaDeJuego.probarSuerte(jugador, probarSuerteMensaje, vidaAlMaximo);
		contadorSuerte++;
		MetodosPantallaDeJuego.accionAleatoriaDelEnemigo(jugador, enemigo, mensaje);
		terminarJuego();
		MetodosPantallaDeJuego.mostrarInformacion(jugador, enemigo, vidaRestanteJugador, ataqueDeJugador,
				informacionArma, vidaRestanteEnemigo, ataqueDeEnemigo, nombreJugadorLabel, nombreEnemigoLabel);
	}

	private void terminarJuego() throws IOException {
		if (jugador.getPv() <= 0 && enemigo.getPv() <= 0) {
			jugador.setPv(0);
			enemigo.setPv(0);
			mensaje.setText("Fin del juego, empate");
			MetodosPantallaDeJuego.mostrarInformacion(jugador, enemigo, vidaRestanteJugador, ataqueDeJugador,
					informacionArma, vidaRestanteEnemigo, ataqueDeEnemigo, nombreJugadorLabel, nombreEnemigoLabel);
			terminarSetUp();
		}
		if (jugador.getPv() <= 0) {
			jugador.setPv(0);
			mensaje.setText("Fin del juego, ganó " + enemigo.getNombre());
			MetodosPantallaDeJuego.mostrarInformacion(jugador, enemigo, vidaRestanteJugador, ataqueDeJugador,
					informacionArma, vidaRestanteEnemigo, ataqueDeEnemigo, nombreJugadorLabel, nombreEnemigoLabel);
			terminarSetUp();
		}
		if (enemigo.getPv() <= 0) {
			enemigo.setPv(0);
			mensaje.setText("Fin del juego, ganó " + jugador.getNombre());
			MetodosPantallaDeJuego.mostrarInformacion(jugador, enemigo, vidaRestanteJugador, ataqueDeJugador,
					informacionArma, vidaRestanteEnemigo, ataqueDeEnemigo, nombreJugadorLabel, nombreEnemigoLabel);
			terminarSetUp();
		}
		MetodosPantallaDeJuego.mostrarInformacion(jugador, enemigo, vidaRestanteJugador, ataqueDeJugador,
				informacionArma, vidaRestanteEnemigo, ataqueDeEnemigo, nombreJugadorLabel, nombreEnemigoLabel);
	}

	public void terminarSetUp() throws IOException {
		MetodosPantallaDeJuego.terminarSetUp(atacaJugador, curarse, probarSuerte);
		irAPantallaFinal();
		MetodosPantallaDeJuego.mostrarInformacion(jugador, enemigo, vidaRestanteJugador, ataqueDeJugador,
				informacionArma, vidaRestanteEnemigo, ataqueDeEnemigo, nombreJugadorLabel, nombreEnemigoLabel);
	}

	public void irAPantallaFinal() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/miproyecto/proyectofinal/pantallaFinal.fxml"));
		Stage stage = new Stage();
		stage.setTitle("RogueFX");
		stage.setWidth(640);
		stage.setHeight(550);
		stage.setScene(new Scene(loader.load()));
		stage.initModality(Modality.APPLICATION_MODAL);

		PantallaFinalController controller = loader.getController();

		controller.setContadores(contadorAtaques, contadorCuras, contadorSuerte);

		stage.showAndWait();
	}

}