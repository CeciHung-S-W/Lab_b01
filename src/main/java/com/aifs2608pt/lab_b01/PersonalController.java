package com.aifs2608pt.lab_b01;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class PersonalController {
   private List<Person> personList = new ArrayList<>();


    @PostMapping("/person/create")
    public Person createPerson(@RequestBody Person newPerson){
        personList.add(newPerson);
        return newPerson;

    }

    @GetMapping("/person/all")
    public List<Person> getAllPeople(){
        return personList;
    }

    @PutMapping ("/person/update")
    public Person updatePerson (@RequestBody Person updatePerson){
        for (Person person : personList){
            if (person.getHkid().equals(updatePerson.getHkid())){
                person.setFirstName(updatePerson.getFirstName());
                person.setLastName(updatePerson.getLastName());
                return person;
            }
        }
        throw new PersonNotFoundException();
    }
    @DeleteMapping ("/person/delete")
    public Person deletePerson (@RequestParam String hkid){
        for (Person person : personList){
            if(person.getHkid().equals(hkid)){
                personList.remove(person);
                return person;
            }
        }
        throw new PersonNotFoundException();
    }

}