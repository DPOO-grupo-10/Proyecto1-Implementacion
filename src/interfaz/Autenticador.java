package interfaz;


import java.util.HashMap;

import Modelo.PersonaldelHotel;

public class Autenticador {
	private HashMap<String,String> usuariosConContraseña ;
	private HashMap<String,String> usuariosConTipo;
	private HashMap<String,PersonaldelHotel> personaldelhotel;
	
	
	
	
	public Autenticador() {
		// tiene que tener un administrador por defecto lo cual se hace en las siguientes lineas de codigo
		// SOLO EXISTE UN ADMINISTRADOR 
		this.usuariosConContraseña = new HashMap<String,String>();
		//EXISTEN TRES TIPOS DE USUARIOS: ADMINISTRADOR, RECEPCIONISTA Y PERSONAL DEL HOTEL
		this.usuariosConTipo = new HashMap<String,String>();
		this.personaldelhotel = new HashMap<String,PersonaldelHotel>();
		
		
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
	
	
	public void setPersonaldelHotel(String nom, String usuario, String contraseña) {
		PersonaldelHotel personal = new PersonaldelHotel(nom,usuario,contraseña);
		personaldelhotel.put(nom, personal);
	}
	
	public String getTipo(String usuario) {
		return usuariosConTipo.get(usuario);
	}
	
	
	
	
	
	
}
