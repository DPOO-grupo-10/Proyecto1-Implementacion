package Modelo;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Bebida {
	
	
	private int tarifa;
	private String nombreBebida;
	
	
	
	
	public Bebida(int tar, String np){
		this.tarifa = tar;
		this.nombreBebida = np;
	}
	
	public int gettarifa() {return tarifa;}
	public String getNombreBebida() {return nombreBebida;}
	

}
