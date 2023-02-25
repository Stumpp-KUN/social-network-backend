package com.network.backend.web.dto.message;

import com.network.backend.model.Users;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class MessageDTO {
    private long id;
    @NotBlank(message = "Message should not be empty")
    private String message;
    private LocalDateTime date;
    private Users users1;
    private Users users2;
}
