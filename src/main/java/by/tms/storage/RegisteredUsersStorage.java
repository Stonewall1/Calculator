package by.tms.storage;

import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class RegisteredUsersStorage {
    private static final List<User> users = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong(0);

    public void save(User user){
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
    }
    public Optional<User> findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}