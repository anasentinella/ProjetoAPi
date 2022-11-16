package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProdutoJavaProj")
public class Produto {
    @Id
    @Column
    private int codigo;
    @Column
    private String descricao;
    @Column
    private String marca;

    public int codigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String descricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String marca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double preco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    private Double preco;
}
