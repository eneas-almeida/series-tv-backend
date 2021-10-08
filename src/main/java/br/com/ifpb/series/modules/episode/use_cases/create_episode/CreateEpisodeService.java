package br.com.ifpb.series.modules.episode.use_cases.create_episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.episode.dtos.CreateEpisodeDTO;
import br.com.ifpb.series.modules.episode.dtos.EpisodeDTO;
import br.com.ifpb.series.modules.episode.entities.Episode;
import br.com.ifpb.series.modules.episode.exceptions.EpisodeAlreadyExistsException;
import br.com.ifpb.series.modules.episode.mappers.EpisodeMapper;
import br.com.ifpb.series.modules.episode.repositories.EpisodeRepository;
import br.com.ifpb.series.modules.episode.utils.EpisodeMessageUtils;

@Service
public class CreateEpisodeService {
    
    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Transactional
    public EpisodeDTO execute(CreateEpisodeDTO dto) {

        /* Verify episode existence with name */

        Boolean existsEpisode = episodeRepository.existsByName(dto.getName());

        if (existsEpisode) {
            throw new EpisodeAlreadyExistsException(EpisodeMessageUtils.EPISODE_ALREADY_EXISTS);
        }

        /* Parse dto to entity */
        
        Episode episode = episodeMapper.toEntity(dto);
        
        /* Save episode in repository */
        
        episodeRepository.save(episode);

        /* Parse entity to dto and return */

        return episodeMapper.toDTO(episode);
    }
}