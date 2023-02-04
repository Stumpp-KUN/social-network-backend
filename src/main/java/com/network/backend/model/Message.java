package com.network.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "message")
@NoArgsConstructor
public class Message {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "message")
    private String message;
    @Column(name="time")
    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user",referencedColumnName = "id")
    private User sender;

    @JoinColumn(name="user",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User receiver;

    public Message(String message, LocalDateTime date) {
        this.message = message;
        this.date = date;
    }
}
