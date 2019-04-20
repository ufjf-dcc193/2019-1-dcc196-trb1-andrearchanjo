package br.ufjf.dcc193.trabalho01.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufjf.dcc193.trabalho01.model.Membro;

/**
 * MembroRepository
 */
public interface MembroRepository extends JpaRepository<Membro,Long>{

    
}