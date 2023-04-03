package Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Reserva {
	
	
	private String titular;
	private String fechaSalida;
	private String fechaEntrada;
	private ArrayList<Huesped> huespedes;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Factura> facturas;
	private int costo;
	
	
	
	public Reserva(String titu,String fechasalida,String fechaentrada,ArrayList<Huesped> hes, ArrayList<Habitacion> habitaciones){
		this.titular = titu;
		this.fechaEntrada = fechaentrada;
		this.fechaSalida = fechasalida;
		this.habitaciones = habitaciones;
		this.huespedes = hes;
		this.facturas = new ArrayList<Factura>();
	}
	
	public void setHabitaciones(Habitacion ha) {
		habitaciones.add( ha);
	}
	
	
	public String getTitular() {
		return titular;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public ArrayList<Huesped> getHuespedes() {
		return huespedes;
	}
	public ArrayList<Habitacion> getHabitaciones(){
		return habitaciones;
	}
	public ArrayList<Factura> getFactura(){
		return facturas;
	}
	
	public void setFacturas(Factura fac) {
		facturas.add(fac);
	}


	
	
	
	
	
}
