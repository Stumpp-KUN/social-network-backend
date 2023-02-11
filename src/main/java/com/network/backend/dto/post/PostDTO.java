package com.network.backend.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class PostDTO {
    private long id;
    private String imagePath;
    private String postMessage;
    private LocalDateTime date;
}
