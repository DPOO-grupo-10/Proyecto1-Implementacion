package Modelo;
import java.util.HashMap;
import java.util.ArrayList;

import java.util.*;

public class Consumo {
    private Map<String, List<Servicio>> consumos;
    
    public Consumo() {
        this.consumos = new HashMap<>();
    }
    
    public void agregarConsumo(String nombreConsumo, Servicio servicio) {
        if (!consumos.containsKey(nombreConsumo)) {
            consumos.put(nombreConsumo, new ArrayList<>());
        }
        
        consumos.get(nombreConsumo).add(servicio);
    }
    
    public List<Servicio> obtenerServiciosPorConsumo(String nombreConsumo) {
        if (!consumos.containsKey(nombreConsumo)) {
            return new ArrayList<>();
        }
        
        return consumos.get(nombreConsumo);
    }
    
    public Map<String, List<Servicio>> obtenerConsumos() {
        return consumos;
    }
}
