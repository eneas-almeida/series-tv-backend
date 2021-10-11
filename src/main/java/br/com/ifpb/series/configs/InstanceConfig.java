package br.com.ifpb.series.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Override
    public void run(String... args) throws Exception {
        
        /* User */

        User user_tiago = User.create("tiago", "tiago@gmail.com", bcrypt.encode("tiago"));
        User user_alex = User.create("alex", "alex@gmail.com", bcrypt.encode("alex"));
        User user_marcos = User.create("marcos", "marcos@gmail.com", bcrypt.encode("marcos"));

        /* Serie */

        Serie serie_friends = Serie.create("Friends", user_tiago);
        Serie serie_rings = Serie.create("Lord of Rings", user_tiago);
        Serie serie_thrones = Serie.create("Game of Thrones", user_tiago);       

        /* Season */

        Season season_1_friends = Season.create("Temporada 1", serie_friends);
        Season season_2_friends = Season.create("Temporada 2", serie_friends);
        Season season_3_friends = Season.create("Temporada 3", serie_friends);

        /* Episode */

        Episode episode_1_season_1_friends = Episode.create("Episódio 1 da temporada 1 de Friends", season_1_friends);
        Episode episode_2_season_1_friends = Episode.create("Episódio 2 da temporada 1 de Friends", season_1_friends);
        Episode episode_3_season_1_friends = Episode.create("Episódio 3 da temporada 1 de Friends", season_1_friends);
        Episode episode_4_season_1_friends = Episode.create("Episódio 4 da temporada 1 de Friends", season_1_friends);
        Episode episode_5_season_1_friends = Episode.create("Episódio 5 da temporada 1 de Friends", season_1_friends);
        Episode episode_6_season_1_friends = Episode.create("Episódio 6 da temporada 1 de Friends", season_1_friends);

        Episode episode_1_season_2_friends = Episode.create("Episódio 1 da temporada 2 de Friends", season_2_friends);
        Episode episode_2_season_2_friends = Episode.create("Episódio 2 da temporada 2 de Friends", season_2_friends);
        Episode episode_3_season_2_friends = Episode.create("Episódio 3 da temporada 2 de Friends", season_2_friends);

        /* Save in repositories */

        userRepository.saveAll(Arrays.asList(user_tiago, user_alex, user_marcos));
        serieRepository.saveAll(Arrays.asList(serie_friends, serie_rings, serie_thrones));
        seasonRepository.saveAll(Arrays.asList(season_1_friends, season_2_friends, season_3_friends));
        episodeRepository.saveAll(
            Arrays.asList(
                episode_1_season_1_friends,
                episode_2_season_1_friends,
                episode_3_season_1_friends,
                episode_4_season_1_friends,
                episode_5_season_1_friends,
                episode_6_season_1_friends,
                episode_1_season_2_friends,
                episode_2_season_2_friends,
                episode_3_season_2_friends));
    } 
}