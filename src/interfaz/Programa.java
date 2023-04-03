package interfaz;

import java.util.Scanner;
import Controlador.Controlador;
import Modelo.DatosHotel;
import Modelo.TipoHabitacion;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Programa {
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("************************* HOTEL GRAN DPOO******************");
		System.out.println("************************* BIENVENIDO******************");
		
		Scanner scan  = new Scanner(System.in);
		
		System.out.println("1. CLIENTE ");
		System.out.println("2. PERSONAL DEL HOTEL ");
		
		int navegante = scan.nextInt();
		
		
		// comunicacion con el controlador**************
		Controlador controlador = new Controlador();
		
		
		if (navegante == 1) {
			Boolean sigueCliente = true;
			while(sigueCliente == true){
			
			System.out.println("*****CLIENTE****** ");
			System.out.println("Elija la opcion que desea utilizar: ");
			System.out.println("1. Consultar Reserva ");
			System.out.println("2. Salir de la aplicacion");
			Scanner scaner2 = new Scanner(System.in);
			int opcion = scaner2.nextInt();
			
			
			if(opcion == 1) {
				System.out.println("Ingrese el nombre del titular de la cuenta: ");
				Scanner scaner = new Scanner(System.in);
				String titu = scaner.nextLine();
				controlador.consultarReservas(titu);	
			}
			if(opcion ==2){
				sigueCliente = false;
			}
			
		}
			
			
		}
		
		
		
		
		
		
		
		
		// Si el usuario es personal del hotel debe tener usuario y contraseña por lo cual esto
		
		if(navegante == 2 ) {
			
			
			
			
			Boolean autorizado = false;
			String usuario ="";
			
			// comunicacion con el autenticador***************************************
			Autenticador autenticador = new Autenticador();
			while(autorizado == false) {
				System.out.println(" Ingrese su usuario : ");
				Scanner scaner3 = new Scanner(System.in);
				usuario = scaner3.nextLine();
				System.out.println(" Ingrese su contraseña : ");
				Scanner scaner4 = new Scanner(System.in);
				String contraseña = scaner4.nextLine();
				Boolean estaEnSistema = autenticador.autenticar(usuario, contraseña);
				if (estaEnSistema == true) {
					autorizado = true;
				}
				else{
					System.out.println("El usuario o la contraseña no estan correctos por favor digitelos nuevamente");
				}
			
			}
			
			
			
			
			// Si el usuario es administrador tiene tres tareas
			
			if(autenticador.getTipo(usuario).equals("ADMINISTRADOR")) {
				
				
				
				
				Boolean seguiradmin = true;
				
				
				while(seguiradmin == true) {
				System.out.println("++++++++++ BIENVENIDO ++++++++ ");
				System.out.println("++++++++ ADMINISTRADOR ++++++++ ");
				System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES SEGUN LO QUE QUIERA REALIZAR: ");
				System.out.println("1. Agregar habitaciones ");
				System.out.println("2. Agregar servicios ");
				System.out.println("3. Agregar Personal del hotel ");
				System.out.println("4. Salir Aplicacion ");
				
				Scanner scaner9 = new Scanner(System.in);
				int opcionAdmin = scaner9.nextInt();
				// Para cuando se desea agregar nuevo personal del hotel, el que lo tiene que hacer es el administrador
				if (opcionAdmin == 3) {
					System.out.println("Ingrese el nombre de la persona: ");
					Scanner scaner5 = new Scanner(System.in);
					String nombre = scaner5.nextLine();
					System.out.println("Ingrese el usuario asignado a esta persona: ");
					Scanner scaner6 = new Scanner(System.in);
					String usuariopersonal = scaner6.nextLine();
					System.out.println("Ingrese la contraseña asignada a esta persona:  ");
					Scanner scaner7 = new Scanner(System.in);
					String cotraseña = scaner7.nextLine();
					System.out.println("Ingrese el tipo de personal que es:");
					System.out.println("1. PERSONAL GENERAL");
					System.out.println("2. RECEPCIONISTA");
					
					Scanner scaner8 = new Scanner(System.in);
					String opcionpersonal = scaner8.nextLine();
					String tipop="" ;
					if(opcionpersonal == "1") {
						tipop = "PERSONAL DEL HOTEL";
					}
					if (opcionpersonal == "2") {
						tipop = "RECEPCIONISTA";
					}
					
					autenticador.setPersonaldelHotel(nombre, usuariopersonal, cotraseña);
					autenticador.setUsuarios(usuariopersonal, cotraseña, tipop);
					
					System.out.println("EL PERSONAL FUE ACTUALIZADO CON EXITO");
					
				}
				
				// Para cuando de desean agregar habitaciones 
				
				
				else if (opcionAdmin == 1) {
					
					System.out.println("De que forma desea ingresar las habitaciones: ");
					System.out.println("1. Por un archivo");
					System.out.println("2. Una por una ");
					Scanner scaner10 = new Scanner(System.in);
					String ingreso  =  scaner10.nextLine();
					
					if(ingreso.equals("1")) {
						
						
						System.out.println("Cada linea del archivo debe tener el siguiente formato: ");
						System.out.println("TIPO HABITACION, TIENE BALCON (SI/NO) ,TIENE VISTA (SI/NO),TIENE COCINA (SI/NO) ");
						System.out.println("Ingrese la ruta del archivo que desea ingresar: ");
						Scanner scaner11 = new Scanner(System.in);
						String rutaArchivo = scaner11.nextLine();
						controlador.agregarHabitacionPorArchivo(rutaArchivo);
						System.out.println("Se han agregado las habitaciones con exito");
						
					}
					else if (ingreso.equals("2")) {
						
						Boolean habitacionesseguir = true;
						
						while(habitacionesseguir) {
					
						System.out.println("Ingrese el tipo de Habitacion: ");
						System.out.println("1. ESTANDAR ");
						System.out.println("2. SUITE ");
						System.out.println("3. SUITE DOUBLE ");
						
						int opciontipo = scan.nextInt();
					
						// tipo habitacion
						
						TipoHabitacion tipoHabitacion = null;
						
						if(opciontipo == 1) {
						    tipoHabitacion = new TipoHabitacion("ESTANDAR");
						} else if(opciontipo == 2) {
						    tipoHabitacion = new TipoHabitacion("SUITE");
						} else if(opciontipo == 3) {
						    tipoHabitacion = new TipoHabitacion("SUITE DOUBLE");
						} else {
						    System.out.println("Opción inválida");
						}
						
					
						System.out.println("¿ La habitacion tiene Balcon ?: ");
						System.out.println("1. SI ");
						System.out.println("2. NO ");
					
						int opcionbalcon = scan.nextInt();
					
					
						// tiene balcon?
						Boolean balcon = false;
					
						if(opcionbalcon == 1 ) {
							balcon = true;
						
						}
						if(opcionbalcon == 2) {
							balcon = false;
						
						}
					
					
						System.out.println("¿ La habitacion tiene vista ?: ");
						System.out.println("1. SI ");
						System.out.println("2. NO ");
					
						int opcionvista = scan.nextInt();
					
					
						// tiene vista??
						Boolean vista = false;
						
						if(opcionvista== 1 ) {
							vista = true;
							
						}
						if(opcionvista== 2) {
							vista = false;
						
						}
					
					
					
					
						System.out.println("¿ La habitacion tiene cocina?: ");
						System.out.println("1. SI ");
						System.out.println("2. NO ");
					
						int opcioncocina = scan.nextInt();
						// tiene cocina ???
						Boolean cocina = false;
					
						if(opcioncocina == 1) {
							cocina = true;
						
						}
						if(opcioncocina==2) {
							cocina = false;
							
						}
					
					
					
						controlador.agregarHabitaciones(tipoHabitacion, balcon, vista, cocina);
						System.out.println("Se ha agregado la habitacion con exito: ");
						
						System.out.println("Desea agregar mas habitaciones? ");
						System.out.println("1. Si ");
						System.out.println("2. No");
						
						int mashabitacion = scan.nextInt();
						if(mashabitacion == 2) {habitacionesseguir = false; System.out.println("SE AGREGARON LAS HABITACIONES CON EXITO");}
						
						}
						
					
					}
					
				
				}
				
				
				
				
				// Para cuando el administrador desea cargar servicios incluidos e el hotel
				// por ejmplo si abren un spa o algo asi nos da el nombre del servicio y cuanto cuesta 
				
				// existe una opcion especifica que es para el RESTAURANTE que tiene otras funcionalidades mas especificas
				else if(opcionAdmin == 2){
					
					System.out.println("++++++++++++ CARGADOR DE SERVICIOS+++++++++++++++");
					System.out.println("Elija el servicio al cual desea cargar: ");
					System.out.println("1. RESTAURANTE");
					System.out.println("2. OTRO");
					
					
					Scanner scaner14 = new Scanner(System.in);
					String opcionServicios = scaner14.nextLine();
					
					// OPCION RESTAURANTE 
					if (opcionServicios.equals("1")) {
						System.out.println("Elija el cual opcion desea cargar: ");
						System.out.println("1. PLATO");
						System.out.println("2. BEBIDA");
						Scanner scaner15 = new Scanner(System.in);
						String opcionrestaurante = scaner15.nextLine();
						if(opcionrestaurante.equals("1")) {
							System.out.println("Ingrese el nombre del plato");
							Scanner scaner16 = new Scanner(System.in);
							String nombrePlato = scaner16.nextLine();
							System.out.println("Ingrese el costo del plato");
							Scanner scaner17 = new Scanner(System.in);
							int costoPlato = scaner17.nextInt();
							
							
							controlador.setPlatosRestaurante(nombrePlato, costoPlato);
							
							System.out.println("SE CARGARON LOS PLATOS CON EXITO");
						}
						if(opcionrestaurante.equals("2")) {
							System.out.println("Ingrese el nombre de la bebida");
							Scanner scaner18 = new Scanner(System.in);
							String nombreBebida = scaner18.nextLine();
							System.out.println("Ingrese el costo de la bebida");
							Scanner scaner19 = new Scanner(System.in);
							int costoBebida = scaner19.nextInt();
							
							
							
							controlador.setBebidasrestaurante(nombreBebida, costoBebida);
							System.out.println("SE CARGARON LAS BEBIDAS CON EXITO");
							
							
						}
						
						
						
						
						
						
					}
					// OPCION DIFERENTE DE RESTAURANTE 
					else if(opcionServicios.equals("2")) {
						System.out.println("Ingrese el tipo de servicio que desea agregar: ");
						Scanner scaner19 = new Scanner(System.in);
						String tiposervicio = scaner19.nextLine();
						System.out.println("Ingrese la disponibilidad de este servicio: : ");
						Scanner scaner20 = new Scanner(System.in);
						String dispo = scaner20.nextLine();
						System.out.println("Ingrese el costo de este servicio: ");
						Scanner scaner21 = new Scanner(System.in);
						int costo = scaner21.nextInt();
						controlador.agregarServicios(tiposervicio, dispo, costo);
						System.out.println("SE CARGO EL SERVICIO CON EXITO");
						
					}
					
				}
				
				else if(opcionAdmin == 4) {seguiradmin = false;}
					
				}
				}
				
				
				
			
			
			// Aca se pasa si el usuario es recepcionista por lo cual tiene otras funciones
			
			
			if(autenticador.getTipo(usuario) == "RECEPCIONISTA") {
				
				Boolean sigueRecepcion = true;
				
				
				while(sigueRecepcion == true) {
				
				System.out.println("++++++++++ BIENVENIDO ++++++++ ");
				System.out.println("++++++++++ A RECEPCION ++++++++ ");
				System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES SEGUN LO QUE QUIERA REALIZAR: ");
				System.out.println("1. Crear Reserva  ");
				System.out.println("2. Cerrar Reserva ");
				System.out.println("3. Salir de la aplicacion ");
				
				
				
				Scanner scaner22 = new Scanner(System.in);
				String opcionRecepcion = scaner22.nextLine();
				
				// CREAR RESERVA
				if(opcionRecepcion.equals("1")) {
					
					 
					System.out.println("Ingrese el nombre del titular de su cuenta");
					Scanner scaner23 = new Scanner(System.in);
					String titularReserva = scaner23.nextLine();
					System.out.println("Ingrese La fecha en la que desea inicia su estadia");
					Scanner scaner24 = new Scanner(System.in);
					String fechaInicial = scaner24.nextLine();
					System.out.println("Ingrese la fecha en la cual termina su estadia");
					Scanner scaner25 = new Scanner(System.in);
					String fechaFinal = scaner25.nextLine();
					
					System.out.println("Ingrese la cantidad de personas que se van a hospedar: ");
					Scanner scaner26 = new Scanner(System.in);
					int cantidad = scaner26.nextInt();
					
					controlador.crearReserva(titularReserva, fechaInicial, fechaFinal,cantidad);	
					System.out.println("LA RESERVA HA SIDO HECHA CON EXITO CONTINUE CON SU ESTADIA :)");
				}
				
				if(opcionRecepcion.equals("2")) {
					System.out.println("Ingrese el nombre del titular: ");
					System.out.println("(La persona a la cual esta asignada la reserva)");
					Scanner scaner27 = new Scanner(System.in);
					String nombretitu = scaner27.nextLine();
					String factura = controlador.cerrarReserva(nombretitu);
					System.out.println("A continuacion se muestra la factura de la reserva: ");
					System.out.println(factura);
					
					// mirar bien lo de sacar factura porque esta bien curioso
					
				}
				
				if(opcionRecepcion.equals("3")) {sigueRecepcion = false;}
				
				
				
				}
				
			}
			
			
			// Aca se pasa si es cualquier personal del hotel entonces solo tiene la facultad de agregar servicios: 
			if(autenticador.getTipo(usuario) == "PERSONAL DEL HOTEL") {
				System.out.println("++++++++++ BIENVENIDO ++++++++ ");
				System.out.println("+++++++++++ PERSONAL ++++++++ ");
				System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES SEGUN LO QUE QUIERA REALIZAR: ");
				System.out.println("1. Asignar consumo a una habitacion:  ");
				
				// Le puede asignar el conumo a cierta habitacion dependiendo del id, por lo cual entonces 
				// sacamos los consumos que hace una habitacion y una reserva en general
				
				
				// puede estar pago ya o no
				// la impresion de esto se haria en las facturas poniendo en un lado la forma de pagado y los otros son los no pagados
				String opcionServicio = scan.nextLine();
				
				
				if (opcionServicio.equals("1")) {
					System.out.println("INGRESE EL ID DE LA HABITACION EN LA QUE SE HOSPEDA EL CLIENTE:");
					String identificador = scan.nextLine();
					System.out.println("Ingrese el tipo de servicio que tomo: ");
					String tipoServicio = scan.nextLine();
					
					
					
					// si el servicio es de restaurante entonces....
					// mira si comio platos o no?
					// mira si tomo algo o no?
					// en cada repeticion solo da el nombre del plato y lo deberia agregar al consumo 
					//que se hace por parte de el cliente tambien tiene que tener CADA CONSUMO si esta pagado o no
					
					if(tipoServicio.equals("RESTAURANTE")) {
						System.out.println("Desea agregarlo a la habitacion o pagarlo de una vez :");
						System.out.println("1. Agregar a la habitacion");
						System.out.println("2. Pagar de una vez");	
						String agregar = scan.nextLine();
						
						
						
						System.out.println("Se consumieron platos ? ");
						System.out.println("1. Si");
						System.out.println("2. No");
						String deseaPlatos = scan.nextLine();
						
						System.out.println("Se consumieron bebidas ? ");
						System.out.println("1. Si");
						System.out.println("2. No");
						String deseaBebidas = scan.nextLine();
					
						
						
						controlador.setConsumoRestauranteTotal(identificador, agregar, deseaPlatos, deseaBebidas);
						
						
						
						System.out.println("SE AGREGARON LOS PLATOS Y BEBIDAS CON EXITO");
						
					}
					
					// si el servicio no es de restaurante entonces es mas facil porque solo seria hacer lo de buscar y dar el precio
					// y saleeeeeeeeeeeee
					else if (tipoServicio.equals("2")){
						
						System.out.println("Ingrese el nombre del servicio que se utilizo: ");
						String nombre = scan.nextLine();
						System.out.println("1. Agregar a la habitacion");
						System.out.println("2. Pagar de una vez");	
						String agregar = scan.nextLine();
						controlador.setConsumoGeneral(identificador, nombre, agregar);
						System.out.println("Quedo agregado con exito el consumo :)");
					}
					
					
				}
				
				
				
			}
		}
			
			
			
			
			
			
			
			
			
		}
		
	
	}
	

