package br.com.ifpb.series.modules.user.dtos;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    /* Attributes */

    private Long id;

    private String name;

    private String email;

    /* Attributes &  Timestamps */

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
