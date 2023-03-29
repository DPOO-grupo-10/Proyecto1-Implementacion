package Controlador;

import Modelo.Recepcion;
import Modelo.Reserva;
import Modelo.Cargador;
import Modelo.Habitacion;
import Modelo.Huesped;

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
	
	public void crearReserva(String titu,String fechaf,String fechai, int cantidadhuespedes) {
		
		
		
		// la maxima capacidad de una habitacion son 5 personas y asi va bajando hasta 2
		
		int modulo1 = cantidadhuespedes /5;
		cantidadhuespedes = cantidadhuespedes -(modulo1 * 5);
		int modulo2 = cantidadhuespedes /4;
		cantidadhuespedes = cantidadhuespedes -(modulo1 * 3);
		int modulo3 = cantidadhuespedes /3;
		cantidadhuespedes = cantidadhuespedes -(modulo1 * 2);
		int modulo4 = cantidadhuespedes /2;
		
		HashMap<Integer,ArrayList<Habitacion>> maphabit = informacionHotel.getHabitacionesPorTipo();
		ArrayList<Habitacion> listatotal = new ArrayList<Habitacion>();
		
		
		if(modulo1 != 0) {
			ArrayList<Habitacion> listahab = maphabit.get(modulo1);
			int size = listahab.size();
			if (size > modulo1) {
			for(int i =0;i<modulo1;i++) {
				Habitacion habitacion = listahab.get(0);
				
				listatotal.add(habitacion);
				listahab.remove(0);
				informacionHotel.sethabitacionocupada(habitacion);
				}
			informacionHotel.sethabitacionesmapa(modulo1, listahab);
			}
		}
		if(modulo2 != 0) {
			ArrayList<Habitacion> listahab = maphabit.get(modulo2);
			int size = listahab.size();
			if (size > modulo2) {
			for(int i =0;i<modulo2;i++) {
				Habitacion habitacion = listahab.get(0);
				listatotal.add(habitacion);
				listahab.remove(0);
				informacionHotel.sethabitacionocupada(habitacion);
				}
			informacionHotel.sethabitacionesmapa(modulo2, listahab);
			}
		}
		if(modulo3 != 0) {
			ArrayList<Habitacion> listahab = maphabit.get(modulo3);
			int size = listahab.size();
			if (size > modulo3) {
			for(int i =0;i<modulo3;i++) {
				Habitacion habitacion = listahab.get(0);
				listatotal.add(habitacion);
				listahab.remove(0);
				informacionHotel.sethabitacionocupada(habitacion);
				}
			informacionHotel.sethabitacionesmapa(modulo3, listahab);
			}
		}
		if(modulo4 != 0) {
			ArrayList<Habitacion> listahab = maphabit.get(modulo4);
			int size = listahab.size();
			if (size > modulo4) {
			for(int i =0;i<modulo4;i++) {
				Habitacion habitacion = listahab.get(0);
				listatotal.add(habitacion);
				listahab.remove(0);
				informacionHotel.sethabitacionocupada(habitacion);
				}
			informacionHotel.sethabitacionesmapa(modulo4, listahab);
			}
		}
		
		
		Reserva res = recepcion.crearReserva(titu,fechaf,fechai,listatotal);
		
	
		
		
		informacionHotel.setReserva(titu, res);
		
	}
	
	
	
	
	public String cerrarReserva(String titu) {
		HashMap<String,Reserva> mapareservas = informacionHotel.getReservas();
		Reserva res = mapareservas.get(titu);
		
		
		String factura = recepcion.cerrarReserva(res);
		
		mapareservas.remove(titu);
		
		
		
		return factura;
		
	
		
	}
	
	
	public Reserva consultarReservas(String titular) {
		HashMap<String,Reserva> mapa = informacionHotel.getReservas();
		Reserva res =  mapa.get(titular);
		return res;
		
	}
	
	
}
