package com.github.toficzak.book_store.a;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    // this actually auto creates queue - guess it's time to read docs
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

}
