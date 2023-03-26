package Modelo;

import java.lang.Math;

public class Habitacion {
	
	private String  tipoHabitacion;
	private String identificador;
	private String tipoCama;
	private int capacidadPersonas;
	private Boolean ocupada;
	
	
	
	public Habitacion(String th,String tipocama,int capapers) {
		this.tipoCama = tipocama;
		this.tipoHabitacion = th;
		this.identificador =Double.toString(Math.random());
		this.ocupada = false;
		this.capacidadPersonas = capapers;
		
	}
	
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}
	public String getIdentificador() {
		return identificador;
	}
	public String gettipoCama() {
		return tipoCama;
	}
	public int getCapacidadPersonas() {
		return capacidadPersonas;
	}
	public Boolean getocupada() {
		return ocupada;
	}

}
