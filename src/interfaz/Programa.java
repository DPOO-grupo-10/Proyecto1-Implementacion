package interfaz;

import java.util.Scanner;
import Controlador.Controlador;
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
		
		
		if (navegante.equals("1")) {
			
			
			
			System.out.println("Elija la opcion que desea utilizar: ");
			System.out.println("1. Consultar Reserva ");
			
			String opcion = scan.nextLine();
			
			if(opcion.equals("1")) {
				System.out.println("Ingrese el nombre del titular de la cuenta: ");
				String titu = scan.nextLine();
				
				controlador.consultarReservas(titu);
				
				
				
			}
			
			
			
			
		}
		
		
		
		
		
		
		
		
		// Si el usuario es personal del hotel debe tener usuario y contraseña por lo cual esto
		
		if(navegante.equals("2") ) {
			
			
			
			
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
				
				
				int opcionAdmin = scan.nextInt();
				// Para cuando se desea agregar nuevo personal del hotel, el que lo tiene que hacer es el administrador
				if (opcionAdmin == 3) {
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
				
				// Para cuando de desean agregar habitaciones 
				// Falta que se agreguen segun un archivo csv o algo asi
				
				else if (opcionAdmin == 1) {
					
					System.out.println("De que forma desea ingresar las habitaciones: ");
					System.out.println("1. Por un archivo");
					System.out.println("2. Una por una ");
					
					String ingreso  =  scan.nextLine();
					
					if(ingreso.equals("1")) {
						
						
						System.out.println("Cada linea del archivo debe tener el siguiente formato: ");
						System.out.println("TIPO HABITACION, TIENE BALCON (SI/NO) ,TIENE VISTA (SI/NO),TIENE COCINA (SI/NO) ");
						System.out.println("Ingrese la ruta del archivo que desea ingresar: ");
						String rutaArchivo = scan.nextLine();
						controlador.agregarHabitacionPorArchivo(rutaArchivo);
						
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
						String tipo = "" ;
						if(opciontipo == 1) {
							tipo = "ESTANDAR";
							
						}	
						if(opciontipo == 2) {
							tipo = "SUITE";
							
						}
						if(opciontipo == 3) {
							tipo = "SUITE DOUBLE";
							
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
					
					
					
						controlador.agregarHabitaciones(tipo, balcon, vista, cocina);
						System.out.println("Se ha agregado la habitacion con exito: ");
						
						System.out.println("Desea agregar mas habitaciones? ");
						System.out.println("1. Si ");
						System.out.println("2. No");
						
						int mashabitacion = scan.nextInt();
						if(mashabitacion == 2) {habitacionesseguir = false; }
						
						}
						
					
					}
					
				
				}
				
				
				
				
				// Para cuando el administrador desea cargar servicios incluidos e el hotel
				// por ejmplo si abren un spa o algo asi nos da el nombre del servicio y cuanto cuesta 
				
				// existe una opcion especifica que es para el RESTAURANTE que tiene otras funcionalidades mas especificas
				else if(opcionAdmin == 2){
					
					System.out.println("+ CARGADOR DE SERVICIOS+++++++++++++++");
					System.out.println("Elija el servicio al cual desea cargar: ");
					System.out.println("1. RESTAURANTE");
					System.out.println("2. OTRO");
					
					
					
					String opcionServicios = scan.nextLine();
					
					// OPCION RESTAURANTE 
					if (opcionServicios.equals("1")) {
						System.out.println("Elija el cual opcion desea cargar: ");
						System.out.println("1. PLATO");
						System.out.println("2. BEBIDA");
						
						String opcionrestaurante = scan.nextLine();
						if(opcionrestaurante.equals("1")) {
							System.out.println("Ingrese el nombre del plato");
							String nombrePlato = scan.nextLine();
							System.out.println("Ingrese el costo del plato");
							int costoPlato = scan.nextInt();
							
							
							controlador.setPlatosRestaurante(nombrePlato, costoPlato);
						}
						if(opcionrestaurante.equals("2")) {
							System.out.println("Ingrese el nombre de la bebida");
							String nombreBebida = scan.nextLine();
							System.out.println("Ingrese el costo de la bebida");
							int costoBebida = scan.nextInt();
							
							
							
							controlador.setBebidasrestaurante(nombreBebida, costoBebida);
						}
						
						
						
						
						
						
					}
					// OPCION DIFERENTE DE RESTAURANTE 
					else if(opcionServicios.equals("2")) {
						System.out.println("Ingrese el tipo de servicio que desea agregar: ");
						String tiposervicio = scan.nextLine();
						System.out.println("Ingrese la disponibilidad de este servicio: : ");
						String dispo = scan.nextLine();
						System.out.println("Ingrese el costo de este servicio: ");
						int costo = scan.nextInt();
						controlador.agregarServicios(tiposervicio, dispo, costo);
						
					}
					
				}
				
				else if(opcionAdmin == 4) {seguiradmin = false;}
					
				}
				}
				
				
				
			
			
			// Aca se pasa si el usuario es recepcionista por lo cual tiene otras funciones
			
			
			if(autenticador.getTipo(usuario) == "RECEPCIONISTA") {
				System.out.println("++++++++++ BIENVENIDO ++++++++ ");
				System.out.println("++++++++++ A RECEPCION ++++++++ ");
				System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES SEGUN LO QUE QUIERA REALIZAR: ");
				System.out.println("1. Crear Reserva  ");
				System.out.println("2. Cerrar Reserva ");
				
				String opcionRecepcion = scan.nextLine();
				
				// CREAR RESERVA
				if(opcionRecepcion.equals("1")) {
					
					 
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
					
					// mirar bien lo de sacar factura porque esta bien curioso
					
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
	

