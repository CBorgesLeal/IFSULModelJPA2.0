package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.TipoEndereco;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Claudinei
 */
public class TestePersistenciaTipoEndereco {

    EntityManager em;

    public TestePersistenciaTipoEndereco() {
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
            
            TipoEndereco te = new TipoEndereco();
            te.setDescricao("Residencial");
            
            em.getTransaction().begin();
            em.persist(te);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }

        Assert.assertEquals(false, exception);

    }

}
