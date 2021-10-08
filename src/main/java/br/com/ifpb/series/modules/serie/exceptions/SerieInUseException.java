package br.com.ifpb.series.modules.serie.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityInUseException;

public class SerieInUseException extends EntityInUseException {
    
    private static final long serialVersionUID = 1L;
    
    public SerieInUseException(String message) {
        super(message);
    }
}