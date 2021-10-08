package br.com.ifpb.series.modules.episode.use_cases.mark_watched_episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodes")
public class MarkWatchedEpisodeController {

    @Autowired
    private MarkWatchedEpisodeService updateEpisodeService;

    @GetMapping("/mark")
    public void handle(@RequestParam(value = "option", defaultValue = "0") String option,
                       @RequestParam(value = "ids", defaultValue = "0") String ids) {

        updateEpisodeService.execute(option, ids);
    }
}