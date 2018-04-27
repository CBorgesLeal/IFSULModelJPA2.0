package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Claudinei
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", nullable = false)
    private String nome;
    @NotNull(message = "O nome deve ser informado")
    @Column(name = "preco", nullable = false, columnDefinition = "decimal(10,2)")
    private Double preco;
    @NotNull(message = "O nome deve ser informado")
    @Column(name = "qtd", nullable = false, columnDefinition = "decimal(10,2)")
    private Double qtd;    
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    @NotNull(message = "A categoria deve ser informada")
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_categoria")
    private Categoria categoria;
    @NotNull(message = "A marca deve ser informada")
    @ManyToOne
    @JoinColumn(name = "marca_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_marca")
    private Marca marca;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "desejos",
               joinColumns = 
               @JoinColumn(name = "produto", referencedColumnName = "id"),
               inverseJoinColumns = 
               @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id")
              )
    private List<PessoaFisica> desejam = new ArrayList<>();

    public Produto() {
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", nome=" + nome + ", preco=" + preco + ", qtd=" + qtd + ", descricao=" + descricao + ", categoria=" + categoria + ", marca=" + marca + '}';
    }

    public List<PessoaFisica> getDesejam() {
        return desejam;
    }

    public void setDesejam(List<PessoaFisica> desejam) {
        this.desejam = desejam;
    }
                    
    
}
