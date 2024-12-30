package com.poly.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	 @Query("SELECT i FROM Item i WHERE LOWER(i.name) LIKE LOWER(CONCAT('%', :name, '%'))")
	    List<Item> findByNameContainingIgnoreCase(@Param("name") String name);
	 
	 List<Item> findByType(String type);
}