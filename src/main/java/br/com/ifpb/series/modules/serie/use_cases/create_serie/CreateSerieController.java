package br.com.ifpb.series.modules.serie.use_cases.create_serie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.serie.dtos.CreateSerieDTO;
import br.com.ifpb.series.modules.serie.dtos.SerieDTO;

@RestController
@RequestMapping("/series")
public class CreateSerieController {

    @Autowired
    private CreateSerieService createSerieService;

    // @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SerieDTO handle(@RequestBody CreateSerieDTO dto) {
        return createSerieService.execute(dto);
    }
}