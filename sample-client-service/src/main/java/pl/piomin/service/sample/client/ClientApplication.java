package pl.piomin.service.sample.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {

	/**
	 * -- 직접 트리거링 방식 --
	 * 1.
	 * http://localhost:8081/ping
	 *
	 * 2. zone1의 설정 변경 커밋 후
	 * https://github.com/Justin-ad-Park/spring-cloud-config-repo/blob/master/client-service-zone1.yml
	 *
	 * 3. 프로퍼티 refresh
	 * http://localhost:8081/refresh
	 *
	 * 4. 변경 확인
	 * http://localhost:8081/ping
	 *
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApplication.class).web(true).run(args);
	}

}
