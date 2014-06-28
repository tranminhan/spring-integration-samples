package helloworld;

import static org.junit.Assert.*;

import org.antran.integration.helloworld.service.GreeterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/applicationContext.xml")
public class HelloWorldTestWithFileContent {

	@Autowired
	GreeterService greeterService;

	@Test
	public void shouldCallServiceOK() {
		greeterService.greet("From Test");
	}

}
