package com.poly.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(length = 50, columnDefinition = "nvarchar(50)")
	    private String name;

	    @Column(length = 50, columnDefinition = "nvarchar(50)")
	    private String description;

	    @Column(length = 50, columnDefinition = "nvarchar(50)")
	    private String type;
}
