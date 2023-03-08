package com.example.demo.web;

import com.example.demo.domain.Owner;
import com.example.demo.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OwnerController {

    @Autowired
    OwnerRepository ownerRepository;

    @RequestMapping("/create-owner")
    public Owner newOwner(@RequestBody Owner owner){
        ownerRepository.save(owner);
        return owner;
    }

//localhost:8080/create-owner2?firstname=Hanna&lastname=Hai
    @PostMapping("/create-owner2")
    public Owner newOwner(@RequestParam String firstname, @RequestParam String lastname){
        System.out.println(firstname + " " + lastname);
        Owner owner = new Owner(firstname,lastname);
        ownerRepository.save(owner);
        return owner;
    }

    @GetMapping("/find-owner")
    public  Owner getOwner(@RequestBody Long id){
        Optional<Owner> opt = ownerRepository.findById(id);
        return opt.orElseGet(Owner::new);
    }

    @DeleteMapping("/delete-owner")
    public String deleteOwner(@RequestBody Long id){
        ownerRepository.deleteById(id);
        return "Done delete";
    }

    @PutMapping("/update-owner/{id}/{firstname}")
    public Owner updateOwner(
            @PathVariable("id") Long id,
            @PathVariable("firstname") String firstname){
            Optional<Owner> opt = ownerRepository.findById(id);

            if(opt.isPresent()){
                Owner owner = opt.get();
                owner.setFirstname(firstname);
                ownerRepository.save(owner);
                return owner;
            }else {
                return new Owner();
            }
        }
}
