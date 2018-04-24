package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Claudinei 19/04/2018 20:37
 */
public class TestePersistirEstado {

    public static void main(String[] args) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        // OBJETO
        Estado estado = new Estado();
        estado.setNome("Piaui");
        estado.setUf("PI");
        estado.setPais(em.find(Pais.class, 1));

        // TRANSAÇÃO
        em.getTransaction().begin();
        em.persist(estado);
        em.getTransaction().commit();

        em.close();
        //emf.close();

    }

}
