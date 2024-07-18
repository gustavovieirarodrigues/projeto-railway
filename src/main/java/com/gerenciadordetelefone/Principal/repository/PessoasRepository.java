package com.gerenciadordetelefone.Principal.repository;

import com.gerenciadordetelefone.Principal.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<UsuarioModel, Long> {
}
