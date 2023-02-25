package com.network.backend.web.dto.like;

import com.network.backend.model.Post;
import com.network.backend.model.Users;
import lombok.Data;

@Data
public abstract class LikeDTO {
    private long id;
    private Users users;
    private Post post;
}
