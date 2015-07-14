/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wei0000
 */
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SearchHiddenGUI extends javax.swing.JFrame {
     
    public static String userDir = System.getProperty("user.dir");
    /**
     * Creates new form SearchHiddenGUI
     */
    public SearchHiddenGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BrowseFile = new javax.swing.JFileChooser();
        Text1 = new javax.swing.JLabel();
        FileNamePath = new javax.swing.JTextField();
        Run = new javax.swing.JButton();
        Log = new javax.swing.JButton();
        Browse = new javax.swing.JButton();
        VersionNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ESRI_Search_Hidden_Charater_Tool");
        setName("ESRI_Hidden_Char_Check_Tool"); // NOI18N

        Text1.setText("Select the erb or yml file that needs to be check");

        FileNamePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileNamePathActionPerformed(evt);
            }
        });

        Run.setText("Run");
        Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunActionPerformed(evt);
            }
        });

        Log.setText("View Log File");
        Log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogActionPerformed(evt);
            }
        });

        Browse.setText("Browse File");
        Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseActionPerformed(evt);
            }
        });

        VersionNumber.setText("version 1.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(VersionNumber)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Run, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78)
                            .addComponent(Log, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(FileNamePath, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(Browse))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VersionNumber)
                .addGap(21, 21, 21)
                .addComponent(Text1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FileNamePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Browse))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Run)
                    .addComponent(Log))
                .addGap(114, 114, 114))
        );

        getAccessibleContext().setAccessibleName("ESRI_Hidden_Char_Check_Tool");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FileNamePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileNamePathActionPerformed
        // TODO add your handling code here:
          
    }//GEN-LAST:event_FileNamePathActionPerformed

    private void BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseActionPerformed
        // TODO add your handling code here:
        FileFilter ft = new FileNameExtensionFilter("erb file (*.erb)","erb");
        BrowseFile.addChoosableFileFilter(ft);
        ft = new FileNameExtensionFilter("yml file (*.yml)","yml");
        BrowseFile.addChoosableFileFilter(ft);
        String file_name = null;
        do {
        int returnVal = BrowseFile.showOpenDialog(this);
        
        if(returnVal == javax.swing.JFileChooser.APPROVE_OPTION){
            File file = BrowseFile.getSelectedFile();
            file_name = file.toString();
            
            FileNamePath.setText(file_name);
            if((!(file_name.endsWith(".erb"))) && (!(file_name.endsWith(".yml")))){
                JOptionPane.showMessageDialog(null,"The file you selected is neither erb nor yml, please select it again");
                FileNamePath.setText("");
                file_name = null;
            }
         }
        }while((!(file_name.endsWith(".erb"))) && (!(file_name.endsWith(".yml"))));
    }//GEN-LAST:event_BrowseActionPerformed

    private void LogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogActionPerformed
        // TODO add your handling code here:
         try{
            Process p = Runtime.getRuntime().exec("C:\\Windows\\System32\\notepad.exe " + userDir + "\\log.txt");
            p.waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_LogActionPerformed

    private void RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunActionPerformed
        // TODO add your handling code here:
        String filename = FileNamePath.getText();
        Search sch = new Search();
        sch.readFile(filename);
    }//GEN-LAST:event_RunActionPerformed

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
            java.util.logging.Logger.getLogger(SearchHiddenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchHiddenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchHiddenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchHiddenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchHiddenGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Browse;
    private javax.swing.JFileChooser BrowseFile;
    private javax.swing.JTextField FileNamePath;
    private javax.swing.JButton Log;
    private javax.swing.JButton Run;
    private javax.swing.JLabel Text1;
    private javax.swing.JLabel VersionNumber;
    // End of variables declaration//GEN-END:variables
}
