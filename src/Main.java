import Model.AdestradorModel;
import Model.PokedexModel;
import Model.PokemonModel;
import Serialización.Serial;
import Services.AdestradorService;
import Services.PokedexService;
import Services.PokemonService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //INSTANCIA DE SERVICIOS
        AdestradorService adestrador = new AdestradorService();
        PokedexService pokedex = new PokedexService();
        PokemonService pokemon = new PokemonService();


        //CREAR
        adestrador.crearAdestrador("Ramon", new Date(1600-3-12));
        adestrador.crearAdestrador("Pepe",new Date(1999-9-2));

        //Pokedex
        pokedex.crearPokedex("Sceptile",20.2,"Mi pokemon favorito");
        pokedex.crearPokedex("Treeko",10.5,"La primera evolución de mi pokemon favorito");
        pokedex.crearPokedex("Grovyle",16.9,"La segunda evolución de mi pokemon favorito");
        pokedex.crearPokedex("Voltorb",4.0,"Mi primer pokemon capturado en pokemon esmeralda");
        pokedex.crearPokedex("Wingull",6.0,"Parte de mi equipo en pokemon ruby omega");
        pokedex.crearPokedex("Migthyena",29,"Parte de mi equipo en pokemon ruby omega");
        pokedex.crearPokedex("Whismur",2.0,"Primera evolución de uno de los pokemon de mi equipo de ruby omega");
        pokedex.crearPokedex("Pikachu",6,"Sobre valorado");
        pokedex.crearPokedex("Electrode",2,"Copia pirata de Voltorb");
        pokedex.crearPokedex("Latios",190,"Mi primer legendario o semi-legendario no se xd");
        pokedex.crearPokedex("Peliper",6.0,"Pajaro, lo echo de menos");
        pokedex.crearPokedex("Groudon",950.0,"Lo mate sin querer queriendo , porque era pequeño y no se me ocurrio capturarlo");


        // adestrador 1 pokemon
        pokemon.crearPokemon("Sceptile",new java.util.Date(2018-1-2),1,1);
        pokemon.crearPokemon("Treeko",new java.util.Date(2018-8-1),2,1);
        pokemon.crearPokemon("Grovyle",new java.util.Date(2017-2-5),3,1);
        pokemon.crearPokemon("Voltob",new java.util.Date(5678-12-1),4,1);
        pokemon.crearPokemon("Wingull",new java.util.Date(1231-12-4),5,1);

        //adestrador 2 pokemon
        pokemon.crearPokemon("Migthyena",new java.util.Date(2018-1-2),6,2);
        pokemon.crearPokemon("Whismur",new java.util.Date(2018-1-2),7,2);
        pokemon.crearPokemon("Pikachu",new java.util.Date(2018-1-2),8,2);
        pokemon.crearPokemon("Electrode",new java.util.Date(2018-1-2),9,2);
        pokemon.crearPokemon("Latios",new java.util.Date(2018-1-2),10,2);

        System.out.println("____________________");
        for(PokemonModel pokemonModel: pokemon.listarPokemon()){
            System.out.println(pokemonModel);
        }
        System.out.println("____________________");
        for(PokedexModel pokedexModel: pokedex.listarPokedex()){
            System.out.println(pokedexModel);
        }

        System.out.println("____________________");
        for (AdestradorModel adestradorModel: adestrador.listarAdestrador()){
            System.out.println(adestradorModel);
        }
        System.out.println("____________________");

        // Serialización

        Serial.serializar(pokedex.leerPokedex(1));

        ArrayList<PokedexModel>pokedexModels = Serial.deserializar();
        for(PokedexModel p : pokedexModels){
            System.out.println(p);
        }

    }



}
