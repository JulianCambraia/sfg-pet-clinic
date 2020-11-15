package juliancambraia.springframework.sfgpetclinic.services.map;

import juliancambraia.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class PetMapServiceTest {

    private PetMapService petMapService;

    final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();

        petMapService.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {
        Set<Pet> petSet = petMapService.findAll();
        assertEquals(petId, petSet.size());
    }

    @Test
    void deleteByIdCorrect() {
        petMapService.deleteById(petId);
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deletePet() {
        petMapService.delete(petMapService.findById(petId));
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {
        Pet pet = Pet.builder().id(5L).build();
        petMapService.delete(pet);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {
        Pet pet = Pet.builder().build();
        petMapService.delete(pet);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void deleteNull() {
        petMapService.delete(null);
        assertEquals(1, petMapService.findAll().size());
    }


    @Test
    void saveExistsId() {
        Long id = 10L;
        Pet pet = Pet.builder().id(id).build();
        Pet petSave = petMapService.save(pet);
        assertEquals(id, petSave.getId());
    }

    @Test
    void saveNotExistsId() {
        Pet petSave = petMapService.save(Pet.builder().build());
        assertNotNull(petSave);
        assertNotNull(petSave.getId());
    }

    @Test
    void saveDuplicateId() {
        Long id = 1L;
        Pet pet2 = Pet.builder().id(id).build();
        Pet petSave = petMapService.save(pet2);

        assertEquals(id, petSave.getId());
        assertEquals(id, petMapService.findAll().size());
    }

    @Test
    void findByIdExistingId() {
        Pet pet = petMapService.findById(petId);
        assertEquals(petId, pet.getId());
    }

    @Test
    void findByIdNotExistingId() {
        Long id = 5L;
        Pet pet = petMapService.findById(id);
        assertNull(pet);
    }

    @Test
    void findByIdNullId() {
        Long id = 5L;
        Pet pet = petMapService.findById(null);
        assertNull(pet);
    }

}