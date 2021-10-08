package br.com.ifpb.series.modules.episode.entities;

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
@Entity(name = "episode")
public class Episode {

    /* Id & strategy to generate */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    /* Attributes */

    private String name;

    private Boolean watched;

    /* Timestamps */

    /* Constructors */

    public Episode(String name) {
        super();
        this.name = name;
    }

    /* Methods */

    public void setWatched() {
        this.watched = true;
    }

    public void setNotWatched() {
        this.watched = false;
    }

    /* Cardinalities */
}