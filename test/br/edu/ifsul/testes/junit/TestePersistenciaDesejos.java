package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Claudinei
 */
public class TestePersistenciaDesejos {
    
    EntityManager em;
    
    public TestePersistenciaDesejos() {
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
            
            PessoaFisica pf = em.find(PessoaFisica.class, 1);
            
            Produto p = em.find(Produto.class, 1);
            
            pf.getDesejos().add(p);
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        
        Assert.assertEquals(false, exception);
        
    }
    
}
