/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author rajan
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class ServiceQueue {
    
    private int processingTime;
    private boolean checkStop = true;
    

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }
    
     private int currentSize; //Current Circular Queue Size
    private int[] circularQueueElements;
    private int maxQue; //Circular Queue maximum size

    private int rear;//rear position of Circular queue(new element enqueued at rear).
    private int front; //front position of Circular queue(element will be dequeued from front).      

    public ServiceQueue() {
        this.maxQue = 10;
        circularQueueElements = new int[maxQue];
        currentSize = 0;
        front = maxQue - 1;
        rear = maxQue - 1;
        /*
       Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         
            
            dequeue();
            System.out.println("dequeue done!");   
        }
        
    });
       timer.setRepeats(true);
       timer.start();
       */
    }

    /**
     * Enqueue elements to rear.
     */
    public void enqueue(int item){
        if (isFull()) {
            //throw new QueueFullException("Circular Queue is full. Element cannot be added");
            System.out.println("Circular Queue is full. Element cannot be added");
        }
        else {
            circularQueueElements[rear] = item;
            rear = (rear + 1) % circularQueueElements.length;
            currentSize++;
        }
    }

    /**
     * Dequeue element from Front.
     */
    public int dequeue(){
        int deQueuedElement = -1;
        if (isEmpty()) {
            //throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
            System.out.println("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = 0;
            front = (front + 1) % circularQueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }

    /**
     * Check if queue is full.
     */
    public boolean isFull() {
        return ((rear + 1) % maxQue == front);
    }

    /**
     * Check if Queue is empty.
     */
    public boolean isEmpty() {
        return (rear == front);
    }
    
    public int size()
   {
      return currentSize;
   }

    @Override
    public String toString() {
        return "CircularQueue [" + Arrays.toString(circularQueueElements) + "]";
    }

    
    public void processAndDequeue(){
        try {
            int time = processingTime*1000;
            Thread.sleep(time);
            dequeue();
            System.out.println("dequeue done!");
        } catch (InterruptedException ex) {
            //Logger.getLogger(ServiceQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sqTimerDeque(int userProcessRate, boolean flag, int numberOfQueuesAL){
          //System.out.println("sqTimerDeque !");
          Timer timerSq = new Timer();
           checkStop = flag;
           System.out.println("checkStop :"+checkStop);
      TimerTask timertaskSq;
        timertaskSq = new TimerTask() {
            @Override
            public void run() {
                System.out.println("checkStop in dequeue :"+checkStop);
                if(checkStop)
                {
                    
                    int dqueueValue = dequeue();
                    System.out.println("sqTimerDeque : dequevalue is: "+dqueueValue);
                    int elementCountOfSQ = size();
                     System.out.println("Q elementCountOfSQ: "+elementCountOfSQ);
                     System.out.println("numberOfQueues in ArrayList: "+numberOfQueuesAL);
                     if(elementCountOfSQ==0)
                     { System.out.println("timer stoped for SQ index: "+numberOfQueuesAL);
                 if(numberOfQueuesAL>=0)
                 {ActiveServiceQueue.serviceQueueList.remove(numberOfQueuesAL);
                        timerSq.cancel();
                        timerSq.purge();}
                        
                        
                    //
                     }
                     
                     
                }
                else{
                    System.out.println("timer stopped");
                    //checkStop = false;
                    timerSq.cancel();
                    timerSq.purge();
                }
            }
        };
      
      timerSq.scheduleAtFixedRate(timertaskSq, 0, userProcessRate);
    // checkStop = false;
    }
       
    }
    

    

