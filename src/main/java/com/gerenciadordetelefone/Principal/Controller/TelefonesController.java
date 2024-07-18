package com.gerenciadordetelefone.Principal.Controller;

import com.gerenciadordetelefone.Principal.Model.TelefoneModel;
import com.gerenciadordetelefone.Principal.Model.UsuarioModel;
import com.gerenciadordetelefone.Principal.Service.PessoaService;
import com.gerenciadordetelefone.Principal.Service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TelefonesController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping("/telefone")
    public String showTelefoneForm(Model model) {
        List<UsuarioModel> pessoas = pessoaService.findAll();
        model.addAttribute("pessoas", pessoas);
        model.addAttribute("telefone", new TelefoneModel());
        return "telefone";
    }

    @PostMapping("/telefone")
    public String saveTelefone(@ModelAttribute TelefoneModel telefone, Model model) {
        telefoneService.save(telefone);
        return "redirect:/";
    }
}
