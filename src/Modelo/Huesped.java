package Modelo;

public class Huesped {
	private String nombre;
	private Boolean titular;
	private int edad;
	private String correoElectronico;
	private String documento;
	private String numerocelular;
	
	
	
	public Huesped(String n,Boolean t,int me, String ce, String doc, String nc) {
		this.nombre = n;
		this.titular = t;
		this.edad = me;
		this.correoElectronico = ce;
		this.documento = doc;
		this.numerocelular = nc;
	}
	
	public String getnombre() {
		return nombre;
	}
	public int getedad() {
		return edad;
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
