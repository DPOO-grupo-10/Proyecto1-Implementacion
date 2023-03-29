package Modelo;

public class Bebida {
	
	
	private int tarifa;
	private String nombreBebida;
	private int disponibilidad;
	
	
	
	public Bebida(int tar, String np, int disp){
		this.tarifa = tar;
		this.nombreBebida = np;
		this.disponibilidad = disp;
		
		
	}
	
	public int gettarifa() {return tarifa;}
	public String getNombreBebida() {return nombreBebida;}
	public int getDisponibilidad() {return disponibilidad;}

}
