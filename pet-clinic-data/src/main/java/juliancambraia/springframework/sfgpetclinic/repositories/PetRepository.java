package juliancambraia.springframework.sfgpetclinic.repositories;

import juliancambraia.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * @author juliancambraia
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
