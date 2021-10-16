package br.com.ifpb.series.modules.wizard.use_cases.create_serie_wizard;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpb.series.modules.episode.entities.Episode;
import br.com.ifpb.series.modules.episode.repositories.EpisodeRepository;
import br.com.ifpb.series.modules.season.entities.Season;
import br.com.ifpb.series.modules.season.repositories.SeasonRepository;
import br.com.ifpb.series.modules.security.JwtUser;
import br.com.ifpb.series.modules.security.services.UserService;
import br.com.ifpb.series.modules.serie.entities.Serie;
import br.com.ifpb.series.modules.serie.repositories.SerieRepository;
import br.com.ifpb.series.modules.user.entities.User;
import br.com.ifpb.series.modules.user.repositories.UserRepository;
import br.com.ifpb.series.modules.wizard.dtos.CreateSerieWizardDTO;

@Service
public class CreateSerieWizardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Transactional
    public void execute(CreateSerieWizardDTO dto) {

        /* JWT guard */

        JwtUser jwtUser = UserService.authenticated();

        if (jwtUser == null) {
            // rule
        }

        /* Find user by id */

        User user = userRepository.findOneById(jwtUser.getId()).get();

        /* Create serie and save in repository */

        Serie  serie = Serie.create(dto.getName(), dto.getTotalSeasons(), dto.getEpisodesPerSeason(), user);

        serieRepository.save(serie);

        /* Create season and save in repository */

        for (Integer i = 1; i < dto.getTotalSeasons()+1; i++) {
            Season season = Season.create("Temporada " + i.toString() + " de " + dto.getName(), serie);
            
            seasonRepository.save(season);

            /* Create season and save in repository */

            for (Integer k = 1; k < dto.getEpisodesPerSeason()+1; k++) {
                Episode episode = Episode.create("Episódio " + k.toString() + " da temporada " + i.toString() + " de " + dto.getName(), season);
             
                episodeRepository.save(episode);
            }
        }
    }
}