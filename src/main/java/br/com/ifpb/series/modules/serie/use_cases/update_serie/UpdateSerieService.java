package br.com.ifpb.series.modules.serie.use_cases.update_serie;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.serie.dtos.SerieDTO;
import br.com.ifpb.series.modules.serie.dtos.UpdateSerieDTO;
import br.com.ifpb.series.modules.serie.entities.Serie;
import br.com.ifpb.series.modules.serie.exceptions.SerieNotFoundException;
import br.com.ifpb.series.modules.serie.mappers.SerieMapper;
import br.com.ifpb.series.modules.serie.repositories.SerieRepository;
import br.com.ifpb.series.modules.serie.utils.SerieMessageUtils;

@Service
public class UpdateSerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private SerieMapper serieMapper;

    @Transactional
    public SerieDTO execute(UpdateSerieDTO dto, Long id) {

        Optional<Serie> optionalEntity = serieRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new SerieNotFoundException(SerieMessageUtils.SERIE_NOT_FOUND);
        }

        Serie serie = optionalEntity.get();

        serie.setName(dto.getName());

        return serieMapper.toDTO(serie);
    }
}