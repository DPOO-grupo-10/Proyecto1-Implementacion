package Controlador;

import Modelo.Recepcion;
import Modelo.Reserva;
import Modelo.Cargador;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.Plato;
import Modelo.Servicio;
import Modelo.Restaurante;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;


import Modelo.DatosHotel;

public class Controlador {
	
	

	
	DatosHotel informacionHotel = new DatosHotel();
	Recepcion recepcion = new Recepcion();
	Cargador cargador = new Cargador();
	Restaurante restaurante = new Restaurante();
	
	
	
	
	
	
	public void agregarHabitaciones(String tipo, Boolean balcon, Boolean vista, Boolean cocina) {
		Habitacion habitacion = new Habitacion(tipo,balcon,vista,cocina);
		
		
		cargador.cargarHabitaciones(informacionHotel, habitacion);	
		
	}
	
	public void agreagrServicios(String tipoServicio,String disponibilidad,int costo ) {
		Servicio servicio = new Servicio(tipoServicio,disponibilidad);
		cargador.cargarServicios(informacionHotel, servicio,costo);
		
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
	// agregar platos 
	
	
	public void setPlatosRestaurante(String nombre, int costo) {
		String tiposervicio = "PLATO";
		cargador.cargarRestaurante(tiposervicio, nombre, costo, restaurante);
		informacionHotel.setbebidasRestaurante(nombre, costo);
		
	}
	
	
	
	// agregar bebidas
	
	
	public void setBebidasrestaurante(String nombre, int costo) {
		String tiposervicio = "BEBIDA";
		cargador.cargarRestaurante(tiposervicio, nombre, costo, restaurante);
		informacionHotel.setbebidasRestaurante(nombre, costo);
		
	}
	
	
	
	// AGREGAR CONSUMO DEL RESTAURANTE
	
	
	public ArrayList<Plato>  setListaPlato() {
		
		Scanner scan = new Scanner(System.in);
		
		HashMap<String,Integer> mapa = informacionHotel.getPlatosRestaurante();		
		ArrayList<Plato> listaPlatos  = new ArrayList<Plato>();
		Boolean sigue =true;
		while(sigue==true) {
			System.out.println("Ingrese el nombre del plato: ");
			String nombre  = scan.nextLine();
			Integer costo = mapa.get(nombre);
			if(costo == null) {
				System.out.println("Lo sentimos pero el nombre que ingreso no combina con ningun plato en a base de datos: ");
				System.out.println("Porfacor revise que lo este ingresando en mayusculas y sinespacios ni demas caracteres");
			}
			else {
				Plato plato = new Plato(costo,nombre);
				listaPlatos.add(plato);
			}
			
			System.out.println("Desea continuar agregando platos ?? ");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			String opcion  = scan.nextLine(); 
			
			if(opcion.equals("2")) {
				sigue = false;
			}
			
		}
		return listaPlatos;
		 
		 
		 
	}
	public void setConsumoBebida() {}
	
	
	
	
	
	
}
