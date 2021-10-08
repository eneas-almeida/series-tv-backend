package br.com.ifpb.series.modules.serie.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityAlreadyExistsException;

public class SerieAlreadyExistsException extends EntityAlreadyExistsException {
    
    private static final long serialVersionUID = 1L;
    
    public SerieAlreadyExistsException(String message) {
        super(message);
    }
}