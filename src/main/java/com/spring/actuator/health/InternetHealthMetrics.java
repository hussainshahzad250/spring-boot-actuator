package com.spring.actuator.health;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InternetHealthMetrics implements HealthIndicator {

	@Override
	public Health health() {
		return checkConnection() ? Health.up().withDetail("message", "You are Online").build()
				: Health.down().withDetail("message", "You are Offline").build();
	}

	private boolean checkConnection() {
		boolean flag = false;
		try {
			URL url = new URL("https://www.google.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
