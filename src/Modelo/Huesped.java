package Modelo;

public class Huesped {
	private String nombre;
	private Boolean titular;
	private Boolean mayorDeEdad;
	private String correoElectronico;
	private String documento;
	private String numerocelular;
	
	
	
	public Huesped(String n,Boolean t,Boolean me, String ce, String doc, String nc) {
		this.nombre = n;
		this.titular = t;
		this.mayorDeEdad = me;
		this.correoElectronico = ce;
		this.documento = doc;
		this.numerocelular = nc;
	}
	
	public String getnombre() {
		return nombre;
	}
	public Boolean getmayordeedad() {
		return mayorDeEdad;
	}
	
	public String getcorreo() {
		return correoElectronico;
	}
	
	public String getDocumento() {
		return documento;
	}
	
	public String getnumerocelular() {
		return numerocelular;
	}
	
	public Boolean gettitular() {
		return titular;
	}
	
	
	

}
