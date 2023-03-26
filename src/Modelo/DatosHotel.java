package Modelo;

import java.util.HashMap;

public class DatosHotel {
	
	
	private HashMap<String,Habitacion> habitaciones  = new HashMap<String,Habitacion>();
	private HashMap<String,Servicio> servicios  = new HashMap<String,Servicio>();
	private HashMap<String,Reserva> reservas = new HashMap<String,Reserva>();

	
	
	
	
	public HashMap<String,Habitacion> getHabitaciones(){
		return habitaciones;
	}
	public HashMap<String, Servicio> getServicios(){
		return servicios;
	}
	public HashMap<String, Reserva> getReservas(){
		return reservas;
	}
}
