package com.network.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String message;
    @Column
    private LocalDateTime date;

    @JoinColumn(name="sender",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;

    @JoinColumn(name="post",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Post post;
}
