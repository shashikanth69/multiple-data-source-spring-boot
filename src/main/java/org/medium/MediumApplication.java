package org.medium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.medium.jpa")
@EnableRedisRepositories(basePackages = "org.medium.redis", enableKeyspaceEvents = RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP)
public class MediumApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MediumApplication.class);
        application.run(args);
    }
}
