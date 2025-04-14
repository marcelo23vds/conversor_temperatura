package br.dev.marcelo.conversor_temperatura.model;

public class Temperatura {
	
	private double celsius;

	
	//getters e setters
	public double getCelsius() {
		return celsius;
	}
	
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	
	
//	logica para converter celsius em kelvin
	public double converterParaKelvin() {
		double kelvin = celsius + 273.15;
		return kelvin;
	}
	
//	logica para converter celsius em fahreinheit
	public double converterParaFahreinheit() {
		double fahreinheit = (celsius * 1.8) + 32;
		return fahreinheit;
	}
	
}
