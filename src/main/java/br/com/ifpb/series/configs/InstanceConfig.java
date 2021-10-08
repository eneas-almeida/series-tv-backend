package br.com.ifpb.series.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.ifpb.series.modules.episode.entities.Episode;
import br.com.ifpb.series.modules.episode.repositories.EpisodeRepository;
import br.com.ifpb.series.modules.season.entities.Season;
import br.com.ifpb.series.modules.season.repositories.SeasonRepository;
import br.com.ifpb.series.modules.serie.entities.Serie;
import br.com.ifpb.series.modules.serie.repositories.SerieRepository;
import br.com.ifpb.series.modules.user.entities.User;
import br.com.ifpb.series.modules.user.repositories.UserRepository;

@Configuration
public class InstanceConfig implements CommandLineRunner {

    /* Repositories injecteds */
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SerieRepository serieRepository;
    
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Override
    public void run(String... args) throws Exception {
        
        /* User */

        User tiago = User.create("tiago", "tiago@gmail.com", "tiago");
        User alex = User.create("alex", "alex@gmail.com", "alex");
        User marcos = User.create("marcos", "marcos@gmail.com", "marcos");

        userRepository.saveAll(Arrays.asList(tiago, alex, marcos));

        /* Serie */

        Serie friends = Serie.create("Friends");
        Serie lord_of_rings = Serie.create("Lord of Rings");
        Serie game_of_thrones = Serie.create("Game of Thrones");

        serieRepository.saveAll(Arrays.asList(friends, lord_of_rings, game_of_thrones));

        /* Season */

        Season season_1_friends = Season.create("Temporada 1");
        Season season_1_lord_of_rings = Season.create("Temporada 1");
        Season season_1_game_of_thrones = Season.create("Temporada 1");

        seasonRepository.saveAll(Arrays.asList(season_1_friends, season_1_lord_of_rings, season_1_game_of_thrones));

        /* Episode */

        Episode episode_1_season_1_friends = Episode.create("Episódio 1 da temporada 1 de Friends");
        Episode episode_2_season_1_friends = Episode.create("Episódio 2 da temporada 1 de Friends");
        Episode episode_3_season_1_friends = Episode.create("Episódio 3 da temporada 1 de Friends");
        Episode episode_4_season_1_friends = Episode.create("Episódio 4 da temporada 1 de Friends");
        Episode episode_5_season_1_friends = Episode.create("Episódio 5 da temporada 1 de Friends");
        Episode episode_6_season_1_friends = Episode.create("Episódio 6 da temporada 1 de Friends");

        episodeRepository.saveAll(
                Arrays.asList(
                    episode_1_season_1_friends,
                    episode_2_season_1_friends,
                    episode_3_season_1_friends,
                    episode_4_season_1_friends,
                    episode_5_season_1_friends,
                    episode_6_season_1_friends));
    } 
}