package pl.piomin.service.sample.client;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

	/**
	 * -- How to Test 1. Triggering via client directly  --
	 * 1.
	 * http://localhost:8081/ping
	 *
	 * 2. Modify and commit configuration file
	 * https://github.com/Justin-ad-Park/spring-cloud-config-repo/blob/master/client-service-zone1.yml
	 *
	 * 3. 프로퍼티 refresh
	 * http://localhost:8081/refresh
	 *
	 * 4. 변경 확인
	 * http://localhost:8081/ping
	 *
	 *
	 *  -- How to Test 2. Triggering via config server  --
	 *
	 *  1. Modify and commit configuration file
	 *  https://github.com/Justin-ad-Park/spring-cloud-config-repo/blob/master/client-service-zone1.yml
	 *
	 *  2. Call command as below
	 *  curl -H "X-Github-Event: push" -H "Content-Type: application/json" -X POST -d '{"commits": [{"modified": ["client-service-zone1.yml"]}]}' http://localhost:8889/monitor
	 *
	 *  3. 변경 확인
	 * 	http://localhost:8081/ping
	 *
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApplication.class).web(true).run(args);
	}

}
