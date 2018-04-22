package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Claudinei
 * 19/04/2018 20:37
 */
public class TestePersistirPais {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULPU");
        
        EntityManager em = emf.createEntityManager();
        
        // OBJETO
        Pais pais = new Pais();
        pais.setNome("Argentina");
        pais.setIso("ARG");

        // TRANSAÇÃO
        em.getTransaction().begin();
        em.persist(pais);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
}
