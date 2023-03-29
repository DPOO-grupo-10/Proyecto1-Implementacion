package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Recepcion {
	
	
	public HashMap<String,Habitacion> consultarHabitaciones(DatosHotel informacion){
		HashMap<String,Habitacion> habitaciones = informacion.getHabitaciones();
		return habitaciones;
		
	}
	
	
	public Reserva crearReserva( String titular ,String fechai, String fechaf, ArrayList<Habitacion> habitaciones) {
		GrupoHuespedes grupo = new GrupoHuespedes();
		ArrayList<Huesped> huespedes = grupo.getHuespedes();
		Reserva reserva = new Reserva(titular,fechaf, fechai,huespedes,habitaciones);
		
		return reserva;
	}
	
	public String cerrarReserva(Reserva reserva) {
		String factura =  generarFacturaTotalReserva(reserva);
		return factura;
		
	}
	
	
	private String generarFacturaTotalReserva(Reserva res) {
		String factura = "INICIO FACTURA" + "\n";
		factura = factura + "COSTO HABITACIONES";
		ArrayList<Habitacion> habitaciones = res.getHabitaciones();
		
		
		for(Habitacion hab : habitaciones) {
			String idhab = hab.getIdentificador();
			String total =  Integer.toString(hab.gettarifa());
			
			factura  =  factura + idhab + " : " + total + "\n";
			
		}
		
		
		
		
		
		
		
		
		ArrayList<Factura> listafacturas = res.getFactura();
		factura = factura + "COSTO SERVICIOS ADQUIRIDOS" + "\n";
		
		for( Factura unafactura: listafacturas) {
			String tipoServicio  = unafactura.gettipoConsumo();
			String idHabitacion = unafactura.getidHabitacion();
			String costo = Integer.toString(unafactura.getcosto());
			Boolean pagado = unafactura.getpagado();
			String estapagado;
			String fecha = unafactura.getFecha();
			if(pagado == true) {estapagado = "Si";}
			else {estapagado = "No";}
			
			
			factura = factura + fecha + "\n" + tipoServicio  + " : " + costo + "\n" + "Habitacion: " + idHabitacion+ "\n" +"Esta pago: " + estapagado + "\n"  ;
			
			
		}
		
		
		return factura;
		
	}

}
