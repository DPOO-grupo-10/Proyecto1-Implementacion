package Modelo;

import java.io.File;
import java.util.ArrayList;

public class Reserva {
	
	
	private String titular;
	private String fechaSalida;
	private String fechaEntrada;
	private ArrayList<Huesped> huespedes;
	private ArrayList<Servicio> serviciosAdquiridos;
	private String factura;
	private int costo;
	
	
	
	public Reserva(String titu,String fechasalida,String fechaentrada,ArrayList<Huesped> hes){
		this.titular = titu;
		this.fechaEntrada = fechaentrada;
		this.fechaSalida = fechasalida;
		ArrayList<Servicio> s = new ArrayList<Servicio>();
		this.serviciosAdquiridos = s;
		this.factura = "INICIO RESERVA \n";
		this.huespedes = hes;
		this.costo = 0;
	}
	
	
	
	public String getTitular() {
		return titular;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public ArrayList<Huesped> getHuespedes() {
		return huespedes;
	}
	public ArrayList<Servicio> getServicio(){
		return serviciosAdquiridos;
	}
	public String getFactura() {
		this.factura = factura + "***SERVICIOS***" + "\n";
		for(Servicio unservicio: serviciosAdquiridos) {
			int tarifa = unservicio.getTarifaServicio();
			this.costo = costo + tarifa;
			String tipoServicio = unservicio.getTipoServicio();
			this.factura = factura + tipoServicio + ": " + Integer.toString(tarifa) + "\n";
		}
		
		
		// falataria sumar lo de el costo de los dias
		
		
		// al final se muestra el costo total
		
		return factura;
	}
	
	
	
	
	
}
