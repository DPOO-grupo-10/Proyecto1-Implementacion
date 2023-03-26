package interfaz;


import java.util.HashMap;

public class Autenticador {
	private HashMap<String,String> usuariosConContraseña ;
	private HashMap<String,String> usuariosConTipo;
	
	
	
	
	public Autenticador() {
		// tiene que tener un administrador por defecto lo cual se hace en las siguientes lineas de codigo
		usuariosConContraseña.put("DPOO","12345");
		// SOLO EXISTE UN ADMINISTRADOR 
		usuariosConTipo.put("DPOO","ADMINISTRADOR");
		//EXISTEN TRES TIPOS DE USUARIOS: ADMINISTRADOR, RECEPCIONISTA Y PERSONAL DEL HOTEL
		
		
	}
	
	
	
	
	
	
	
	
	
	
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
	
	
	public void setUsuarios(String usuario,String contraseña,String tipo) {
		usuariosConContraseña.put(usuario, contraseña);
		usuariosConTipo.put(usuario,tipo);
	}
	
	public String getTipo(String usuario) {
		return usuariosConTipo.get(usuario);
	}
	
	
	
	
	
	
}
