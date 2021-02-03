package br.com.wallet.repository;

import br.com.wallet.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
public class UserRepositoryTest {

    private static final String EMAIL = "bernardo@teste.com";

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp(){
        User u = new User();
        u.setName("bernardo");
        u.setPassword("123");
        u.setEmail(EMAIL);
        userRepository.save(u);
    }
    @After
    public void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    public void  testSave(){
        User usuario = new User();
        usuario.setName("test");
        usuario.setPassword("102030");
        usuario.setEmail("bernardo@teste.com");

       User response = userRepository.save(usuario);

       assertNotNull(response);
    }

    @Test
    public void findByEmailTest(){
        Optional<User> response = userRepository.findByEmailEquals(EMAIL);

        assertTrue(response.isPresent());
    }



}
