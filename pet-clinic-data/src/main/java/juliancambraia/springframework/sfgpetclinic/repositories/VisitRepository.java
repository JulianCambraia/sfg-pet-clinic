package juliancambraia.springframework.sfgpetclinic.repositories;

import juliancambraia.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * @author juliancambraia
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
