package interfaz;


import java.util.HashMap;

public class Autenticador {
	private HashMap<String,String> usuariosConContraseña ;
	private HashMap<String,String> usuariosConTipo;
	
	
	public boolean autenticar(String usuario, String contraseña) {
		Boolean resultado = false;
		if(usuariosConContraseña.containsKey(usuario)) {
			String contramapa;
			contramapa = usuariosConContraseña.get(usuario);
			if(contramapa == contraseña) {
				resultado = true;
			}
		}
		return resultado;
	}
	
	
	
	
	
	
}
