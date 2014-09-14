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
     */
    public void register(User user) {
        System.out.println("Register new user "+user);
        users.put(user.getUserName(), user);
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