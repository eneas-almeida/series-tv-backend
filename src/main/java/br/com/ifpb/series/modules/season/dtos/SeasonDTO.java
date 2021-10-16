package br.com.ifpb.series.modules.season.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.ifpb.series.modules.episode.dtos.EpisodeDTO;
import br.com.ifpb.series.modules.serie.dtos.BasicSerieDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeasonDTO {
    
    private Long id;

    private String name;

    /* Attributes & Cardinalities */

    @JsonManagedReference
    private BasicSerieDTO serie;

    @JsonManagedReference
    private List<EpisodeDTO> episodes = new ArrayList<>();
}