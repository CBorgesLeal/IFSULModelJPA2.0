package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Endereco;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.TipoEndereco;
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
public class TestePersistenciaEndereco {
    
    EntityManager em;
    
    public TestePersistenciaEndereco() {
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
            
            Endereco e = new Endereco();
            e.setBairro("São Sebastião");
            e.setCep("64.600-356");
            e.setCidade(em.find(Cidade.class, 1));
            e.setComplemento("");
            e.setEndereco("Rua Veneza");
            e.setNickname("Casa");
            e.setNumero("679");
            e.setReferencia("Ao lado do SINTE");
            e.setTipoEndereco(em.find(TipoEndereco.class, 2));
            
            pf.addEndereco(e);          
            
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
