package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Claudinei
 */
public class TestePersistenciaEstado {
    
    EntityManager em;
    
    public TestePersistenciaEstado() {
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
            
            Estado estado = new Estado();
            estado.setNome("São Paulo");
            estado.setUf("SP");
            estado.setPais(em.find(Pais.class, 1));
            
            em.getTransaction().begin();
            em.persist(estado);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            
            exception = true;
            e.printStackTrace();
            em.getTransaction().rollback();
            
        }
        
        Assert.assertEquals(false, exception);
        
    }
    
}
