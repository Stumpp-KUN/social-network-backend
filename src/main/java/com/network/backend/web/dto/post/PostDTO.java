package com.network.backend.web.dto.post;

import com.network.backend.model.Users;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class PostDTO {
    private long id;
    @Size(min = 1,message = "PostMessage should be longer than 1")
    private String postMessage;
    private LocalDateTime date;
    private Users users;
    private String base64image;
}
