package com.example.demo.Repository;

import com.example.demo.Model.Cliente;
import com.example.demo.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto,Integer> {

    public List<Produto> findBycodigo(int codigo);
    public List<Produto> findByPreco (double preco);
    public List<Produto> findByMarca (String marca);
    public List<Produto> findByDescr (String descricao);

    @Query (value = "Select a from Produto a Where a.descr like %?1%")
    public List<Produto>findByLetra(String descricao);

    @Query (value = "Select a from Produto a Where a.marca like %?1%")
    public List<Produto>findByLetras(String marca);

    @Query (value = "Select a from Produto a Where a.preco >  ?1")
    public List<Produto> findByPrecoMaior (double preco);

    @Query (value = "Select a from Produto a Where a.preco <  ?1")
    public List<Produto> findByPrecoMenor (double preco);

    @Query (value="select a.nome from Produto a where a.desc > %?1% and a.marca like %?2%")
    public List<Produto>findByDescriMarca(String descricao,String marca);

    @Query (value="select a.nome from Produto a where a.desc > %?1% and a.preco < ?2")
    public List<Produto>findByDescriPreco(String descricao,double preco);
}
