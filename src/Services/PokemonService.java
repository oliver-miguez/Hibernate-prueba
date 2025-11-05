package Services;

import Config.HibernateConfig;
import Model.AdestradorModel;
import Model.PokedexModel;
import Model.PokemonModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class PokemonService {
    /**
     * Crea un pokemon con estos datos
     * @param nome nombre del pokemon
     * @param nacemento fecha de nacimiento del pokemon
     * @param pokedexentry numero de pokedex
     * @param adestrador adestrador del pokemon
     */
    public void crearPokemon(String nome, Date nacemento, int pokedexentry, int adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            PokemonModel pokemonModel = new PokemonModel();

            AdestradorModel adestradorModel = new AdestradorService().lerAdestrador(adestrador);
            PokedexModel pokedexModel = new PokedexService().leerPokedex(pokedexentry);

            pokemonModel.setNome(nome);
            pokemonModel.setNacemento(nacemento);
            pokemonModel.setPokedexentry(pokedexModel);
            pokemonModel.setAdestrador(adestradorModel);
            session.save(pokemonModel);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao crea-lo pokemon: " + e.getMessage());
        }
    }

    /**
     * Lee el pokemon según el id
     * @param id del pokemon
     * @return los valores del pokemon que se lee
     */
    public PokemonModel leerPokemon(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(PokemonModel.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao ler o pokemon: " + e.getMessage());
            return null;
        }
    }

    /**
     * Actualiza un pokemon
     * @param id el pokemon a actualizar
     * @param novoNome novo nome
     * @param novoNacemento nova fecha de nacemento
     */
    public void actualizarPokemon(int id,String novoNome, Date novoNacemento) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

                // Obtener la entrada específica por ID
            PokemonModel pokemon = session.get(PokemonModel.class, id);

            if (pokemon != null) {
                pokemon.setNome(novoNome);
                pokemon.setNacemento(novoNacemento);
                session.update(pokemon);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao actualiza-lo pokemon: " + e.getMessage());
        }
    }

    /**
     * Elimina el pokemon según su id
     * @param id del pokemon
     */
    public void eliminarPokemon(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            PokemonModel pokemonModel = session.get(PokemonModel.class, id);
            if (pokemonModel != null) {
                session.delete(pokemonModel);
            } else {
                System.out.println("non se atopou o pokemon");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Non quero eliminar ningunha pokemon Y.Y: " + e.getMessage());
        }
    }

    /**
     * Lista todos los pokemon
     * @return una lista de todos lo pokemon
     */
    public List<PokemonModel> listarPokemon() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from PokemonModel", PokemonModel.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-los pokemons: " + e.getMessage());
            return null;
        }
    }
}
