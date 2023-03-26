package Modelo;


public class PersonaldelHotel {
	private String usuarioSistema;
	private String contraseñaSistema;
	
	public PersonaldelHotel(String usuario, String contraseña ) {
		
		this.usuarioSistema = usuario;
		this.contraseñaSistema = contraseña;
	}
	
	public String getUsuario() {
		return usuarioSistema;
	}
	public String getContraseña() {
		return contraseñaSistema;
	}

}
