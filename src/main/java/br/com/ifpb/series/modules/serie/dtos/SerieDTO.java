package br.com.ifpb.series.modules.serie.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.ifpb.series.modules.season.dtos.SpecialSeasonDTO;
import br.com.ifpb.series.modules.user.dtos.BasicUserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SerieDTO {
    
    private Long id;

    private String name;

    private Integer totalSeasons;
    
    private Integer episodesPerSeason;

    /* Attributes & Cardinalities */

    @JsonManagedReference
    private BasicUserDTO user;
    
    @JsonManagedReference
    private List<SpecialSeasonDTO> seasons = new ArrayList<>();
}
