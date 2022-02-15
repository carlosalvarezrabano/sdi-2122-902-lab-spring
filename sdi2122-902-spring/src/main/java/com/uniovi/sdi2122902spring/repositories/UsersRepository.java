package com.uniovi.sdi2122902spring.repositories;

import com.uniovi.sdi2122902spring.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByDni(String dni);
}
