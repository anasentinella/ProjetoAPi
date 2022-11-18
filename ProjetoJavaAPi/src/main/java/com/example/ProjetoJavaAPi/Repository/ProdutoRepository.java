package com.example.ProjetoJavaAPi.Repository;

import com.example.ProjetoJavaAPi.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    public List<Produto> findBycodigo(int codigo);
    public List<Produto> findByPreco (double preco);
    public List<Produto> findByMarca (String marca);
    public List<Produto> findByDescricao(String descricao);

    @Query (value = "Select p From Produto p Where p.marca like %?1%")
    public List<Produto>findByLetras(String marca);

    @Query (value = "Select p From Produto p Where p.preco >  ?1")
    public List<Produto> findByPrecoMaior (double preco);

    @Query (value = "Select p From Produto p Where p.preco <  ?1")
    public List<Produto> findByPrecoMenor (double preco);

   // @Query (value = "SELECT p FROM Produto p WHERE p.descr LIKE %?1% AND p.marca LIKE %?2%")
    //List<Produto> findByDescriMarca(String descr, String marca);


    //  @Query (value="SELECT p FROM Produto p WHERE p.descr like ?1%")
   // public List<Produto> findByInicialDescr(String descr);


    @Query("SELECT p FROM Produto p where p.descr LIKE %?1% AND p.preco < ?2")
    List<Produto> findByDescriPrecoMenor(String descr, double preco);


}
