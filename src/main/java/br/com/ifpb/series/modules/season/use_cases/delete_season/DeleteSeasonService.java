package br.com.ifpb.series.modules.season.use_cases.delete_season;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.season.dtos.SeasonDTO;
import br.com.ifpb.series.modules.season.entities.Season;
import br.com.ifpb.series.modules.season.exceptions.SeasonNotFoundException;
import br.com.ifpb.series.modules.season.mappers.SeasonMapper;
import br.com.ifpb.series.modules.season.repositories.SeasonRepository;
import br.com.ifpb.series.modules.season.utils.SeasonMessageUtils;

@Service
public class DeleteSeasonService {
    
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeasonMapper seasonMapper;

    @Transactional
    public SeasonDTO execute(Long id) {

        Optional<Season> optionalEntity = seasonRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new SeasonNotFoundException(SeasonMessageUtils.SEASON_NOT_FOUND);
        }

        Season season = optionalEntity.get();

        seasonRepository.deleteById(id);

        return seasonMapper.toDTO(season);
    }
}