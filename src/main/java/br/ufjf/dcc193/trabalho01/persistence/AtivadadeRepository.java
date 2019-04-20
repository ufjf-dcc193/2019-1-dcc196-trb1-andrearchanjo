package br.ufjf.dcc193.trabalho01.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufjf.dcc193.trabalho01.model.Membro;

/**
 * AtivadadeRepository
 */
public interface AtivadadeRepository extends JpaRepository<Membro,Long>{

    
}