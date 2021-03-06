/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.ActiveServiceQueue;
import Business.MyThread;
import Business.ReqServiceDispatcher;
import Business.RequestGenerator;
import Business.ServiceQueue;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author Mrunalini
 */
public class CreateJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateJPanel
     */
    
  
    private RequestGenerator requestGenerator;
    //private ServiceQueue serviceQueue;
    private ReqServiceDispatcher reqServiceDispatcher;
    private ActiveServiceQueue activeServiceQueue;
    private int usereqRate = 0;
    private int userProcessRate = 0;
    private boolean flag = true;
    private long responseTime = 0;
    private static long serverUsedCount = 0;
    
    public CreateJPanel( RequestGenerator requestGenerator, ReqServiceDispatcher reqServiceDispatcher) {
        initComponents();
      this.requestGenerator = requestGenerator;
      //this.serviceQueue = serviceQueue;
      this.reqServiceDispatcher = reqServiceDispatcher;
      this.activeServiceQueue = reqServiceDispatcher.getActiveServiceQueue();
      reqDispatch();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        processTime = new javax.swing.JTextField();
        reqRate = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        inputQueue1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        activeServer1 = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        respTime1 = new javax.swing.JTextField();
        serverUsed1 = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Enter Inputs");

        jLabel2.setText("Request Arrival Rates:");

        jLabel3.setText("Processing Time:");

        reqRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqRateActionPerformed(evt);
            }
        });

        submitBtn.setBackground(new java.awt.Color(204, 204, 204));
        submitBtn.setForeground(new java.awt.Color(51, 102, 255));
        submitBtn.setText("Start");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setText("No of  Requests in Input Queue");

        inputQueue1.setEditable(false);

        jLabel11.setText("Active Servers");

        activeServer1.setEditable(false);
        activeServer1.setText("                ");

        refresh.setBackground(new java.awt.Color(204, 204, 204));
        refresh.setForeground(new java.awt.Color(51, 102, 255));
        refresh.setText("Get values when running");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jLabel12.setText("Response Time of Request");

        jLabel13.setText("Number of Servers used");

        respTime1.setEditable(false);
        respTime1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respTime1ActionPerformed(evt);
            }
        });

        serverUsed1.setEditable(false);
        serverUsed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverUsed1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reqRate, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(refresh)
                            .addGap(70, 70, 70))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(38, 38, 38))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(processTime, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel13))
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inputQueue1)
                                .addComponent(activeServer1)
                                .addComponent(serverUsed1)
                                .addComponent(respTime1))
                            .addGap(19, 19, 19)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refresh)
                    .addComponent(errorLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(reqRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(processTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(inputQueue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(activeServer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(respTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverUsed1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addContainerGap(142, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reqRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reqRateActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        flag = true;
     
        if(reqRate.getText().trim().matches("[0-9]*") && processTime.getText().trim().matches("[0-9]*")&&
                !reqRate.getText().equals("") && !processTime.getText().equals("")){
            //JOptionPane.showMessageDialog(null,"Plese enter numbers only!!");
           errorLabel.setText(""); 
       
         usereqRate = Integer.parseInt(reqRate.getText());
        userProcessRate = Integer.parseInt(processTime.getText());
        
        //JOptionPane.showMessageDialog(null,"User input taken...processing requests..");
         }
        else{
           errorLabel.setText("User input should be numeric");
           errorLabel.setForeground(Color.red);
        }
      
     
    }//GEN-LAST:event_submitBtnActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        
        //Refresh
        activeServer1.setText(String.valueOf(activeServiceQueue.getServiceQueueList().size()));
        inputQueue1.setText(String.valueOf(requestGenerator.getReqQueue().display()));
        respTime1.setText(String.valueOf(responseTime));
        serverUsed1.setText(String.valueOf(serverUsedCount));

    }//GEN-LAST:event_refreshActionPerformed

    private void respTime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respTime1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_respTime1ActionPerformed

    private void serverUsed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverUsed1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serverUsed1ActionPerformed

    // Prompt user that product is successfully created
    
    
    
        public void reqDispatch(){
        
        
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(flag)
                {
                    synchronized(this){
                          //timer starts
                          requestGenerator.setReqRate(reqServiceDispatcher, usereqRate);
                for(int i = 0; i< requestGenerator.getReqRate(); i++){
                            requestGenerator.getReqQueue().enqueue((int) (Math.random() * 50 + 1));
                            //System.out.println("in timer");
                        }
                responseTime = System.currentTimeMillis();
                System.out.println("in input queue: "+requestGenerator.getReqRate());
                System.out.println("input queue size : "+requestGenerator.getReqQueue().display());
                
                notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ReqServiceDispatcher.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //timer ends

                    }
                }
              
            }
        });
 
        // Create consumer thread
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                
                while(flag)
                {
                    synchronized(this){
                        //dispatcher starts
                while (!requestGenerator.getReqQueue().isEmpty()) {
                    
                    int request;
                    request = requestGenerator.getReqQueue().dequeue().data;
                    //if(serviceQueue==null||serviceQueue.isFull())=
                    
                    int size=activeServiceQueue.getServiceQueueList().size();
//                    if(size==0 && usereqRate== 0)
//                    {activeServiceQueue.getServiceQueueList().remove(0);
//                    }
                    if((size==0||activeServiceQueue.getServiceQueueList().get(size-1).isFull()) && usereqRate!= 0)
                    {System.out.println("usereqRate"+usereqRate );
                        ServiceQueue serviceQueue  = new ServiceQueue();
                        serverUsedCount++;
                        serviceQueue.sqTimerDeque(userProcessRate*1000, true,activeServiceQueue.getServiceQueueList().size()-1);
                        activeServiceQueue.getServiceQueueList().add(serviceQueue);
//                        System.out.println("Service Queue Name : "+activeServiceQueue.getServiceQueueList());
                    }
                    //inserting into last queue
                    activeServiceQueue.getServiceQueueList().get(activeServiceQueue.getServiceQueueList().size()-1).enqueue(request);
                    
                     
                }
                System.out.println("Total Queue created: " + activeServiceQueue.getServiceQueueList().size() );
                System.out.println("Service Queue Name : "+activeServiceQueue.getServiceQueueList());
                  responseTime = System.currentTimeMillis() - responseTime;
                notify();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ReqServiceDispatcher.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //dispatcher ends
                    }
                }
                
                
            }
            
        });
 
        // Start both threads
        t1.start();
        t2.start();
        
        
        /*try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(CreateJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        //uncomment for running
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField activeServer1;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField inputQueue1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField processTime;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField reqRate;
    private javax.swing.JTextField respTime1;
    private javax.swing.JTextField serverUsed1;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
