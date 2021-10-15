package br.com.ifpb.series.modules.serie.use_cases.list_series;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.serie.dtos.ListSerieDTO;
import br.com.ifpb.series.modules.serie.entities.Serie;
import br.com.ifpb.series.modules.serie.mappers.SerieMapper;
import br.com.ifpb.series.modules.serie.repositories.SerieRepository;
import br.com.ifpb.series.modules.user.entities.User;
import br.com.ifpb.series.modules.user.repositories.UserRepository;

@Service
public class ListSerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SerieMapper serieMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<ListSerieDTO> execute() {
        
        Optional<User> optionalEntity = userRepository.findOneById(1L);

        if (optionalEntity.isEmpty()) {}

        User user = optionalEntity.get();

        List<Serie> series = serieRepository.findAllByUserId(user.getId());

        List<ListSerieDTO> listSerieDTO = serieMapper.toCollectionModel(series);

        return listSerieDTO;
    }
}