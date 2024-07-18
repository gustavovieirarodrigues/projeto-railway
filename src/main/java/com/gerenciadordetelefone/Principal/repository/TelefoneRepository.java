package com.gerenciadordetelefone.Principal.repository;

import com.gerenciadordetelefone.Principal.Model.TelefoneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<TelefoneModel, Long> {
}
