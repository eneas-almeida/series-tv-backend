package br.com.ifpb.series.modules.season.use_cases.update_season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.season.dtos.SeasonDTO;
import br.com.ifpb.series.modules.season.dtos.UpdateSeasonDTO;

@RestController
@RequestMapping("/seasons")
public class UpdateSeasonController {

    @Autowired
    private UpdateSeasonService updateSeasonService;

    @PutMapping("/{id}")
    public SeasonDTO handle(@RequestBody UpdateSeasonDTO dto, @PathVariable Long id) {
        return updateSeasonService.execute(dto, id);
    }
}