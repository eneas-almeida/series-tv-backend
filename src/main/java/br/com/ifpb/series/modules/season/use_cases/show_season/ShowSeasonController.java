package br.com.ifpb.series.modules.season.use_cases.show_season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.season.dtos.SeasonDTO;

@RestController
@RequestMapping("/seasons")
public class ShowSeasonController {

    @Autowired
    private ShowSeasonService showSeasonService;
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SeasonDTO handle(@PathVariable Long id) {
        return showSeasonService.execute(id);
    }
}