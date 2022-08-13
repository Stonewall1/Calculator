package by.tms.service.validation;

import by.tms.entity.User;
import by.tms.storage.RegisteredUsersStorage;

public class UserRegistrationValidation {
    private final RegisteredUsersStorage registeredUsersStorage = new RegisteredUsersStorage();

    public boolean checkUserInStorage(User user){
        for(User u : registeredUsersStorage.getUsers()){
            if(user.getEmail().equals(u.getEmail())){
                return true;
            }
        }
        return false;
    }
    public boolean checkIsFieldsEmpty(User user){
        return user.getEmail().equals("") || user.getPassword().equals("") || user.getName().equals("");
    }
}
