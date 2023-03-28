package Modelo;

public class Servicio {
	private String tipoServicio;
	private double tarifaServicio;
	private String nombreServicio;
	
	public Servicio(String n, String ts, int tas){
		this.nombreServicio = n;
		this.tarifaServicio = tas;
		this.tipoServicio = ts;
	}
	
	public double getTarifaServicio() {
		return tarifaServicio;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}	

	public String getNombreServicio(){
		return nombreServicio;
	}
	
	@Override
	public String toString() {
		return nombreServicio + ": $" + tarifaServicio;
	}

	
}
