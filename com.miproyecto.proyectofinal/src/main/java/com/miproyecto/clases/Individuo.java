package com.miproyecto.clases;

public class Individuo {

	private String nombre;
	private double pv, pvMax, atk;
	private Arma arma;

	public Individuo(String nombre, double pv, double pvMax, double atk) {
		this.nombre = nombre;
		this.pv = pv;
		this.pvMax = pvMax;
		this.atk = atk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPv() {
		return pv;
	}

	public void setPv(double pv) {
		this.pv = pv;
	}

	public double getPvMax() {
		return pvMax;
	}

	public void setPvMax(double pvMax) {
		this.pvMax = pvMax;
	}

	public double getAtk() {
		return atk;
	}

	public void setAtk(double atk) {
		this.atk = atk;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

}
