package Modelo;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Plato {
	
	private int tarifa;
	private String nombrePlato;
	
	
	
	
	public Plato(int tar, String np){
		this.tarifa = tar;
		this.nombrePlato = np;
		
		
		
	}
	
	public int gettarifa() {return tarifa;}
	public String getNombrePlato() {return nombrePlato;}
	
}
