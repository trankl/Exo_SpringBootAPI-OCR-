package com.exo.WebAPI.Repository;

import org.springframework.data.repository.CrudRepository;

import com.exo.WebAPI.Model.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface UserRepositories extends CrudRepository<User, Integer>{

}
