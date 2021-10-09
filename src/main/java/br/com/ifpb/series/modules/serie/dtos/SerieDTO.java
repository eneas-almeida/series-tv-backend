package br.com.ifpb.series.modules.serie.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.ifpb.series.modules.season.dtos.SpecialSeasonDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SerieDTO {
    
    private Long id;

    /* Attributes */

    private String name;

    /* Attributes & Cardinalities */

    // @JsonManagedReference
    // private ListUserDTO user;

    @JsonManagedReference
    private List<SpecialSeasonDTO> seasons = new ArrayList<>();
}
