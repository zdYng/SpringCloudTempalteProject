package com.example.configclient;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
@Component
class ConfigclientApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void send(){
		amqpTemplate.convertAndSend("myQueue", "now" + new Date());

	}
}
