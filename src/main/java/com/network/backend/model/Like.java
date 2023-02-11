package com.network.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "likes")
@Data
@NoArgsConstructor
public class Like {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name="user_id",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;

    @Column(name = "post")
    private long post_id;
}
