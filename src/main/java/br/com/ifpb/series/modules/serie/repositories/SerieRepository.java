package br.com.ifpb.series.modules.serie.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifpb.series.modules.serie.entities.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    Optional<Serie> findOneById(Long id);

    Optional<Serie> findOneByName(String name);
    
    List<Serie> findAllByNameContaining(String name);

    List<Serie> findAllByUserId(Long id);

    Optional<Serie> findFirstByNameContaining(String name);

    List<Serie> findTop5ByNameContaining(String name);

    Boolean existsByName(String name);

    Integer countByName(String name);
}