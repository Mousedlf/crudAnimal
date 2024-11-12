package dev.esdlyon.crudanimal.repository;

import dev.esdlyon.crudanimal.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
