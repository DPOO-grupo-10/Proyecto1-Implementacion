package Modelo;
import java.io.Serializable;
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

