package br.com.ifpb.series.modules.user.dtos;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    
    private Long id;

    /* Others */

    private String name;

    private String email;

    /* Timestamps */

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    /* Cardinalities */
}
