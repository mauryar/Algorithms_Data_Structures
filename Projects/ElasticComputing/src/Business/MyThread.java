/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author rajan
 */
public class MyThread extends Thread{
 
    
    
   private String name;
   private int reqRate;
   private ReqQueue reqQueue;
 
   public MyThread(String name, int reqRate, ReqQueue reqQueue) {   // constructor
      this.name = name;
      this.reqRate = reqRate;
      this.reqQueue = reqQueue;
   }
 
   // Override the run() method to specify the thread's running behavior
   @Override
   public void run() {
             
            //reqServiceDispatcher.checkReqQueueEmpty();
            for(int i = 0; i< reqRate; i++){
            reqQueue.enqueue((int) (Math.random() * 50 + 1));
            System.out.println("in timer");
            }
        }
   
}
    

