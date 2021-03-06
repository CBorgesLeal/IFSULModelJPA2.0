package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.PessoaFisica;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
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
            pf.setCpf("335.427.408-53");
            pf.setEmail("cbleal@bol.com.br");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Raimundo de Souza Leal");
            pf.setNomeUsuario("rsleal");
            pf.setRg("9501358");
            pf.setSenha("jj38kl");
            pf.setTelefone("(89)99976-4587");
            
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
