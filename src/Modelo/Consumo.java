package Modelo;

public class Consumo {
	
	private String identificadorHabitacion;
	private String tipoServicio;
	private int costoServicio;
	private Boolean estaPago;
	
	public Consumo(String id, String serv,int cs,Boolean ep) {
		this.identificadorHabitacion = id;
		this.tipoServicio = serv;
		this.costoServicio = cs;
		this.estaPago = ep;
	}
	
	public int getCostoServicio() {
		return costoServicio;
	}

}
