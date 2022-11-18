package com.example.ProjetoJavaAPi.Controller;




import com.example.ProjetoJavaAPi.Model.Cliente;
import com.example.ProjetoJavaAPi.Repository.CLiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apiCliente")
public class ClienteControler {
    @Autowired
   CLiRepository clRepo;

    @GetMapping("/todos")
    public List<Cliente> buscartodos() {
        return clRepo.findAll();
    }
    //http://localhost:8080/apiCliente/todos
    @PostMapping("/inserir")
    public void inserirCliente(@RequestBody Cliente cl) {
        clRepo.save(cl);
    }
    //http://localhost:8080/apiCliente/inserir
    @DeleteMapping("/remover")
    public void deletarCliente(@RequestBody Cliente cl) {
        clRepo.delete(cl);
    }
    //http://localhost:8080/apiCliente/remover
    @PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente cl) {
        clRepo.save(cl);
    }
    //http://localhost:8080/apiCliente/atualizar
    @GetMapping("/codigo/{codigo}")
    public List<Cliente> buscarporCodigo(@PathVariable(name = "codigo") int codigo) {
        return clRepo.findBycodigo(codigo);
    }
    //http://localhost:8080/apiCliente/codigo/{codigo}
    @GetMapping("/nome/{nome}")
    public List<Cliente> buscarporNome(@PathVariable(name = "nome") String nome ) {
        return clRepo.findByNome(nome);
    }
    //http://localhost:8080/apiCliente/nome/{nome}
    @GetMapping("/email/{email}")
    public List<Cliente> buscarporEmail(@PathVariable(name = "email") String email) {
        return clRepo.findByEmail(email);
    }
    //http://localhost:8080/apiCliente/email/{email}
    @GetMapping("/nomeEspecial/{nome}")
    public List<Cliente> findByLetras(@PathVariable(name = "nome") String nome) {
        return clRepo.findByLetra(nome);
    }
    //http://localhost:8080/apiCliente/nomeEspecial/{nome}
    @GetMapping("/CodigoMAior/{codigo}")
    public List<Cliente> findByCodigomaior(@PathVariable(name = "codigo") int codigo) {
        return clRepo.findByCodMaior(codigo);
    }
    //http://localhost:8080/apiCliente/codigoMAior/{codigo}
    @GetMapping("/EmailEspecial/{email}")
    public List<Cliente> findByEmailInicial(@PathVariable(name = "email") String email) {
        return clRepo.findByEmailLetras(email);
    }
    //http://localhost:8080/apiCliente/EmailEspecial/{email}

    // http://localhost:8080/apiCliente/inicialNomeEmail/Sa/sa
    // FUNCIONAL
    @GetMapping (value="/inicialNomeEmail/{nome}/{email}")
    public List<Cliente> buscaPorInicialNomeEmail
    (@PathVariable (value="nome") String nome,
     @PathVariable (value="email") String email) {
        return clRepo.findByInicialNomeEmail(nome, email);
    }

}
