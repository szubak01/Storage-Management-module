package com.example.storagemanagement.domain.contractor;

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
@Entity(name = "contractor")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contractorName;
    private Long nip;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "contractor") //, fetch = FetchType.EAGER, orphanRemoval = true,
    private List<Assignment> assignments;
}
