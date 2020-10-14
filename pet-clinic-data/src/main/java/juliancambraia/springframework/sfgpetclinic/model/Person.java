package juliancambraia.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Entidade Person
 *
 * @author juliancambraia
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    public Person(Long id, String firstname, String lastname) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

}
