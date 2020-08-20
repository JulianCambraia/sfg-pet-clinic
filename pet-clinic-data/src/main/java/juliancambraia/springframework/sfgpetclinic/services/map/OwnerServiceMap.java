package juliancambraia.springframework.sfgpetclinic.services.map;

import juliancambraia.springframework.sfgpetclinic.model.Owner;
import juliancambraia.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;

/**
 * Service OwnerServiceMap que implementa todos os métodos
 *
 * @author juliancambraia
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
