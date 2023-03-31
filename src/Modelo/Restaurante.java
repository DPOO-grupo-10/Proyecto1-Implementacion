package Modelo;

import java.util.ArrayList;

public class Restaurante extends Servicio{
	private ArrayList<Plato> platos;
	private ArrayList<Bebida> bebidas;
	
	
	public Restaurante ( ) {
		
	
		super("RESTAURANTE","LUNES-VIERNES");
		this.platos = new ArrayList<Plato>();
		this.bebidas = new ArrayList<Bebida>();
		
	}
	
	
	public ArrayList<Plato> getPlatos(){
		return platos;
	}
	public ArrayList<Bebida> getBebidas(){
		return bebidas;
	}
	
	public void setPlato(String nombre, int costo ) {
		Plato plato = new Plato(costo,nombre);
		platos.add(plato);
	}
	public void setBebida(String nombre, int costo) {
		Bebida beb = new Bebida(costo, nombre);
		bebidas.add(beb);
	}
	
	
	
}
