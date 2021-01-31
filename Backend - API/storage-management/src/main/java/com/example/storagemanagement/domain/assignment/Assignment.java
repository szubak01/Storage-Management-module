package com.example.storagemanagement.domain.assignment;


import com.example.storagemanagement.domain.contractor.Contractor;
import com.example.storagemanagement.domain.product.Product;
import com.example.storagemanagement.domain.storage.Storage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;


    @JsonIgnoreProperties("assignments")
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    private Product product;

    @JsonIgnoreProperties("assignments")
    @ManyToOne
    @JoinColumn(name = "id_contractor", referencedColumnName = "id", nullable = false)
    private Contractor contractor;

    @JsonIgnoreProperties("assignments")
    @ManyToOne
    @JoinColumn(name = "id_storage", referencedColumnName = "id", nullable = false)
    private Storage storage;



}
