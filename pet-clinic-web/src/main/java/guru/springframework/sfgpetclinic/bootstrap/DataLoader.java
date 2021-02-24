package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("mitsos");
        owner1.setLastName("mitsopoulos");
        owner1.setAddress("sdasf");
        owner1.setCity("miami");
        owner1.setTelephone("1234567890");


        Pet mitsosPet = new Pet();
        mitsosPet.setPetType(savedDogPetType);
        mitsosPet.setOwner(owner1);
        mitsosPet.setPetName("louis");
        mitsosPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mitsosPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("marko");
        owner2.setLastName("dimarko");
        owner2.setAddress("dsfdddddd");
        owner2.setCity("san fransisco");
        owner2.setTelephone("0987654321");
        ownerService.save(owner2);

        Pet markoPet = new Pet();
        markoPet.setPetType(savedCatPetType);
        markoPet.setOwner(owner2);
        markoPet.setPetName("mitsi");
        markoPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(markoPet);


        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("nikos");
        vet1.setLastName("korobos");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("bob");
        vet2.setLastName("omastoras");
        vetService.save(vet2);

        System.out.println("Loaded Vet....");


    }
}
