package com.example.demo.Controller;

import com.example.demo.Model.Cliente;
import com.example.demo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiCliente")
public class ClienteControler {
    @Autowired
    ClienteRepository clRepo;

    @GetMapping("/todos")
    public List<Cliente> buscartodos() {
        return clRepo.findAll();
    }

    @PostMapping("/inserir")
    public void inserirCliente(@RequestBody Cliente cl) {
        clRepo.save(cl);
    }

    @DeleteMapping("/remover")
    public void deletarCliente(@RequestBody Cliente cl) {
        clRepo.delete(cl);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente cl) {
        clRepo.save(cl);
    }

    @GetMapping("/codigo/{codigo}")
    public List<Cliente> buscarporCodigo(@PathVariable(name = "codigo") int codigo) {
        return clRepo.findBycodigo(codigo);
    }

    @GetMapping("/nome/{nome}")
    public List<Cliente> buscarporNome(@PathVariable(name = "nome") String nome ) {
        return clRepo.findByNome(nome);
    }

    @GetMapping("/email/{email}")
    public List<Cliente> buscarporEmail(@PathVariable(name = "email") String email) {
        return clRepo.findByEmail(email);
    }

    @GetMapping("/nomeEspecial/{nome}")
    public List<Cliente> findByLetras(@PathVariable(name = "nome") String nome) {
        return clRepo.findByLetra(nome);
    }

    @GetMapping("/CodigoMAior/{codigo}")
    public List<Cliente> findByCodigomaior(@PathVariable(name = "codigo") int codigo) {
        return clRepo.findByCodMaior(codigo);
    }

    @GetMapping("/EmailEspecial/{email}")
    public List<Cliente> findByEmailInicial(@PathVariable(name = "email") String email) {
        return clRepo.findByEmailLetras(email);
    }
    @GetMapping("/NomeEmail/{nome}/{email}")
    public List<Cliente> findByEmailNome(@PathVariable (value="email") String email,
                                         @PathVariable (value="nome") String nome) {
        return clRepo.findByNomeEmmail(nome,email);
    }


}
