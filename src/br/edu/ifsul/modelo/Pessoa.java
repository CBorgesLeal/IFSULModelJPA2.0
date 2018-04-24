package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Claudinei
 */
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Length(min = 3, max = 50, message = "O nome não pode ter mais de {max} caracteres")
    @NotBlank(message = "O nome deve ser informado")
    @NotNull(message = "O nome não pode ser nulo")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Length(min = 3, max = 14, message = "O telefone não pode ter mais de {max} caracteres")
    @NotBlank(message = "O telefone deve ser informado")
    @NotNull(message = "O telefone não pode ser nulo")
    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;
    
    @Length(min = 3, max = 50, message = "O email não pode ter mais de {max} caracteres")
    @NotBlank(message = "O email deve ser informado")
    @NotNull(message = "O email não pode ser nulo")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    public Pessoa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
            
}
