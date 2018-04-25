package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * MAPEAMENTO DE HERANÇA
 * @author Claudinei 
 * 24/04/2018 19:44
 */
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable {

    @Length(min = 5, max = 20, message = "A IE não pode ter mais de {max} caracteres")
    @NotBlank(message = "A IE deve ser informada")
    @NotNull(message = "A IE não pode ser nula")
    @Column(name = "ie", length = 20, nullable = false)
    private String ie;
    
    @Length(min = 18, max = 18, message = "O CNPJ não pode ter mais de {max} caracteres")
    @NotBlank(message = "O CNPJ deve ser informado")
    @NotNull(message = "O CNPJ não pode ser nulo")
    @Column(name = "cnpj", length = 18, nullable = false)
    private String cnpj;

    public PessoaJuridica() {
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
        
}
