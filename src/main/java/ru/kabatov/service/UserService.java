package ru.kabatov.service;

/**
 * Created by Кабатов on 22.08.2017.
 */
import java.util.ArrayList;
import java.util.List;
import ru.kabatov.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    List<User> users = new ArrayList<User>();

    public UserService() {
        init();
    }

    private void init(){
        users.add(new User(Long.valueOf(1), "alec"));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void updateUser(User user) {
        for (User us : users) {
            if (us.getId().longValue() == user.getId().longValue()) {
                int index = users.indexOf(us);
                users.set(index, user);
                break;
            }
        }
    }

    @Override
    public void deleteUser(Long id) {
        for(User u : users){
            if(u.getId().longValue() == id.longValue()) {
                users.remove(u);
                break;
            }
        }
    }

    @Override
    public void addUser(User user) {
        Long l = Long.MAX_VALUE;
        for (User u : users) {
            l = u.getId();
        }
        user.setId(l + 1);
        users.add(user);
    }
}