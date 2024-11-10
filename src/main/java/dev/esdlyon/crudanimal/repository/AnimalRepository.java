package dev.esdlyon.crudanimal.repository;

import dev.esdlyon.crudanimal.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Animal findByName(@Param("name") String name);
}
