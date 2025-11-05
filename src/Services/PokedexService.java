package Services;

import Config.HibernateConfig;
import Model.PokedexModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class PokedexService implements Serializable {

    /**
     * Crea pokedex
     * @param nome nombre para pokedex
     * @param peso peso de cada pokemon de la pokedex
     * @param misc descripcion
     */
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

    /**
     * Lee pokedexs en base a su id
     * @param id del pokedex
     * @return los datos del pokedex
     */
    public PokedexModel leerPokedex(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(PokedexModel.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao ler o pokedex: " + e.getMessage());
            return null;
        }
    }

    /**
     * Actualiza los datos de una pokedex con base en su id
     * @param id del pokedex 
     * @param nuevoNombre  de la pokedex
     * @param nuevoPeso de la pokedex
     * @param nuevoMisc de la pokedex
     */
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

    /**
     *  Elimina la pokedex con un id específico
     * @param id de la pokedex a borrar
     */
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

    /**
     * Lista todas las pokedex
     * @return una lista de todos los valores de la pokedex
     */
    public List<PokedexModel> listarPokedex() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from PokedexModel", PokedexModel.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-las pokedex: " + e.getMessage());
            return null;
        }
    }
}
