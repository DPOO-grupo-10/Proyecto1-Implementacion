package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class DatosHotel {
	
	
	private HashMap<String,Habitacion> habitaciones  = new HashMap<String,Habitacion>();
	private HashMap<String,Habitacion> habitacionesOcupadas  = new HashMap<String,Habitacion>();
	private HashMap<Integer,ArrayList<Habitacion>> habitacionesPorTipo  = new HashMap<Integer,ArrayList<Habitacion>>();
	private HashMap<String,Servicio> servicios  = new HashMap<String,Servicio>();
	private HashMap<String,Reserva> reservas = new HashMap<String,Reserva>();

	
	
	
	
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
	public HashMap<String, Reserva> getReservas(){
		return reservas;
	}
	public void setReserva(String titular, Reserva res){
		reservas.put(titular, res);
	}
	
	public void setHabitaciones(String identificador, Habitacion habit){
		int capacidad = habit.getCapacidadPersonas();
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
	
	public void setServicios(String tiposervicio, Servicio serv){
		servicios.put(tiposervicio, serv);
	}
	
}
