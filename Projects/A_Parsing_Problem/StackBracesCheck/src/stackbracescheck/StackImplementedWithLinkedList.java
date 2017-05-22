/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackbracescheck;

/**
 *
 * @author rajan
 */
public class StackImplementedWithLinkedList<String> {
    
    private static class StackNode<String>{
        
        private String data;
        private StackNode<String> next;
        
        public StackNode(String data){
            this.data = data;
        }
        
    }
    
    private StackNode<String> top;
    
    public String pop(){
        if(top == null){
            String errorMessage = (String) "Stack is empty";
            return errorMessage;
        }else{
            String item = top.data;
            top = top.next;
            return item;
        }
            
    }
    
    public void push(String item){
        
        StackNode<String> t = new StackNode<String>(item);
        t.next = top;
        top = t;
        //System.out.println("In push of LL: "+top.data);
        
    }
    
    public String peek(){
        if(top == null){
            String errorMessage = (String) "Stack is empty";
            return errorMessage;
        }else{
            return top.data;
        }
    }
    
    public boolean isEmpty(){
        return top == null;
    }
    
    
}
