package Controlador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import Modelo.Recepcion;

import Modelo.ConsumoRestaurante;
import Modelo.Reserva;
import Modelo.Bebida;
import Modelo.Cargador;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.Plato;
import Modelo.Servicio;
import Modelo.TipoHabitacion;
import Modelo.Restaurante;
import Modelo.Consumo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import Modelo.DatosHotel;

public class Controlador implements Serializable {
	
	

	
	DatosHotel informacionHotel = new DatosHotel();
	Recepcion recepcion = new Recepcion();
	Cargador cargador = new Cargador();
	Restaurante restaurante = new Restaurante();
	
	
	
	
	
	
	public void agregarHabitaciones(TipoHabitacion tipo, Boolean balcon, Boolean vista, Boolean cocina) {
		Habitacion habitacion = new Habitacion(tipo,balcon,vista,cocina);
		
		
		cargador.cargarHabitaciones(informacionHotel, habitacion);	
		
	}
	
	
	public void agregarHabitacionPorArchivo(String ruta) {
		
		File archivo = new File(ruta);
	
		try {
			
			
			Scanner scan = new Scanner(archivo);
			while(scan.hasNextLine()) {
				String linea = scan.nextLine();
				String[] listaLinea = linea.split(",");
				ArrayList<String> list = new ArrayList<String>(Arrays.asList(listaLinea));
				String nombreTipoHabitacion = listaLinea[0];
				TipoHabitacion tipoHabitacion = null;
				if (nombreTipoHabitacion.equals("ESTANDAR")) {
				    tipoHabitacion = new TipoHabitacion("ESTANDAR");
				} else if (nombreTipoHabitacion.equals("SUITE")) {
				    tipoHabitacion = new TipoHabitacion("SUITE");
				} else if (nombreTipoHabitacion.equals("SUITE_DOBLE")) {
				    tipoHabitacion = new TipoHabitacion("SUITE_DOBLE");
				}
				String tieneBalcon = list.get(1);
				Boolean balcon = false;
				if(tieneBalcon.equals("SI")) {
					balcon = true;
				}
				String tieneVista = list.get(2);
				Boolean vista = false;
				if(tieneVista.equals("SI")) {
					vista = true;
				}
				String tieneCocina = list.get(3);
				Boolean cocina = false;
				if(tieneCocina.equals("SI")) {
					cocina = true;
				}
				
				Habitacion habitacion = new Habitacion(tipoHabitacion, balcon, vista, cocina);
				cargador.cargarHabitaciones(informacionHotel, habitacion);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarServicios(String tipoServicio,String disponibilidad,int costo ) {
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
		
		
		if(modulo1 > 0) {
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
		if(modulo2 > 0) {
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
		if(modulo3 > 0) {
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
		if(modulo4 > 0) {
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
		String factura = "";
		
		if(res == null) {
			System.out.println("EL NOMBRE DEL TITULAR NO COINCIDE CON NINGUNA RESERVA EN LA BASE DE DATOS");
		}
		else {
		
		
		factura = recepcion.cerrarReserva(res);
		
		mapareservas.remove(titu);
		
		}
		
		return factura;
		
	
		
	}
	
	
	public void consultarReservas(String titular) {
		HashMap<String,Reserva> mapa = informacionHotel.getReservas();
		Reserva res =  mapa.get(titular);
		
		if(res == null) {System.out.println("Lo sentimos no se encuentra ninguna reserva a este nombre \n");}
		else {
		System.out.println("Titular : " + res.getTitular());
		System.out.println("Fecha Salida: " + res.getFechaSalida());
		System.out.println("Fecha Entrada: " + res.getFechaEntrada());
		
		ArrayList<Huesped> huespedes = res.getHuespedes();
		
		System.out.println("HUESPEDES");
		for(Huesped huesped: huespedes) {
			System.out.println("Huesped : " + huesped.getnombre());
		}
		ArrayList<Habitacion> habitaciones = res.getHabitaciones();
		System.out.println("HABITACIONES");
		for(Habitacion habitacion: habitaciones) {
			System.out.println("Identificador habitacion : " + habitacion.getIdentificador());
		}
		
		}
		
		
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
	
	
	
	
	public void setConsumoRestauranteTotal(String id, String agregar, String platos, String bebidas) {
		HashMap<String,Habitacion> listahabitaciones =  informacionHotel.getHabitaciones();
		Habitacion habitacion =  listahabitaciones.get(id);
		// mirar si se pago en caja o se agrega a la habitacion
		Boolean estaPago = false;
		if(agregar.equals("2")) {
			estaPago = true;
		}
		
		// creacion consumo
		ConsumoRestaurante conRes = new ConsumoRestaurante(id,estaPago);
		
		// si desea o no agregar platos a la cuenta de consumo
		ArrayList<Plato> listaplatos  =  new ArrayList<Plato>();
		if(platos.equals("1")) {
			listaplatos = setListaPlato();	
		}
		
		// si desea o no agregar bebidas a la cuenta de consumo
		
		ArrayList<Bebida> listabebidas =  new ArrayList<Bebida>();
		if(bebidas.equals("2")) {
			listabebidas = setListaBebidas();
		}
		
		
		conRes.setBebidasConsumidas(listabebidas);
		conRes.setPlatosConsumidos(listaplatos);
		
		habitacion.setConsumos(conRes);
		informacionHotel.setHabitaciones(id, habitacion);
		
	}
	
	
	
	
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
	
	
	public ArrayList<Bebida>  setListaBebidas() {
		
		Scanner scan = new Scanner(System.in);
		
		HashMap<String,Integer> mapa = informacionHotel.getBebidasRestaurante();		
		ArrayList<Bebida> listabebidas  = new ArrayList<Bebida>();
		Boolean sigue =true;
		while(sigue==true) {
			System.out.println("Ingrese el nombre de la bebida: ");
			String nombre  = scan.nextLine();
			Integer costo = mapa.get(nombre);
			if(costo == null) {
				System.out.println("Lo sentimos pero el nombre que ingreso no combina con ninguna bebida en a base de datos: ");
				System.out.println("Por favor revise que lo este ingresando en mayusculas y sin espacios ni demas caracteres");
			}
			else {
				Bebida bebida = new Bebida(costo,nombre);
				listabebidas.add(bebida);
			}
			
			System.out.println("Desea continuar agregando bebidas ?? ");
			System.out.println("1. Si");
			System.out.println("2. No");
			
			String opcion  = scan.nextLine(); 
			
			if(opcion.equals("2")) {
				sigue = false;
			}
			
		}
		return listabebidas;
		 
		 
		 
	}



	// Se va a mirar y ver si el consumo existe y si se entonces lo agregamos a lo de la habitacion y ya 
	public void setConsumoGeneral(String id,String nombre, String agregar) {
		HashMap<String,Habitacion> listahabitaciones =  informacionHotel.getHabitaciones();
		Habitacion habitacion =  listahabitaciones.get(id);
		HashMap<String,Integer> mapaservicios = informacionHotel.getServicioscostos();
		
		if (mapaservicios.containsKey(nombre) == false) {
			System.out.println(" Lo sentimos pero el servicio que desea agregar no esta en la base de datos");
			System.out.println("Por favor revise detalladamente como ingreso el nombre del servicio");
			
		}
		else {
			
			Boolean siagrega = false;
			if(agregar.equals("1")) {siagrega =true;}
			
			
			int costo = mapaservicios.get(nombre);
			Consumo consumo = new Consumo(id,nombre,costo,siagrega);
			
			
			habitacion.setConsumos(consumo);
			informacionHotel.setHabitaciones(id, habitacion);
		}
		
	}


	
	

	
	
	
	
	
	
	
	
	
	
}
