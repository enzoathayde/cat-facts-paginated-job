package com.pagination.client.catfacts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "facts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Facts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fact")
    private String fact;

    @Column(name = "length_value")
    private Integer lengthValue;

}
