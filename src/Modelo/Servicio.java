package Modelo;

public class Servicio {
	private String tipoServicio;
	private int tarifaServicio;
	private String nombreServicio;
	
	public Servicio(String n, String ts, int tas){
		this.nombreServicio = n;
		this.tarifaServicio = tas;
		this.tipoServicio = ts;
	}
	
	public int getTarifaServicio() {
		return tarifaServicio;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}	

	public String getNombreServicio(){
		return nombreServicio;
	}
}