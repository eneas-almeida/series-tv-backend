package br.com.ifpb.series.modules.episode.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityInUseException;

public class EpisodeInUseException extends EntityInUseException {
    
    private static final long serialVersionUID = 1L;
    
    public EpisodeInUseException(String message) {
        super(message);
    }
}