package com.example.storagemanagement.domain.storage;

import com.example.storagemanagement.domain.assignment.Assignment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "storage") //, fetch = FetchType.EAGER, orphanRemoval = true,
    private List<Assignment> assignments;
}
