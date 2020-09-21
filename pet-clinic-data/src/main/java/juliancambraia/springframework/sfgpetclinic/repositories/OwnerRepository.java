package juliancambraia.springframework.sfgpetclinic.repositories;

import juliancambraia.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @author juliancambraia
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
