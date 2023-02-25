package com.network.backend.web.dto.subscription;

import com.network.backend.model.Users;
import lombok.Data;

@Data
public abstract class SubscriptionDTO {
    private long id;
    private Users User;
    private Users Sub_id;
}
