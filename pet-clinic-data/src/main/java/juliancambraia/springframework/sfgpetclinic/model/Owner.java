package juliancambraia.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidade Owners
 *
 * @author juliancambraia
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstname, String lastname, String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstname, lastname);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }
}
