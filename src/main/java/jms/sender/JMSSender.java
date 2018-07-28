package jms.sender;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
@Component
public class JMSSender {
	
	@Autowired
	private JmsTemplate template;
	@Autowired
	private Destination dest;

	@PostConstruct //JSR-250 相当于init-method,@PreDestroy相当于destroy-method
	public void init() throws Exception {
		System.out.println("init...........");
		template.send(dest, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage(System.currentTimeMillis()+"");
				return msg;
			}
		});
	}



}
