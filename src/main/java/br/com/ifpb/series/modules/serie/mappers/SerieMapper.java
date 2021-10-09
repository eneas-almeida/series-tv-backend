package br.com.ifpb.series.modules.serie.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.ifpb.series.modules.serie.dtos.CreateSerieDTO;
import br.com.ifpb.series.modules.serie.dtos.ListSerieDTO;
import br.com.ifpb.series.modules.serie.dtos.SerieDTO;
import br.com.ifpb.series.modules.serie.dtos.UpdateSerieDTO;
import br.com.ifpb.series.modules.serie.entities.Serie;

@Component
public class SerieMapper {

    @Autowired
    private ModelMapper modelMapper;

    public SerieDTO toDTO(Serie serie) {
        return modelMapper.map(serie, SerieDTO.class);
    }

    public ListSerieDTO toListDTO(Serie serie) {
        return modelMapper.map(serie, ListSerieDTO.class);
    }

    public List<ListSerieDTO> toCollectionModel(List<Serie> series) {
        return series.stream()
                    .map(e -> toListDTO(e))
                    .collect(Collectors.toList());
    }

    public Page<ListSerieDTO> toCollectionPageModel(Page<Serie> series) {
        return series.map(e -> toListDTO(e));
    }

    public Serie toEntity(CreateSerieDTO dto) {
        return modelMapper.map(dto, Serie.class);
    }

    public void toCopyEntity(UpdateSerieDTO dto, Serie serie) {
        modelMapper.map(dto, serie);
    }
}