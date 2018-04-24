package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.PessoaFisica;
import java.util.Calendar;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Claudinei
 */
public class TestePersistenciaPessoaFisica {

    EntityManager em;

    public TestePersistenciaPessoaFisica() {
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
            
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("527.389.143-49");
            pf.setEmail("cborgesleal@gmail.com");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Claudinei Borges Leal");
            pf.setNomeUsuario("borgesleal");
            pf.setRg("1350638 SSPPI");
            pf.setSenha("passw");
            pf.setTelefone("(89) 3422-3388");
            
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
