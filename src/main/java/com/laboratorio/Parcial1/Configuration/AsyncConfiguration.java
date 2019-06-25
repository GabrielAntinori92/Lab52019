package com.laboratorio.Parcial1.Configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

    @Value("${executor.corePoolSize: 3}")
    private  Integer CORE_POL_SIZE;

    @Value("${executor.maxPoolSize: 4}")
    private  Integer MAX_POOL_SIZE;

    @Value("${executor.queueCapacity: 50}")
    private  Integer QUEUE_CAPACITY;

    @Bean("threadPoolTaskExecutor")
    public Executor asyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(CORE_POL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.initialize();
        return executor;
    }
}
