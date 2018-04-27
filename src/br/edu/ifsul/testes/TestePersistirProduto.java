package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;

/**
 *
 * @author Claudinei
 */
public class TestePersistirProduto {
    
    public static void main(String[] args) {
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        PessoaFisica pf = em.find(PessoaFisica.class, 1);
            
            Produto p = em.find(Produto.class, 1);
            
            pf.getDesejos().add(p);
            
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        
        em.close();
        
    }
    
}
