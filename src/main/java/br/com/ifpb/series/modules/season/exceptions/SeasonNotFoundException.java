package br.com.ifpb.series.modules.season.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityNotFoundException;

public class SeasonNotFoundException extends EntityNotFoundException {
    
    private static final long serialVersionUID = 1L;
    
    public SeasonNotFoundException(String message) {
        super(message);
    }
}
