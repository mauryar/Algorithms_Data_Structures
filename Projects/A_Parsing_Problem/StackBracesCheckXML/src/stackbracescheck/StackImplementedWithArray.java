/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackbracescheck;

import java.util.Arrays;

/**
 *
 * @author rajan
 */
public class StackImplementedWithArray {
    private static int counter = 0;
    private String [] arr;
	
	public StackImplementedWithArray(){
		
	}
	public StackImplementedWithArray(int size){
		arr = new String[size];
	}
	
        public String [] stackArrayResize(String [] arr){
            if(arr != null  && arr.length > 0){
                int newArrayLength = (arr.length)*2;
                //System.out.println("new Arraylength in stackArrayResize is: "+newArrayLength);
                arr = Arrays.copyOf(arr, newArrayLength);
                return arr;}
            else{
                //System.out.println("Given array / stack has no elements in it.");
                return null;
            }
	}
        
	public String pop(){
		// insert code here and change the return value
                if((counter-1) >= 0){
                  String poppedValue = arr[counter-1];
                    arr[counter-1] = null;
                    counter--;
                    return poppedValue;
                }else {
		return "Stack array has no data";
                }
	}
	
	public String peek(){
		// insert code here and change the return value
                if((counter-1) >= 0){
                    String peekValue = arr[counter-1];
                    //counter--;
                    return peekValue;
                }else{
                    return "Stack array has no data";
                }
		
	}
	
	public void push(String input){
		// insert code here
                if(counter < arr.length){
                    arr[counter] = input;
                    counter++;
                } else if(counter >= arr.length){
                    //System.out.println("counter in else if section of push: "+counter);
                    arr = stackArrayResize(arr);
                    //System.out.println("New array size is: "+arr.length);
                    arr[counter] = input;
                    counter++;
                }
	}
	
	public boolean isEmpty(){
		// insert code here and change the return value
                if(arr.length == 0 || counter == 0){
                return true;
        }else{
            
		return false;
             }    
        }
        
        public boolean isFull(){
		// insert code here and change the return value
                if(counter == arr.length){
                return true;
        }else{
            
		return false;
             }    
        }
}
