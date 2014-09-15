package se.enbohms.bdd.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.ejb.Singleton;

import se.enbohms.bdd.entity.User;

/**
 * Service responsible for registering new users
 * 
 * @author enbohm
 *
 */
@Singleton
public class RegistrationService {

    private Map<String, User> users = new HashMap<>();
    
    /**
     * Registers a new user
     * @param user
     * @throws UserExistException if user already exist
     */
    public void register(User user) throws UserExistException {
        if (users.containsKey(user.getUserName())) {
            throw new UserExistException();
        }
        users.put(user.getUserName(), user);
    }
    
    
    /**
     * 
     * @param userName
     * @return {@code true} if user name exist {@code false} otherwise
     */
    public boolean userExist(String userName){
        return users.containsKey(userName);
    }
    
    /**
     * 
     * @param userName
     * @return a Optional<User>
     */
    public Optional<User> getUser(String userName) {
        return users.get(userName) != null ? Optional.of(users.get(userName)) : Optional.empty();
    }
}