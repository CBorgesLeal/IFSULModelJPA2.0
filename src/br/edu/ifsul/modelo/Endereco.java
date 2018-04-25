package br.edu.ifsul.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Claudinei
 */
@Entity
@Table(name = "endereco")
public class Endereco {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "O apelido deve ser informado")
    @Length(max = 20, message = "O apelido não deve ter mais de {max} caracteres")
    @NotNull(message = "O apelido não pode ser nulo")
    @Column(name = "apelido", length = 20, nullable = false)
    private String nickname;
    
    @NotBlank(message = "O endereco deve ser informado")
    @Length(max = 50, message = "O endereco não deve ter mais de {max} caracteres")
    @NotNull(message = "O endereco não pode ser nulo")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    
    @NotBlank(message = "O numero deve ser informado")
    @Length(max = 10, message = "O numero não deve ter mais de {max} caracteres")
    @NotNull(message = "O numero não pode ser nulo")
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;
    
    @Length(max = 50, message = "O complemento não deve ter mais de {max} caracteres")
    @Column(name = "complemento", length = 50)
    private String complemento;
    
    @NotBlank(message = "O CEP deve ser informado")
    @Length(max = 10, message = "O CEP não deve ter mais de {max} caracteres")
    @NotNull(message = "O CEP não pode ser nulo")
    @Column(name = "cep", length = 10, nullable = false)
    private String cep;
    
    @NotBlank(message = "O bairro deve ser informado")
    @Length(max = 30, message = "O bairro não deve ter mais de {max} caracteres")
    @NotNull(message = "O bairro não pode ser nulo")
    @Column(name = "bairro", length = 30, nullable = false)
    private String bairro;
    
    @Length(max = 50, message = "A referência não deve ter mais de {max} caracteres")
    @Column(name = "referencia", length = 50)
    private String referencia;
    
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ForeignKey(name = "fk_pessoa_id")
    private Pessoa pessoa;    
    
    @NotNull(message = "O tipo de endereco deve ser informado")
    @ManyToOne
    @JoinColumn(name = "tipo_endereco_id", referencedColumnName = "id")
    @ForeignKey(name = "fk_tipo_endereco_id")
    private TipoEndereco tipoEndereco;    
    
    @NotNull(message = "A cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    @ForeignKey(name = "fk_cidade_id")
    private Cidade cidade;
    
    public Endereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }   

    
}
