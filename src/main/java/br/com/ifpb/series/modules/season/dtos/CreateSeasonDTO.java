package br.com.ifpb.series.modules.season.dtos;

import br.com.ifpb.series.modules.serie.entities.Serie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSeasonDTO {

    private String name;

    private Serie serie;
}