package com.myapp.mywebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserSErvice {
    @Autowired private UserRepository repo;
    public List<user>listall(){
        return (List<user>) repo.findAll();
    }

    public void save(user user) {
        repo.save(user);
    }

    public user get(Integer id) throws userNotfoundException {
      Optional<user> resultat= repo.findById(id);
      if (resultat.isPresent()){
          return resultat.get();
      }
      throw  new userNotfoundException("on n epeoeueb dejbfejbfebfjk",+id);
    }
  public  void  delete(Integer id) throws userNotfoundException {

      Long count = repo.countByid(id);
      if (count ==null || count==0)
          throw  new userNotfoundException("on n epeoeueb dejbfejbfebfjk",+id);
      repo.deleteById(id);
  }
}
