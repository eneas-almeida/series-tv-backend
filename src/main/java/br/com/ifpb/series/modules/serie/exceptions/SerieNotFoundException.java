package br.com.ifpb.series.modules.serie.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityNotFoundException;

public class SerieNotFoundException extends EntityNotFoundException {
    
    private static final long serialVersionUID = 1L;
    
    public SerieNotFoundException(String message) {
        super(message);
    }
}
