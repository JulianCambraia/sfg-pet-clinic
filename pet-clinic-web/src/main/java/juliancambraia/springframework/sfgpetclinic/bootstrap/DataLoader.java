package juliancambraia.springframework.sfgpetclinic.bootstrap;

import juliancambraia.springframework.sfgpetclinic.model.Owner;
import juliancambraia.springframework.sfgpetclinic.model.Pet;
import juliancambraia.springframework.sfgpetclinic.model.PetType;
import juliancambraia.springframework.sfgpetclinic.model.Speciality;
import juliancambraia.springframework.sfgpetclinic.model.Vet;
import juliancambraia.springframework.sfgpetclinic.model.Visit;
import juliancambraia.springframework.sfgpetclinic.services.OwnerService;
import juliancambraia.springframework.sfgpetclinic.services.PetTypeService;
import juliancambraia.springframework.sfgpetclinic.services.SpecialtyService;
import juliancambraia.springframework.sfgpetclinic.services.VetService;
import juliancambraia.springframework.sfgpetclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstname("Michael");
        owner1.setLastname("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123444");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Fiona");
        owner2.setLastname("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123123123444");

        Pet fionaCat = new Pet();
        fionaCat.setName("Just Cat");
        fionaCat.setOwner(owner2);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionaCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionaCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");
        vet1.getSpecialities().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Jessie");
        vet2.setLastname("Porter");
        vet2.getSpecialities().add(saveSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
