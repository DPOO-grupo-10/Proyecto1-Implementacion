package Modelo;


public class PersonaldelHotel {
	private String nombre;
	private String usuarioSistema;
	private String contraseñaSistema;
	
	public PersonaldelHotel(String nom,String usuario, String contraseña ) {
		
		this.usuarioSistema = usuario;
		this.contraseñaSistema = contraseña;
		this.nombre = nom;
	}
	
	public String getUsuario() {
		return usuarioSistema;
	}
	public String getContraseña() {
		return contraseñaSistema;
	}
	public String getnombre() {
		return nombre;
	}

	public Servicio agregarServicio(String nombre, String contraseña, String tipo, int tarifa ) {
		if (contraseña.equals(contraseñaSistema)) {  
		return new Servicio(nombre, tipo, tarifa);
	}	
		else
		{
		return null;
		}
	}
}
