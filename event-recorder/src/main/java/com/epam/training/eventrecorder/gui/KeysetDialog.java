package gui;

import customexceptions.NeedsInterventionException;
import customexceptions.NothingToDoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import pojos.Experiment;
import pojos.KeyEvent;
import pojos.Keyset;
import pojos.User;

public class KeysetDialog extends javax.swing.JDialog {

    private User user;
    private List<Keyset> keysets;
    private Keyset keyset;
    private DefaultTableModel tmKeyEvents;
    private List<KeyEvent> keysEvents;
    private JFrame parent;
    private boolean isEditorEnabled;
    private boolean hasBeenEdited;
    private JFileChooser fc;
    private static final SimpleDateFormat SDFFileName = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
    private static final SimpleDateFormat SDFInCell = new SimpleDateFormat("yyyy.MM.dd.");

    public KeysetDialog(java.awt.Frame parent, User user) {
        super(parent, true);
        this.user = user;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Manage keysets of " + user.getName());
        tmKeyEvents = (DefaultTableModel) jtKeysEvents.getModel();
        btnExport.setEnabled(false);
        initOrUpdateDataAndView();
        setEditorEnabled(false);
        setupActionListeners();
    }

    private void initOrUpdateDataAndView() {
        keysets = user.getKeysetList();
        if (keysets != null) {
            jlKeysets.setListData(keysets.toArray());
            jlKeysets.repaint();
            updateEditorView();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlKeysets = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnAddKeyset = new javax.swing.JButton();
        btnDeleteKeyset = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtKeysEvents = new javax.swing.JTable();
        btnEditKeyset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfKeysetName = new javax.swing.JTextField();
        btnSaveAs = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDiscard = new javax.swing.JButton();
        btnAddKey = new javax.swing.JButton();
        btnRemoveKey = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jlKeysets.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jlKeysets.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlKeysets.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlKeysets.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlKeysetsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlKeysets);

        jLabel1.setText("Keysets:");

        btnAddKeyset.setText("Add New");
        btnAddKeyset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKeysetActionPerformed(evt);
            }
        });

        btnDeleteKeyset.setText("Delete selected");
        btnDeleteKeyset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKeysetActionPerformed(evt);
            }
        });

        btnExport.setText("Export all");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jtKeysEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Key", "Event", "Instantaneous"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtKeysEvents.setEnabled(false);
        jtKeysEvents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtKeysEvents.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtKeysEventsFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(jtKeysEvents);

        btnEditKeyset.setText("Edit selected");
        btnEditKeyset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditKeysetActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        btnSaveAs.setText("Save As New");
        btnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAsActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDiscard.setText("Discard");
        btnDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscardActionPerformed(evt);
            }
        });

        btnAddKey.setText("Add New Key");
        btnAddKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKeyActionPerformed(evt);
            }
        });

        btnRemoveKey.setText("Remove Key");
        btnRemoveKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveKeyActionPerformed(evt);
            }
        });

        btnUp.setText("Move Up");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnDown.setText("Move Down");
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        jLabel3.setText("Keyset Editor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(189, 189, 189))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddKeyset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditKeyset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteKeyset, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfKeysetName))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnSaveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDiscard, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnRemoveKey, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddKey, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(29, 29, 29))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tfKeysetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddKeyset)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditKeyset)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteKeyset)
                                .addGap(18, 18, 18)
                                .addComponent(btnExport)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddKey)
                            .addComponent(btnUp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDown)
                            .addComponent(btnRemoveKey))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveAs, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDiscard, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(38, 38, 38)
                .addComponent(btnClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        if (isEditorEnabled && hasBeenEdited) {
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, "Are you sure you want to discard changes made in the Editor?", "Discard changes?", JOptionPane.YES_NO_OPTION)) {
                setVisible(false);
            }
        } else {
            setVisible(false);
        }
    }//GEN-LAST:event_btnCloseActionPerformed

    private void jlKeysetsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlKeysetsValueChanged
        if (jlKeysets.getSelectedIndex() == -1) {
            keyset = null;
        } else {
            keyset = keysets.get(jlKeysets.getSelectedIndex());
        }
        updateEditorView();
    }//GEN-LAST:event_jlKeysetsValueChanged

    private void btnAddKeysetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKeysetActionPerformed
        jlKeysets.setSelectedIndex(-1);
        keyset = null;
        initOrUpdateDataAndView();
        setEditorEnabled(true);
    }//GEN-LAST:event_btnAddKeysetActionPerformed

    private void btnEditKeysetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditKeysetActionPerformed
        if (keysets == null) {
            JOptionPane.showMessageDialog(parent, "There is no saved keyset to be edited. Add a new keyset.", "No keyset in database", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int selIndex = jlKeysets.getSelectedIndex();
            if (selIndex == -1) {
                JOptionPane.showMessageDialog(parent, "Please select a keyset for editing.", "No keyset selected", JOptionPane.INFORMATION_MESSAGE);
            } else {     //There are saved keysets, and one is selected
                keyset = keysets.get(selIndex);
                setEditorEnabled(true);
            }
        }
    }//GEN-LAST:event_btnEditKeysetActionPerformed

    private void btnDeleteKeysetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKeysetActionPerformed
        if (keysets == null) {
            JOptionPane.showMessageDialog(parent, "There is no saved keyset to be deletedt.", "No keyset in database", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int selIndex = jlKeysets.getSelectedIndex();
            if (selIndex == -1) {
                JOptionPane.showMessageDialog(parent, "Please select a keyset to be deleted.", "No keyset selected", JOptionPane.INFORMATION_MESSAGE);
            } else {
                keyset = keysets.get(selIndex);
                String message;
                boolean inUse = false;
                Set<Experiment> experiments = keyset.getExperiments();
                if (experiments != null && experiments.size() > 0) {
                    inUse = true;
                    message = "Keyset \"" + keyset.getName() + "\" is used in the following experiment(s):\n";
                    for (Experiment experiment : experiments) {
                        message += experiment.getName();
                        message += "\n";
                    }
                    message += "Are you sure you want to permanently delete this keyset?";
                } else {
                    message = "Are you sure you want to permanently delete keyset \"" + keyset.getName() + "\"?";
                }
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, message, (inUse ? "Keyset is in use!" : "Confirm permanent deletion"), JOptionPane.YES_NO_OPTION)) {
                    if (inUse) {
                        for (Experiment experiment : experiments) {
                            experiment.setKeyset(null);
                            hibernate.HibernateMethods.saveOrUpdateExperiment(experiment);
                        }
                    }
                    hibernate.HibernateMethods.deleteKeyset(keyset);
                    user.getKeysets().remove(keyset);
                    initOrUpdateDataAndView();
                    if (keysets != null && keysets.size() > 0) {
                        if (selIndex < keysets.size()) {
                            jlKeysets.setSelectedIndex(selIndex);
                        } else {
                            jlKeysets.setSelectedIndex(keysets.size() - 1);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnDeleteKeysetActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Please select a folder in which all keysets will be exported.");
        if (fc.showSaveDialog(KeysetDialog.this) == JFileChooser.APPROVE_OPTION) {
            File folder = fc.getSelectedFile();
            for (Keyset ks : keysets) {
                Date saveDate = new Date(System.currentTimeMillis());
                File file = new File(folder + "/" + ks.getName() + "_" + SDFFileName.format(saveDate) + ".csv");
                try {
                    PrintWriter pw = new PrintWriter(file,"UTF-8");
                    pw.println("User;" + ks.getUser().getName());
                    pw.println("Keyset name;" + ks.getName());
                    pw.println("Date of export;" + SDFInCell.format(saveDate));
                    pw.println();
                    pw.println("keystroke;event name;instantaneous");
                    for (KeyEvent ke : ks.getKeyEventList()) {
                        pw.println(ke.getKeystroke()+";"+ke.getEventName()+";"+(ke.isInstantaneous()?1:0));
                    }
                    pw.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(parent, ex.getMessage(), "File not found.", JOptionPane.ERROR_MESSAGE);
                } catch (UnsupportedEncodingException ex) {
                    JOptionPane.showMessageDialog(parent, ex.getMessage(), "Unsupported character encoding.", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsActionPerformed
        try {
            checkNameBeforeSave(true);
            checkConstraintsBeforeSave();
            keyset = new Keyset(user);
            user.getKeysets().add(keyset);
            updadeKeysetInDB();
            initOrUpdateDataAndView();
            setEditorEnabled(false);
        } catch (NeedsInterventionException ex) {
            JOptionPane.showMessageDialog(parent, ex.getMessage(), "Improper keyset", JOptionPane.ERROR_MESSAGE);
        } catch (NothingToDoException ex) {
        }
    }//GEN-LAST:event_btnSaveAsActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (keyset == null) {       // This is actially an Add Nem window, so we need to save a new keyset
            btnSaveAs.doClick();
        } else {    // we overwrite the keyset that was opened to be edited
            try {
                checkConstraintsBeforeSave();
                checkNameBeforeSave(false);     // The name has to be compared only to the other keysets
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, "Are you sure you want to overwrite keyset \"" + keyset.getName() + "\"?",
                        "Confirm overwrite.", JOptionPane.YES_NO_OPTION)) {
                    updadeKeysetInDB();
                    int selKeyset = jlKeysets.getSelectedIndex();
                    initOrUpdateDataAndView();
                    jlKeysets.setSelectedIndex(selKeyset);
                    setEditorEnabled(false);
                }
            } catch (NeedsInterventionException ex) {
                JOptionPane.showMessageDialog(parent, ex.getMessage(), "Improper keyset", JOptionPane.ERROR_MESSAGE);
            } catch (NothingToDoException ex) {
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscardActionPerformed
        if (isEditorEnabled && hasBeenEdited) {
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, "Are you sure you want to discard changes?", "Discard changes?", JOptionPane.YES_NO_OPTION)) {
                updateEditorView();
                setEditorEnabled(false);
            }
        } else {
            updateEditorView();
            setEditorEnabled(false);
        }
    }//GEN-LAST:event_btnDiscardActionPerformed

    private void btnAddKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKeyActionPerformed
        int selRow = jtKeysEvents.getSelectedRow();
        tmKeyEvents.insertRow(selRow == -1 ? tmKeyEvents.getRowCount() : selRow, new Vector());
        jtKeysEvents.repaint();
    }//GEN-LAST:event_btnAddKeyActionPerformed

    private void btnRemoveKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveKeyActionPerformed
        int selRow = jtKeysEvents.getSelectedRow();
        if (selRow != -1) {
            tmKeyEvents.removeRow(jtKeysEvents.getSelectedRow());
        }
    }//GEN-LAST:event_btnRemoveKeyActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        if (tmKeyEvents != null) {
            int selRow = jtKeysEvents.getSelectedRow();
            if (0 < selRow) {
                tmKeyEvents.moveRow(selRow - 1, selRow - 1, selRow);
                jtKeysEvents.setRowSelectionInterval(selRow - 1, selRow - 1);
            }
        }
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        if (tmKeyEvents != null) {
            int selRow = jtKeysEvents.getSelectedRow();
            if (selRow != -1 && selRow < jtKeysEvents.getRowCount() - 1) {
                tmKeyEvents.moveRow(selRow, selRow, selRow + 1);
                jtKeysEvents.setRowSelectionInterval(selRow + 1, selRow + 1);
            }
        }
    }//GEN-LAST:event_btnDownActionPerformed

    private void jtKeysEventsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtKeysEventsFocusLost
        if (jtKeysEvents.getCellEditor() != null) {
            jtKeysEvents.getCellEditor().stopCellEditing();
        }
    }//GEN-LAST:event_jtKeysEventsFocusLost

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKey;
    private javax.swing.JButton btnAddKeyset;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDeleteKeyset;
    private javax.swing.JButton btnDiscard;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnEditKeyset;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnRemoveKey;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList jlKeysets;
    private javax.swing.JTable jtKeysEvents;
    private javax.swing.JTextField tfKeysetName;
    // End of variables declaration//GEN-END:variables

    private void updateEditorView() {
        tmKeyEvents.getDataVector().removeAllElements();
        tfKeysetName.setText("");
        if (keyset != null) {
            tfKeysetName.setText(keyset.getName());
            keysEvents = keyset.getKeyEventList();
            for (KeyEvent keyevent : keysEvents) {
                Vector sor = new Vector();
                sor.add(keyevent.getKeystroke());
                sor.add(keyevent.getEventName());
                sor.add(keyevent.isInstantaneous());
                tmKeyEvents.addRow(sor);
            }
        }

        tmKeyEvents.fireTableDataChanged();
    }

    private void updadeKeysetInDB() {
        keyset.setName(tfKeysetName.getText());
        hibernate.HibernateMethods.saveOrUpdateKeyset(keyset);

        if (keyset.getKeyEvents() != null) {
            for (KeyEvent keyevent : keyset.getKeyEvents()) {
                hibernate.HibernateMethods.deleteKeyEvent(keyevent);
            }
        }
        keyset.setKeyEvents(new HashSet<>());
        for (int row = 0; row < tmKeyEvents.getRowCount(); row++) {
            KeyEvent newKeyevent = new KeyEvent(
                    keyset,
                    (String) tmKeyEvents.getValueAt(row, 0),
                    (String) tmKeyEvents.getValueAt(row, 1),
                    (Boolean) tmKeyEvents.getValueAt(row, 2)
            );
            keyset.getKeyEvents().add(newKeyevent);
            hibernate.HibernateMethods.saveOrUpdateKeyEvent(newKeyevent);
        }
    }

    private void checkNameBeforeSave(boolean checkAll) throws NeedsInterventionException {
        String keysetName = tfKeysetName.getText();

        if (checkAll) {      // the user wants to add a new keyset - the program needs to compare its name to all existing keysets
            for (Keyset ks : keysets) {
                if (keysetName.equals(ks.getName())) {
                    throw new NeedsInterventionException("Keyset \"" + keysetName + "\" already exists. Please change the name of the keyset.");
                }
            }
        } else {          // the user wants to overwrite an existing keyset - the program needs to compare its name to all the _other_ keysets, but not to that specific one
            for (Keyset ks : keysets) {
                if (ks.getId() != keyset.getId() && keysetName.equals(ks.getName())) {
                    throw new NeedsInterventionException("Keyset \"" + keysetName + "\" already exists. Please change the name of the keyset.");
                }
            }
        }
    }

    private void checkConstraintsBeforeSave() throws NeedsInterventionException, NothingToDoException {
        List<String> keystrokes = new ArrayList<>();
        List<String> eventNames = new ArrayList<>();
        String keysetName;

        keysetName = tfKeysetName.getText();
        if (keysetName.length() < 1) {
            throw new NeedsInterventionException("Please specify a name for this keyset");
        } else if (keysetName.length() > Keyset.NAME_MAX_LENGTH) {
            throw new NeedsInterventionException("Keyset's name is too long. Maximum: " + Keyset.NAME_MAX_LENGTH + " characters.");
        } else {
            Pattern p = Pattern.compile("([\\/=<>.,:;|?\"*])");
            Matcher m = p.matcher(keysetName);
            if (m.find()) {
                throw new NeedsInterventionException("Do not use special characters in the name field: \\ / = < > . , : ; | ? \" * are not allowed.");
            }
        }

        int rowCount = jtKeysEvents.getRowCount();

        for (int i = 0; i < rowCount; i++) {

            String keystroke = (String) tmKeyEvents.getValueAt(i, 0);
            if (keystroke == null) {
                throw new NeedsInterventionException("No keystroke specified in row no. " + (i + 1) + ".");
            } else if (keystroke.length() < 1) {
                throw new NeedsInterventionException("No keystroke specified in row no. " + (i + 1) + ".");
            } else if (keystroke.length() > 1) {
                throw new NeedsInterventionException("More than one keystroke in row no. " + (i + 1) + ".");
            }
            keystrokes.add(keystroke);

            String eventName = (String) tmKeyEvents.getValueAt(i, 1);
            if (eventName == null) {
                throw new NeedsInterventionException("No event name specified in row no. " + (i + 1) + ".");
            } else if (eventName.length() < 1) {
                throw new NeedsInterventionException("No event name specified in row no. " + (i + 1) + ".");
            } else if (eventName.length() > KeyEvent.EVENT_NAME_MAX_LENGTH) {
                throw new NeedsInterventionException("Event name is too long in row no. " + (i + 1) + ". Maximum: " + KeyEvent.EVENT_NAME_MAX_LENGTH + " characters.");
            } else {
                Pattern p = Pattern.compile("([\\wéáűúőóüöíÉÁŰÚŐÓÜÖÍ\\-_.]+)");
                Matcher m = p.matcher(eventName);
                if (!m.find()) {
                    throw new NeedsInterventionException("Invalid event name: " + eventName + ". Letters, digits and - _ . characters are allowed without space.");
                } else if (!eventName.equals(m.group())) {
                    throw new NeedsInterventionException("Invalid event name: " + eventName + ". Letters, digits and - _ . characters are allowed without space.");
                }
            }
            eventNames.add(eventName);

            if (tmKeyEvents.getValueAt(i, 2) == null) {
                tmKeyEvents.setValueAt(false, i, 2);
            }  // set null values to false in the Instantaneous column

        }

        // Ha azonos kulcsok vannak, javítást kérni
        int redundantKeystrokes = isRedundant(keystrokes);
        if (redundantKeystrokes != -1) {
            throw new NeedsInterventionException("The following keystroke has more than one copies: " + keystrokes.get(redundantKeystrokes));
        }

        // Ha azonos események vannak, rákérdezni, hogy így is menti-e!
        int redundantEventNames = isRedundant(eventNames);
        if (redundantEventNames != -1) {
            if (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(parent, "Are you sure you want to add more than one keystroke to a specific event?",
                    "Redundant events", JOptionPane.YES_NO_OPTION)) {
                throw new NothingToDoException();
            }
        }
    }

    private int isRedundant(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    if (list.get(i).equals(list.get(j))) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private void setEditorEnabled(boolean b) {
        jtKeysEvents.setEnabled(b);
        tfKeysetName.setEnabled(b);
        btnAddKey.setEnabled(b);
        btnRemoveKey.setEnabled(b);
        btnUp.setEnabled(b);
        btnDown.setEnabled(b);
        btnSaveAs.setEnabled(b);
        btnSave.setEnabled(b);
        btnDiscard.setEnabled(b);

        jlKeysets.setEnabled(!b);
        btnAddKeyset.setEnabled(!b);
        btnEditKeyset.setEnabled(!b);
        btnDeleteKeyset.setEnabled(!b);
        btnExport.setEnabled(!b);
        isEditorEnabled = b;
        hasBeenEdited = false;
    }

    private void setupActionListeners() {
        tfKeysetName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                hasBeenEdited = true;
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                hasBeenEdited = true;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                hasBeenEdited = true;
            }
        });

        tmKeyEvents.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {
                hasBeenEdited = true;
            }
        });
    }

}
