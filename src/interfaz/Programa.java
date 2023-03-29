package interfaz;
import java.util.ArrayList;
import java.util.Scanner;
import Controlador.Controlador;
import Modelo.Habitacion;
import Modelo.Reserva;

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
				System.out.println("Ingrese el nombre del titular de la cuenta: ");
				String titu = scan.nextLine();
				
				Reserva res = controlador.consultarReservas(titu);
				// hacemos una forma de que las reservas se vean de forma bonita :)
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
				
				if (opcionAdmin == "3") {
					System.out.println("Ingrese el nombre de la persona: ");
					String nombre = scan.nextLine();
					System.out.println("Ingrese el usuario asignado a esta persona: ");
					String usuariopersonal = scan.nextLine();
					System.out.println("Ingrese la contraseña asignada a esta persona:  ");
					String cotraseña = scan.nextLine();
					System.out.println("Ingrese el tipo de personal que es:");
					System.out.println("1. PERSONAL GENERAL");
					System.out.println("2. RECEPCIONISTA");
					
					
					String opcionpersonal = scan.nextLine();
					String tipop="" ;
					if(opcionpersonal == "1") {
						tipop = "PERSONAL DEL HOTEL";
					}
					if (opcionpersonal == "2") {
						tipop = "RECEPCIONISTA";
					}
					
					autenticador.setPersonaldelHotel(nombre, usuariopersonal, cotraseña);
					autenticador.setUsuarios(usuariopersonal, cotraseña, tipop);
					
				}
				else {
				controlador.agregarinformacion(opcionAdmin);
				}
				
				
				
				
					
					
					
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
					
					System.out.println("Ingrese la cantidad de personas que se van a hospedar: ");
					
					int cantidad = scan.nextInt();
					
					controlador.crearReserva(titularReserva, fechaInicial, fechaFinal,cantidad);	
					
				}
				
				if(opcionRecepcion =="2") {
					System.out.println("Ingrese el nombre del titular: ");
					System.out.println("(La persona a la cual esta asignada la reserva)");
					String nombretitu = scan.nextLine();
					String factura = controlador.cerrarReserva(nombretitu);
					System.out.println("A continuacion se muestra la factura de la reserva: ");
					System.out.println(factura);
					
				}
				
				
				
				
				
			}
			
			if(autenticador.getTipo(usuario) == "PERSONAL DEL HOTEL") {
				System.out.println("++++++++++ BIENVENIDO ++++++++ ");
				System.out.println("+++++++++++ PERSONAL ++++++++ ");
				System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES SEGUN LO QUE QUIERA REALIZAR: ");
				System.out.println("1. Asignar consumo a una habitacion:  ");
				
				
				String opcionServicio = scan.nextLine();
				
				
				if (opcionServicio == "1") {
					
					
				}
				
				
				
			}
		}
			
			
			
			
			
			
			
			
			
		}
		
		
	}
	

