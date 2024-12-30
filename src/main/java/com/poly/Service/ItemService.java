package com.poly.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DTO.ItemDTO;
import com.poly.Repository.ItemRepository;
import com.poly.entity.Item;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemDTO(
                        item.getId(),
                        item.getName(),
                        item.getDescription(),
                        item.getType()
                ))
                .collect(Collectors.toList());
    }

    public ItemDTO getItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
        return new ItemDTO(item.getId(), item.getName(), item.getDescription(), item.getType());
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        item.setType(itemDetails.getType());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
        itemRepository.delete(item);
    }
    public List<Item> findByName(String name) {
        return itemRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Item> findByType(String type) {
        return itemRepository.findByType(type);
    }
}