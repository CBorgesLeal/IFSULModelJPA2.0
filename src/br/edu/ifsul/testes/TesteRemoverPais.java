package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Claudinei
 * 19/04/2018 21:50
 */
public class TesteRemoverPais {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULPU");
        
        EntityManager em = emf.createEntityManager();
        
        // TRANSAÇÃO
        em.getTransaction().begin();
        Pais pais = em.find(Pais.class, 3);
        em.remove(pais);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
}
