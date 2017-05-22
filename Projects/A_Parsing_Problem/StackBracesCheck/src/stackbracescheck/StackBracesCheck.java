/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackbracescheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author rajan
 */
public class StackBracesCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // execution time calculation
        long startTime = System.currentTimeMillis();
        
        //initializations
        int tokenCount = 0;
        //StackImplementedWithArray siwa = new StackImplementedWithArray(10);
        StackImplementedWithLinkedList siwa = new StackImplementedWithLinkedList();
        String[] bracesPattern = new String[500];
        int braceCount = 0;
        String match = "NO";
        int countOpenBrace = 0;
        int countCloseBrace = 0;
        int flagUnbalance = 0;
        //int actualToken = 0;

        //File reading
        //File file = new File("C:\\Users\\rajan\\Desktop\\Sem6\\Algorithms\\Asignment1\\InputExample_Java.java"); // the file could be .txt .csv or anything else
        File file = new File("C:\\Users\\rajan\\Desktop\\Sem6\\Algorithms\\Asignment1\\TestInputFile.java");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
            //while ((lineTxt = bufferedReader.readLine()) != null && flagUnbalance == 0) { // to stop reading when found unbalance in between file
                //System.out.println("line is: "+lineTxt);
                StringTokenizer st = new StringTokenizer(lineTxt, "{}", true);

                while (st.hasMoreTokens()) {

                    String tokenValue = st.nextToken();
                    if (tokenValue.equals("{")) {

                        tokenCount++;
                        siwa.push(tokenValue);
                        bracesPattern[braceCount] = tokenValue;
                        braceCount++;

                    } else if (tokenValue.equals("}")) {
                        tokenCount++;
                        String peekExistingTop = (String) siwa.peek();
                        if (peekExistingTop.equals("{")) {
                            siwa.pop();

                        } else {
                            flagUnbalance = 1;
                            // to stop reading when found unbalance in between file
                            //System.out.println("line 68: flagUnbalance of else part is : "+flagUnbalance);
                            //break;
                        }
                        bracesPattern[braceCount] = tokenValue;
                        braceCount++;
                        
                    }

                }
            }
            bufferedReader.close();
        } else {
            System.out.println("File doesn't exist");
        }

        // Tokens count is:
        System.out.println("tokenCount is: " + tokenCount);

        // Braces Pattern is:
        System.out.println("braces pattern is: ");
        for (int p = 0; p < braceCount; p++) {

            System.out.print(bracesPattern[p]);
        }

        //Braces Balancded Unbalanced - Match Unmatch
        System.out.print("\n The braces are ");
        if (siwa.isEmpty() && flagUnbalance == 0) {

            System.out.print(" Balanced \n");
            match = "YES";
            System.out.println("Braces match: " + match);
        } else {
            System.out.print(" Unbalanced \n");
            System.out.println("braces match: " + match);

            while (!siwa.isEmpty()) {
                String op1 = (String) siwa.pop();
                //System.out.println("data in stack "+op1);
                if (op1.equals("{")) {
                    countOpenBrace++;
                } else {
                    countCloseBrace++;
                }
            }

            // Closing and Opening brace count
            if (countCloseBrace > countOpenBrace || flagUnbalance == 1) {
                System.out.println("Too many closing braces \n");
            } else {
                System.out.println("Too many opening braces \n");
            }
        }

        
        
        
        final long duration = System.currentTimeMillis() - startTime;
        System.out.println("Total program execution time in milliseconds: "+duration);
        
    }
    
}
