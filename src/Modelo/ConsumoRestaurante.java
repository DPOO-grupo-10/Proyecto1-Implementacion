package Modelo;

import java.util.ArrayList;

public class ConsumoRestaurante {
	
	private ArrayList<Plato> platosConsumidos;
	private ArrayList<Bebida> bebidasConsumidas;
	private int tarifaTotal;
	
	
	
	public ConsumoRestaurante(){
		this.platosConsumidos = new ArrayList<Plato>();
		this.bebidasConsumidas = new ArrayList<Bebida>();
		this.tarifaTotal = 0;
	}
	
	
	public void setPlatosConsumidos(Plato plato) {
		platosConsumidos.add(plato);
	}
	public void setBebidasConsumidas(Bebida bebida) {
		bebidasConsumidas.add(bebida);
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
