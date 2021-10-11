package br.com.ifpb.series.modules.wizard.use_cases.create_serie_wizard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.wizard.dtos.CreateSerieWizardDTO;

@RestController
@RequestMapping("/serie_wizard")
public class CreateSerieWizardController {

    @Autowired
    private CreateSerieWizardService createSerieWizardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void handle(@RequestBody CreateSerieWizardDTO dto) {
        createSerieWizardService.execute(dto);
    }
}