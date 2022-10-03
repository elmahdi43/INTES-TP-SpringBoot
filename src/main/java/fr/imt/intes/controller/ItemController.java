package fr.imt.intes.controller;

import fr.imt.intes.model.ItemEntity;
import fr.imt.intes.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService service;

    @GetMapping("/hello")
    public ResponseEntity<String> getHelloPage() {
        return new ResponseEntity<String>( "Hello world !",HttpStatus.OK);
    }




    @GetMapping("/{name}")
    public String getHelloDynamiquePage (@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
    //spring.jpa.hibernate.ddl-auto=create

    @GetMapping("/service/item")
    public ResponseEntity<ItemEntity> getItems(){
        ItemEntity item0 = new ItemEntity(1L,"table", 12, 2);
        List<ItemEntity> listItems = service.findAllItems();
        listItems.add(item0);

        return new ResponseEntity<ItemEntity>(HttpStatus.OK);
    }

    @PostMapping
    public String postItem(@RequestAttribute("itemEntity") ItemEntity itemEntity){
        service.save(itemEntity);
        return "redirect:/";
    }
}
