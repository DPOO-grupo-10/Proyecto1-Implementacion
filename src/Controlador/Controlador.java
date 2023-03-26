package Controlador;

import Modelo.Recepcion;
import Modelo.Reserva;

import java.util.HashMap;

import Modelo.DatosHotel;

public class Controlador {
	
	
	
	
	DatosHotel informacionHotel = new DatosHotel();
	
	public void agregarHabitacionesUnaPorUna(String identificador) {
		
		informacionHotel.setHabitaciones(null, null);
		
		
	}
	
	public void crearReserva(String titu,String fechaf,String fechai) {
		
		Recepcion recepcion = new Recepcion();
		
		recepcion.crearReserva(titu,fechaf,fechai);
		
	}
	
	
	public Reserva consultarReservas(String titular,DatosHotel info) {
		HashMap<String,Reserva> mapa = info.getReservas();
		Reserva res =  mapa.get(titular);
		return res;
		
	}
}

