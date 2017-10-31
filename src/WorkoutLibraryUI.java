
import java.util.logging.Level;
import java.util.logging.Logger;
import helper.Exercise;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Vector;
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
public class WorkoutLibraryUI extends javax.swing.JFrame {

    private static final String workoutDataFilePath = "workouts.csv";
    private HashMap<String, Exercise> exerciseMap  = new HashMap<String, Exercise>();
    private String[] categoryStrings = {"Strength", "Cardio"};
    private Vector<String> strengthExercises = new Vector<String>();
    private Vector<String> cardioExercises = new Vector<String>();
    /**
     * Creates new form WorkoutLibraryUI
     */
    public WorkoutLibraryUI() throws Exception {
        initComponents();
        setLocationRelativeTo(null);    //puts the window in the center of the screen
        setVisible(true);               // show the window
        loadExerciseMap();              // load the exercises in the the map
        loadInitialListData();
    }
    
    /**
     * Takes the exercises from the map and loads them into respective vectors
     */
    public void loadInitialListData() {
        strengthRadioButton.setSelected(true);
        descriptionTextArea.setText("Click on an exercise to learn more about it!");
        exerciseList.setListData(strengthExercises);
    }
    
    /**
     * 
     * Loads the list of exercises from the csv file into the exercise map
     * and also adds the exercise to their respective vectors
     * @throws Exception 
     */
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
            if (cat.equals(categoryStrings[0])) {
                strengthExercises.add(name);
                
            } else {
                cardioExercises.add(name);
            }
            
            dataRow = csvFile.readLine();       // read in the next line
        }
        csvFile.close();    // close the file we are done
    }
    
    /**
     * 
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        exerciseList = new javax.swing.JList<>();
        backButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        categoryLabel = new javax.swing.JLabel();
        strengthRadioButton = new javax.swing.JRadioButton();
        cardioRadioButton = new javax.swing.JRadioButton();
        helpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(490, 450));
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Workout Library");
        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        exerciseList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Pushups", "Squats", "Shoulder Press", "Plank" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        exerciseList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        exerciseList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exerciseListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(exerciseList);

        backButton.setText("<< Go Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        descriptionTextArea.setEditable(false);
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setText("Click on an exercise to learn more about it!");
        descriptionTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(descriptionTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
        );

        categoryLabel.setText("Pick a category:");

        strengthRadioButton.setText("Strength");
        strengthRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strengthRadioButtonActionPerformed(evt);
            }
        });

        cardioRadioButton.setText("Cardio");
        cardioRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardioRadioButtonActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(categoryLabel)
                        .addGap(18, 18, 18)
                        .addComponent(strengthRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(cardioRadioButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(helpButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel)
                    .addComponent(strengthRadioButton)
                    .addComponent(cardioRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(helpButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * If the back button is clicked we need to destroy the window and load
     * the home window
     * @param evt 
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new HomeScreenUI();
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * if the exercise was clicked we want to get the selected name and use 
     * it to as a key to look up the description in the hash map, then we want
     * to display the description of the selected exercise in the text area
     * @param evt 
     */
    private void exerciseListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exerciseListMouseClicked
        Exercise ex = exerciseMap.get(exerciseList.getSelectedValue());
        descriptionTextArea.setText(ex.getDescription());
    }//GEN-LAST:event_exerciseListMouseClicked

    /**
     * This should be selected by default, and any other radio buttons should
     * be deselected and change the exercise list data
     * @param evt 
     */
    private void strengthRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strengthRadioButtonActionPerformed
        // TODO add your handling code here:
        cardioRadioButton.setSelected(false);
        exerciseList.setListData(strengthExercises);
        exerciseList.updateUI();
        descriptionTextArea.setText("Click on a strength exercise to learn more about it!");
    }//GEN-LAST:event_strengthRadioButtonActionPerformed

    /**
     * If the cardio radio button is selected we need to deselect any other
     * radio buttons and change the exercise list data
     * @param evt 
     */
    private void cardioRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardioRadioButtonActionPerformed
        // TODO add your handling code here:
        strengthRadioButton.setSelected(false);
        exerciseList.setListData(cardioExercises);
        exerciseList.updateUI();
        descriptionTextArea.setText("Click on a cardio exercise to learn more about it!");
    }//GEN-LAST:event_cardioRadioButtonActionPerformed

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
            java.util.logging.Logger.getLogger(WorkoutLibraryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkoutLibraryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkoutLibraryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkoutLibraryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new WorkoutLibraryUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(WorkoutLibraryUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JRadioButton cardioRadioButton;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JList<String> exerciseList;
    private javax.swing.JButton helpButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton strengthRadioButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
