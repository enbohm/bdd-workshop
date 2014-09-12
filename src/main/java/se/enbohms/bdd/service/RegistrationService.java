package se.enbohms.bdd.service;

import javax.ejb.Singleton;

import se.enbohms.bdd.entity.User;

/**
 * Service responsible for registering new users
 * @author enbohm
 *
 */
@Singleton
public class RegistrationService {

	public void register(User user) {
	    System.out.println("Registering user " +user);
	}
}
