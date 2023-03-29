package Modelo;

import java.util.ArrayList;

public class Restaurante extends Servicio{
	private ArrayList<Plato> platos;
	private ArrayList<Bebida> bebidas;
	
	
	public Restaurante () {
		
	}
	
	
	public ArrayList<Plato> getPlatos(){
		return platos;
	}
	public ArrayList<Bebida> getBebidas(){
		return bebidas;
	}
	
}
