package juliancambraia.springframework.sfgpetclinic.services.map;

import juliancambraia.springframework.sfgpetclinic.model.Speciality;
import juliancambraia.springframework.sfgpetclinic.model.Vet;
import juliancambraia.springframework.sfgpetclinic.services.SpecialtyService;
import juliancambraia.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Service VetServiceMap que implementa todos os métodos
 *
 * @author juliancambraia
 */

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality saveSpecialty = specialtyService.save(speciality);
                    speciality.setId(saveSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
