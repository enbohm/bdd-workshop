package se.enbohms.bdd.facade;

import java.io.Serializable;
import java.util.Optional;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import se.enbohms.bdd.entity.User;
import se.enbohms.bdd.service.RegistrationService;

/**
 * A CDI Facade which is responsible for loggin in users (using services)
 * 
 * @author enbohm
 *
 */
@Named
@SessionScoped
public class LoginFacade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private transient RegistrationService registrationService;

    private String userName;

    private User user;

    /**
     * 
     * @param userName
     * @return the user assiciated with the user name or {@code null} otherwise
     */
    public void login() {
        Optional<User> foundUser = registrationService.getUser(userName);
        if (foundUser.isPresent()) {
            user = foundUser.get();
        } else {
            FacesContext.getCurrentInstance().addMessage("Login failed", new FacesMessage("Login failed, please try again"));
        }
    }

    /**
     * Logs out the current user
     */
    public void logout() {
        this.user = null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }
}