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

    @PostMapping("/inserir")
    public void inserirProduto(@RequestBody Produto pr) {
        prRepo.save(pr);
    }

    @DeleteMapping("/remover")
    public void deletarProduto(@RequestBody Produto pr) {
        prRepo.delete(pr);
    }

    @PutMapping("/atualizar")
    public void AtualizarProduto(@RequestBody Produto pr) {
        prRepo.save(pr);
    }

    @GetMapping("/codigo/{codigo}")
    public List<Produto> buscaporNome(@PathVariable(name = "codigo") int codigo) {
        return prRepo.findBycodigo(codigo);
    }

    @GetMapping("/preco/{preco}")
    public List<Produto> buscarporPreco(@PathVariable(name = "preco") Double preco) {
        return prRepo.findByPreco(preco);
    }
    @GetMapping("/descricao/{descricao}")
    public List<Produto> buscarporDescricao(@PathVariable(name = "descricao") String descricao) {
        return prRepo.findByDescricao(descricao);
    }

    @GetMapping("/marca/{marca}")
    public List<Produto> buscarporMarca(@PathVariable(name = "marca") String marca) {
        return prRepo.findByMarca(marca);
    }

    @GetMapping("/marcaEspecial/{marca}")
    public List<Produto> findByLetra(@PathVariable(name = "marca") String marca) {

        return prRepo.findByLetras(marca);
    }

    @GetMapping("/precoMaior/{preco}")
    public List<Produto> findByPrecomaior(@PathVariable(name = "preco") double preco) {
        return prRepo.findByPrecoMaior(preco);
    }
    @GetMapping("/precoMenor/{preco}")
    public List<Produto> findByPrecomenor(@PathVariable(name = "preco") double preco) {
        return prRepo.findByPrecoMenor(preco);
    }

    @GetMapping("/DescriMarca/{descricao}/{marca}")
    public List<Produto> findByDescrMarca(@PathVariable(value = "descricao") String descricao,
                                          @PathVariable(value = "marca") String marca) {
        return prRepo.findByDescriMarca(descricao, marca);
    }



}
