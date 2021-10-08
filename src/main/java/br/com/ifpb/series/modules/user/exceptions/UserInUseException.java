package br.com.ifpb.series.modules.user.exceptions;

import br.com.ifpb.series.shared.exceptions.problems.EntityInUseException;

public class UserInUseException extends EntityInUseException {
    
    private static final long serialVersionUID = 1L;
    
    public UserInUseException(String message) {
        super(message);
    }
}