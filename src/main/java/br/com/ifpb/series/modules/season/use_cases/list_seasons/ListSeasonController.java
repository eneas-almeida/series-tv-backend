package br.com.ifpb.series.modules.season.use_cases.list_seasons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.season.dtos.SeasonDTO;

@RestController
@RequestMapping("/seasons")
public class ListSeasonController {

    @Autowired
    private ListSeasonService listSeasonService;

    @GetMapping
    public Page<SeasonDTO> handle(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        return listSeasonService.execute(page, linesPerPage, orderBy, direction);
    }
}