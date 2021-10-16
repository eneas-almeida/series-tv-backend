package br.com.ifpb.series.modules.serie.dtos;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.ifpb.series.modules.user.dtos.BasicUserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicSerieDTO {
    
    private Long id;

    private String name;

    @JsonManagedReference
    private BasicUserDTO user;
}
