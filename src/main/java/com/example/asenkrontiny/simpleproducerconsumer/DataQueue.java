package com.example.asenkrontiny.simpleproducerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
    final Queue<Message> queue=new LinkedList<>();
    final int maxSize;
    final Object FULL_QUEUE = new Object();
    final Object EMPTY_QUEUE = new Object();

    public DataQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public void waitOnFull() throws InterruptedException {
        synchronized (FULL_QUEUE) {
            FULL_QUEUE.wait();
        }
    }

    public void notifyAllForFull() {
        synchronized (FULL_QUEUE) {
            FULL_QUEUE.notifyAll();
        }
    }

    public void waitOnEmpty() throws InterruptedException {
        synchronized (EMPTY_QUEUE) {
            EMPTY_QUEUE.wait();
        }
    }

    public void notifyAllForEmpty() {
        synchronized (EMPTY_QUEUE) {
            EMPTY_QUEUE.notify();
        }
    }

    public void add(Message message) {
        synchronized (queue) {
            queue.add(message);
        }
    }

    public Message remove() {
        synchronized (queue) {
            return queue.poll();
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }


}
