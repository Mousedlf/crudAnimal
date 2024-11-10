package dev.esdlyon.crudanimal.controller;

import dev.esdlyon.crudanimal.entity.Animal;
import dev.esdlyon.crudanimal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

   @GetMapping("/all")
    public List<Animal> getAll() {
       return animalService.findAll();
   }

    @GetMapping("/{id}")
    public Optional<Animal> getById(@PathVariable Long id) {
       return animalService.findById(id);
    }

    @PostMapping("/new")
    public Animal create(@RequestBody Animal animal) {
       return animalService.save(animal);
    }

    @PutMapping("/{id}/edit")
    public Animal update(@PathVariable Long id, @RequestBody Animal animal) {
       return animalService.update(animal);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable long id) {
       animalService.deleteById(id);
    }

}
