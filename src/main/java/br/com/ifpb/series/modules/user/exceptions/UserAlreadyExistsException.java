package br.com.ifpb.series.modules.user.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityAlreadyExistsException;

public class UserAlreadyExistsException extends EntityAlreadyExistsException {
    
    private static final long serialVersionUID = 1L;
    
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}