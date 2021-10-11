package br.com.ifpb.series.modules.serie.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.ifpb.series.modules.season.entities.Season;
import br.com.ifpb.series.modules.user.entities.User;
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

    /* Attribute Id & strategy to generate */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    /* Attributes */

    private String name;

    /* Attributes & Cardinalities */

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Season> seasons = new ArrayList<>();

    /* Constructors */

    public Serie(String name, User user) {
        super();
        this.name = name;
        this.user = user;
    }

    /* Methods */

    public static Serie create(String name, User user) {
        return new Serie(name, user);
    }
}