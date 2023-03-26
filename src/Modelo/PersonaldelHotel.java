package Modelo;
import java.util.Random;

public class PersonaldelHotel {
	private String usuarioSistema;
	private String contraseñaSistema;
	
	public PersonaldelHotel(String nombre ) {
		Random aleatorio = new Random();
		this.usuarioSistema = nombre + aleatorio.nextInt(9999);
		this.contraseñaSistema = Integer.toString(aleatorio.nextInt(999999));
	}
	
	public String getUsuario() {
		return usuarioSistema;
	}
	public String getContraseña() {
		return contraseñaSistema;
	}

}
