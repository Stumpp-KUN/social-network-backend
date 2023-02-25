package com.network.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name="user_id",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;

    @JoinColumn(name = "post",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Post post;
}
