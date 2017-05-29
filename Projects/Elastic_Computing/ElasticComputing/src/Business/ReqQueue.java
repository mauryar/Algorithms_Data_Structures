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
        }
        
        else
        {
            rear.next = newNode;
            rear = newNode;
        }
        rear.next = front;    // next of rear is front in circular queue
    }
    
    public void dequeue()
    {
        int element;
        if (front == null)
        {
            return;   // For empty queue
        }
        else if (front == rear)    // only one node in circular queue
        {
            element = front.data ;
            front = rear = null;
        }
        else
        {
            Node temp = front;
            element = temp.data;
            front = front.next;
            rear.next = front;
        }
        
    }
    
    public void display()
    {
        
        Node temp = front;
        if (front != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != front);
        }
    }
    
}
