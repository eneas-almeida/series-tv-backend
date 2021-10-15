package br.com.ifpb.series.modules.serie.use_cases.create_serie;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.serie.dtos.CreateSerieDTO;
import br.com.ifpb.series.modules.serie.dtos.SerieDTO;
import br.com.ifpb.series.modules.serie.entities.Serie;
import br.com.ifpb.series.modules.serie.exceptions.SerieAlreadyExistsException;
import br.com.ifpb.series.modules.serie.mappers.SerieMapper;
import br.com.ifpb.series.modules.serie.repositories.SerieRepository;
import br.com.ifpb.series.modules.serie.utils.SerieMessageUtils;
import br.com.ifpb.series.modules.user.entities.User;
import br.com.ifpb.series.modules.user.repositories.UserRepository;

@Service
public class CreateSerieService {
    
    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private SerieMapper serieMapper;

    @Transactional
    public SerieDTO execute(CreateSerieDTO dto) {

        /* Data user */

        Optional<User> optionalEntity = userRepository.findOneById(1L);

        if (optionalEntity.isEmpty()) {}

        User user = optionalEntity.get();

        /* Verify serie existence with name */

        Boolean existsSerieWithName = serieRepository.existsByName(dto.getName());

        if (existsSerieWithName) {
            throw new SerieAlreadyExistsException(SerieMessageUtils.SERIE_ALREADY_EXISTS);
        }

        /* Parse dto to entity */
        
        Serie serie = serieMapper.toEntity(dto);

         /* Set user of entity */

        serie.setUser(user);
        
        /* Save serie in repository */
        
        serieRepository.save(serie);

        /* Parse entity to dto and return */

        return serieMapper.toDTO(serie);
    }
}