package com.network.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Image {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "postId",referencedColumnName = "id")
    private Long postId;
    private String imgPath;

    public Image(Long postId, String imgPath) {
        this.postId = postId;
        this.imgPath = imgPath;
    }
}
