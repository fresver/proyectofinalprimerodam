package metodosDeControladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import com.miproyecto.clases.Arma;
import com.miproyecto.clases.Individuo;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MetodosPantallaDeJuego {

	public static void mostrarInformacion(Individuo jugador, Individuo enemigo, Label vidaRestanteJugador,
			Label ataqueDeJugador, Label informacionArma, Label vidaRestanteEnemigo, Label ataqueDeEnemigo,
			Label nombreJugadorLabel, Label nombreEnemigoLabel) {
		nombreJugadorLabel.setText(jugador.getNombre());
		vidaRestanteJugador.setText("PV restantes: " + jugador.getPv());
		ataqueDeJugador.setText("Ataque: " + jugador.getAtk());
		informacionArma.setText("Tu arma te está dando " + (int) jugador.getArma().getDaño()
				+ " de daño extra y además " + jugador.getArma().getHabilidad());
		nombreEnemigoLabel.setText(enemigo.getNombre());
		vidaRestanteEnemigo.setText("PV restantes: " + enemigo.getPv());
		ataqueDeEnemigo.setText("Ataque: " + enemigo.getAtk());
	}

	public static Individuo generarEnemigo() {
		List<Individuo> enemigos = new ArrayList<>();
		enemigos.add(new Individuo("Dragón", 200., 200., 15.));
		enemigos.add(new Individuo("Delincuente", 100., 100., 8.));
		enemigos.add(new Individuo("Espectro", 50., 50., 20.));
		Collections.shuffle(enemigos);
		return enemigos.stream().findFirst().get();
	}

	public static void habilidadArco(Individuo jugador) {
		if (jugador.getArma().equals(Arma.AR)) {
			jugador.setPv(jugador.getPv() + 2);
		}
	}

	public static void habilidadSarten(Individuo jugador, Individuo enemigo) {
		if (jugador.getArma().equals(Arma.SA)) {
			enemigo.setPv(enemigo.getPv() - enemigo.getPv() * 0.25);
			enemigo.setPvMax(enemigo.getPvMax() - enemigo.getPvMax() * 0.25);
		}
	}

	public static void atacaJugador(Individuo jugador, Individuo enemigo, Label vidaAlMaximo) {
		Random random = new Random();
		int aleatorioHacha = random.nextInt(3);
		int dañoCriticoHacha = 0;
		if (jugador.getArma().equals(Arma.HA)) {
			if (aleatorioHacha == 0) {
				dañoCriticoHacha = (int) (Arma.HA.getDaño() * 2);
			}
		}
		vidaAlMaximo.setText("");
		enemigo.setPv(enemigo.getPv() - danoJugador(jugador) + dañoCriticoHacha);
	}

	public static double danoJugador(Individuo jugador) {
		return jugador.getAtk() + jugador.getArma().getDaño();
	}

	public static void curarse(Individuo jugador, Label vidaAlMaximo) {
		if (jugador.getPv() >= jugador.getPvMax()) {
			jugador.setPv(jugador.getPvMax());
			vidaAlMaximo.setText("Tu vida está al máximo, espabila");
		} else {
			vidaAlMaximo.setText("");
			jugador.setPv(jugador.getPv() + 1);
			jugador.setPv(jugador.getPv() + 1);
			if (jugador.getArma().equals(Arma.ES)) {
				jugador.setPv(jugador.getPv() + 2);
			} else {
				jugador.setPv(jugador.getPv() + 1);
			}
		}
	}

	public static void probarSuerte(Individuo jugador, Label probarSuerteMensaje, Label vidaAlMaximo) {
		Random random = new Random();
		int accionAleatoria = random.nextInt(3);
		switch (accionAleatoria) {
		case 0:
			if (jugador.getArma().equals(Arma.MA)) {
				jugador.setAtk(jugador.getAtk() + 4);
				probarSuerteMensaje.setText("Aumentaste tu ataque en 4 puntos");
			}
			jugador.setAtk(jugador.getAtk() + 3);
			probarSuerteMensaje.setText("Aumentaste tu ataque en 3 puntos");
			break;
		case 1:
			jugador.setPvMax(jugador.getPvMax() + 4);
			jugador.setPv(jugador.getPv() + 4);
			probarSuerteMensaje.setText("Aumentaste tu vida máxima en 4 puntos");
			break;
		case 2:
			if (jugador.getArma().equals(Arma.PI)) {
				jugador.setAtk(jugador.getAtk() + 1);
				probarSuerteMensaje.setText("Aumentaste tu ataque en 1 punto");
			}
			probarSuerteMensaje.setText("Te ha tocado 1 euro");
			break;
		}
		vidaAlMaximo.setText("");
	}

	public static void accionAleatoriaDelEnemigo(Individuo jugador, Individuo enemigo, Label mensaje) {
		Random random = new Random();
		int accionAleatoria = random.nextInt(3);
		switch (accionAleatoria) {
		case 0:
			jugador.setPv(jugador.getPv() - enemigo.getAtk());
			mensaje.setText(enemigo.getNombre() + " atacó, " + jugador.getNombre() + " perdió " + enemigo.getAtk()
					+ " puntos de vida");
			break;
		case 1:
			enemigo.setPv(enemigo.getNombre().equalsIgnoreCase("dragón") ? enemigo.getPv() + 1 : enemigo.getPv() + 10);
			mensaje.setText(enemigo.getNombre() + " aumentó sus puntos de vida a " + enemigo.getPv());
			break;
		case 2:
			enemigo.setAtk(
					enemigo.getNombre().equalsIgnoreCase("espectro") ? enemigo.getAtk() + 1 : enemigo.getAtk() + 5);
			mensaje.setText(enemigo.getNombre() + " aumentó su ataque a " + enemigo.getAtk());
			break;
		}
	}

	public static void terminarSetUp(Button atacaJugador, Button curarse, Button probarSuerte) {
		atacaJugador.setDisable(true);
		curarse.setDisable(true);
		probarSuerte.setDisable(true);
	}

	public static void empezarJuego(Button atacaJugador, Button curarse, Button probarSuerte, Button empezarJuego) {
		atacaJugador.setDisable(false);
		curarse.setDisable(false);
		probarSuerte.setDisable(false);
		empezarJuego.setDisable(true);
	}

	public static void cambiarImagenesEnemigos(Individuo enemigo, ImageView imagenEnemigo, Image enemigo1,
			Image enemigo2, Image enemigo3) {
		if (enemigo.getNombre().equalsIgnoreCase("Dragón")) {
			imagenEnemigo.setImage(enemigo1);
		} else if (enemigo.getNombre().equalsIgnoreCase("Delincuente")) {
			imagenEnemigo.setImage(enemigo2);
		} else if (enemigo.getNombre().equalsIgnoreCase("Espectro")) {
			imagenEnemigo.setImage(enemigo3);
		}
	}

}
