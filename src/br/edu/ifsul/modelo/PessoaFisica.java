package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Claudinei
 */
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {
    
    @Length(min = 3, max = 20, message = "O RG não pode ter mais de {max} caracteres")
    @NotBlank(message = "O RG deve ser informado")
    @NotNull(message = "O RG não pode ser nulo")
    @Column(name = "rg", length = 20, nullable = false)
    private String rg;
    
    @Length(min = 3, max = 14, message = "O CPF não pode ter mais de {max} caracteres")
    @NotBlank(message = "O CPF deve ser informado")
    @NotNull(message = "O CPF não pode ser nulo")
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    
    @NotNull(message = "O nascimento não pode ser nulo")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @Length(min = 3, max = 50, message = "O usuário não pode ter mais de {max} caracteres")
    @NotBlank(message = "O usuário deve ser informado")
    @NotNull(message = "O usuário não pode ser nulo")
    @Column(name = "usuario", length = 50, nullable = false, unique = true)
    private String nomeUsuario;
    
    @Length(min = 3, max = 50, message = "A senha não pode ter mais de {max} caracteres")
    @NotBlank(message = "A senha deve ser informada")
    @NotNull(message = "A senha não pode ser nula")
    @Column(name = "senha", length = 50, nullable = false)
    private String senha;

    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
            
}
