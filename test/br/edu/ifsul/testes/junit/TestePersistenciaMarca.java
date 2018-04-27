package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Marca;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Claudinei
 */
public class TestePersistenciaMarca {
    
    EntityManager em;
    
    public TestePersistenciaMarca() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste() {
        boolean exception = false;
        try {
            Marca m = new Marca();
            m.setNome("Brother");
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        Assert.assertEquals(false, exception);
    }
    
}
