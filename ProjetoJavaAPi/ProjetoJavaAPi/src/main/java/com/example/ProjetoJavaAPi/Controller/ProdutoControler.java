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

    @GetMapping("/buscarDescr/{descricao}")
    public List<Produto> buscarInicialDescricao(@PathVariable("descricao") String descricao) {
        return prRepo.findByInicialDescr(descricao);
    }

    @GetMapping("/marca/{marca}")
    public List<Produto> buscarporMarca(@PathVariable(name = "marca") String marca) {
        return prRepo.findByMarca(marca);
    }

    @GetMapping("/marcaEspecial/{marca}")
    public List<Produto> findByLetra(@PathVariable(name = "marca") String marca) {

        return prRepo.findByInicialMarca(marca);
    }

    @GetMapping("/precoMaior/{preco}")
    public List<Produto> findByPrecomaior(@PathVariable(name = "preco") double preco) {
        return prRepo.findByPrecoMaior(preco);
    }
    @GetMapping("/precoMenor/{preco}")
    public List<Produto> findByPrecomenor(@PathVariable(name = "preco") double preco) {
        return prRepo.findByPrecoMenor(preco);
    }

    @GetMapping("/DescrMarca/{descricao}/{marca}")
    public List<Produto> buscarParteDescricaoMarca(@PathVariable("descricao") String descricao, @PathVariable("marca") String marca) {
        return prRepo.findByDescrMarca(descricao, marca);
    }
    @GetMapping("/buscarDescrPrecoMenor/{descricao}/{preco}")
    public List<Produto> buscarParteDescricaoPrecoMenorQue(@PathVariable("descricao") String descricao, @PathVariable("preco") double preco) {
        return prRepo.findByDescrPrecoMenor(descricao, preco);
    }


}
