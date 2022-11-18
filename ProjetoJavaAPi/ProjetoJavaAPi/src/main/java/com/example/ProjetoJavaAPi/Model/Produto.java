package com.example.ProjetoJavaAPi.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "ProdutoJavaProj")
public class Produto {
    @Id
    @Column
    private int codigo;
    @Column
    private String descricao;
    @Column
    private String marca;
    @Column
    private Double preco;

    public int getcodigop() {
        return codigo;
    }

    public void setCodigop(int codigo) {
        this.codigo = codigo;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getmarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getpreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


}
