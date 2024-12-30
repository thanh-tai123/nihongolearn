package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.DTO.ItemDTO;
import com.poly.Service.ItemService;
import com.poly.entity.Item;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/items")
public class ItemController {
	 
    @Autowired
    private ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable("id") Long id) { // Chỉ định tên "id"
        ItemDTO item = itemService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.createItem(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") Long id, @RequestBody Item item) {
        return ResponseEntity.ok(itemService.updateItem(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public List<Item> searchByName(@RequestParam("name") String name) {
        return itemService.findByName(name);
    }
    @GetMapping("/filter")
    public List<Item> filterByType(@RequestParam("type") String type) {
        return itemService.findByType(type);
    }
}