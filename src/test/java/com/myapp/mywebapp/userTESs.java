package com.myapp.mywebapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class userTESs {
 @Autowired private UserRepository repo;

 @Test
 public void testAdDNew(){
  user user=new user();
  user.setEmail("thiamasjo@gmail.com");
  user.setPassword("papa");
  user.setNom("youssouph");
  user.setPrenom("thia");

  user saveDUser= repo.save(user);

  Assertions.assertThat(saveDUser).isNotNull();
  Assertions.assertThat(saveDUser.getId()).isGreaterThan(0);

 }
}
