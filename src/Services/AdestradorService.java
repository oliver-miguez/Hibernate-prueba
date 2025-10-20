package Services;

import Config.HibernateConfig;
import Model.AdestradorModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class AdestradorService {

    public void crearAdestrador(String nome, Date nacemento ) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            AdestradorModel adestradorModel = new AdestradorModel();
            adestradorModel.setNacemento(nacemento);
            adestradorModel.setNome(nome);
            session.save(adestradorModel);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao crea-lo adestrador: " + e.getMessage());
        }
    }

    public AdestradorModel lerAdestrador(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(AdestradorModel.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao ler o Adestrador: " + e.getMessage());
            return null;
        }
    }

    public void actualizarAdestrador(int id, String nome, Date nacemento) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            AdestradorModel adestrador = session.get(AdestradorModel.class, id);
            if (adestrador != null) {
                adestrador.setNome(nome);
                adestrador.setNacemento(nacemento);
                session.update(adestrador);
            } else {
                System.out.println("Adestrador non encontrado para actualizar.");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao actualiza-lo Adestrador: " + e.getMessage());
        }
    }

    public void actualizarAdestador(AdestradorModel adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(adestrador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao actualiza-lo adestrador: " + e.getMessage());
        }
    }

    public void eliminarAdestrador(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            AdestradorModel adestradorModel = session.get(AdestradorModel.class, id);
            if (adestradorModel != null) {
                session.delete(adestradorModel);
            } else {
                System.out.println("non se atopou o Adestrador");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Non quero eliminar ningun Adestrador Y.Y: " + e.getMessage());
        }
    }

    public List<AdestradorModel> listarAdestrador() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from AdestradorModel", AdestradorModel.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-los adestradores: " + e.getMessage());
            return null;
        }
    }
}
