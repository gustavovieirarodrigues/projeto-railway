package com.gerenciadordetelefone.Principal.Service;

import com.gerenciadordetelefone.Principal.Model.UsuarioModel;
import com.gerenciadordetelefone.Principal.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoasRepository pessoasRepository;

    public List<UsuarioModel> findAll() {
        return pessoasRepository.findAll();
    }
    public void criarPessoa(UsuarioModel novaPessoa) {
        pessoasRepository.save(novaPessoa);
    }

    public void deletarPessoa(Long id) {
        pessoasRepository.deleteById(id);
    }

    public UsuarioModel encontrarPorId(Long id) {
        return pessoasRepository.findById(id).orElse(null);
    }

    public void atualizarPessoa(UsuarioModel pessoaAtualizada) {
        Optional<UsuarioModel> pessoaExistente = pessoasRepository.findById(pessoaAtualizada.getId());

        pessoaExistente.ifPresent(p -> {
            p.setNome(pessoaAtualizada.getNome());
            p.setSobrenome(pessoaAtualizada.getSobrenome());
            p.setEmail(pessoaAtualizada.getEmail());
            p.setEstado(pessoaAtualizada.getEstado());

            pessoasRepository.save(p);
        });
    }


}
