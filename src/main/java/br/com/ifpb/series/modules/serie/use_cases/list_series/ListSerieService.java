package br.com.ifpb.series.modules.serie.use_cases.list_series;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpb.series.modules.security.JwtUser;
import br.com.ifpb.series.modules.security.services.UserService;
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
        
        /* JWT guard */

        JwtUser jwtUser = UserService.authenticated();

        if (jwtUser == null) {
            // rule
        }

        /* Find user by id */

        User user = userRepository.findOneById(jwtUser.getId()).get();

        /* Find all series by UserId */

        List<Serie> series = serieRepository.findAllByUserId(user.getId());

        /* Parse entity to list dto */

        List<ListSerieDTO> listSerieDTO = serieMapper.toCollectionModel(series);

        /* Resturn list serie dto */

        return listSerieDTO;
    }
}