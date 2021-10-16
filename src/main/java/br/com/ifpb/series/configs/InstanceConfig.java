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
import br.com.ifpb.series.modules.user.entities.Profile;
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

        User user_tiago = User.create("tiago", "tiago@gmail.com", bcrypt.encode("tiago"), Profile.ROLE_ADMIN);
        User user_alex = User.create("alex", "alex@gmail.com", bcrypt.encode("alex"), Profile.ROLE_USUARIO);
        User user_marcos = User.create("marcos", "marcos@gmail.com", bcrypt.encode("marcos"), Profile.ROLE_USUARIO);

        /* Serie */

        Serie serie_friends_tiago = Serie.create("Friends tiago", 3, 6, user_tiago);
        Serie serie_rings_tiago = Serie.create("Lord of Rings tiago", 3, 6, user_tiago);
        Serie serie_thrones_tiago = Serie.create("Game of Thrones tiago", 3, 6, user_tiago);
        
        Serie serie_friends_alex = Serie.create("Friends alex", 3, 6, user_alex);
        Serie serie_rings_alex = Serie.create("Lord of Rings alex", 3, 6, user_alex);
        Serie serie_thrones_alex = Serie.create("Game of Thrones alex", 3, 6, user_alex);  

        /* Season */

        Season season_1_friends_tiago = Season.create("Temporada 1", serie_friends_tiago);
        Season season_2_friends_tiago = Season.create("Temporada 2", serie_friends_tiago);
        Season season_3_friends_tiago = Season.create("Temporada 3", serie_friends_tiago);

        Season season_1_friends_alex = Season.create("Temporada 1", serie_thrones_alex);
        Season season_2_friends_alex = Season.create("Temporada 2", serie_thrones_alex);
        Season season_3_friends_alex = Season.create("Temporada 3", serie_thrones_alex);

        /* Episode */

        Episode episode_1_season_1_friends_tiago = Episode.create("Episódio 1 da temporada 1 de Friends","120", season_1_friends_tiago);
        Episode episode_2_season_1_friends_tiago = Episode.create("Episódio 2 da temporada 1 de Friends","120", season_1_friends_tiago);
        Episode episode_3_season_1_friends_tiago = Episode.create("Episódio 3 da temporada 1 de Friends","120", season_1_friends_tiago);
        Episode episode_4_season_1_friends_tiago = Episode.create("Episódio 4 da temporada 1 de Friends","120", season_1_friends_tiago);
        Episode episode_5_season_1_friends_tiago = Episode.create("Episódio 5 da temporada 1 de Friends","120", season_1_friends_tiago);
        Episode episode_6_season_1_friends_tiago = Episode.create("Episódio 6 da temporada 1 de Friends","120", season_1_friends_tiago);

        Episode episode_1_season_2_friends_tiago = Episode.create("Episódio 1 da temporada 2 de Friends","120", season_2_friends_tiago);
        Episode episode_2_season_2_friends_tiago = Episode.create("Episódio 2 da temporada 2 de Friends","120", season_2_friends_tiago);
        Episode episode_3_season_2_friends_tiago = Episode.create("Episódio 3 da temporada 2 de Friends","120", season_2_friends_tiago);

        Episode episode_1_season_2_friends_alex = Episode.create("Episódio 1 da temporada 2 de Friends","120", season_2_friends_alex);
        Episode episode_2_season_2_friends_alex = Episode.create("Episódio 2 da temporada 2 de Friends","120", season_2_friends_alex);
        Episode episode_3_season_2_friends_alex = Episode.create("Episódio 3 da temporada 2 de Friends","120", season_2_friends_alex);

        /* Save in repositorieS */

        userRepository.saveAll(Arrays.asList(user_tiago, user_alex, user_marcos));

        /* Save in repositories TIAGO */

        serieRepository.saveAll(Arrays.asList(serie_friends_tiago, serie_rings_tiago, serie_thrones_tiago));
        seasonRepository.saveAll(Arrays.asList(season_1_friends_tiago, season_2_friends_tiago, season_3_friends_tiago));
        episodeRepository.saveAll(
            Arrays.asList(
                episode_1_season_1_friends_tiago,
                episode_2_season_1_friends_tiago,
                episode_3_season_1_friends_tiago,
                episode_4_season_1_friends_tiago,
                episode_5_season_1_friends_tiago,
                episode_6_season_1_friends_tiago,
                episode_1_season_2_friends_tiago,
                episode_2_season_2_friends_tiago,
                episode_3_season_2_friends_tiago));

        /* Save in repositories TIAGO */

        serieRepository.saveAll(Arrays.asList(serie_friends_alex, serie_rings_alex, serie_thrones_alex));
        seasonRepository.saveAll(Arrays.asList(season_1_friends_alex, season_2_friends_alex, season_3_friends_alex));
        episodeRepository.saveAll(
            Arrays.asList(
                episode_1_season_2_friends_alex,
                episode_2_season_2_friends_alex,
                episode_3_season_2_friends_alex));
    } 
}