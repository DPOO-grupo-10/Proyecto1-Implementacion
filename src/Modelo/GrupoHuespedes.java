package Modelo;

import java.util.ArrayList;
import java .util.Scanner;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class GrupoHuespedes {
	
	private ArrayList<Huesped> huespedes;
	
	
	
	public GrupoHuespedes() {
		this.huespedes = new ArrayList<Huesped>();
		Boolean  mashuespedes = true;
		
		
		System.out.println(" A CONTINUACION DEBERA INGRESAR LOS DATOS DE LOS HUESPEDES QUE SE HOSPEDARAN (INCLUIDO EL TITULAR)");
		
		while(mashuespedes == true) {
			
			
			System.out.println("Ingrese nombre del nuevo huesped: ");
			Scanner scan = new Scanner(System.in);
			String nombre = scan.nextLine();
			System.out.println("Ingrese correo del nuevo huesped: ");
			Scanner scaner1 = new Scanner(System.in);
			String correo = scaner1.nextLine();
			System.out.println("Ingrese la edad del huesped: ");
			Scanner scaner2 = new Scanner(System.in);
			int edad = scaner2.nextInt();
			
			System.out.println("ingrese numero celular:( 0 si no tiene) ");
			Scanner scaner3 = new Scanner(System.in);
			String ncelular = scaner3.nextLine();
			System.out.println("Es usted el titular de la reserva?: (a: Si b: no) ");
			Scanner scaner4 = new Scanner(System.in);
			String titular = scaner4.nextLine();
			Boolean titu =false;
			if (titular.equals("a")) {
				titu = true;
				
			}
			System.out.println("Ingrese el documento del nuevo huesped : ");
			Scanner scaner5 = new Scanner(System.in);
			String doc = scaner5.nextLine();
			
			
			
			Huesped huesped = new Huesped(nombre, titu , edad, correo, doc, ncelular);
			huespedes.add(huesped);
			System.out.println("El huesped ha sido agregado con exito ");
			
			System.out.println("Desea agregar mas huespedes: a: Si b: No ");
			Scanner scaner6 = new Scanner(System.in);
			String nuevo = scaner6.nextLine();
			
			if (nuevo.equals("b")) {
				mashuespedes = false;
			}
		}
	}
	public ArrayList<Huesped> getHuespedes(){
		return huespedes;
	}

}
