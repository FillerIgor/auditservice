package integrationTest;

import com.example.demo.DemoApplication;
import com.example.demo.controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    @Autowired
    private UserController sut;

    @BeforeEach
    void setUp() {
        //todo create DB.
    }

    @Test
    void shouldCreateUser() {
        //given
        //when
        //then
    }

    @Test
    void shouldGetUser() {
        //given
        //when
        //then
    }

    @Test
    void shouldUpdateUser() {
        //given
        //when
        //then
    }

    @Test
    void shouldDeleteUser() {
        //given
        //when
        //then
    }
}
