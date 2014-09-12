package se.enbohms.bdd.service;

import javax.ejb.Singleton;

import se.enbohms.bdd.entity.User;

/**
 * Service responsible for fetching reward points for s specific user
 * 
 * @author enbohm
 *
 */
@Singleton
public class RewardService {

    public Integer getCurrentPoints(User user) {
        return 100;
    }
}
