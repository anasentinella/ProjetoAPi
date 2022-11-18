package com.example.ProjetoJavaAPi.Repository;

import com.example.ProjetoJavaAPi.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    public List<Produto> findBycodigo(int codigo);
    public List<Produto> findByPreco (double preco);
    public List<Produto> findByMarca (String marca);

    /* public List<Produto> findByDescricao(String descricao);*/

    @Query (value = "Select a from Produto a Where a.marca like %?1%")
    public List<Produto>findByInicialMarca(String marca);
    @Query("SELECT p FROM Produto p WHERE p.descricao like %?1%")
    List<Produto> findByInicialDescr(String descricao);
    @Query (value = "Select a from Produto a Where a.preco >  ?1")
    public List<Produto> findByPrecoMaior (double preco);

    @Query (value = "Select a from Produto a Where a.preco <  ?1")
    public List<Produto> findByPrecoMenor (double preco);

    @Query("SELECT p FROM Produto p WHERE p.descricao like %?1% and p.marca like %?2%")
    List<Produto> findByDescrMarca(String descricao, String marca);

    @Query("SELECT p FROM Produto p WHERE p.descricao like %?1% and p.preco < ?2")
    List<Produto> findByDescrPrecoMenor(String descricao, double preco);


}
