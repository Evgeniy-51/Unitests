package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {
    User user;
    UserRepository userRepository = new UserRepository();

    /**
     * Задание 3.  (необязательное)
     * Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов.
     * Для этого, вам потребуется расширить класс User новым свойством, указывающим, обладает ли пользователь
     * админскими правами. Протестируйте данную функцию.
     */

    @Test
    void adminLogOut(){
        String username = "John";
        user = new User(username, "john123", true, true);
        userRepository.addUser(user);
        userRepository.logOut(username);
        assertThat(user.isAuthenticate).isTrue();
    }

    @Test
    void guestLogOut(){
        String username = "Alex";
        user = new User(username, "alex123", false, true);
        userRepository.addUser(user);
        userRepository.logOut(username);
        assertThat(user.isAuthenticate).isFalse();
    }


    /**
     * Задание №6
     * Разработайте класс User с методом аутентификации по логину и паролю. Метод должен возвращать true, если
     * введенные логин и пароль корректны, иначе false. Протестируйте все методы
     */
    @BeforeEach
    void setUp(){user = new User("Alex", "alex123", false, true);}

    @Test
    void authenticateFalseTest() {
        assertThat(user.authenticate("Alex", "AnotherPassword")).isFalse();
        assertThat(user.authenticate("AnotherName", "alex123")).isFalse();
    }

    @Test
    void authenticateTrueTest() {
        assertThat(user.authenticate("Alex", "alex123")).isTrue();
    }



}