/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;



/**
 *
 * @author rajan
 */
public class RequestGenerator {
    
    private int reqRate;
    private ReqQueue reqQueue = new ReqQueue();

    public int getReqRate() {
        return reqRate;
    }

    public void setReqRate(int reqRate) {
        this.reqRate = reqRate;
        Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i< reqRate; i++){
            reqQueue.enqueue((int) (Math.random() * 50 + 1));
            System.out.println("in timer");
            }
            reqQueue.display();
        }

});
        timer.setRepeats(true);
        timer.start();
    }

    
    public void setReqQueue(ReqQueue reqQueue) {
        this.reqQueue = reqQueue;
        
    }

    public ReqQueue getReqQueue() {
        return reqQueue;
    }
    
 
}
