package Serialización;

import Model.PokedexModel;
import Model.PokemonModel;

import java.io.*;
import java.util.ArrayList;

public class Serial {
    public static void serializar(PokedexModel pokedexModel){
        try {

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Serializar.txt"));
            oos.writeObject(pokedexModel);
        } catch (IOException e) {
            System.out.println("Error serializando pokedex: "+e.getMessage());
        }
    }

    public static ArrayList<PokedexModel> deserializar(){
        ArrayList<PokedexModel> pokedexs= new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Serializar.txt"));
            Model.PokedexModel pokedexModels = (PokedexModel) ois.readObject();
            while (pokedexModels != null){
                pokedexs.add(pokedexModels);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo non encontrado: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error entrada/saida: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pokedexs;
    }
}
