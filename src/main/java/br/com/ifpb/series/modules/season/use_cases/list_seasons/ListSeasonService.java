package br.com.ifpb.series.modules.season.use_cases.list_seasons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
public class ListSeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeasonMapper seasonMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<SeasonDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<Season> seasons = seasonRepository.findAll(pageRequest);

        if (seasons.isEmpty()) {
            throw new SeasonNotFoundException(SeasonMessageUtils.SEASON_NOT_FOUND);
        }

        Page<SeasonDTO> pageSeasonDTO = seasonMapper.toCollectionPageModel(seasons);

        return pageSeasonDTO;
    }
}