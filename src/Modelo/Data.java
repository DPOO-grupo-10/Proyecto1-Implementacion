package Modelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//intento para serializacion
public class Data {

	private String nombre;
	private ArrayList<Habitacion> habitacionesDisponibles;
	private HashMap<Integer, Habitacion> totalHabitaciones;
	private HashMap<String, Huesped> huespedes;
	private HashMap<Integer, Reserva> reservaciones;
	private HashMap<String, PersonaldelHotel> empleados;
	private HashMap<String, Recepcion> recepcion;
	private HashMap<String, Servicio> servicios;

	public void GuardarSerializado(Data datosAguardar) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
		ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(fileOutputStream);
		ObjectOutputStream.writeObject(datosAguardar);
		try {
			ObjectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Data CargarSerializado() throws IOException, ClassNotFoundException {
		FileInputStream FileInputStream = new FileInputStream("data.txt");
		ObjectInputStream ObjectInputStream = new ObjectInputStream(FileInputStream);
		Data datos = (Data) ObjectInputStream.readObject();
		ObjectInputStream.close();
		return datos;
	}

	public Data(String nombre) {
		this.nombre = nombre;
		this.totalHabitaciones = new HashMap<>();
		this.habitacionesDisponibles = new ArrayList<>();
		this.huespedes = new HashMap<>();
		this.reservaciones = new HashMap<>();
		this.empleados = new HashMap<>();
		this.servicios = new HashMap<>();
        this.recepcion = new HashMap<>();
		Restaurante restaurante = new Restaurante();
		this.servicios.put("Restaurante", restaurante);

	}
}
