package se.enbohms.bdd.facade;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import se.enbohms.bdd.entity.User;
import se.enbohms.bdd.service.RegistrationService;
import se.enbohms.bdd.service.UserExistException;

/**
 * A CDI Facade which is responsible for validation input from the registration
 * form and creation of new users (using services)
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
        try {
            registrationService.register(user);
            return "registered.xhtml";
        } catch (UserExistException e) {
            FacesContext.getCurrentInstance().addMessage("User already exist", new FacesMessage("User already exist"));
            return "";
        }
    }

    /**
     * JSF/Ajax callback method which check if a certain user name exist or not
     * 
     * @param userName
     */
    public void validateUser(AjaxBehaviorEvent event) {
        if (registrationService.userExist(user.getUserName())) {
            FacesContext.getCurrentInstance().addMessage("User already exist", new FacesMessage("User already exist"));
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}