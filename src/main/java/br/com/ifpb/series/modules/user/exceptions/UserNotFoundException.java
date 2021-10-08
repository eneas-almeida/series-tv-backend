package br.com.ifpb.series.modules.user.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    
    private static final long serialVersionUID = 1L;
    
    public UserNotFoundException(String message) {
        super(message);
    }
}
