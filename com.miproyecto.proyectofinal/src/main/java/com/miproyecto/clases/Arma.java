package com.miproyecto.clases;

public enum Arma {

	ES("Espada", "te curas 1 más", 8.), AR("Arco", "tienes 2 más de vida máxima", 4.),
	PI("Pistola", "cuando pruebes suerte, en vez de que te toque 1 euro puedes aumentar tu ataque en 1", 6.),
	HA("Hacha", "cuando ataques puedes realizar críticos del doble", 5.),
	SA("Sartén", "los enemigos tienen 25% menos de vida máxima", 2.),
	MA("Machete", "si pruebas suerte y aumentas tu ataque éste aumentará 1 más", 7.);

	private String nombre, habilidad;
	private double daño;

	private Arma(String nombre, String habilidad, double daño) {
		this.nombre = nombre;
		this.habilidad = habilidad;
		this.daño = daño;
	}

	public String getNombre() {
		return nombre;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public double getDaño() {
		return daño;
	}

}
