package com.network.backend.dto.message;

import com.network.backend.model.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class MessageDTO {
    private long id;
    @NotBlank(message = "Message should not be empty")
    private String message;
    private LocalDateTime date;
    private User user1;
    private User user2;
}
