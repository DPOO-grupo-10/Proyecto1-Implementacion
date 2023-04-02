package Modelo;

import java.util.HashMap;
import java.util.Calendar;
import java.util.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;

public class TipoHabitacion {

	// existen tres tipos de habitación: estándar, suite, y suite doble.
	
	//atributos
		private String tipoHabitacion;
		private double tarifaDia;
		private double tarifaRango;
		private HashMap<Date, Double> tarifaAño;
		private HashMap<DayOfWeek, Double> tarifaDiaSemana;
		
		
	// constructor
		
		public TipoHabitacion(String tipoHabitacion, double tarifaDia, double tarifaRango, HashMap<Date, Double> tarifaAño, HashMap<DayOfWeek, Double> tarifaDiaSemana)
		{
			 this.setTipoHabitacion(tipoHabitacion);
		     this.tarifaDia = tarifaDia;
		     this.tarifaRango = tarifaRango;
		     this.tarifaAño = tarifaAño;
		     this.tarifaDiaSemana = tarifaDiaSemana;
		    
		}
		
		
	// getters y setters

		public Double gettarifaDia(Date dia) 
		{
			
			LocalDate diaLocal = dia.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			DayOfWeek diaSemana = diaLocal.getDayOfWeek();
			double tarifaAñoValor = 0.0;
			double tarifaDiaSemanaValor = 0.0;
			
			if (tarifaAño.containsKey(dia)) {
				tarifaAñoValor = tarifaAño.get(dia);
		    }
			
			if (tarifaDiaSemana.containsKey(diaSemana)) {
				tarifaDiaSemanaValor = tarifaDiaSemana.get(diaSemana);
		    }
			
			if (tarifaAñoValor > 0 && tarifaDiaSemanaValor > 0) {
		        return Math.min(tarifaAñoValor, tarifaDiaSemanaValor);
		    } else {
		        return tarifaAñoValor + tarifaDiaSemanaValor;
		    }

		}

	// crea hash map con llave (fecha) y valor (tarifa) para los siguientes 365 días. Tarifa default es 0.0
		 public void settarifaAño() {
		        if (this.tarifaAño == null) {
		            this.tarifaAño = new HashMap<Date, Double>();
		        }
		        
		        Calendar calendario = Calendar.getInstance();
		        Date fechaInicio = calendario.getTime();
		        //añadir un año a la fecha para calcular fecha final
		        calendario.add(Calendar.YEAR, 1);
		        Date fechaFinal = calendario.getTime();
		        
		        //añadir llaves de fecha al mapa
		        
		        while (!fechaInicio.after(fechaFinal)) {
		            if (!this.tarifaAño.containsKey(fechaInicio)) {
		            	this.tarifaAño.put(fechaInicio, (double) 0.0);
		            }
		            //fecha de inicio + 1  día
		            fechaInicio = calendario.getTime();
		            calendario.add(Calendar.DATE, 1);
		        
		        }
		        
		}
		


	//metodos

		public boolean setTarifaRango(Date fechaInicioRango, Date fechaFinalRango, double tarifa) {
			
			//verificar orden de las fechas 
			
			 if (fechaInicioRango.after(fechaFinalRango))
			 {
				 return false;
			 }
			
			 Calendar calendario = Calendar.getInstance();
			 calendario.setTime(fechaInicioRango);
			 
			 //mientras fecha inicio no este despues de fecha final se asigna tarifa. Se cambia dia +1
			 
			 while (!calendario.getTime().after(fechaFinalRango)) 
			 {
			 this.tarifaAño.put(calendario.getTime(), tarifa);
			  calendario.add(Calendar.DATE, 1);
			  }
			 
			 return true;
			
			}
		
		public void setTarifaDiaSemana(DayOfWeek DiaSemana, double tarifa) 
		{
			tarifaDiaSemana.put(DiaSemana, tarifa);
		}
		
		public Double getTarifaRango(Date fechaInicio, Date fechaFinal) 
		{
			Double TarifaRango = 0.0;
			
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(fechaInicio);
			
			while (!calendario.getTime().after(fechaFinal)) {
				TarifaRango += gettarifaDia(calendario.getTime());
		        calendario.add(Calendar.DATE, 1);
		    }
			
			return TarifaRango;
			
			
		}


		public String getTipoHabitacion() {
			return tipoHabitacion;
		}


		public void setTipoHabitacion(String tipoHabitacion) {
			this.tipoHabitacion = tipoHabitacion;
		}

}
