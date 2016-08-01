package gui;

import customexceptions.NeedsInterventionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import pojos.Event;
import pojos.Experiment;
import pojos.KeyEvent;
import pojos.Keyset;
import pojos.Trial;
import pojos.User;

public class ExperimentsDialog extends javax.swing.JDialog {

    private List<Experiment> exps;
    private List<Keyset> keysets;
    private Experiment exp;
    private JFrame parent;
    private boolean isEditorEnabled;
    private boolean hasBeenEdited;
    private int selIndex = -1;
    private User user;
    private JFileChooser fc;
    private static final SimpleDateFormat SDFFileName = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
    private static final SimpleDateFormat SDFInCell = new SimpleDateFormat("yyyy.MM.dd.");

    public ExperimentsDialog(java.awt.Frame parent, User user) {
        super(parent, true);
        this.user = user;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Experiments of " + user.getName());
        btnExport.setEnabled(false);
        initOrUpdateDataAndView();
        setEditorEnabled(false);
        setTrialEditorEnabled(false);
        setupActionListeners();
        cbCodingMethod.setEnabled(false);
    }

    private void initOrUpdateDataAndView() {
        exps = user.getExpList();
        if (exps != null) {
            jlExp.setListData(exps.toArray());
            jlExp.repaint();
            updateEditorView();
            btnNewAnalysis.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEditExp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlExp = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnAddExp = new javax.swing.JButton();
        btnDeleteExp = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfExpName = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        cbKeyset = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbCodingMethod = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tfTrialLength = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSaveAs = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDiscard = new javax.swing.JButton();
        btnNewAnalysis = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnEditTrials = new javax.swing.JButton();
        btnDeleteTrials = new javax.swing.JButton();
        btnCloseTrialEditor = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlTrials = new javax.swing.JList();
        btnKeysets = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnEditExp.setText("Edit selected");
        btnEditExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditExpActionPerformed(evt);
            }
        });

        jlExp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jlExp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlExp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlExp.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlExpValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlExp);

        jLabel1.setText("Saved experiments:");

        btnAddExp.setText("Add New");
        btnAddExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExpActionPerformed(evt);
            }
        });

        btnDeleteExp.setText("Delete selected");
        btnDeleteExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteExpActionPerformed(evt);
            }
        });

        btnExport.setText("Export selected");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel3.setText("Description:");

        taDescription.setColumns(20);
        taDescription.setFont(taDescription.getFont().deriveFont(taDescription.getFont().getSize()-1f));
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        taDescription.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taDescription);

        jLabel4.setText("Keyset:");

        cbKeyset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKeyset.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKeysetItemStateChanged(evt);
            }
        });

        jLabel5.setText("Coding Method:");

        jLabel6.setText("Trial length:");

        jLabel7.setText("Analyzed trials:");

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

        btnNewAnalysis.setText("Start New Analysis");
        btnNewAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAnalysisActionPerformed(evt);
            }
        });

        jLabel8.setText("Properties:");

        btnEditTrials.setText("Edit Trials");
        btnEditTrials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTrialsActionPerformed(evt);
            }
        });

        btnDeleteTrials.setText("Delete selected trials");
        btnDeleteTrials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTrialsActionPerformed(evt);
            }
        });

        btnCloseTrialEditor.setText("Close Trial Editor");
        btnCloseTrialEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTrialEditorActionPerformed(evt);
            }
        });

        jlTrials.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jlTrials.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setViewportView(jlTrials);

        btnKeysets.setText("Manage Keysets");
        btnKeysets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeysetsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddExp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditExp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditTrials, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteExp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDeleteTrials)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCloseTrialEditor)
                                .addGap(4, 4, 4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNewAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSaveAs, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDiscard, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbCodingMethod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfTrialLength, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnKeysets)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfExpName)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                .addComponent(cbKeyset, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tfExpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cbKeyset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnKeysets)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbCodingMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(tfTrialLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDiscard)
                                    .addComponent(btnSave)
                                    .addComponent(btnSaveAs))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCloseTrialEditor)
                                    .addComponent(btnDeleteTrials))
                                .addGap(9, 9, 9)))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClose)
                            .addComponent(btnNewAnalysis))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddExp)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditExp)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditTrials)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteExp)
                        .addGap(18, 18, 18)
                        .addComponent(btnExport)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditExpActionPerformed
        if (exps == null) {
            JOptionPane.showMessageDialog(parent, "There is no saved experiment to be edited. Add a new experiment.", "No experiment in database", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int selIndex = jlExp.getSelectedIndex();
            if (selIndex == -1) {
                JOptionPane.showMessageDialog(parent, "Please select an experiment for editing.", "No experiment selected", JOptionPane.INFORMATION_MESSAGE);
            } else {     //There are saved experiments, and one is selected
                exp = exps.get(selIndex);
                setEditorEnabled(true);
            }
        }
    }//GEN-LAST:event_btnEditExpActionPerformed

    private void jlExpValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlExpValueChanged
        if (jlExp.getSelectedIndex() == -1) {
            exp = null;
            btnNewAnalysis.setEnabled(false);
        } else {
            exp = exps.get(jlExp.getSelectedIndex());
            btnNewAnalysis.setEnabled(true);
        }
        updateEditorView();
    }//GEN-LAST:event_jlExpValueChanged

    private void btnAddExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExpActionPerformed
        jlExp.setSelectedIndex(-1);
        exp = null;
        initOrUpdateDataAndView();
        setEditorEnabled(true);
    }//GEN-LAST:event_btnAddExpActionPerformed

    private void btnDeleteExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteExpActionPerformed
        if (exps == null) {
            JOptionPane.showMessageDialog(parent, "There is no saved experiment to be deletedt.", "No experiment in database", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int selIndex = jlExp.getSelectedIndex();
            if (selIndex == -1) {
                JOptionPane.showMessageDialog(parent, "Please select an experiment to be deleted.", "No experiment selected", JOptionPane.INFORMATION_MESSAGE);
            } else {
                exp = exps.get(selIndex);
                String message;
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, "Are you sure you want to permanently delete experiment \"" + exp.getName() + "\"?",
                        "Confirm permanent deletion", JOptionPane.YES_NO_OPTION)) {
                    hibernate.HibernateMethods.deleteExperiment(exp);
                    user.getExperiments().remove(exp);
                    initOrUpdateDataAndView();
                    if (exps != null && exps.size() > 0) {
                        if (selIndex < exps.size()) {
                            jlExp.setSelectedIndex(selIndex);
                        } else {
                            jlExp.setSelectedIndex(keysets.size());
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnDeleteExpActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        if (exps == null) {
            JOptionPane.showMessageDialog(parent, "There is no saved experiment to be exported. Add a new experiment.", "No experiment in database", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int selIndex = jlExp.getSelectedIndex();
            if (selIndex == -1) {
                JOptionPane.showMessageDialog(parent, "Please select an experiment for export.", "No experiment selected", JOptionPane.INFORMATION_MESSAGE);
            } else {     //There are saved experiments, and one is selected
                exp = exps.get(selIndex);
                fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setDialogTitle("Please select a folder in which the selected experiment will be exported.");
                if (fc.showSaveDialog(ExperimentsDialog.this) == JFileChooser.APPROVE_OPTION) {
                    File folder = fc.getSelectedFile();
                    Date saveDate = new Date(System.currentTimeMillis());
                    File experiment = new File(folder + "/" + exp.getName() + "_" + SDFFileName.format(saveDate) + ".csv");
                    try {
                        PrintWriter pw = new PrintWriter(experiment, "UTF-8");
                        pw.println("User;" + exp.getUser().getName());
                        pw.println("Experiment name;" + exp.getName());
                        pw.println("Description;" + exp.getDescription());
                        pw.println("Keyset name;" + exp.getKeyset().getName());
                        pw.println("Trial length;" + exp.getTrialLength() / 1000);
                        pw.println("Event mode;" + exp.getEventMode());
                        pw.println("Date of export;" + SDFInCell.format(saveDate));
                        pw.println();
                        pw.println("List of analyzed trials;Comment");
                        for (Trial t : exp.getTrialList()) {
                            pw.println(t.getName() + ";" + (t.getComment() == null ? "" : t.getComment()));
                        }
                        pw.close();

                        for (Trial t : exp.getTrialList()) {
                            File trial = new File(folder + "/" + exp.getName() + "_" + t.getName() + "_" + SDFFileName.format(saveDate) + ".csv");
                            PrintWriter pwFile = new PrintWriter(trial, "UTF-8");
                            pwFile.println("User;" + exp.getUser().getName());
                            pwFile.println("Experiment name;" + exp.getName());
                            pwFile.println("Trial name;" + t.getName());
                            pwFile.println("Comment;" + t.getComment());
                            pwFile.println("Trial length;" + exp.getTrialLength() / 1000);
                            pwFile.println("Event mode;" + exp.getEventMode());
                            pwFile.println("Date of export;" + SDFInCell.format(saveDate));
                            pwFile.println();
                            pwFile.println("Calculated data:");
                            pwFile.println("Event name; Latency; Frequency; Time; Time%");
                            for (KeyEvent ke : t.getExperiment().getKeyset().getKeyEventList()) {
                                pwFile.println(ke.getEventName() + ";" + t.getLatency(ke)/1000.0 + ";" + t.getFrequency(ke) + ";" + t.getTime(ke)/1000.0 + ";" + t.getTimePC(ke));
                            }
                            pwFile.println();

                            pwFile.println("Raw data:");
                            pwFile.println("Event no.; Event name; Time; Instantaneous");
                            for (Event e : t.getEventsList()) {
                                pwFile.println(e.getNoInTrial() + ";" + e.getName() + ";" + e.getEndTime() / 1000.0 + ";" + (e.getInstant() ? 1 : 0));
                            }
                            pwFile.close();

                        }

                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(parent, ex.getMessage(), "File not found.", JOptionPane.ERROR_MESSAGE);
                    } catch (UnsupportedEncodingException ex) {
                        JOptionPane.showMessageDialog(parent, ex.getMessage(), "Unsupported character encoding.", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        if (isEditorEnabled && hasBeenEdited) {
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, "Are you sure you want to discard changes made in the Editor?", "Discard changes?", JOptionPane.YES_NO_OPTION)) {
                setVisible(false);
            }
        } else {
            setVisible(false);
        }
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsActionPerformed
        try {
            checkConstraintsBeforeSave(true);
            exp = new Experiment(user);
            user.getExperiments().add(exp);
            updadeExpInDB();
            initOrUpdateDataAndView();
            setEditorEnabled(false);
        } catch (NeedsInterventionException ex) {
            JOptionPane.showMessageDialog(parent, ex.getMessage(), "Improper keyset", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveAsActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (exp == null) {       // This is actially an Add Nem window, so we need to save a new keyset
            btnSaveAs.doClick();
        } else {    // we overwrite the keyset that was opened to be edited
            try {
                checkConstraintsBeforeSave(false);
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, "Are you sure you want to overwrite experiment \"" + exp.getName() + "\"?",
                        "Confirm overwrite.", JOptionPane.YES_NO_OPTION)) {
                    updadeExpInDB();
                    int selExp = jlExp.getSelectedIndex();
                    initOrUpdateDataAndView();
                    jlExp.setSelectedIndex(selExp);
                    setEditorEnabled(false);
                }
            } catch (NeedsInterventionException ex) {
                JOptionPane.showMessageDialog(parent, ex.getMessage(), "Improper data", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscardActionPerformed
        if (isEditorEnabled && hasBeenEdited) {
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, "Are you sure you want to discard changes?", "Discard changes?", JOptionPane.YES_NO_OPTION)) {
                updateEditorView();
                setEditorEnabled(false);
                jlExp.setSelectedIndex(selIndex);
            }
        } else {
            updateEditorView();
            setEditorEnabled(false);
            jlExp.setSelectedIndex(selIndex);
        }
    }//GEN-LAST:event_btnDiscardActionPerformed

    private void btnNewAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAnalysisActionPerformed
        if (exp == null) {
            JOptionPane.showMessageDialog(parent, "Please select an experiment to start new analysis", "No selected experiment", JOptionPane.ERROR_MESSAGE);
        } else if (isEditorEnabled && hasBeenEdited) {
            JOptionPane.showMessageDialog(parent, "Please save or discard changes in Experiment Editor", "Close Editor before analysis", JOptionPane.ERROR_MESSAGE);
        } else {
            if (isEditorEnabled) {
                setEditorEnabled(false);
            }
            AnalysisDialog ad = new AnalysisDialog(parent, exp);
            ad.setVisible(true);
            updateJlTrials();
        }
    }//GEN-LAST:event_btnNewAnalysisActionPerformed

    private void cbKeysetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKeysetItemStateChanged
        hasBeenEdited = true;
    }//GEN-LAST:event_cbKeysetItemStateChanged

    private void btnDeleteTrialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTrialsActionPerformed
        int[] delIndices = jlTrials.getSelectedIndices();
        List<Trial> trialsToBeDeleted = new ArrayList<>();
        if (delIndices.length < 1) {
            JOptionPane.showMessageDialog(parent, "There is no selected trial that could be deleted", "No trial is selected", JOptionPane.INFORMATION_MESSAGE);
        } else if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, "Are you sure you want to permanently delete the selected trials? This action can not be undone.",
                "Confirm deletion", JOptionPane.YES_NO_OPTION)) {
            for (int i = 0; i < exp.getTrialList().size(); i++) {
                for (int j = 0; j < delIndices.length; j++) {
                    if (i == delIndices[j]) {
                        trialsToBeDeleted.add(exp.getTrialList().get(i));
                    }
                }
            }
            for (Trial trial : trialsToBeDeleted) {
                hibernate.HibernateMethods.deleteTrial(trial);
                exp.getTrials().remove(trial);
            }
            updateJlTrials();
        }

    }//GEN-LAST:event_btnDeleteTrialsActionPerformed

    private void btnCloseTrialEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTrialEditorActionPerformed
        setTrialEditorEnabled(false);
    }//GEN-LAST:event_btnCloseTrialEditorActionPerformed

    private void btnEditTrialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTrialsActionPerformed
        if (exps == null) {
            JOptionPane.showMessageDialog(parent, "There is no saved experiment to be edited. Add a new experiment.", "No experiment in database", JOptionPane.INFORMATION_MESSAGE);
        } else {
            selIndex = jlExp.getSelectedIndex();
            if (selIndex == -1) {
                JOptionPane.showMessageDialog(parent, "Please select an experiment for editing.", "No experiment selected", JOptionPane.INFORMATION_MESSAGE);
            } else {     //There are saved experiments, and one is selected
                exp = exps.get(selIndex);
                setTrialEditorEnabled(true);
            }
        }

    }//GEN-LAST:event_btnEditTrialsActionPerformed

    private void btnKeysetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeysetsActionPerformed
        KeysetDialog kld = new KeysetDialog(parent, user);
        kld.setVisible(true);
        updateCbKeysets();
    }//GEN-LAST:event_btnKeysetsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddExp;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCloseTrialEditor;
    private javax.swing.JButton btnDeleteExp;
    private javax.swing.JButton btnDeleteTrials;
    private javax.swing.JButton btnDiscard;
    private javax.swing.JButton btnEditExp;
    private javax.swing.JButton btnEditTrials;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnKeysets;
    private javax.swing.JButton btnNewAnalysis;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JComboBox<String> cbCodingMethod;
    private javax.swing.JComboBox<String> cbKeyset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList jlExp;
    private javax.swing.JList jlTrials;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextField tfExpName;
    private javax.swing.JTextField tfTrialLength;
    // End of variables declaration//GEN-END:variables

    private void updateEditorView() {
        tfExpName.setText("");
        taDescription.setText("");
        updateCbKeysets();
        cbCodingMethod.setModel(new DefaultComboBoxModel(new String[]{"ATEND"}));
//        cbCodingMethod.setModel(new DefaultComboBoxModel(new String[]{"ATEND", "ATSTART"}));
        tfTrialLength.setText("");
        if (exp != null) {
            tfExpName.setText(exp.getName());
            taDescription.setText(exp.getDescription());

            int cbKeysetSelIndex = 0;
            if (exp.getKeyset() != null) {
                for (int i = 0; i < keysets.size(); i++) {
                    if (keysets.get(i).getId() == exp.getKeyset().getId()) {
                        cbKeysetSelIndex = i + 1;
                    }
                }
            }
            cbKeyset.setSelectedIndex(cbKeysetSelIndex);

            switch (exp.getEventMode()) {
                case "ATEND":
                    cbCodingMethod.setSelectedIndex(0);
                    break;
//                case "ATSTART":
//                    cbCodingMethod.setSelectedIndex(1);
//                    break;
            }

            if (exp.getTrialLength() != null) {
                tfTrialLength.setText((exp.getTrialLength() / 1000) + "");
            }
            updateJlTrials();
        }
    }

    private void updateCbKeysets() {
        cbKeyset.removeAllItems();
        keysets = user.getKeysetList();
        if (keysets != null) {
            String[] valasztani = new String[keysets.size() + 1];
            valasztani[0] = "Please select keyset...";
            for (int i = 0; i < keysets.size(); i++) {
                valasztani[i + 1] = keysets.get(i).getName();
            }
            cbKeyset.setModel(new DefaultComboBoxModel(valasztani));
        }
    }

    private void updateJlTrials() {
        jlTrials.setListData(new Object[0]);
        if (exp.getTrialList() != null) {
            jlTrials.setListData(exp.getTrialList().toArray());
        }
        jlTrials.repaint();
        jlTrials.setSelectedIndex(-1);
    }

    private void updadeExpInDB() {
        exp.setName(tfExpName.getText());
        exp.setDescription(taDescription.getText());
        exp.setKeyset(keysets.get(cbKeyset.getSelectedIndex() - 1));
        exp.setEventMode(cbCodingMethod.getSelectedItem().toString());
        exp.setTrialLength(1000 * Long.parseLong(tfTrialLength.getText()));
        hibernate.HibernateMethods.saveOrUpdateExperiment(exp);
    }

    private void checkConstraintsBeforeSave(boolean checkAll) throws NeedsInterventionException {
        String expName = tfExpName.getText();
        if (checkAll) {      // the user wants to add a new experiment - the program needs to compare its name to all existing keysets
            for (Experiment ex : exps) {
                if (expName.equals(ex.getName())) {
                    throw new NeedsInterventionException("Experiment \"" + expName + "\" already exists. Please change the name of the experiment.");
                }
            }
        } else {          // the user wants to overwrite an existing experiment - the program needs to compare its name to all the _other_ experiments, but not to that specific one
            for (Experiment ex : exps) {
                if (ex.getId() != exp.getId() && expName.equals(ex.getName())) {
                    throw new NeedsInterventionException("Experiment \"" + expName + "\" already exists. Please change the name of the experiment.");
                }
            }
        }

        if (expName.length() < 1) {
            throw new NeedsInterventionException("Please specify a name for this Experiment");
        } else if (expName.length() > Experiment.NAME_MAX_LENGTH) {
            throw new NeedsInterventionException("Experiment's name is too long. Maximum: " + Experiment.NAME_MAX_LENGTH + " characters.");
        } else {
            Pattern p = Pattern.compile("([\\/=<>.,:;|?\"*])");
            Matcher m = p.matcher(expName);
            if (m.find()) {
                throw new NeedsInterventionException("Do not use special characters in the name field: \\ / = < > . , : ; | ? \" * are not allowed.");
            }
        }

        String description = taDescription.getText();
        if (description.length() > Experiment.DESCR_MAX_LENGTH) {
            throw new NeedsInterventionException("Description is too long. Maximum: " + Experiment.DESCR_MAX_LENGTH + " characters.");
        } else {
            Pattern p = Pattern.compile("(;)");
            Matcher m = p.matcher(description);
            if (m.find()) {
                throw new NeedsInterventionException("Do not use semicolon (;) in the description field.");
            }
        }

        if (cbKeyset.getSelectedIndex() == 0) {
            throw new NeedsInterventionException("Please choose a keyset. You can configure a new keyset by pressing \"Manage Keysets\"");
        }

        try {
            long trialLength = Long.parseLong(tfTrialLength.getText());
            if (trialLength <= 0) {
                throw new NeedsInterventionException("Please specify an integer as trial length (in seconds). If you want to terminate the analysis manually, please specify a sufficiently long time interval.");
            }
        } catch (NumberFormatException e) {
            throw new NeedsInterventionException("Please specify an integer as trial length (in seconds). If you want to terminate the analysis manually, please specify a sufficiently long time interval.");
        }
    }

    private void setEditorEnabled(boolean b) {
        tfExpName.setEnabled(b);
        taDescription.setEnabled(b);
        cbKeyset.setEnabled(b);
        btnKeysets.setEnabled(b);
//        cbCodingMethod.setEnabled(b);
        tfTrialLength.setEnabled(b);
        btnSaveAs.setEnabled(b);
        btnSave.setEnabled(b);
        btnDiscard.setEnabled(b);

        jlExp.setEnabled(!b);
        btnAddExp.setEnabled(!b);
        btnEditExp.setEnabled(!b);
        btnDeleteExp.setEnabled(!b);
        btnEditTrials.setEnabled(!b);
        btnExport.setEnabled(!b);
        isEditorEnabled = b;
        hasBeenEdited = false;
    }

    private void setTrialEditorEnabled(boolean b) {
        jlTrials.setEnabled(b);
        btnDeleteTrials.setEnabled(b);
        btnCloseTrialEditor.setEnabled(b);

        jlExp.setEnabled(!b);
        btnAddExp.setEnabled(!b);
        btnEditExp.setEnabled(!b);
        btnDeleteExp.setEnabled(!b);
        btnEditTrials.setEnabled(!b);
        btnExport.setEnabled(!b);
    }

    private void setupActionListeners() {
        tfExpName.getDocument().addDocumentListener(new DocumentListener() {
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

        taDescription.getDocument().addDocumentListener(new DocumentListener() {
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

        tfTrialLength.getDocument().addDocumentListener(new DocumentListener() {
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
    }
}
