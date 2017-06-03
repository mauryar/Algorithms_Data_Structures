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
public class ReqQueue {
    
    private static Node front = null;
    private static Node rear = null;
    private static int countInputRequest = 0;
    
    public class Node {
    
    public int data;
    public Node next;
    
    public Node(int data)
    {
        this.data = data;
    }
    
}
    
    
    
    public void enqueue(int element)
    {
        Node newNode = new Node(element);
        newNode.next = null;
        
        if (front==null)
        {
            front = rear = newNode;
            countInputRequest++;
        }
        
        else
        {
            rear.next = newNode;
            rear = newNode;
            countInputRequest++;
        }
        rear.next = front;    // next of rear is front in circular queue
    }
    
    public Node dequeue()
    {
        Node element;
        if (front == null)
        {
            return null;   // For empty queue
        }
        else if (front == rear)    // only one node in circular queue
        {
            element = front ;
            front = rear = null;
            countInputRequest--;
        }
        else
        {
            Node temp = front;
            element = temp;
            front = front.next;
            rear.next = front;
            countInputRequest--;
        }
        return element;
    }
    
    public int display()
    {
        
        Node temp = front;
        if (front != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != front);
        }
        return countInputRequest;
    }
    
    
    public boolean isEmpty()
    {
        boolean flag = true;
        
        if (front != null) {
           flag = false; 
        }
        return flag;
    }
    
}
