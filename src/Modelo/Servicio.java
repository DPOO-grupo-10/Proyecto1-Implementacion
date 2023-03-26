package Modelo;

public class Servicio {
	private String tipoServicio;
	private int tarifaServcio;
	
	
	public Servicio(String ts, int tas){
		this.tarifaServcio = tas;
		this.tipoServicio = ts;
	}
	
	public int getTarifaServicio() {
		return tarifaServcio;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}	

}
