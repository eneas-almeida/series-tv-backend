package br.com.ifpb.series.modules.season.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.ifpb.series.modules.season.dtos.CreateSeasonDTO;
import br.com.ifpb.series.modules.season.dtos.ListSeasonDTO;
import br.com.ifpb.series.modules.season.dtos.SeasonDTO;
import br.com.ifpb.series.modules.season.dtos.UpdateSeasonDTO;
import br.com.ifpb.series.modules.season.entities.Season;

@Component
public class SeasonMapper {

    @Autowired
    private ModelMapper modelMapper;

    public SeasonDTO toDTO(Season season) {
        return modelMapper.map(season, SeasonDTO.class);
    }

    public ListSeasonDTO toListDTO(Season season) {
        return modelMapper.map(season, ListSeasonDTO.class);
    }

    public List<ListSeasonDTO> toCollectionModel(List<Season> seasons) {
        return seasons.stream()
                    .map(e -> toListDTO(e))
                    .collect(Collectors.toList());
    }

    public Page<ListSeasonDTO> toCollectionPageModel(Page<Season> seasons) {
        return seasons.map(e -> toListDTO(e));
    }

    public Season toEntity(CreateSeasonDTO dto) {
        return modelMapper.map(dto, Season.class);
    }

    public void toCopyEntity(UpdateSeasonDTO dto, Season season) {
        modelMapper.map(dto, season);
    }
}