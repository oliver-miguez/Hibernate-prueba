import Model.AdestradorModel;
import Model.PokedexModel;
import Model.PokemonModel;
import Services.AdestradorService;
import Services.PokedexService;
import Services.PokemonService;

import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //INSTANCIA DE SERVICIOS
        AdestradorService adestrador = new AdestradorService();
        PokedexService pokedex = new PokedexService();
        PokemonService pokemon = new PokemonService();

        /*
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

        // adestrador 1 pokemon
        pokemon.crearPokemon("Sceptile",new java.util.Date(2018-1-2),1,1);
        pokemon.crearPokemon("Treeko",new java.util.Date(2018-8-1),2,1);
        pokemon.crearPokemon("Grovyle",new java.util.Date(2017-2-5),3,1);
        pokemon.crearPokemon("Latios",new java.util.Date(1890-2-9),4,1);
        pokemon.crearPokemon("Peliper", new java.util.Date(1769-9-6),9,1);
        pokemon.crearPokemon("Absol",new java.util.Date(2020-3-5),11,1);

        //adestrador 2 pokemon
        pokemon.crearPokemon("Voltorb",new java.util.Date(1790-2-6),5,2);
        pokemon.crearPokemon("Electrode",new java.util.Date(1750-4-5),6,2);
        pokemon.crearPokemon("Mightyena",new java.util.Date(1900-6-12),7,2);
        pokemon.crearPokemon("Wingull",new java.util.Date(1980-1-5),8,2);
        pokemon.crearPokemon("whismur",new java.util.Date(2001-8-15),10,2);
        pokemon.crearPokemon("Pikachu",new java.util.Date(2002-3-3),12,2);
*/
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


    }



}
