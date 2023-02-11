package com.network.backend.dto.like;

import com.network.backend.model.Post;
import com.network.backend.model.Users;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public abstract class LikeDTO {
    private long id;
    @NotBlank(message = "User can't be null")
    private Users users;
    @NotBlank(message = "Post can't be null")
    private long post;
}
