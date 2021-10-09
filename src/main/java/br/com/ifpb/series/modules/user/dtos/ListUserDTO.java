package br.com.ifpb.series.modules.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListUserDTO {

    private Long id;
    
    private String name;
    
    private String email;
}
