package com.example.ProjetoJavaAPi.Repository;

import com.example.ProjetoJavaAPi.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CLiRepository  extends JpaRepository<Cliente, Integer> {

    public List<Cliente> findBycodigo(int codigo);
    public List<Cliente> findByNome (String nome);
    public List<Cliente> findByEmail (String email);

    @Query(value = "Select c From Cliente c Where c.nome like %?1%")
    public List<Cliente>findByLetra(String nome);

    @Query (value = "Select c From Cliente c Where c.codigo >  ?1")
    public List<Cliente> findByCodMaior (int codigo);

    @Query (value = "Select c From Cliente c Where c.email like %?1%")
    public List<Cliente>findByEmailLetras(String email);

    @Query (value="SELECT c FROM Cliente c WHERE c.nome LIKE ?1% AND c.email LIKE ?2%")
    List<Cliente> findByInicialNomeEmail(String nome, String email);



}