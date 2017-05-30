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

   
   public ReqServiceDispatcher( RequestGenerator requestGenerator){
       
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
 

    public void checkReqQueueEmpty(){
   while(!reqQueue.isEmpty()){
        System.out.println("Inloop"+reqQueue);
        if(reqQueue.isEmpty()){
            System.out.println("No requests present");
        }else{
            int request;
            if(activeServiceQueue.getServiceQueueList().size() == 0){
                 request = reqQueue.dequeue().data;
                ServiceQueue serviceQueue = new ServiceQueue();
                activeServiceQueue.getServiceQueueList().add(serviceQueue);
                serviceQueue.enqueue(request);
                System.out.println("in dispatcher - if part"+request);
            }else{
                for (int i = 0; i < activeServiceQueue.getServiceQueueList().size(); i++){
                    if(activeServiceQueue.getServiceQueueList().get(i).size() < 6){
                         request = reqQueue.dequeue().data;
                        activeServiceQueue.getServiceQueueList().get(i).enqueue(request);
                        System.out.println("in dispatcher - else part"+request);
                        break;
                    }
                }
            }
        }
        
    }

    }
}
