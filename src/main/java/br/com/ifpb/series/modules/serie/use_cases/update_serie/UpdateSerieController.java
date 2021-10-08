package br.com.ifpb.series.modules.serie.use_cases.update_serie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.serie.dtos.SerieDTO;
import br.com.ifpb.series.modules.serie.dtos.UpdateSerieDTO;

@RestController
@RequestMapping("/series")
public class UpdateSerieController {

    @Autowired
    private UpdateSerieService updateSerieService;

    @PutMapping("/{id}")
    public SerieDTO handle(@RequestBody UpdateSerieDTO dto, @PathVariable Long id) {
        return updateSerieService.execute(dto, id);
    }
}