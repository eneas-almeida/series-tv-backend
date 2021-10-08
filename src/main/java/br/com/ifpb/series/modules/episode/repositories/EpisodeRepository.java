package br.com.ifpb.series.modules.episode.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifpb.series.modules.episode.entities.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {

    Optional<Episode> findOneById(Long id);

    Optional<Episode> findOneByName(String name);
    
    List<Episode> findAllByNameContaining(String name);

    Optional<Episode> findFirstByNameContaining(String name);

    List<Episode> findTop5ByNameContaining(String name);

    Boolean existsByName(String name);

    Integer countByName(String name);
}