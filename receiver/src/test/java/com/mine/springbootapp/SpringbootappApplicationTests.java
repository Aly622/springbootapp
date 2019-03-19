package com.mine.springbootapp;

import com.mine.receiver.HelloReceive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootappApplicationTests {
	@Autowired
	private HelloReceive helloReceive;
	@Test
	public void contextLoads() {
		//helloReceive.processC();
	}

}
