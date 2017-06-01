/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.ReqQueue;

/**
 *
 * @author rajan
 */
public class ReqServiceDispatcher {

    private ReqQueue reqQueue;
    private ActiveServiceQueue activeServiceQueue;
    private RequestGenerator requestGenerator;

    public ReqServiceDispatcher(RequestGenerator requestGenerator) {

        reqQueue = requestGenerator.getReqQueue();
        activeServiceQueue = new ActiveServiceQueue();
    }

    public RequestGenerator getRequestGenerator() {
        return requestGenerator;
    }

    public void setRequestGenerator(RequestGenerator requestGenerator) {
        this.requestGenerator = requestGenerator;
    }

    public ReqQueue getReqQueue() {
        return reqQueue;
    }

    /*
    public void setReqQueue(ReqQueue reqQueue) {
        this.reqQueue = requestGenerator.getReqQueue();
    }
     */
    public ActiveServiceQueue getActiveServiceQueue() {
        return activeServiceQueue;
    }

    public void setActiveServiceQueue(ActiveServiceQueue activeServiceQueue) {
        this.activeServiceQueue = activeServiceQueue;
    }

    public void checkReqQueueEmpty() {
        while (!reqQueue.isEmpty()) {

                int request;
                request = reqQueue.dequeue().data;
                //if(serviceQueue==null||serviceQueue.isFull())=
                int size=activeServiceQueue.getServiceQueueList().size();
                if(size==0||activeServiceQueue.getServiceQueueList().get(size-1).isFull())   
                {
                   ServiceQueue serviceQueue  = new ServiceQueue();
                   activeServiceQueue.getServiceQueueList().add(serviceQueue);
                   System.out.println("Service Queue Name : "+activeServiceQueue.getServiceQueueList());
                }    
                //inserting into last queue
                activeServiceQueue.getServiceQueueList().get(activeServiceQueue.getServiceQueueList().size()-1).enqueue(request);
               
            
        }
         System.out.println("Total Queue created: " + activeServiceQueue.getServiceQueueList().size() );
         System.out.println("Service Queue Name : "+activeServiceQueue.getServiceQueueList());

    }

}