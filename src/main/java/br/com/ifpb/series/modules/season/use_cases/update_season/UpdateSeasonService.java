package br.com.ifpb.series.modules.season.use_cases.update_season;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.season.dtos.SeasonDTO;
import br.com.ifpb.series.modules.season.dtos.UpdateSeasonDTO;
import br.com.ifpb.series.modules.season.entities.Season;
import br.com.ifpb.series.modules.season.exceptions.SeasonNotFoundException;
import br.com.ifpb.series.modules.season.mappers.SeasonMapper;
import br.com.ifpb.series.modules.season.repositories.SeasonRepository;
import br.com.ifpb.series.modules.season.utils.SeasonMessageUtils;

@Service
public class UpdateSeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeasonMapper seasonMapper;

    @Transactional
    public SeasonDTO execute(UpdateSeasonDTO dto, Long id) {

        Optional<Season> optionalEntity = seasonRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new SeasonNotFoundException(SeasonMessageUtils.SEASON_NOT_FOUND);
        }

        Season season = optionalEntity.get();

        season.setName(dto.getName());

        return seasonMapper.toDTO(season);
    }
}