/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knuthshuffle;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;



    
    class Node {
    public String value;
    public Node left;
    public Node right;
}

class Tree {

    public Node insert(Node root, String v) {
        if (root == null) {
            root = new Node();
            root.value = v;
        } else if (v.compareTo(root.value) > 0 ) {
            root.left = insert(root.left, v);
        } else {
            root.right = insert(root.right, v);
        }

        return root;
    }

   
    
    int findHeight(Node root) {
        if (root == null) {
            return -1;
        }

        int lefth = findHeight(root.left);
        int righth = findHeight(root.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }
    
    
    
}

class BinarySearchTree {
    public static void main(String[] args) {
        
        //knuth
        
        int shuffleConstant = 1000;
      int sizeOfArray = 1000;
      String[] inArray = new String[sizeOfArray];
      
      int k = 9;
    for(int i = 0; i< sizeOfArray; i++){
       
      inArray[i] = randomString(k);
    }
    
    for(int i = 0; i< shuffleConstant; i++){
        shuffleArray(inArray);
        
    }
    
  
        
        //end knuth
        
        Node root = null;
        Tree bst = new Tree();
        
        final int SIZE = sizeOfArray;
        String[] a = inArray;

        

        for (int i = 0; i < SIZE; i++) {
            root = bst.insert(root, a[i]);
        }


        System.out.println("Traverse the nodes of tree of size "+SIZE);


    

        int height=bst.findHeight(root);
        System.out.println("Binary tree height is "+height);
        
    }
    
    
      static void shuffleArray(String[] ar)
  {
    // If running on Java 6 or older, use `new Random()` on RHS here
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      String a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
  
  
  static String randomString(int k){
     
     String alphabet= "abcdefghijklmnopqrstuvwxyz";
        String s = "";
        int maxSize = k;
        Random random = new Random();
        int randomLen = 1+random.nextInt(maxSize);
        for (int i = 0; i < randomLen; i++) {
            char c = alphabet.charAt(random.nextInt(26));
            s+=c;
        }
         
        return s;
  }
  
  
}
    

