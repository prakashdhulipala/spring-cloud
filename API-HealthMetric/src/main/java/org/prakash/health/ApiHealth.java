package org.prakash.health;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConditionalOnProperty(name = "management.endpoint.health.apihealth.enabled", havingValue = "true")
public class ApiHealth implements HealthIndicator {
	@Autowired
	Environment env;
	
	@Autowired
	RestTemplate template;
	
	@Bean
	@ConditionalOnMissingBean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@Value("${management.endpoint.health.apihealth.monitor}")
	String[] apis;
	
	@Override
	public Health health() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		if (apis != null) {
			for (String api : apis) {
				String url = getApi(api);
				String health = getApiHealthEndPoint(api);
				Map<String, String> map = new HashMap<String, String>();
				map.put("url", url);
				map.put("health", health);
				String forObject = template.getForObject(health, String.class);
				if (forObject.contains("{\"status\":\"UP\"")) {
					map.put("status", "UP");
				}
				list.add(map);
			}
		}
		return Health.up().withDetail("health", list).build();
	}
	
	public String getApiHealthEndPoint(String key){
		return env.getProperty(key+".health");
	}
	
	public String getApi(String key){
		return env.getProperty(key);
	}
	
}


@Component
class Test implements HealthIndicator {
	@Override
	public Health health() {
		return Health.up().withDetail("status", "up").build();
	}
	
	
}
