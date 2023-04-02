package Modelo;

import java.lang.Math;
import java.util.ArrayList;

public class Habitacion {
	private String identificador;
	// SOLO TRES TIPOS : ESTANDAR, SUITE Y SUITE DOUBLE
	private String  tipoHabitacion;
	private Boolean balcon;
	private Boolean vista;
	private Boolean cocina;
	private ArrayList<Cama> camas;
	private ArrayList<Consumo> consumos;
	private int capacidadPersonas;
	private Boolean ocupada;
	private int tarifa;
	
	
	
	public Habitacion(String tipo, Boolean balcon2,Boolean vista2, Boolean cocina2) {
		this.identificador =Double.toString(Math.random());
		this.tipoHabitacion = tipo;
		this.balcon = balcon2;
		this.vista = vista2;
		this.cocina = cocina2;
		this.camas = new ArrayList<Cama>();
		this.consumos = new ArrayList<Consumo>();
		this.capacidadPersonas = 0;
		this.ocupada = false;
		
	}
	
	

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}
	public String getIdentificador() {
		return identificador;
	}
	public ArrayList<Cama> gettipoCama() {
		return camas;
	}
	public int getCapacidadPersonas() {
		return capacidadPersonas;
	}
	public Boolean getocupada() {
		return ocupada;
	}
	public Boolean getbalcon() {
		return balcon;
	}
	public Boolean getvista() {
		return vista;
	}
	public Boolean getcocina() {
		return cocina;
	}
	
	public int gettarifa() {
		return tarifa;
	}
	
	
	public ArrayList<Consumo> getConsumos(){
		return consumos;
	}

	public void setCamas(String tipocama,int capacidad) {
		Cama cama = new Cama(tipocama,capacidad);
		camas.add(cama);
	}
	
	public void setConsumos(Consumo consum) {
		consumos.add(consum);
	}
	
	
	// este calculo se hace al inicializar las camas 
	//y se cuentan la capacidad de las camas para asi 
	//dar la cantidad de personas en cada habitacion
	
	public void setCapacidadPersonas() {
		int count = 0;
		for (Cama unacama:camas ) {
			count = count + unacama.getocupacion();
		}
		
		this.capacidadPersonas = count;
		
	}
	
	

}
