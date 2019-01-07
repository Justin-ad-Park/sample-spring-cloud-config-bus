package pl.piomin.service.sample.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.monitor.GithubPropertyPathNotificationExtractor;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

/**
 * 	 1. Run rabbitMP after checking rabbit container
 *
 * 	 	1-1. Check the docker is running or not
 * 	 	lsof -nP -i4TCP | grep LISTEN|grep 15671
 *
 * 	 	1-2. Check exist rabbit container in docker
 * 	 	docker ps -a|grep rabbit
 *
 * 	 	1-3. start rabbit container
 * 	 	docker start rabbit
 *
 * 		1-4. If doesn't exist a rabbit container, run rabbit
 * 	 	docker run -d --name rabbit -p 5672:5672 -p 15672:15672 rabbitmq:management
 *
 * 	rabbitMP default username / password : guest / guest
 *
 * 	 2. Run Config-service
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigApplication.class).web(true).run(args);
	}

	@Bean
	public GithubPropertyPathNotificationExtractor githubPropertyPathNotificationExtractor() {
		return new GithubPropertyPathNotificationExtractor();
	}
}
