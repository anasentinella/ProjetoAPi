package com.example.ProjetoJavaAPi.Repository;

import com.example.ProjetoJavaAPi.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CLiRepository  extends JpaRepository<Cliente, Integer> {

    public List<Cliente> findBycodigo(int codigo);
    public List<Cliente> findByNome (String nome);
    public List<Cliente> findByEmail (String email);

    @Query(value = "Select a from Cliente a Where a.nome like %?1%")
    public List<Cliente>findByLetra(String nome);

    @Query (value = "Select a from Cliente a Where a.codigo >  ?1")
    public List<Cliente> findByCodMaior (int codigo);

    @Query (value = "Select a from Cliente a Where a.email like %?1%")
    public List<Cliente>findByEmailLetras(String email);

    @Query (value="SELECT a from Cliente a where a.nome LIKE ?1% and a.email LIKE ?2%")
    List<Cliente> findByInicialNomeEmail(String nome, String email);



}