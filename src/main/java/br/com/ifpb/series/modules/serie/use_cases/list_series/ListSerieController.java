package br.com.ifpb.series.modules.serie.use_cases.list_series;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.serie.dtos.ListSerieDTO;

@RestController
@RequestMapping("/series")
public class ListSerieController {

    @Autowired
    private ListSerieService listSerieService;

    @GetMapping
    public List<ListSerieDTO> handle() {
        return listSerieService.execute();
    }
}