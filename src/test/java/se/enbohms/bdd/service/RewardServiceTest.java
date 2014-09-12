package se.enbohms.bdd.service;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import se.enbohms.bdd.entity.User;

/**
 * Test client for the {@link RewardService}
 * 
 * @author enbohm
 *
 */
public class RewardServiceTest {

	@Test
	public void should_return_correct_rewards_points_for_new_customer() {
		// given
		RewardService service = new RewardService();

		// when
		Integer result = service.getCurrentPoints(new User());

		// then
		assertThat(result).isEqualTo(100);
	}
}
