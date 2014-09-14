package se.enbohms.bdd.facade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import se.enbohms.bdd.entity.User;
import se.enbohms.bdd.service.RegistrationService;

/**
 * A CDI Facade which is responsible for validation input from the registration form
 * and creation of new users (using services)
 * 
 * @author enbohm
 *
 */
@Named
@RequestScoped
public class RegistrationFacade {

    @Inject
    private transient RegistrationService registrationService;

    private User user = new User();

    /**
     * Registers the user by delegation to {@link RegistrationService}
     */
    public String register() {
        registrationService.register(user);
        return "registered.xhtml?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}