package dev.esdlyon.crudanimal.service;

import dev.esdlyon.crudanimal.entity.Type;
import dev.esdlyon.crudanimal.repository.TypeRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> findAll(){
        return typeRepository.findAll();
    }

    public Optional<Type> findById(long id){
        return typeRepository.findById(id);
    }
    public Type save(Type type) {
        return typeRepository.save(type);
    }
    public Type update(long id, Type type) {
        Optional<Type> optionalType = typeRepository.findById(id);
        if(optionalType.isPresent()) {
            Type typeToUpdate = optionalType.get();
            typeToUpdate.setName(type.getName());
            return typeRepository.save(typeToUpdate);
        }else {
            throw new RuntimeException("Type not found" + id);
        }
    }

    public void deleteById(long id) {
        typeRepository.deleteById(id);
    }
}

