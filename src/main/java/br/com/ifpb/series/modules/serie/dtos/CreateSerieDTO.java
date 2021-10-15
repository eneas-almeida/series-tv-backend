package br.com.ifpb.series.modules.serie.dtos;

import br.com.ifpb.series.modules.user.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSerieDTO {

    private String name;

    private Integer totalSeasons;
    
    private Integer episodesPerSeason;

    private User user;
}