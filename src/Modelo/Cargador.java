package Modelo;


import java.util.ArrayList;
import java.util.Scanner;

public class Cargador {
	
	
	public void cargarHabitaciones(DatosHotel info,Habitacion habitacion ) {
		Boolean haycamas = true;
		
		System.out.println("A CONTINUACION SE AGREGARAN LAS CAMAS DE LA HABITACION : ");
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Cama> camas = new ArrayList<Cama>();
		while (haycamas==true) {
			
			System.out.println("Ingrese el tipo de cama: ");
			System.out.println("1. NIÑOS ");
			System.out.println("2. SENCILLA ");
			System.out.println("3. DOBLE ");
			
			String opciontipocama = scan.nextLine();
			
			// tipo cama
			String tipocama ="" ;
			if(opciontipocama == "1") {
				tipocama = "NIÑOS";
				
			}
			if(opciontipocama == "2") {
				tipocama = "SENCILLA";
				
			}
			if(opciontipocama == "3") {
				tipocama = "DOBLE";
				
			}
			System.out.println("Ingrese la capacidad de personas en la cama: ");
			
			int capacidad = scan.nextInt();
			
			
			habitacion.setCamas(tipocama, capacidad);
			
			
			System.out.println("Desea agregar mas camas ? ");
			System.out.println("1. Si");
			System.out.println("2. No");
			String desea = scan.nextLine();
			if(desea == "2") {
				haycamas = false;
			}			
		}
		
		
		String identificador = habitacion.getIdentificador();
		info.setHabitaciones(identificador, habitacion);
	}
	
	public void cargarServicios(DatosHotel info, Servicio serv, int costo) {
		String tipoServicio = serv.getTipoServicio();
		info.setServicios(tipoServicio, costo , serv);
	}
	
	
	
	public void cargarRestaurante(String tipo, String nombre, int costo , Restaurante res) {
		if (tipo == "PLATO") {
			res.setPlato(nombre,costo);	
			
		}
		else if(tipo == "BEBIDA") {
			res.setBebida(nombre, costo);
		}
	}

}
