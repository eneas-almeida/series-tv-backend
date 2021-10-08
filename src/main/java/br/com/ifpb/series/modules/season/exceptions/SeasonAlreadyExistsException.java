package br.com.ifpb.series.modules.season.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityAlreadyExistsException;

public class SeasonAlreadyExistsException extends EntityAlreadyExistsException {
    
    private static final long serialVersionUID = 1L;
    
    public SeasonAlreadyExistsException(String message) {
        super(message);
    }
}