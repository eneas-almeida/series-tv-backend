package br.com.ifpb.series.modules.episode.use_cases.mark_watched_episode;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.episode.entities.Episode;
import br.com.ifpb.series.modules.episode.repositories.EpisodeRepository;

@Service
public class MarkWatchedEpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Transactional
    public void execute(String option, String ids) {

        String[] parts = ids.trim().split(",");

        for (String id : parts) {
            Optional<Episode> optionalEntity = episodeRepository.findById(Long.parseLong(id));

            if (optionalEntity.isPresent()) {
                Episode episode = optionalEntity.get();

                if (option.equals("1")) {
                    episode.setWatched();
                } else if (option.equals("0")) {
                    episode.setNotWatched();  
                }
            }
        }
    }
}