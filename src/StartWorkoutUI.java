
import helper.Exercise;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
 * @author cjwn
 */
public class StartWorkoutUI extends javax.swing.JFrame {

    private static final String workoutDataFilePath = "workouts.csv";
    private HashMap<String, Exercise> exerciseMap  = new HashMap<String, Exercise>();
    private Vector<String> selectedExerciseNames = new Vector<String>();
    /**
     * Creates new form StartWorkoutUI
     */
    public StartWorkoutUI() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        loadExerciseMap();              // load the exercises in the the map
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
            
            // check if the category is either strength or cardio
            /*
            if (cat.equals(categoryStrings[0])) {
                strengthExercises.add(name);
                
            } else {
                cardioExercises.add(name);
            }
            */
            
            dataRow = csvFile.readLine();       // read in the next line
        }
        csvFile.close();    // close the file we are done
    }

    public void setExerciseNames(Vector<String> exNames) {
        selectedExerciseNames = exNames;
        exerciseList.setListData(selectedExerciseNames);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        exerciseList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        setLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        repTextField = new javax.swing.JTextField();
        addSetButton = new javax.swing.JButton();
        setNumberLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        saveWorkoutButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        summaryTextArea = new javax.swing.JTextArea();
        helpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Start Workout");

        exerciseList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        exerciseList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        exerciseList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                exerciseListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(exerciseList);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Exercise Info"));

        setLabel.setText("Set:");

        jLabel3.setText("# of repetitions:");

        repTextField.setText("0");

        addSetButton.setText("Add");
        addSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSetButtonActionPerformed(evt);
            }
        });

        setNumberLabel.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(setLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(addSetButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(setLabel)
                            .addComponent(setNumberLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(repTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addSetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveWorkoutButton.setText("Save Workout");
        saveWorkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveWorkoutButtonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Workout Summary"));

        summaryTextArea.setColumns(20);
        summaryTextArea.setRows(5);
        jScrollPane2.setViewportView(summaryTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(helpButton)
                        .addGap(26, 26, 26)
                        .addComponent(saveWorkoutButton))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveWorkoutButton)
                    .addComponent(helpButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        JOptionPane.showMessageDialog(null, "Instructions", "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpButtonActionPerformed

    private void addSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSetButtonActionPerformed
        // TODO add your handling code here:
        
        String exName = exerciseList.getSelectedValue();
        String catName = exerciseMap.get(exName).getCategory();
        String setNumber = setNumberLabel.getText();
        String repNumber = repTextField.getText();
        
        String newExercise = exName + ", " + catName + ", "+ setNumber + ", " + repNumber + "\n";
        String summary = summaryTextArea.getText();
        summaryTextArea.setText(summary + newExercise);
        
        int setNum = Integer.parseInt(setNumber);
        setNum++;
        setNumberLabel.setText(String.valueOf(setNum));
       
    }//GEN-LAST:event_addSetButtonActionPerformed

    private void exerciseListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_exerciseListValueChanged
        setNumberLabel.setText("1");
    }//GEN-LAST:event_exerciseListValueChanged

    private void saveWorkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveWorkoutButtonActionPerformed
        String workoutName = JOptionPane.showInputDialog("Enter a workout name:");
        String workoutFolderPath = System.getProperty("user.dir") + "/workouts";
        File workoutFolder = new File(workoutFolderPath);
        
        // look for workout folder
        if (workoutFolder.exists()) {
            System.out.println("workout folder exists");
        } else {
            workoutFolder.mkdir();
        }
        
        // look for workout name list
        String workoutListFilePath = System.getProperty("user.dir") + "/workouts/workoutListFile.txt";
        File workoutListFile = new File(workoutListFilePath);
        // if the workoutListFile exists, then append a line with the workout name to it
        if (!workoutListFile.exists()) {
            try {
                PrintWriter writer = new PrintWriter(workoutListFile);
                writer.println(workoutName);
                writer.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StartWorkoutUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Files.write(Paths.get(workoutListFilePath), workoutName.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                //exception handling left as an exercise for the reader
            } 

        }
            
        String workoutFilePath = System.getProperty("user.dir") + "/workouts/" + workoutName + ".txt";
        File workoutFile = new File(workoutFilePath);
        
        try {
            PrintWriter writer = new PrintWriter(workoutFile);
            writer.print(summaryTextArea.getText());
            writer.close();
            dispose();
            JOptionPane.showMessageDialog(null, "Workout Successfully saved");
            new HomeScreenUI();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StartWorkoutUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveWorkoutButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
        new HomeScreenUI();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StartWorkoutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartWorkoutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartWorkoutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartWorkoutUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StartWorkoutUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(StartWorkoutUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSetButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JList<String> exerciseList;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField repTextField;
    private javax.swing.JButton saveWorkoutButton;
    private javax.swing.JLabel setLabel;
    private javax.swing.JLabel setNumberLabel;
    private javax.swing.JTextArea summaryTextArea;
    // End of variables declaration//GEN-END:variables
}
