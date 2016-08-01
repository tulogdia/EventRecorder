package gui;

import customexceptions.NeedsInterventionException;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import pojos.Experiment;
import pojos.User;

public class EditUserDialog extends javax.swing.JDialog {

    private List<User> users;
    private boolean addOrRename;
    private int selIndex;
    private User user;

    public EditUserDialog(java.awt.Frame parent, List<User> users, boolean addOrRename, int selIndex) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        this.users = users;
        this.addOrRename = addOrRename;
        this.selIndex = selIndex;
        if (this.addOrRename) {
            setTitle("Add new User");
            user = null;
        } else {
            setTitle("Rename User");
            tfUserName.setText(users.get(selIndex).getName());
            user = users.get(selIndex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfUserName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Please type the name of the new user below:");

        tfUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUserNameKeyPressed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUserName)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addGap(24, 24, 24)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (addOrRename) {       // This is actially an Add Nem window, so we need to save a new user
            try {
                checkConstraintsBeforeSave(addOrRename);
                user = new User();
                updadeUserInDB();
                setVisible(false);
            } catch (NeedsInterventionException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Improper name", JOptionPane.ERROR_MESSAGE);
            }
        } else {    // we overwrite the user name that was opened to be renamed
            try {
                checkConstraintsBeforeSave(addOrRename);
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Are you sure you want to rename user \"" + user.getName() + "\"?",
                        "Confirm rename.", JOptionPane.YES_NO_OPTION)) {
                    updadeUserInDB();
                    setVisible(false);
                }
            } catch (NeedsInterventionException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Improper name", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tfUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUserNameKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnSave.doClick();
        }
    }//GEN-LAST:event_tfUserNameKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables

    private void checkConstraintsBeforeSave(boolean addOrRename) throws NeedsInterventionException {
        String userName = tfUserName.getText();
        if (addOrRename) {      // the user wants to add a new user - the program needs to compare its name to all existing users
            for (User u : users) {
                if (userName.equals(u.getName())) {
                    throw new NeedsInterventionException("User \"" + userName + "\" already exists. Please change the name of the user.");
                }
            }
        } else {          // the user wants to rename an existing user - the program needs to compare its name to all the _other_ users, but not to that specific one
            for (User u : users) {
                if (u.getId() != user.getId() && userName.equals(u.getName())) {
                    throw new NeedsInterventionException("User \"" + userName + "\" already exists. Please change the name of the user.");
                }
            }
        }

        if (userName.length() < 1) {
            throw new NeedsInterventionException("Please specify a name for the user.");
        } else if (userName.length() > User.NAME_MAX_LENGTH) {
            throw new NeedsInterventionException("User's name is too long. Maximum: " + User.NAME_MAX_LENGTH + " characters.");
        } else {
            Pattern p = Pattern.compile("([\\\"'/=();.:,#])");
            Matcher m = p.matcher(userName);
            if (m.find()) {
                throw new NeedsInterventionException("Do not use special characters in the name field: \\ \" ' / = ( ) ; . : , # are not allowed.");
            }
        }
    }

    private void updadeUserInDB() {
        user.setName(tfUserName.getText());
        hibernate.HibernateMethods.saveOrUpdateUser(user);
    }

}
