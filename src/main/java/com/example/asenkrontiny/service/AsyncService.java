package com.example.asenkrontiny.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsyncService {

    @Async("asyncWork")
    public void doAsync(List<Integer> taskList) {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        taskList.forEach(System.out::println);
    }
}
