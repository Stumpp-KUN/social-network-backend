package com.network.backend.fasad.dto.user;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public abstract class UserDTO {
    private long id;
    @Size(min = 2,message = "Wrong name length")
    private String name;
    @Size(min=4,message = "Wrong surname length")
    private String surname;
    @Size(min=4, message = "Wrong email length")
    private String email;
    @Size (min = 2, message = "Wrong message length")
    private String password;
}
