package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.PessoaJuridica;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Claudinei
 * 24/04/2018 19:53
 */
public class TestePersistenciaPessoaJuridica {
    
    EntityManager em;
    
    public TestePersistenciaPessoaJuridica() {
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
            
            PessoaJuridica pj = new PessoaJuridica();
            pj.setCnpj("04.540.560/0001-90");
            pj.setEmail("micropoint_inf@hotmail.com");
            pj.setIe("19.448.010-0");
            pj.setNome("Micropoint Informatica");
            pj.setTelefone("(89) 3422-3388");
            
            em.getTransaction().begin();
            em.persist(pj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        
        Assert.assertEquals(false, exception);
    }
    
}
