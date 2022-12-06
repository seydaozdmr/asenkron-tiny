package com.example.asenkrontiny.simpleproducerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    public static void main(String[] args) {

        BlockingQueue<Message> dataQueue = new LinkedBlockingQueue<>(100);

        Producer producer = new Producer(dataQueue);
        Thread producerThread = new Thread(producer);
        Producer producer1 = new Producer(dataQueue);
        Thread producerThread1 = new Thread(producer1);
        Consumer consumer = new Consumer(dataQueue);
        Thread consumerThread = new Thread(consumer);
        Consumer consumer1=new Consumer(dataQueue);
        Thread consumerThread1=new Thread(consumer1);



        producerThread.start();
        producerThread1.start();
        consumerThread.start();
        consumerThread1.start();
    }
}
