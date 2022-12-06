package com.example.asenkrontiny.controller;

import com.example.asenkrontiny.service.AsyncService;
import com.google.common.collect.Lists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class AsyncController {
    private final AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/doAsync")
    public ResponseEntity<String> doAsync(){

        Stream<Integer> infinite=Stream.iterate(0,i-> i+2);

        List<Integer> taskList=infinite.limit(2000).collect(Collectors.toList());
        List<List<Integer>> partitioned = Lists.partition(taskList,20);
        partitioned.parallelStream().forEach(asyncService::doAsync);

        return ResponseEntity.ok("Asenkron işlem başladı");


    }
}
