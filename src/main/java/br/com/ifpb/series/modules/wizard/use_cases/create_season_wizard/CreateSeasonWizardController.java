package br.com.ifpb.series.modules.wizard.use_cases.create_season_wizard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.wizard.dtos.CreateSeasonWizardDTO;

@RestController
@RequestMapping("/season_wizard")
public class CreateSeasonWizardController {

    @Autowired
    private CreateSeasonWizardService createSeasonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void handle(@RequestBody CreateSeasonWizardDTO dto) {
        createSeasonService.execute(dto);
    }
}