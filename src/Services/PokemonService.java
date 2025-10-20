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

    public PokemonModel leerPokemon(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(PokemonModel.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao ler o pokemon: " + e.getMessage());
            return null;
        }
    }

    public void actualizarPokemon(PokemonModel pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(pokemon);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao actualiza-lo pokemon: " + e.getMessage());
        }
    }

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

    public List<PokemonModel> listarPokemon() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Gatos", PokemonModel.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-los gatos: " + e.getMessage());
            return null;
        }
    }
}
