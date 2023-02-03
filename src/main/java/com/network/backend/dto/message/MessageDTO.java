package com.network.backend.dto.message;

import com.network.backend.model.User;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public abstract class MessageDTO {
    private long id;
    @Size(min = 1, message = "Incorrect message length")
    private String message;
    private LocalDateTime date;
    private User user1;
    private User user2;
}
