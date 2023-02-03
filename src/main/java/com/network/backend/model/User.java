package com.network.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sender")
    private List<Message> messages;

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

//    public void addMessages(Message message,User user){
//        if(messages==null)
//            messages=new ArrayList<>();
//        messages.add(message);
//        message.setUser1(this);
//        message.setUser2(user);
//    }
}