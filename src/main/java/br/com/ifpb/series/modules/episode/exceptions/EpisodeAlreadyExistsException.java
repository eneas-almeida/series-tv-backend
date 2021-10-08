package br.com.ifpb.series.modules.episode.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityAlreadyExistsException;

public class EpisodeAlreadyExistsException extends EntityAlreadyExistsException {
    
    private static final long serialVersionUID = 1L;
    
    public EpisodeAlreadyExistsException(String message) {
        super(message);
    }
}