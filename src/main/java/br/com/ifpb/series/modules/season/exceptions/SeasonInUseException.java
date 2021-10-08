package br.com.ifpb.series.modules.season.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityInUseException;

public class SeasonInUseException extends EntityInUseException {
    
    private static final long serialVersionUID = 1L;
    
    public SeasonInUseException(String message) {
        super(message);
    }
}