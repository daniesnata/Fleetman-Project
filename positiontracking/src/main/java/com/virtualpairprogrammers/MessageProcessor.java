package com.virtualpairprogrammers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * This class served only as Listener to queue in ActiveMQ
 */
@Component
public class MessageProcessor {

	@Autowired
	private Data data;
	
	@JmsListener(destination = "positionQueue")
	public void processPositionMessageFromQueue(Map<String, String> message) {
		data.updatePosition(message);
	}
}
