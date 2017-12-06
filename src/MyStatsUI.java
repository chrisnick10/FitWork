/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cjwn
 */
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;

public class MyStatsUI extends javax.swing.JFrame {
    
    // holds the list of workout names
    private Vector<String> workoutNameArray = new Vector<String>();
    private double strengthCount = 0;
    private  double cardioCount = 0;
    private double x;
    private double y;
    private double total = 1;
    
    /**
     * Creates new form MyStatsUI
     */
    public MyStatsUI() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        loadWorkoutNamesList();
        getContentPane().setBackground(new Color(63, 169, 245));
        setVisible(true);
    }
    
    private void loadWorkoutNamesList() throws Exception {
        // look for workout name list
        String workoutListFilePath = System.getProperty("user.dir") + "/workouts/workoutListFile.txt";
        File workoutListFile = new File(workoutListFilePath);
        
        if (workoutListFile.exists()) {
            BufferedReader workoutNameReader = new BufferedReader(new FileReader(workoutListFilePath));
            String workoutName = workoutNameReader.readLine();
            
            while (workoutName != null) {
                workoutNameArray.add(workoutName);
                workoutName = workoutNameReader.readLine();
            }
            
            workoutNameReader.close();
        }
        
        workoutNameList.setListData(workoutNameArray);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        selectWorkoutButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        workoutNameList = new javax.swing.JList<>();
        titleLabel = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("Choose Workout");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setText("<< Go Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        selectWorkoutButton.setText("Select Workout");
        selectWorkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectWorkoutButtonActionPerformed(evt);
            }
        });

        workoutNameList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(workoutNameList);

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("My Workouts");
        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(backButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(selectWorkoutButton)))
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectWorkoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new HomeScreenUI();
    }//GEN-LAST:event_backButtonActionPerformed

    private void selectWorkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectWorkoutButtonActionPerformed
        String selectedWorkout = workoutNameList.getSelectedValue();
        
        String selectedWorkoutFilePath = System.getProperty("user.dir") + "/workouts/" + selectedWorkout + ".txt";
        
        File selectedWorkoutFile = new File(selectedWorkoutFilePath);
        
        try {
            BufferedReader selectedWorkoutFileReader = new BufferedReader(new FileReader(selectedWorkoutFilePath));
            String dataRow = selectedWorkoutFileReader.readLine();
            
            while (dataRow != null) {
                String[] dataArray = dataRow.split(",");    // split along the commas
                String exCat = dataArray[1];
                System.out.println("Category found:" + exCat);
                
                if (exCat.equals("Strength")) {
                    strengthCount++;
                } else if (exCat.equals("Cardio")) {
                    cardioCount++;
                }
                
                dataRow = selectedWorkoutFileReader.readLine();
            }
            
            selectedWorkoutFileReader.close();
            
            total = cardioCount + strengthCount;
            x = ((cardioCount / total) * 100);
            y = ((strengthCount / total) * 100);
            
            // Insert code for pie chart here
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyStatsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyStatsUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //piechart
        
       
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Cardio", new Integer((int) x));
        pieDataset.setValue("Strength", new Integer((int) y));
        JFreeChart chart= ChartFactory.createPieChart(selectedWorkout, pieDataset, true, true, true);
        PiePlot P = (PiePlot)chart.getPlot();
        ChartFrame frame = new ChartFrame(selectedWorkout,chart);
        
        
  
        if (cardioCount > strengthCount){
                TextTitle legendText = new TextTitle("YOU NEED TO DO MORE STRENGTH!");
                legendText.setPosition(RectangleEdge.BOTTOM);
                chart.addSubtitle(legendText);}
        if (cardioCount < strengthCount){
                TextTitle legendText = new TextTitle("YOU NEED TO DO MORE CARDIO!");
                legendText.setPosition(RectangleEdge.BOTTOM);
                chart.addSubtitle(legendText);}
        if (cardioCount == strengthCount){
                TextTitle legendText = new TextTitle("YOUR WORKOUT IS BALANCED");
                legendText.setPosition(RectangleEdge.BOTTOM);
                chart.addSubtitle(legendText);}
        
        frame.setSize(450,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }//GEN-LAST:event_selectWorkoutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
  //import statements for the utilities

    
        


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyStatsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyStatsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyStatsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyStatsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MyStatsUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MyStatsUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });      
    }
    
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton selectWorkoutButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JList<String> workoutNameList;
    // End of variables declaration//GEN-END:variables

}
