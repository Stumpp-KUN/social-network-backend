package com.network.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image")
@NoArgsConstructor
@Data
public class Image {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "postPath")
    private long postPath;
    @Column(name = "imgPath")
    private String imgPath;
}
