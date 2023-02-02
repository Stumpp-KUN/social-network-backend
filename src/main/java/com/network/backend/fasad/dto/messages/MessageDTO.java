package com.network.backend.fasad.dto.messages;

import com.network.backend.models.User;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public abstract class MessageDTO {
    private long id;
    @Size(min = 1, message = "Incorrect message length")
    private String message;
    private Date date;
    private User user1;
    private User user2;
}
