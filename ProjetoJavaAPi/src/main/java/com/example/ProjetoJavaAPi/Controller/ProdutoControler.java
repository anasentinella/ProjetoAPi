package com.example.ProjetoJavaAPi.Controller;

import com.example.ProjetoJavaAPi.Model.Produto;
import com.example.ProjetoJavaAPi.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiProduto")
public class ProdutoControler {
    @Autowired
    ProdutoRepository prRepo;

    @GetMapping("/todos")
    public List<Produto> buscartodos() {
        return prRepo.findAll();
    }
    //http://localhost:8080/apiProduto/todos
    @PostMapping("/inserir")
    public void inserirProduto(@RequestBody Produto pr) {
        prRepo.save(pr);
    }
    //http://localhost:8080/apiProduto/inserir
    @DeleteMapping("/remover")
    public void deletarProduto(@RequestBody Produto pr) {
        prRepo.delete(pr);
    }
    //http://localhost:8080/apiProduto/remover
    @PutMapping("/atualizar")
    public void AtualizarProduto(@RequestBody Produto pr) {
        prRepo.save(pr);
    }
    //http://localhost:8080/apiProduto/atualizar
    @GetMapping("/codigo/{codigo}")
    public List<Produto> buscaporNome(@PathVariable(name = "codigo") int codigo) {
        return prRepo.findBycodigo(codigo);
    }
    //http://localhost:8080/apiProduto/codigo/{codigo}
    @GetMapping("/preco/{preco}")
    public List<Produto> buscarporPreco(@PathVariable(name = "preco") Double preco) {
        return prRepo.findByPreco(preco);
    }
    //http://localhost:8080/apiProduto/preco/{preco}
    @GetMapping("/descricao/{descricao}")
    public List<Produto> buscarporDescricao(@PathVariable(name = "descricao") String descricao) {
        return prRepo.findByDescricao(descricao);
    }
    //http://localhost:8080/apiProduto/descricao/{descricao}
    @GetMapping("/marca/{marca}")
    public List<Produto> buscarporMarca(@PathVariable(name = "marca") String marca) {
        return prRepo.findByMarca(marca);
    }
    //http://localhost:8080/apiProduto/marca/{marca}


   // @GetMapping (value="/DescrEspecial/{descr}")
    //public List<Produto> buscaPorInicialDescr
      //      (@PathVariable (value="descr") String descr) {
       // return prRepo.findByInicialDescr(descr);
   // }
    //http://localhost:8080/apiProduto/DescrEspecial/{marca}

    @GetMapping("/marcaEspecial/{marca}")
    public List<Produto> findByLetra(@PathVariable(name = "marca") String marca) {

        return prRepo.findByLetras(marca);
    }
    //http://localhost:8080/apiProduto/marcaEspecial/{marca}
    @GetMapping("/precoMaior/{preco}")
    public List<Produto> findByPrecomaior(@PathVariable(name = "preco") double preco) {
        return prRepo.findByPrecoMaior(preco);
    }
    //http://localhost:8080/apiProduto/precoMaior/{preco}
    @GetMapping("/precoMenor/{preco}")
    public List<Produto> findByPrecomenor(@PathVariable(name = "preco") double preco) {
        return prRepo.findByPrecoMenor(preco);
    }
    //http://localhost:8080/apiProduto/precoMenor/{preco}
    //@GetMapping (value="/descrMarca/{descr}/{marca}")
   // public List<Produto> buscaDescriMarca
   // (@PathVariable (value="descr") String descr,
    // @PathVariable (value="marca") String marca) {
    //    return prRepo.findByDescriMarca(descr, marca);
    //}

  //  @GetMapping (value="/descrPreco/{descr}/{preco}")
  //  public  List<Produto> buscaDescriPrecoMenor
   //         (@PathVariable (value="descr") String descr,
    //         @PathVariable (value="preco") double preco) {
    //    return prRepo.findByDescriPrecoMenor(descr, preco);
   // }
//http://localhost:8080/apiProduto/descrPreco/{descr}/{preco}


}
