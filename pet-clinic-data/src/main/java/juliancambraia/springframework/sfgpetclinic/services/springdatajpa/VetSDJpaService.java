package juliancambraia.springframework.sfgpetclinic.services.springdatajpa;

import juliancambraia.springframework.sfgpetclinic.model.Vet;
import juliancambraia.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import juliancambraia.springframework.sfgpetclinic.repositories.VetRepository;
import juliancambraia.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author juliancambraia
 */

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final SpecialtyRepository specialtyRepository;
    private final VetRepository vetRepository;

    public VetSDJpaService(SpecialtyRepository specialtyRepository, VetRepository vetRepository) {
        this.specialtyRepository = specialtyRepository;
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
