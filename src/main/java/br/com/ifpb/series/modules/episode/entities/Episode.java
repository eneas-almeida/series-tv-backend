package br.com.ifpb.series.modules.episode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ifpb.series.modules.season.entities.Season;
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

    /* Attribute Id & strategy to generate */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    /* Attributes */

    private String name;

    private Boolean watched;

    /* Attributes & Cardinalities */

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    /* Constructors */

    public Episode(String name, Season season) {
        super();
        this.name = name;
        this.season = season;
        this.setNotWatched();
    }

    /* Methods */

    public static Episode create(String name, Season season) {
        return new Episode(name, season);
    }

    public void setWatched() {
        this.watched = true;
    }

    public void setNotWatched() {
        this.watched = false;
    }
}