package br.edu.ifsul.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Claudinei
 * 22/04/2018 20:57
 */
public class EntityManagerUtil {
    
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;
    
    
    public static EntityManager getEntityManager() {
        
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("IFSULPU");
        }
        
        if (em == null) {
            em = factory.createEntityManager();
        }
        
        return em;
        
    }
    
}
