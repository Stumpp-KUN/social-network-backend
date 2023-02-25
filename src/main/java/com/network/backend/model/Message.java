package com.network.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender",referencedColumnName = "id")
    private Users sender;

    @JoinColumn(name="receiver",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Users receiver;

    public Message(String message, LocalDateTime date) {
        this.message = message;
        this.date = date;
    }
}
