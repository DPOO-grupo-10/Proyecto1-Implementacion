package Modelo;

import java.util.ArrayList;

public class GrupoHuespedes {
	
	private ArrayList<Huesped> huespedes;
	public GrupoHuespedes(int cantidadHuespedes) {
		this.huespedes = new ArrayList<Huesped>();
		for(Integer i = 0; i<= cantidadHuespedes;i++) {
			System.out.println("Ingrese nombre del nuevo huesped: ");
			System.out.println("Ingrese correo del nuevo huesped: ");
			System.out.println("¿Es mayor de edad ? : ");
			System.out.println("ingrese numero celular: ");
			System.out.println("Es usted el titular de la reserva?: ");
			System.out.println("Ingrese el documento del nuevo huesped : ");
			
			Huesped huesped = new Huesped();
		}
	}

}
