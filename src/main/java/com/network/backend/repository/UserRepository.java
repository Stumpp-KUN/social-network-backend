package com.network.backend.repository;

import com.network.backend.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {

}
