package com.network.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user1")
    private User user1;

    @JoinColumn(name="user",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user2;

    public Message(String message, Date date) {
        this.message = message;
        this.date = date;
    }
}
