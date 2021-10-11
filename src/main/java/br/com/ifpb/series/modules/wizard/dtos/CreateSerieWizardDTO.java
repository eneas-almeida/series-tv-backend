package br.com.ifpb.series.modules.wizard.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSerieWizardDTO {

    String name;

    Integer totalSeasons;
    
    Integer episodesPerSeason;
}
