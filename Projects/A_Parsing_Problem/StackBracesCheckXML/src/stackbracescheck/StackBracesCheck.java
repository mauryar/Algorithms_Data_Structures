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
       int balanceFlag = 0; //File tags are unbalanced
        StackImplementedWithArray siwa = new StackImplementedWithArray(10);
        //StackImplementedWithLinkedList siwa = new StackImplementedWithLinkedList();
        

        //File reading
        File file = new File("C:\\Users\\rajan\\Desktop\\Sem6\\Algorithms\\Asignment1\\InputExample_xml.xml"); // the file could be .txt .csv or anything else
        //File file = new File("C:\\Users\\rajan\\Desktop\\Sem6\\Algorithms\\Asignment1\\TestInputFile.java");
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
            
                StringTokenizer st = new StringTokenizer(lineTxt, "</>", true);

                while (st.hasMoreTokens()) {
                    
                    String tokenValue = st.nextToken();
                    System.out.println("token is: "+tokenValue);
                    if(tokenValue.equals("<") && st.hasMoreTokens()){
                        siwa.push(tokenValue);
                        String value = st.nextToken().split(" ")[0];
                        //String value = st.nextToken();
                        System.out.println("value is: "+value);
                        if((!value.equals("/")) && (!value.equals(">")) && st.hasMoreTokens()){
                            siwa.push(value);
                            String closeTokenValue = st.nextToken();
                            if(closeTokenValue.equals(">")){
                                siwa.push(closeTokenValue);
                                System.out.println("closeTokenValue is: "+closeTokenValue);
                                balanceFlag = 0;
                            }else if(closeTokenValue.equals("/") && st.hasMoreTokens()){
                                String closingAngleBracketSingleTag = st.nextToken();
                                if(closingAngleBracketSingleTag.equals(">")){
                                    siwa.pop();
                                    siwa.pop();
                                    balanceFlag = 1;
                                }
                            }
                        }else if (value.equals("/") && st.hasMoreTokens()){
                            String closingValue = st.nextToken();
                            System.out.println("closingValue: "+closingValue);
                            if(st.hasMoreTokens() && st.nextToken().equals(">")){
                                siwa.pop();
                                siwa.pop();
                                String checkDataFromStack = (String) siwa.pop();
                                System.out.println("checkDataFromStack: "+checkDataFromStack);
                                if(closingValue.equals(checkDataFromStack)){
                                 siwa.pop();
                                 balanceFlag = 1;
                                }else balanceFlag = 0;
                            }
                        } 
                        
                    }else if(tokenValue.equals(">")) {
                        siwa.push(tokenValue);
                        balanceFlag = 0;
                        break;
                    } 
                    
                    
                }
            }
        }
        
        if(balanceFlag == 0 || (!siwa.isEmpty())){
            System.out.println("File tags are Unbalanced");
        }else if(siwa.isEmpty() && balanceFlag == 1){
            System.out.println("File tags are Balanced");
        }
        
        
        final long duration = System.currentTimeMillis() - startTime;
        System.out.println("Total program execution time in milliseconds: "+duration);
    }
    
}
