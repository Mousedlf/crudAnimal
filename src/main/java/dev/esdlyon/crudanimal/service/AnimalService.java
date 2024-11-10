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

    public Animal update(long id, Animal animal){
        Optional<Animal> optionalAnimal = animalRepository.findById(id);

        if(optionalAnimal.isPresent()){
            Animal animalToUpdate = optionalAnimal.get();
            animalToUpdate.setName(animal.getName());
            return animalRepository.save(animalToUpdate);
        } else {
            throw new RuntimeException("Animal not found with id: " + id);
        }
    }

    public void deleteById(long id){
        animalRepository.deleteById(id);
    }
}
