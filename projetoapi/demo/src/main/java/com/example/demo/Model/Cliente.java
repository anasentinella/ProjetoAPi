package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClienteJavaProj")
public class Cliente {
    @Id
    @Column
    private int codigo;
    @Column
    private String nome;
    @Column
    private String email;

    public int codigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String nome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
