package seminars.third.tdd;

/**
 * Разработайте класс User с методом аутентификации по логину и паролю. Метод должен возвращать true, если
 * введенные логин и пароль корректны, иначе false. Протестируйте все методы
 */
public class User {

    String name;
    String password;
    Boolean isAdmin;
    boolean isAuthenticate;

    public User(String name, String password, boolean isAdmin, boolean isAuthenticate) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isAuthenticate = isAuthenticate;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        return name == this.name & password == this.password;
    }

}