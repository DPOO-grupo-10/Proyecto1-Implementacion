package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Recepcion {
	
	
	public HashMap<String,Habitacion> consultarHabitaciones(DatosHotel informacion){
		HashMap<String,Habitacion> habitaciones = informacion.getHabitaciones();
		return habitaciones;
		
	}
	
	
	public Reserva crearReserva( String titular ,String fechai, String fechaf) {
		GrupoHuespedes grupo = new GrupoHuespedes();
		ArrayList<Huesped> huespedes = grupo.getHuespedes();
		Reserva reserva = new Reserva(titular,fechaf, fechai,huespedes);
		return reserva;
	}
	
	public String cerrarReserva(Reserva reserva) {
		String factura =  reserva.getFactura();
		return factura;
		
	}

}
