package com.example.storagemanagement.domain.product;


import com.example.storagemanagement.domain.assignment.Assignment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class Product {

    public Product(Long id, String name){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "product") //, fetch = FetchType.EAGER, orphanRemoval = true,
    private List<Assignment> assignments;




}
