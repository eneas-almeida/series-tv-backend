package br.com.ifpb.series.modules.season.use_cases.create_season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.season.dtos.CreateSeasonDTO;
import br.com.ifpb.series.modules.season.dtos.SeasonDTO;
import br.com.ifpb.series.modules.season.entities.Season;
import br.com.ifpb.series.modules.season.exceptions.SeasonAlreadyExistsException;
import br.com.ifpb.series.modules.season.mappers.SeasonMapper;
import br.com.ifpb.series.modules.season.repositories.SeasonRepository;
import br.com.ifpb.series.modules.season.utils.SeasonMessageUtils;

@Service
public class CreateSeasonService {
    
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeasonMapper seasonMapper;

    @Transactional
    public SeasonDTO execute(CreateSeasonDTO dto) {

        /* Verify season existence with name */

        Boolean existsSeason = seasonRepository.existsByName(dto.getName());

        if (existsSeason) {
            throw new SeasonAlreadyExistsException(SeasonMessageUtils.SEASON_ALREADY_EXISTS);
        }

        /* Parse dto to entity */
        
        Season season = seasonMapper.toEntity(dto);
        
        /* Save season in repository */
        
        seasonRepository.save(season);

        /* Parse entity to dto and return */

        return seasonMapper.toDTO(season);
    }
}