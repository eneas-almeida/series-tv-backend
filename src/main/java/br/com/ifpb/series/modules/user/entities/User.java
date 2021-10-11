package br.com.ifpb.series.modules.user.entities;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.ifpb.series.modules.serie.entities.Serie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {

    /* Attribute Id & strategy to generate */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    /* Attributes */

    private String name;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PROFILE")
	private Set<Integer> profiles = new HashSet<>();

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    /* Attributes & Cardinalities */

    @OneToMany(mappedBy = "user")
    private List<Serie> series = new ArrayList<>();

    /* Attributes & Timestamps */

    @Column(nullable = false, columnDefinition = "datetime")
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(nullable = false, columnDefinition = "datetime")
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    /* Attributes & Date for data hiding */

    @Column(nullable = true, columnDefinition = "datetime")
    private OffsetDateTime deletedAt;

    /* Constructors */

    public User(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        addProfile(Profile.CLIENT);
    }

    /* Methods */

    public static User create(String name, String email, String password) {
        return new User(name, email, password);
    }

	public Set<Profile> getPerfis() {
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addProfile(Profile profile) {
		profiles.add(profile.getCod());
	}
}