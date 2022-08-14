package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.RegisteredUsersStorage;

import java.util.Optional;

public class RegistrationService {
    private final RegisteredUsersStorage registeredUsersStorage = new RegisteredUsersStorage();

    public void register(User user) {
        registeredUsersStorage.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return registeredUsersStorage.findByEmail(email);
    }
}