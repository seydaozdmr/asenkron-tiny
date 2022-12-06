package com.example.asenkrontiny.simpleproducerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{

    final BlockingQueue<Message> dataQueue;

    public Producer(BlockingQueue<Message> dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        produce();
    }

    public void produce(){
        AtomicInteger id = new AtomicInteger(0);
        while (true) {
            Message value = generateMessage(id.getAndIncrement());
            try {
                dataQueue.put(value);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private Message generateMessage(int id) {
        return new Message(id,Thread.currentThread().getName());
    }
}
