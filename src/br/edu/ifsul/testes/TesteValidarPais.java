package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Claudinei 19/04/2018 22:15
 */
public class TesteValidarPais {

    public static void main(String[] args) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        Pais pais = new Pais();
        pais.setNome("");
        pais.setIso(""); 

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

    }

}
