package com.network.backend.web.dto.user;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public abstract class UserDTO {
    private long id;
    @Size(min = 2,message = "Wrong name length, should be > 2 letters")
    private String name;
    @Size(min=4,message = "Wrong surname length, should be > 4 letters")
    private String surname;
    @Size(min=4, message = "Wrong email length, should be > 4 letters")
    private String email;
    @Size (min = 2, message = "Wrong message length, should be > 2 letters")
    private String password;
}
