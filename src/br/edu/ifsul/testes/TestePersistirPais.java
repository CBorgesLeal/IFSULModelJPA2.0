package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;

/**
 *
 * @author Claudinei 
 * 19/04/2018 20:37
 */
public class TestePersistirPais {

    public static void main(String[] args) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        // OBJETO
        Pais p = new Pais();
        p.setNome("Brasil");
        p.setIso("BRA");

        // TRANSAÇÃO
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        em.close();

    }

}
