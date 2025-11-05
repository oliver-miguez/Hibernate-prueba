package Serialización;

import Model.PokedexModel;
import Model.PokemonModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serial {
    /**
     * Serializa la pokedex
     */
    public static void serializarPokedex(List<PokedexModel> pokedexModels){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Serializar.txt"));
            oos.writeObject(pokedexModels);

        } catch (IOException e) {
            System.out.println("Error al serializar: "+e.getMessage());
        }
    }

    public static List<PokedexModel> deserializar(){
        List<PokedexModel> pokedexModels = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Serializar.txt"));
            pokedexModels = (List<PokedexModel>) ois.readObject();
            System.out.println(pokedexModels);
        } catch (IOException e) {
            System.out.println("Error al deserializar");
        } catch (ClassNotFoundException e) {
            System.out.println("Objeto al deserializar no encontrado");
        }
        return pokedexModels;
    }
}
