package br.com.ifpb.series.modules.episode.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityNotFoundException;

public class EpisodeNotFoundException extends EntityNotFoundException {
    
    private static final long serialVersionUID = 1L;
    
    public EpisodeNotFoundException(String message) {
        super(message);
    }
}
