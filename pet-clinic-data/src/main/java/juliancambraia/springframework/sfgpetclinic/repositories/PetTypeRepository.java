package juliancambraia.springframework.sfgpetclinic.repositories;

import juliancambraia.springframework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author juliancambraia
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
