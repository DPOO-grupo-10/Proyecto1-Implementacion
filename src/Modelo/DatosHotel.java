package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class DatosHotel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private HashMap<String,Habitacion> habitaciones  = new HashMap<String,Habitacion>();
	private HashMap<String,Habitacion> habitacionesOcupadas  = new HashMap<String,Habitacion>();
	private HashMap<Integer,ArrayList<Habitacion>> habitacionesPorTipo  = new HashMap<Integer,ArrayList<Habitacion>>();
	private HashMap<String,Servicio> servicios  = new HashMap<String,Servicio>();
	private HashMap<String,Integer> servicioscosto  = new HashMap<String,Integer>();
	private HashMap<String,Integer> platosRestaurante = new HashMap<String, Integer>();
	private HashMap<String,Integer> bebidasRestaurante = new HashMap<String, Integer>();
	
	private HashMap<String,Reserva> reservas = new HashMap<String,Reserva>();

	
	
	public DatosHotel() {
		habitacionesPorTipo.put(5, new ArrayList<Habitacion>());
		habitacionesPorTipo.put(4, new ArrayList<Habitacion>());
		habitacionesPorTipo.put(3, new ArrayList<Habitacion>());
		habitacionesPorTipo.put(2, new ArrayList<Habitacion>());
		habitacionesPorTipo.put(1, new ArrayList<Habitacion>());
		
	}
	
	public HashMap<String,Habitacion> getHabitaciones(){
		return habitaciones;
	}
	public HashMap<String,Habitacion> getHabitacionesOcupadas(){
		return habitacionesOcupadas;
	}
	public HashMap<Integer,ArrayList<Habitacion>> getHabitacionesPorTipo(){
		return habitacionesPorTipo;
	}
	public HashMap<String, Servicio> getServicios(){
		return servicios;
	}
	public HashMap<String, Integer> getServicioscostos(){
		return servicioscosto;
	}
	public HashMap<String, Integer> getBebidasRestaurante(){
		return bebidasRestaurante;
	}
	public HashMap<String, Integer> getPlatosRestaurante(){
		return platosRestaurante;
	}
	public HashMap<String, Reserva> getReservas(){
		return reservas;
	}
	public void setReserva(String titular, Reserva res){
		reservas.put(titular, res);
	}
	
	public void setHabitaciones(String identificador, Habitacion habit){
		int capacidad = habit.getCapacidadPersonas();
		System.out.println(capacidad);
		ArrayList<Habitacion> lista = habitacionesPorTipo.get(capacidad);
		lista.add(habit);
		
		habitacionesPorTipo.put(capacidad, lista);
		
		habitaciones.put(identificador, habit);
	}
	
	
	public void sethabitacionocupada(Habitacion hab) {
		String id = hab.getIdentificador();
		habitacionesOcupadas.put(id, hab);
	}
	public void sethabitacionesmapa(Integer capacidad ,ArrayList<Habitacion> listahab) {
		habitacionesPorTipo.put(capacidad, listahab);
		
	}
	
	
	public void setPlatosRestaurante(String nombre, int tarifa) {
		platosRestaurante.put(nombre, tarifa);
	}
	public void setbebidasRestaurante(String nombre ,int tarifa) {
		bebidasRestaurante.put(nombre, tarifa);
	}
	public void setServicios(String tiposervicio,int costo, Servicio serv){
		servicioscosto.put(tiposervicio, costo);
		servicios.put(tiposervicio, serv);
	}
	
	public static void serializar(DatosHotel hotel, String nombreArchivo) {
        try {
            FileOutputStream archivoSalida = new FileOutputStream(nombreArchivo);
            ObjectOutputStream salida = new ObjectOutputStream(archivoSalida);
            salida.writeObject(hotel);
            salida.close();
            archivoSalida.close();
            System.out.println("Objeto serializado en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static DatosHotel deserializar(String nombreArchivo) {
        DatosHotel hotel = null;
        try {
            FileInputStream archivoEntrada = new FileInputStream(nombreArchivo);
            ObjectInputStream entrada = new ObjectInputStream(archivoEntrada);
            hotel = (DatosHotel) entrada.readObject();
            entrada.close();
            archivoEntrada.close();
            System.out.println("Objeto deserializado desde el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return hotel;
    }
}
