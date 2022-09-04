package by.tms.storage;

import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class RegisteredUsersStorage implements InMemoryStorage<User>{
    private static RegisteredUsersStorage instance;

    private RegisteredUsersStorage() {

    }

    public static RegisteredUsersStorage getInstance() {
        if (instance == null) {
            instance = new RegisteredUsersStorage();
        }
        return instance;
    }

    private final List<User> users = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong(0);
    @Override
    public User save(User user) {
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
        return user;
    }

    public Optional<User> findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
    @Override
    public List<User> getElements() {
        return users;
    }
}