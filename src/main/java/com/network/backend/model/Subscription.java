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

    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Users user;
    @JoinColumn(name = "subscriber", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Users subscriber;

}
