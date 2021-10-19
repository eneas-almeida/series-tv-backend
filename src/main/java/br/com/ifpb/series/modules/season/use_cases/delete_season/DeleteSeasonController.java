package br.com.ifpb.series.modules.season.use_cases.delete_season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.season.dtos.SeasonDTO;

@RestController
@RequestMapping("/seasons")
public class DeleteSeasonController {

    @Autowired
    private DeleteSeasonService updateSeasonService;

    @DeleteMapping("/{id}")
    public SeasonDTO handle(@RequestBody @PathVariable Long id) {
        return updateSeasonService.execute(id);
    }
}