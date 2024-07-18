package com.gerenciadordetelefone.Principal.Controller;

import com.gerenciadordetelefone.Principal.Model.UsuarioModel;
import com.gerenciadordetelefone.Principal.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PessoasController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public String listarPessoas(Model model) {
        List<UsuarioModel> pessoas = pessoaService.findAll();
        model.addAttribute("pessoas", pessoas);
        return "index";
    }

    @GetMapping("/pessoa")
    public String criarPessoaForm(Model model) {
        model.addAttribute("usuario", new UsuarioModel());
        return "criarPessoa";
    }

    @PostMapping("/pessoa")
    public String criarPessoa(@ModelAttribute UsuarioModel novaPessoa) {
        pessoaService.criarPessoa(novaPessoa);
        return "redirect:/";
    }

    @GetMapping("/pessoa/{id}")
    public String editarPessoaForm(@PathVariable Long id, Model model) {
        UsuarioModel pessoa = pessoaService.encontrarPorId(id);
        model.addAttribute("usuario", pessoa);
        return "editarPessoa";
    }

    @PostMapping("/pessoa/{id}")
    public String atualizarPessoa(@PathVariable Long id, @ModelAttribute UsuarioModel pessoaAtualizada) {
        pessoaAtualizada.setId(id);
        pessoaService.atualizarPessoa(pessoaAtualizada);
        return "redirect:/";
    }

    @GetMapping("/pessoa/delete/{id}")
    public String deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
        return "redirect:/";
    }
}
