package com.gerenciadordetelefone.Principal.Service;

import com.gerenciadordetelefone.Principal.Model.TelefoneModel;
import com.gerenciadordetelefone.Principal.Model.UsuarioModel;
import com.gerenciadordetelefone.Principal.repository.TelefoneRepository;
import com.gerenciadordetelefone.Principal.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {
    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private PessoasRepository pessoasRepository;

    public void save(TelefoneModel telefone) {
        telefoneRepository.save(telefone);
    }
    public void adicionarTelefone(Long usuarioId, TelefoneModel telefone) {
        UsuarioModel usuario = pessoasRepository.findById(usuarioId).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        telefone.setUsuario(usuario);
        telefoneRepository.save(telefone);
    }
}
