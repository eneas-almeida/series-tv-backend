package br.com.ifpb.series.modules.wizard.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSeasonWizardDTO {

    String name;

    Integer totalEpisodes;

    Long serieId;
}
