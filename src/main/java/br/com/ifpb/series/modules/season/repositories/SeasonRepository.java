package br.com.ifpb.series.modules.season.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifpb.series.modules.season.entities.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

    Optional<Season> findOneById(Long id);

    Optional<Season> findOneByName(String name);
    
    List<Season> findAllByNameContaining(String name);

    Optional<Season> findFirstByNameContaining(String name);

    List<Season> findTop5ByNameContaining(String name);

    Boolean existsByName(String name);

    Integer countByName(String name);
}