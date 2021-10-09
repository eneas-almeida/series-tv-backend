package br.com.ifpb.series.modules.season.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpb.series.modules.episode.dtos.EpisodeDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecialSeasonDTO {
    
    /* Attributes */

    private Long id;

    private String name;

    /* Attributes & Cardinalities */

    @JsonIgnore
    private List<EpisodeDTO> episodes = new ArrayList<>();

    /* Methods */

    public Integer getTotalEpisodes() {
        return episodes.size();
    }

    public Integer getEpisodesWatcheds() {
        int count = 0;

        for (EpisodeDTO e : episodes) {
            if (e.getWatched().equals(true)) {
                count++;
            }
        }

        return count;
    }
}