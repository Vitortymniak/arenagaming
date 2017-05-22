package br.com.arenagaming.model.connection;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fernando
 */
public final class DBConnection implements Serializable {

    private static final String PU = "arenagamingPU";
    private static DBConnection instance;
    private final EntityManagerFactory factory;
    private EntityManager entityManager;

    private DBConnection() {
        factory = Persistence.createEntityManagerFactory(PU);
    }

    public static synchronized DBConnection newInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
}
