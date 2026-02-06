package com.veneta.prestotest.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configuration
@MapperScan("com.veneta.prestotest.presto.dao")
public class PrestoConfig {
    @Bean
    public Scheduler prestoScheduler() {
        // JDBC의 Blocking 작업을 처리할 전용 스케줄러 생성
        return Schedulers.newBoundedElastic(10, 100, "presto-pool");
    }
}
