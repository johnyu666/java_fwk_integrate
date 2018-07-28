package jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class MyListener implements MessageListener {
	
	public void onMessage(Message arg0){
		TextMessage msg=(TextMessage)arg0;
		try {
			System.out.println(msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
