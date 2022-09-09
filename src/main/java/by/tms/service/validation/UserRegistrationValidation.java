package by.tms.service.validation;

import by.tms.entity.User;
import by.tms.service.RegistrationService;

public class UserRegistrationValidation {
    private final RegistrationService registrationService = RegistrationService.getInstance();

    public boolean checkUserInStorage(User user) {
        for (User u : registrationService.getUsers()) {
            if (user.getEmail().equals(u.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIsFieldsEmpty(User user) {
        return user.getEmail().isEmpty() || user.getPassword().isEmpty() || user.getName().isEmpty();
    }
}
