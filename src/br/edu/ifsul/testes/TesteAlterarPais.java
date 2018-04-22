package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Claudinei
 * 19/04/2018 21:47
 */
public class TesteAlterarPais {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULPU");
        
        EntityManager em = emf.createEntityManager();
        
        // TRANSAÇÃO
        em.getTransaction().begin();
        Pais pais = em.find(Pais.class, 2);
        pais.setNome("Argentina");
        pais.setIso("ARG");
        em.merge(pais);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
}
