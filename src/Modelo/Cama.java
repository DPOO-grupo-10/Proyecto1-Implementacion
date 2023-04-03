package Modelo;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Cama {
	// existen tres tipos de cama: NIÑOS, SENCILLA Y DOBLE 
	private String tamañoCama;
	// CUANTAS PERSONAS CABEN SEGUN EL TIPO DE CAMA
	private int ocupacion;
	
	
	public Cama(String tamaño, int capacidad) {
		this.tamañoCama = tamaño;
		this.ocupacion = capacidad;
	}
	
	public int getocupacion() {
		return ocupacion;
	}

}
