package juliancambraia.springframework.sfgpetclinic.services.map;

import juliancambraia.springframework.sfgpetclinic.model.Vet;
import juliancambraia.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;

/**
 * Service VetServiceMap que implementa todos os métodos
 *
 * @author juliancambraia
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
