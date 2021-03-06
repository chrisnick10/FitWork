
import helper.Exercise;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Binbin
 */
public class CreateWorkoutUI extends javax.swing.JFrame {

    private static final String workoutDataFilePath = "workouts.csv";
    private HashMap<String, Exercise> exerciseMap  = new HashMap<String, Exercise>();
    private Vector<String> unselectedExerciseNames = new Vector<String>();
    private Vector<String> selectedExerciseNames = new Vector<String>();
    
    
    public CreateWorkoutUI() throws Exception {
        initComponents();
        setLocationRelativeTo(null);    //puts the window in the center of the screen
        getContentPane().setBackground(new Color(255, 147, 30));
        setVisible(true);               // show the window
        loadExerciseMap();              // load the exercises in the the map
        loadInitialListData();
    }
    
    public void loadInitialListData() {
        for ( String item : exerciseMap.keySet()) {
            unselectedExerciseNames.add(item);
        }
        
        unselectedExerciseList.setListData(unselectedExerciseNames);
        selectedExerciseList.setListData(selectedExerciseNames);
    }
    
    public void loadExerciseMap() throws Exception {
        BufferedReader csvFile = new BufferedReader(new FileReader(workoutDataFilePath));
        
        String dataRow = csvFile.readLine(); // read the line
        
        // while the data is not null, parse the csv line
        while (dataRow != null) {
            String[] dataArray = dataRow.split(",");    // split along the commas
            String cat = dataArray[0];                  // first field is category
            String subCat = dataArray[1];               // second field is subcategory
            String name = dataArray[2];                 // third field is name
            String desc = "";
            
            // this creates the string for the description because if there
            // were commas in the string it was split up
            for (int i = 3; i < dataArray.length; i++) {
                desc += "," + dataArray[i];
            }
            // get rid of the parenthesis on either side of the string
            desc = desc.substring(2, desc.length()-1);
            
            // create a new exercise and add to the map
            Exercise ex = new Exercise(name, cat, subCat, desc);
            exerciseMap.put(name, ex);
            
            dataRow = csvFile.readLine();       // read in the next line
        }
        csvFile.close();    // close the file we are done  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startWorkoutButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addExerciseButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        unselectedExerciseList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedExerciseList = new javax.swing.JList<>();
        removeExerciseButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        helpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        startWorkoutButton.setLabel("Start Workout");
        startWorkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startWorkoutButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Create Workout");

        backButton.setText("<< Go Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addExerciseButton.setLabel(">>");
        addExerciseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExerciseButtonActionPerformed(evt);
            }
        });

        unselectedExerciseList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(unselectedExerciseList);

        selectedExerciseList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(selectedExerciseList);

        removeExerciseButton.setLabel("<<");
        removeExerciseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeExerciseButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Exercise List:");

        jLabel2.setText("Selected Exercises:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addExerciseButton)
                            .addComponent(removeExerciseButton)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(addExerciseButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeExerciseButton)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(helpButton)
                        .addGap(18, 18, 18)
                        .addComponent(startWorkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(startWorkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(helpButton)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dispose();
        new HomeScreenUI();
    }//GEN-LAST:event_backButtonActionPerformed

    private void addExerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExerciseButtonActionPerformed
        
        String exercise = unselectedExerciseList.getSelectedValue();
        selectedExerciseNames.add(exercise);
        unselectedExerciseNames.remove(exercise);
        
        unselectedExerciseList.updateUI();
        selectedExerciseList.updateUI();
    }//GEN-LAST:event_addExerciseButtonActionPerformed

    private void removeExerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeExerciseButtonActionPerformed
        
        String exercise = selectedExerciseList.getSelectedValue();
        unselectedExerciseNames.add(exercise);
        selectedExerciseNames.remove(exercise);
        
        selectedExerciseList.updateUI();
        unselectedExerciseList.updateUI();
    }//GEN-LAST:event_removeExerciseButtonActionPerformed

    private void startWorkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startWorkoutButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        StartWorkoutUI workoutUI;
        try {
            workoutUI = new StartWorkoutUI();
            workoutUI.setExerciseNames(selectedExerciseNames);
            workoutUI.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(CreateWorkoutUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_startWorkoutButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Instructions", "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CreateWorkoutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateWorkoutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateWorkoutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateWorkoutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CreateWorkoutUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CreateWorkoutUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExerciseButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeExerciseButton;
    private javax.swing.JList<String> selectedExerciseList;
    private javax.swing.JButton startWorkoutButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JList<String> unselectedExerciseList;
    // End of variables declaration//GEN-END:variables
}
