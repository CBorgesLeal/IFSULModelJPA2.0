package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Claudinei 19/04/2018 22:15
 */
public class TesteValidarPais {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULPU");

        EntityManager em = emf.createEntityManager();

        // OBJETO
        Pais pais = new Pais();
        // IGNORA OS DADOS A SEREM PERSISTIDOS
        pais.setNome("Teste");
        pais.setIso("ARGE"); 

        // TRANSAÇÃO
        em.getTransaction().begin();

        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validador.validate(pais);

        if (erros.size() > 0) {
            
            for (ConstraintViolation<Pais> erro : erros) {
                System.out.println("Erro: " + erro.getMessage());
            }
            
        } else {
            em.persist(pais);
        }
        
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
