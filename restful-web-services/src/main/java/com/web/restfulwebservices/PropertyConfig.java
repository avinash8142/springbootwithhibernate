package com.web.restfulwebservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring-cloud")
public class PropertyConfig {
	
	private String minimum;
	private String maximum;
	
	public PropertyConfig() {
		super();
	}
	
	public String getMinimum() {
		return minimum;
	}

	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}

	public String getMaximum() {
		return maximum;
	}
	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}
	@Override
	public String toString() {
		return "PropertyConfig [minimum=" + minimum + ", maximum=" + maximum + "]";
	}
	
	
	
	

}
