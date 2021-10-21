package com.exo.WebStroreAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exo.WebStroreAPI.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
