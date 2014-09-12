package se.enbohms.bdd.entity;

/**
 * Represents a user in Cinema Reward feature
 * 
 * @author enbohm
 *
 */
public class User {

    private String userName;
    private String firstName;
    private String lastName;
    private Integer rewardPoints = Integer.valueOf(100);

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", rewardPoints=" + rewardPoints + "]";
    }
}
