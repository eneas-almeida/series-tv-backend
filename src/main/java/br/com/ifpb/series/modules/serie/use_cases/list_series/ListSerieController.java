package br.com.ifpb.series.modules.serie.use_cases.list_series;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.serie.dtos.ListSerieDTO;

@RestController
@RequestMapping("/series")
public class ListSerieController {

    @Autowired
    private ListSerieService listSerieService;

    @GetMapping
    public Page<ListSerieDTO> handle(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                     @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                     @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        return listSerieService.execute(page, linesPerPage, orderBy, direction);
    }
}