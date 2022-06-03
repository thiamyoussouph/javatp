package com.myapp.mywebapp;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<user,Integer> {

    public  long countByid(Integer id);
}
