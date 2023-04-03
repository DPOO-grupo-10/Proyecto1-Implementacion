package Modelo;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Servicio {
	private String tipoServicio;
	private String disponibilidad;
	
	
	public Servicio(String tipoServicio, String disponibilidad){
		this.tipoServicio = tipoServicio;
		this.disponibilidad = disponibilidad;
		
	}
	
	public String getDisponibilidads() {
		return disponibilidad;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}	

}

