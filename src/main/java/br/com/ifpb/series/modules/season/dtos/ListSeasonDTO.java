package br.com.ifpb.series.modules.season.dtos;

import br.com.ifpb.series.modules.serie.dtos.ListSerieDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListSeasonDTO {
    
    private Long id;

    private String name;

    private ListSerieDTO serie;
}
