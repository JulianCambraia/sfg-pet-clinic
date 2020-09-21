package juliancambraia.springframework.sfgpetclinic.repositories;

import juliancambraia.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

/**
 * @author juliancambraia
 */
public interface VetRepository extends CrudRepository<Vet, Long> {
}
