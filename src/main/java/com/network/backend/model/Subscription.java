package com.network.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "users", referencedColumnName = "id")
    @ManyToOne
    private Users user;
    @JoinColumn(name = "subscriber", referencedColumnName = "id")
    @ManyToOne
    private Users subscriber;

}
