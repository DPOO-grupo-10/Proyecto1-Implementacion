package Modelo;

import java.io.File;
import java.util.ArrayList;

public class Reserva {
	
	
	private String titular;
	private String fechaSalida;
	private String fechaEntrada;
	private ArrayList<Servicio> serviciosAdquiridos;
	private String factura;
	
	
	
	public Reserva(String titu,String fechasalida,String fechaentrada){
		this.titular = titu;
		this.fechaEntrada = fechaentrada;
		this.fechaSalida = fechasalida;
		ArrayList<Servicio> s = new ArrayList<Servicio>();
		this.serviciosAdquiridos = s;
		this.factura = "INICIO RESERVA \n";
	}
	
	
	
}
