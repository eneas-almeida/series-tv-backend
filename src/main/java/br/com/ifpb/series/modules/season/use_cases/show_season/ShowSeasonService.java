package br.com.ifpb.series.modules.season.use_cases.show_season;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.season.dtos.SeasonDTO;
import br.com.ifpb.series.modules.season.entities.Season;
import br.com.ifpb.series.modules.season.exceptions.SeasonNotFoundException;
import br.com.ifpb.series.modules.season.mappers.SeasonMapper;
import br.com.ifpb.series.modules.season.repositories.SeasonRepository;
import br.com.ifpb.series.modules.season.utils.SeasonMessageUtils;

@Service
public class ShowSeasonService {
    
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeasonMapper seasonMapper;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public SeasonDTO execute(Long id) {
        Optional<Season> optionalEntity = seasonRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new SeasonNotFoundException(SeasonMessageUtils.SEASON_NOT_FOUND);
        }

        return seasonMapper.toDTO(optionalEntity.get());
    }
}