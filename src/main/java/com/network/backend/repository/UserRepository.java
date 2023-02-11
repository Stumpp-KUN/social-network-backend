package com.network.backend.repository;

import com.network.backend.model.Users;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends CrudRepository<Users,Long> {

}
