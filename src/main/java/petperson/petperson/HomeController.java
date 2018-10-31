package petperson.petperson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    PetRepository petRepository;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String showPersonwithPet(Model model){

        Person person = new Person();
        person.setName("Person Name");
        person.setGender("Male");

        Pet pet = new Pet();
        pet.setName("Buby");
        pet.setAge(8);
        petRepository.save(pet);

        Set<Pet> pets = new HashSet<Pet>();
        pets.add(pet);
        person.setCast(pets);

        personRepository.save(person);

        model.addAttribute("person", personRepository.findAll());
        return "list";
    }
}
