package fr.imt.intes.service;

import fr.imt.intes.model.ItemEntity;
import fr.imt.intes.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;


@Service

public class ItemService {
    @Autowired
    ItemRepository repository;

    public void save(ItemEntity entity) {
        repository.save(entity);
    }

    public void delete(ItemEntity entity){
        repository.deleteById(entity.getId());
    }
  //  ItemEntity findFirstByName (){
  //      return null;
  //  }
    public List<ItemEntity> findAllItems (){
        return (List<ItemEntity>) repository.findAll();
    }
    Page<ItemEntity> findAll (Pageable page){
        return null;
    }



}
