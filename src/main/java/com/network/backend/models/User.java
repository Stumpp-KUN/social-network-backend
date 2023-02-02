package com.network.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user1")
    private List<Message> messages;

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    //не знаю как добавить для двух юзеров, придумал так что 1 юзер
    // отправляет это сообщение  полностью инициализируется message
    public void addMessages(Message message,User user){
        if(messages==null)
            messages=new ArrayList<>();
        messages.add(message);
        message.setUser1(this);
        message.setUser2(user);
    }
}
