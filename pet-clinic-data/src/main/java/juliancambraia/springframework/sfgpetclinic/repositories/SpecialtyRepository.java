package juliancambraia.springframework.sfgpetclinic.repositories;

import juliancambraia.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

/**
 * @author juliancambraia
 */
public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
