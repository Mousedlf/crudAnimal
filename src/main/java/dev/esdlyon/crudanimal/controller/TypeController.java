package dev.esdlyon.crudanimal.controller;

import dev.esdlyon.crudanimal.entity.Type;
import dev.esdlyon.crudanimal.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/all")
    public List<Type> getAll() {
        return typeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Type> getById(@PathVariable long id) {
        return typeService.findById(id);
    }

    @PostMapping("/new")
    public Type create(@RequestBody Type animal) {
        return typeService.save(animal);
    }

    @PutMapping("/{id}/edit")
    public Type update(@PathVariable long id, @RequestBody Type animal) {
        return typeService.update(id, animal);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable long id) {
        typeService.deleteById(id);
    }


}
