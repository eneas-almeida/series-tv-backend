package br.com.ifpb.series.modules.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {
    
    private String name;

    private String email;

    private String password;
}
