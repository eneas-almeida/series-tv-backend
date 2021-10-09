package br.com.ifpb.series.modules.episode.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.ifpb.series.modules.episode.dtos.CreateEpisodeDTO;
import br.com.ifpb.series.modules.episode.dtos.EpisodeDTO;
import br.com.ifpb.series.modules.episode.dtos.ListEpisodeDTO;
import br.com.ifpb.series.modules.episode.dtos.UpdateEpisodeDTO;
import br.com.ifpb.series.modules.episode.entities.Episode;

@Component
public class EpisodeMapper {

    @Autowired
    private ModelMapper modelMapper;

    public EpisodeDTO toDTO(Episode episode) {
        return modelMapper.map(episode, EpisodeDTO.class);
    }

    public ListEpisodeDTO toListDTO(Episode episode) {
        return modelMapper.map(episode, ListEpisodeDTO.class);
    }

    public List<ListEpisodeDTO> toCollectionModel(List<Episode> episodes) {
        return episodes.stream()
                    .map(e -> toListDTO(e))
                    .collect(Collectors.toList());
    }

    public Page<ListEpisodeDTO> toCollectionPageModel(Page<Episode> episodes) {
        return episodes.map(e -> toListDTO(e));
    }

    public Episode toEntity(CreateEpisodeDTO dto) {
        return modelMapper.map(dto, Episode.class);
    }

    public void toCopyEntity(UpdateEpisodeDTO dto, Episode episode) {
        modelMapper.map(dto, episode);
    }
}