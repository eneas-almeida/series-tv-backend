package br.com.ifpb.series.modules.wizard.use_cases.create_season_wizard;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.episode.entities.Episode;
import br.com.ifpb.series.modules.episode.repositories.EpisodeRepository;
import br.com.ifpb.series.modules.season.entities.Season;
import br.com.ifpb.series.modules.season.repositories.SeasonRepository;
import br.com.ifpb.series.modules.serie.entities.Serie;
import br.com.ifpb.series.modules.serie.repositories.SerieRepository;
import br.com.ifpb.series.modules.wizard.dtos.CreateSeasonWizardDTO;

@Service
public class CreateSeasonWizardService {
    
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Transactional
    public void execute(CreateSeasonWizardDTO dto) {

        Optional<Serie> entityOptional = this.serieRepository.findOneById(dto.getSerieId());

        if (entityOptional.isEmpty()) {}
        
        Season season = Season.create(dto.getName(), entityOptional.get());

        seasonRepository.save(season);

        Episode episode = null;

        for (int i = 0; i < dto.getTotalEpisodes(); i++) {
            episode = Episode.create("Episode 1", "120", season);

            episodeRepository.save(episode);
        }
    }
}