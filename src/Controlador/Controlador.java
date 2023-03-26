package Controlador;

import Modelo.Recepcion;
import Modelo.Reserva;
import Modelo.Cargador;
import Modelo.Habitacion;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;


import Modelo.DatosHotel;

public class Controlador {
	
	
	
	
	DatosHotel informacionHotel = new DatosHotel();
	Recepcion recepcion = new Recepcion();
	
	public void agregarinformacion(String tipodeinformacion) {
		
		// 1 = habitaciones 2 = servicios 3 =  personal del hotel
		
		Cargador cargador = new Cargador();
		Scanner scan = new Scanner(System.in);
		
		if(tipodeinformacion == "1") {
			System.out.println("Ingrese el tipo de Habitacion: ");
			System.out.println("1. ESTANDAR ");
			System.out.println("2. SUITE ");
			System.out.println("3. SUITE DOUBLE ");
			
			String opciontipo = scan.nextLine();
			
			// tipo habitacion
			String tipo = "" ;
			if(opciontipo == "1") {
				tipo = "ESTANDAR";
				
			}
			if(opciontipo == "2") {
				tipo = "SUITE";
				
			}
			if(opciontipo == "3") {
				tipo = "SUITE DOUBLE";
				
			}
			
			System.out.println("¿ La habitacion tiene Balcon ?: ");
			System.out.println("1. SI ");
			System.out.println("2. NO ");
			
			String opcionbalcon = scan.nextLine();
			
			
			// tiene balcon?
			Boolean balcon = false;
			
			if(opcionbalcon == "1") {
				balcon = true;
				
			}
			if(opcionbalcon == "2") {
				balcon = false;
				
			}
			
			
			System.out.println("¿ La habitacion tiene vista ?: ");
			System.out.println("1. SI ");
			System.out.println("2. NO ");
			
			String opcionvista = scan.nextLine();
			
			
			// tiene vista??
			Boolean vista = false;
			
			if(opcionvista == "1") {
				vista = true;
				
			}
			if(opcionvista == "2") {
				vista = false;
				
			}
			
			
			
			
			System.out.println("¿ La habitacion tiene Balcon ?: ");
			System.out.println("1. SI ");
			System.out.println("2. NO ");
			
			String opcioncocina = scan.nextLine();
			// tiene cocina ???
			Boolean cocina = false;
			
			if(opcioncocina == "1") {
				cocina = true;
				
			}
			if(opcioncocina == "2") {
				cocina = false;
				
			}
			
			
			Habitacion habitacion = new Habitacion(tipo,balcon,vista,cocina);
			
			
			cargador.cargarHabitaciones(informacionHotel, habitacion);	
			
		}
		// SERVICIOS
		if(tipodeinformacion == "2") {}
		
		
		
		
		
		
	}
	
	public void crearReserva(String titu,String fechaf,String fechai) {
		
		Reserva res = recepcion.crearReserva(titu,fechaf,fechai);
		
		informacionHotel.setReserva(titu, res);
		
	}
	
	public String cerrarReserva(String titu) {
		HashMap<String,Reserva> mapareservas = informacionHotel.getReservas();
		Reserva res = mapareservas.get(titu);
		
		
		String factura = recepcion.cerrarReserva(res);
		
		mapareservas.remove(titu);
		
		
		
		return factura;
		
	
		
	}
	
	
	public Reserva consultarReservas(String titular,DatosHotel info) {
		HashMap<String,Reserva> mapa = info.getReservas();
		Reserva res =  mapa.get(titular);
		return res;
		
	}
}
