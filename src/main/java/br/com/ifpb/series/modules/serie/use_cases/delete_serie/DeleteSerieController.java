package br.com.ifpb.series.modules.serie.use_cases.delete_serie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.serie.dtos.SerieDTO;

@RestController
@RequestMapping("/series")
public class DeleteSerieController {

    @Autowired
    private DeleteSerieService updateSerieService;

    @DeleteMapping("/{id}")
    public SerieDTO handle(@RequestBody @PathVariable Long id) {
        return updateSerieService.execute(id);
    }
}