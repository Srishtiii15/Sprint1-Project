package capgemini.emp_asset.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import capgemini.emp_asset.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

	@Autowired UserServiceImpl userService;

	@Test
	public final void testAddUser() {
		User user = new User();
		user.setUserId(4);
		user.setUsername("abc");
		user.setPassword("abc@123");
		user.setRole("Analyst");
		
		user=userService.addUser(user);
		assertThat(user.getUsername().equalsIgnoreCase("abc"));
	}

	@Test
	public final void testRemoveUser() {
		User user = new User();
		user.setUserId(5);
		user.setUsername("xyz");
		user.setPassword("xyz@123");
		user.setRole("Analyst");
		
		user=userService.addUser(user);
		userService.removeUser(user);
		assertThat(user.getUserId()==0);
	}

}
