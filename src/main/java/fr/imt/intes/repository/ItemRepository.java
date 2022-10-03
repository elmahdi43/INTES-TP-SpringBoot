package fr.imt.intes.repository;

import fr.imt.intes.model.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemEntity, Long> {



}
