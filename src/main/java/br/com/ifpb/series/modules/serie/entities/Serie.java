package br.com.ifpb.series.modules.serie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "serie")
public class Serie {

    /* Id & strategy to generate */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    /* Attributes */

    private String name;

    /* Timestamps */

    /* Constructors */

    public Serie(String name) {
        super();
        this.name = name;
    }

    /* Cardinalities */
}