package com.network.backend.web.dto.comment;

import com.network.backend.model.Post;
import com.network.backend.model.Users;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class CommentDTO {
    private long id;
    @NotBlank(message = "Comment should not be null")
    private String message;
    private LocalDateTime date;
    @NotNull(message = "Comment should have a receiver")
    private Users users;
    @NotNull(message = "Enter a post")
    private Post post;
}
