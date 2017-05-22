package br.com.arenagaming.model.connection;

import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class ConnectionTest {

    private final EntityManager entityManager;

    public ConnectionTest() {
        entityManager = DBConnection.newInstance().getEntityManager();
    }

    @Test
    public void hasNotNullEntityManager() {
        Assert.assertNotNull(entityManager);
    }

    @Test
    public void hasValidEntityManager() {
        Assert.assertTrue(entityManager.isOpen());
    }
}
