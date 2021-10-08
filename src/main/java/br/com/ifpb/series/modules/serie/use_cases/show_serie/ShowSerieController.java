package br.com.ifpb.series.modules.serie.use_cases.show_serie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.serie.dtos.SerieDTO;

@RestController
@RequestMapping("/series")
public class ShowSerieController {
    
    @Autowired
    private ShowSerieService showSerieService;
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SerieDTO handle(@PathVariable Long id) {
        return showSerieService.execute(id);
    }
}