package br.com.ifpb.series.modules.episode.use_cases.list_episodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.episode.dtos.ListEpisodeDTO;
import br.com.ifpb.series.modules.episode.entities.Episode;
import br.com.ifpb.series.modules.episode.exceptions.EpisodeNotFoundException;
import br.com.ifpb.series.modules.episode.mappers.EpisodeMapper;
import br.com.ifpb.series.modules.episode.repositories.EpisodeRepository;
import br.com.ifpb.series.modules.episode.utils.EpisodeMessageUtils;

@Service
public class ListEpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private EpisodeMapper episodeMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<ListEpisodeDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<Episode> episodes = episodeRepository.findAll(pageRequest);

        if (episodes.isEmpty()) {
            throw new EpisodeNotFoundException(EpisodeMessageUtils.EPISODE_NOT_FOUND);
        }

        Page<ListEpisodeDTO> pageEpisodeDTO = episodeMapper.toCollectionPageModel(episodes);

        return pageEpisodeDTO;
    }
}