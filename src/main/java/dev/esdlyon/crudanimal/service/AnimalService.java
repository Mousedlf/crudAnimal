package dev.esdlyon.crudanimal.service;

import dev.esdlyon.crudanimal.entity.Animal;
import dev.esdlyon.crudanimal.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public Optional<Animal> findById(Long id){
        return animalRepository.findById(id);
    }

    public Animal findByName(String name) {
        return animalRepository.findByName(name);
    }

    public Animal save(Animal animal){
        return animalRepository.save(animal);
    }

    public Animal update(Animal animal){
        return animalRepository.save(animal);
    }

    public void deleteById(long id){
        animalRepository.deleteById(id);
    }
}
