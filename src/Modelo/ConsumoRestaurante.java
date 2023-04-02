package Modelo;

import java.util.ArrayList;

public class ConsumoRestaurante extends Consumo{
	
	private ArrayList<Plato> platosConsumidos;
	private ArrayList<Bebida> bebidasConsumidas;
	
	private int tarifaTotal;
	
	
	
	public ConsumoRestaurante(String id, Boolean estaPago){
		super(id,"RESTAURANTE",0,estaPago);
	}
	
	
	public void setPlatosConsumidos(ArrayList<Plato> listaPlatos) {
		this.platosConsumidos = listaPlatos;
	}
	public void setBebidasConsumidas(ArrayList<Bebida> listabebidas) {
		this.bebidasConsumidas = listabebidas;
	}
	public void setTarifa() {
		for(Bebida unabebida: bebidasConsumidas) {
			tarifaTotal = tarifaTotal + unabebida.gettarifa();
		}
		for(Plato unplato: platosConsumidos) {
			tarifaTotal = tarifaTotal + unplato.gettarifa();
		}
	}
	
	
	public int getTarifa() {
		return tarifaTotal;
		
	}
	public ArrayList<Plato> getplatosCOnsumidos(){
		return platosConsumidos;
	}
	public ArrayList<Bebida> getBebidasConsumidas(){
		return bebidasConsumidas;
		
	}
	
	

}
