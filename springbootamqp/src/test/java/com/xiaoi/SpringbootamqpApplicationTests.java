package com.xiaoi;

import com.xiaoi.send.MessageSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootamqpApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private MessageSend messageSend;

	@Test
	public void contextLoads() {
		messageSend.sendMessage();
	}




}
