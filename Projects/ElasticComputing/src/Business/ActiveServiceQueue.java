/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author rajan
 */
public class ActiveServiceQueue {
    
    public static ArrayList<ServiceQueue> serviceQueueList = new ArrayList<ServiceQueue>();

    public ArrayList<ServiceQueue> getServiceQueueList() {
        return serviceQueueList;
    }

    public void setServiceQueueList(ArrayList<ServiceQueue> serviceQueueList) {
        this.serviceQueueList = serviceQueueList;
    }
    
    
}
