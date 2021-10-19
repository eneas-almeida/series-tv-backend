package br.com.ifpb.series.modules.season.use_cases.create_season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.season.dtos.CreateSeasonDTO;
import br.com.ifpb.series.modules.season.dtos.SeasonDTO;

@RestController
@RequestMapping("/seasons")
public class CreateSeasonController {

    @Autowired
    private CreateSeasonService createSeasonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SeasonDTO handle(@RequestBody CreateSeasonDTO dto) {
        return createSeasonService.execute(dto);
    }
}