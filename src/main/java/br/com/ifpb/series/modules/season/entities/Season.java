package br.com.ifpb.series.modules.season.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.ifpb.series.modules.episode.entities.Episode;
import br.com.ifpb.series.modules.serie.entities.Serie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "season")
public class Season {

    /* Attribute Id & strategy to generate */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    /* Attributes */

    private String name;

    /* Attributes & Cardinalities */

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodes = new ArrayList<>();

    /* Constructors */

    public Season(String name, Serie serie) {
        super();
        this.name = name;
        this.serie = serie;
    }

    /* Methods */

    public static Season create(String name, Serie serie) {
        return new Season(name, serie);
    }
}