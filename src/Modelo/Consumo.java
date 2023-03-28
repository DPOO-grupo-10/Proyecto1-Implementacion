package Modelo;
import java.util.HashMap;
import java.util.ArrayList;

public class Consumo {
    // nota el String seria la habitacion a la que se le aplican los consumos
    private HashMap<String,ArrayList> consumos = new HashMap<String,ArrayList>();

    public HashMap<String,ArrayList> getConsumos(){
        return consumos;
    }
}
