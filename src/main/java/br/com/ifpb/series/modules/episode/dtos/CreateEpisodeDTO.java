package br.com.ifpb.series.modules.episode.dtos;

import br.com.ifpb.series.modules.season.entities.Season;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEpisodeDTO {

    private String name;

    private Season season;
}