package Modelo;

import java.util.ArrayList;
import java .util.Scanner;

public class GrupoHuespedes {
	
	private ArrayList<Huesped> huespedes;
	public GrupoHuespedes() {
		this.huespedes = new ArrayList<Huesped>();
		Boolean  mashuespedes = true;
		
		
		System.out.println(" A CONTINUACION DEBERA INGRESAR LOS DATOS DE LOS HUESPEDES QUE SE HOSPEDARAN (INCLUIDO EL TITULAR)");
		
		while(mashuespedes == true) {
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Ingrese nombre del nuevo huesped: ");
			String nombre = scan.nextLine();
			System.out.println("Ingrese correo del nuevo huesped: ");
			String correo = scan.nextLine();
			System.out.println("¿Es mayor de edad ? (a: Si b: no): ");
			String mayorDeEdad = scan.nextLine();
			Boolean me =false;
			if (mayorDeEdad == "a") {
				me = true;
				
			}
			System.out.println("ingrese numero celular: ");
			String ncelular = scan.nextLine();
			System.out.println("Es usted el titular de la reserva?: (a: Si b: no) ");
			String titular = scan.nextLine();
			Boolean titu =false;
			if (titular == "a") {
				titu = true;
				
			}
			System.out.println("Ingrese el documento del nuevo huesped : ");
			String doc = scan.nextLine();
			
			
			
			Huesped huesped = new Huesped(nombre, titu , me, correo, doc, ncelular);
			huespedes.add(huesped);
			System.out.println("El huesped ha sido agregado con exito ");
			
			System.out.println("Desea agregar mas huespedes: a: Si b: No ");
			String nuevo = scan.nextLine();
			
			if (nuevo == "b") {
				mashuespedes = false;
			}
		}
	}
	public ArrayList<Huesped> getHuespedes(){
		return huespedes;
	}

}
