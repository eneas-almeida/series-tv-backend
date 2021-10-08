package br.com.ifpb.series.modules.episode.use_cases.list_episodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpb.series.modules.episode.dtos.EpisodeDTO;

@RestController
@RequestMapping("/episodes")
public class ListEpisodeController {

    @Autowired
    private ListEpisodeService listEpisodeService;

    @GetMapping
    public Page<EpisodeDTO> handle(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

                                    System.out.println("okkkkx");

        return listEpisodeService.execute(page, linesPerPage, orderBy, direction);
    }
}