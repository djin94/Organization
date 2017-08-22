package ru.kabatov.service;

/**
 * Created by Кабатов on 22.08.2017.
 */

import java.util.List;
import ru.kabatov.domain.User;

public interface IUserService {
    List<User> getAll();
    void updateUser(User user);
    void deleteUser(Long id);
    void addUser(User user);

}