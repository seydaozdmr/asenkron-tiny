package com.example.asenkrontiny.simpleproducerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    final BlockingQueue<Message> dataQueue;


    public Consumer(BlockingQueue<Message> dataQueue) {
        this.dataQueue = dataQueue;
    }



    @Override
    public void run() {
        consume();
    }

    public void consume() {

        while(true){
            Message message;
            try{
                message = dataQueue.take();
            }catch (InterruptedException e){
                break;
            }
            useMessage(message);
        }


    }


    private void useMessage(Message message){
        System.out.println(message.id+" : "+message.data);
    }
}
