package com.network.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(schema = "public",name = "post")
@Entity
@NoArgsConstructor
public class Post {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "post_message")
    private String postMessage;
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @JoinColumn(name="users",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;

    @JoinColumn(name = "imagePath",referencedColumnName = "imgPath")
    private String base64image;

}
