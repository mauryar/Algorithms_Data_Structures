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

import java.util.Arrays;
public class ServiceQueue {
    
    private int processingTime;

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

    
}
