package interfaz;
import java.util.Scanner;
import Controlador.Controlador;

public class Programa {
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("************************* HOTEL GRAN DPOO******************");
		System.out.println("************************* BIENVENIDO******************");
		
		Scanner scan  = new Scanner(System.in);
		
		System.out.println("1. CLIENTE ");
		System.out.println("2. PERSONAL DEL HOTEL ");
		
		String navegante = scan.nextLine();
		
		
		// comunicacion con el controlador**************
		Controlador controlador = new Controlador();
		
		if (navegante == "1") {
			
			
			
			System.out.println("Elija la opcion que desea utilizar: ");
			System.out.println("1. Consultar Reserva ");
			
			String opcion = scan.nextLine();
			if(opcion == "1") {
				System.out.println("Ingrese el nombre del titular de su cuenta");
				String titularReserva = scan.nextLine();
				System.out.println("Ingrese La fecha en la que desea inicia su estadia");
				String fechaInicial = scan.nextLine();
				System.out.println("Ingrese la fecha en la cual termina su estadia");
				String fechaFinal = scan.nextLine();
				
				controlador.crearReserva(titularReserva, fechaInicial, fechaFinal);
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		if(navegante == "2") {
			
			
			
			
			Boolean autorizado = false;
			String usuario ="";
			
			// comunicacion con el autenticador***************************************
			Autenticador autenticador = new Autenticador();
			while(autorizado == false) {
				System.out.println(" Ingrese su usuario : ");
				usuario = scan.nextLine();
				System.out.println(" Ingrese su contraseña : ");
				String contraseña = scan.nextLine();
				Boolean estaEnSistema = autenticador.autenticar(usuario, contraseña);
				if (estaEnSistema == true) {
					autorizado = true;
				}
			
			}
			
			
			if(autenticador.getTipo(usuario) == "ADMINISTRADOR") {
				System.out.println("++++++++++ BIENVENIDO ++++++++ ");
				System.out.println("++++++++ ADMINISTRADOR ++++++++ ");
				System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES SEGUN LO QUE QUIERA REALIZAR: ");
				System.out.println("1. Agregar habitaciones ");
				System.out.println("2. Agregar servicios ");
				System.out.println("3. Agregar Personal del hotel ");
				
				
				String opcionAdmin = scan.nextLine();
				
				controlador.agregarinformacion(opcionAdmin);
				
				
				
				
				
					
					
					
				}
				
				
				
			
			
			
			if(autenticador.getTipo(usuario) == "RECEPCIONISTA") {
				System.out.println("++++++++++ BIENVENIDO ++++++++ ");
				System.out.println("++++++++++ A RECEPCION ++++++++ ");
				System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES SEGUN LO QUE QUIERA REALIZAR: ");
				System.out.println("1. Crear Reserva  ");
				System.out.println("2. Cerrar Reserva ");
				
				String opcionRecepcion = scan.nextLine();
				
				
				if(opcionRecepcion == "1") {
					
					
					System.out.println("Ingrese el nombre del titular de su cuenta");
					String titularReserva = scan.nextLine();
					System.out.println("Ingrese La fecha en la que desea inicia su estadia");
					String fechaInicial = scan.nextLine();
					System.out.println("Ingrese la fecha en la cual termina su estadia");
					String fechaFinal = scan.nextLine();
					
					controlador.crearReserva(titularReserva, fechaInicial, fechaFinal);
					
					
				}
				
				
				
				
				
			}
			
			if(autenticador.getTipo(usuario) == "PERSONAL DEL HOTEL") {
				System.out.println("++++++++++ BIENVENIDO ++++++++ ");
				System.out.println("+++++++++++ PERSONAL ++++++++ ");
				System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES SEGUN LO QUE QUIERA REALIZAR: ");
				System.out.println("1. Asignar servicio a una reserva:  ");
				
				
				
			}
		}
			
			
			
			
			
			
			
			
			// Ahora se mira que tipo de usuario es y se le asignan funciones segun lo que sea
		}
		
		
	}
	


