package com.spring.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Endpoint(id = "custome-endpoint", enableByDefault = true)
public class MyEndPoint {

	@ReadOperation
	public CustomeEndPointResponse features() {
		return new CustomeEndPointResponse(1, "Employee", "Active");
	}

}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class CustomeEndPointResponse {
	private int id;
	private String name;
	private String status;
}
