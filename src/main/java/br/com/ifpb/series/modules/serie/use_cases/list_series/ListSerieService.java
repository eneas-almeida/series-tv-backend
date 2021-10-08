package br.com.ifpb.series.modules.serie.use_cases.list_series;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.serie.dtos.SerieDTO;
import br.com.ifpb.series.modules.serie.entities.Serie;
import br.com.ifpb.series.modules.serie.exceptions.SerieNotFoundException;
import br.com.ifpb.series.modules.serie.mappers.SerieMapper;
import br.com.ifpb.series.modules.serie.repositories.SerieRepository;
import br.com.ifpb.series.modules.serie.utils.SerieMessageUtils;

@Service
public class ListSerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private SerieMapper serieMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<SerieDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<Serie> series = serieRepository.findAll(pageRequest);

        if (series.isEmpty()) {
            throw new SerieNotFoundException(SerieMessageUtils.SERIE_NOT_FOUND);
        }

        Page<SerieDTO> pageSerieDTO = serieMapper.toCollectionPageModel(series);

        return pageSerieDTO;
    }
}