package juliancambraia.springframework.sfgpetclinic.services.springdatajpa;

import juliancambraia.springframework.sfgpetclinic.model.Owner;
import juliancambraia.springframework.sfgpetclinic.repositories.OwnerRepository;
import juliancambraia.springframework.sfgpetclinic.repositories.PetRepository;
import juliancambraia.springframework.sfgpetclinic.repositories.PetTypeRepository;
import juliancambraia.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author juliancambraia
 */

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findBylastname(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
