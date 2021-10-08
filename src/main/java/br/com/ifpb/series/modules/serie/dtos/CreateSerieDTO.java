package br.com.ifpb.series.modules.serie.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSerieDTO {

    private String name;

    private Integer total_seasons;

    private Integer episodes_per_season;
}