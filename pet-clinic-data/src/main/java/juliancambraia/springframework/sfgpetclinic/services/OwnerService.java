package juliancambraia.springframework.sfgpetclinic.services;

import juliancambraia.springframework.sfgpetclinic.model.Owner;

/**
 * Interface Generics
 *
 * @author juliancambraia
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
