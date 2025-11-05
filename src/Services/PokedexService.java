package Services;

import Config.HibernateConfig;
import Model.PokedexModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class PokedexService implements Serializable {

    public void crearPokedex(String nome, double peso, String misc ) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            PokedexModel pokedexModel = new PokedexModel();
            pokedexModel.setNome(nome);
            pokedexModel.setMisc(misc);
            pokedexModel.setPeso(peso);
            session.save(pokedexModel);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao crea-lo pokedex: " + e.getMessage());
        }
    }

    public PokedexModel leerPokedex(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(PokedexModel.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao ler o pokedex: " + e.getMessage());
            return null;
        }
    }

    public void actualizarCamposPokedex(int id, String nuevoNombre, double nuevoPeso, String nuevoMisc) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Obtener la entrada específica por ID
            PokedexModel pokedex = session.get(PokedexModel.class, id);

            // Cambiar solo los campos que quieres
            if (pokedex != null) {
                pokedex.setNome(nuevoNombre);
                pokedex.setPeso(nuevoPeso);
                pokedex.setMisc(nuevoMisc);
                // Hibernate detectará los cambios y actualizará solo esos campos
                session.update(pokedex);
            }

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al actualizar la pokedex: " + e.getMessage());
        }
    }

    public void eliminarPokedex(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            PokedexModel pokedexModel = session.get(PokedexModel.class, id);
            if (pokedexModel != null) {
                session.delete(pokedexModel);
            } else {
                System.out.println("non se atopou o pokedex");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Non quero eliminar ningunha pokedex Y.Y: " + e.getMessage());
        }
    }

    public List<PokedexModel> listarPokedex() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from PokedexModel", PokedexModel.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-las pokedex: " + e.getMessage());
            return null;
        }
    }
}
