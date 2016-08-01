package gui;

import customexceptions.NeedsInterventionException;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JButton;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import pojos.Event;
import pojos.Experiment;
import pojos.KeyEvent;
import pojos.Keyset;
import pojos.Trial;

public class AnalysisDialog extends javax.swing.JDialog {

    private Frame parent;
    private JButton[] keys;
    private final Experiment exp;
    private final Keyset keyset;
    private final List<KeyEvent> keyEvents;
    private final Map<String, KeyEvent> keyEventsMap;
    private List<Event> events;
    private long trialLength;
    private long trialStart;
    private long trialEnd;
    private long timeRemaining;
    private long actualTime;
    private DefaultTableModel eventsTableModel;
    private Timer timer;
    private NumberFormat timeFormat = new DecimalFormat("#.#");
    private int lastNonInstantEvent;
    private Trial trial;

    public AnalysisDialog(java.awt.Frame parent, Experiment exp) {
        super(parent, true);
        this.exp = exp;
        this.keyset = exp.getKeyset();
        this.keyEvents = keyset.getKeyEventList();
        this.keyEventsMap = new HashMap<>();
        for (KeyEvent ke : keyEvents) {
            keyEventsMap.put(ke.getEventName(), ke);
        }
        this.trialLength = exp.getTrialLength();
        setTitle("Analysis");
        initComponents();
        setLocationRelativeTo(null);
        this.trial = new Trial(exp);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (timeRemaining > 0) {
                    timeRemaining = trialEnd - System.currentTimeMillis();
                    actualTime = trialLength - timeRemaining;
                } else {
                    timer.stop();
                    timeRemaining = 0;
                    actualTime = trialLength;
                    btnPause.setEnabled(false);
                }
                tfTimeRemaining.setText(timeFormat.format(timeRemaining / 1000d));
                tfActualTime.setText(timeFormat.format(actualTime / 1000d));
            }
        });

        eventsTableModel = (DefaultTableModel) jtEvents.getModel();

        keys = new JButton[keyEvents.size()];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = new JButton(keyEvents.get(i).getKeystroke() + " - " + keyEvents.get(i).getEventName());
            keys[i].setName(keyEvents.get(i).getEventName());
            keys[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String eventName = ((JButton) ae.getSource()).getName();
                    KeyEvent ke = keyEventsMap.get(eventName);
                    if (timeRemaining <= 0 && ke.isInstantaneous() && exp.getEventMode().equals("ATEND")) {
                        // ignore instantaneuous event if trial time has passed and EventMode is "ATEND"
                    } else {
                        processKeystroke(ke);
                        updateJTable();
                        if (timeRemaining <= 0) {
                            for (JButton key : keys) {
                                key.setEnabled(false);
                            }
                            btnPause.setEnabled(false);
                        }
                    }
                }
            });
            pKeys.add(keys[i]);
            keys[i].setEnabled(false);
        }

        InputMap imap = pKeys.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        for (int i = 0; i < keyEvents.size(); i++) {
            String keystroke = keyEvents.get(i).getKeystroke().toUpperCase();
            String name = keyEvents.get(i).getEventName();
            imap.put(KeyStroke.getKeyStroke(keystroke), keystroke);
            pKeys.getActionMap().put(keystroke, new AbstractAction() {
                private int index;

                private AbstractAction init(int var) {
                    this.index = var;
                    return this;
                }

                @Override
                public void actionPerformed(ActionEvent ae) {
                    keys[index].doClick();
                }
            }.init(i));
        }

        resetAnalysis();
    }

    private void resetAnalysis() {
        timer.stop();
        timeRemaining = trialLength;
        actualTime = 0;
        tfTimeRemaining.setText(timeFormat.format(timeRemaining / 1000));
        tfActualTime.setText("0");
        btnStart.setEnabled(true);
        btnSaveTrial.setEnabled(false);
        btnPause.setEnabled(false);
        btnContinue.setEnabled(false);
        events = new ArrayList<>();
        updateJTable();
        lastNonInstantEvent = -1;
    }

    private void processKeystroke(KeyEvent ke) {
        if (ke.isInstantaneous()) {   //instantaneuous -> add if within time, ignore if 
            events.add(new Event(ke.getEventName(), true, actualTime, trial));
        } else if (lastNonInstantEvent == -1 //non-instant, there was no non-instant before -> add, save as lastNonInstant OR
                || !ke.getEventName().equals(events.get(lastNonInstantEvent).getName())) {    // non-instant, differs from last non-instant -> add, save as lastNonInstant
            events.add(new Event(ke.getEventName(), false, actualTime, trial));
            lastNonInstantEvent = events.size() - 1;
        } else {      // the last non-instantaneuous and this event are the same 
            switch (exp.getEventMode()) {
                case "ATEND":   //remove last non-instant, add this one as last event
                    events.remove(lastNonInstantEvent);
                    events.add(new Event(ke.getEventName(), false, actualTime, trial));
                    lastNonInstantEvent = events.size() - 1;
                    break;
                case "ATSTART":
                    break;      //ignore this actual event.
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEvents = new javax.swing.JTable();
        pKeys = new javax.swing.JPanel();
        jlabKeyset = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfTestLength = new javax.swing.JTextField();
        tfTimeRemaining = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jlabExp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfActualTime = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnSaveTrial = new javax.swing.JButton();
        tfTrialName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taComment = new javax.swing.JTextArea();
        btnPause = new javax.swing.JButton();
        btnContinue = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jtEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Number", "Event", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtEvents.setEnabled(false);
        jScrollPane1.setViewportView(jtEvents);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(677, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(25, 25, 25))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pKeys.setLayout(new java.awt.GridLayout(20, 1));

        jlabKeyset.setText("Keyset: " + exp.getKeyset().getName());

        jLabel1.setText("Trial length:");

        tfTestLength.setEditable(false);
        tfTestLength.setText((exp.getTrialLength()/1000)+"");

        tfTimeRemaining.setEditable(false);
        tfTimeRemaining.setText((exp.getTrialLength()/1000)+"");

        jLabel2.setText("Time remaining:");

        btnStart.setText("Start Analysis");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jlabExp.setText("Experiment: " + exp.getName());

        jLabel3.setText("Actual time:");

        tfActualTime.setEditable(false);
        tfActualTime.setText("0");

        btnCancel.setText("Cancel Trial");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSaveTrial.setText("Save Trial");
        btnSaveTrial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTrialActionPerformed(evt);
            }
        });

        jLabel4.setText("Trial name:");

        jLabel5.setText("Comment:");

        taComment.setColumns(20);
        taComment.setRows(5);
        jScrollPane2.setViewportView(taComment);

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnContinue.setText("Continue");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfActualTime, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(tfTestLength, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addComponent(jlabExp)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTimeRemaining, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveTrial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfTrialName)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2)
                    .addComponent(btnPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContinue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pKeys, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabKeyset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabKeyset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pKeys, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jlabExp)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTestLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfActualTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfTimeRemaining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnStart)
                .addGap(18, 18, 18)
                .addComponent(btnPause)
                .addGap(18, 18, 18)
                .addComponent(btnContinue)
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTrialName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveTrial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        trialStart = System.currentTimeMillis();
        trialEnd = trialStart + trialLength;
        timer.start();
        for (JButton key : keys) {
            key.setEnabled(true);
        }
        btnSaveTrial.setEnabled(true);
        btnStart.setEnabled(false);
        btnPause.setEnabled(true);
        btnContinue.setEnabled(false);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        btnPause.doClick();
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(parent, "Are you sure you want to cancel this analysis? Data will be lost.", "Confirm cancel", JOptionPane.YES_NO_OPTION)) {
            resetAnalysis();
        } else {
            btnContinue.doClick();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveTrialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTrialActionPerformed
        try {
            checkTrialNameBeforeSave();
            trial.setName(tfTrialName.getText());
            trial.setComment(taComment.getText());
            for (int i = 0; i < events.size(); i++) {
                events.get(i).setNoInTrial(i);
            }
            trial.setEvents(new HashSet<Event>(events));
            hibernate.HibernateMethods.saveTrial(trial);
            hibernate.HibernateMethods.saveEventList(events);
            tfTrialName.setText(null);
            taComment.setText(null);
            resetAnalysis();
            exp.getTrials().add(trial);
        } catch (NeedsInterventionException ex) {
            btnPause.doClick();
            JOptionPane.showMessageDialog(parent, ex.getMessage(), "Improper Trial name or comment", JOptionPane.ERROR_MESSAGE);
            btnContinue.doClick();
        }
    }//GEN-LAST:event_btnSaveTrialActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        timer.stop();
        timeRemaining = trialEnd - System.currentTimeMillis();
        for (JButton key : keys) {
            key.setEnabled(false);
        }
        btnContinue.setEnabled(true);
        btnPause.setEnabled(false);
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        for (JButton key : keys) {
            key.setEnabled(true);
        }
        timer.restart();
        trialEnd = timeRemaining + System.currentTimeMillis();
        btnContinue.setEnabled(false);
        btnPause.setEnabled(true);
    }//GEN-LAST:event_btnContinueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnSaveTrial;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabExp;
    private javax.swing.JLabel jlabKeyset;
    private javax.swing.JTable jtEvents;
    private javax.swing.JPanel pKeys;
    private javax.swing.JTextArea taComment;
    private javax.swing.JTextField tfActualTime;
    private javax.swing.JTextField tfTestLength;
    private javax.swing.JTextField tfTimeRemaining;
    private javax.swing.JTextField tfTrialName;
    // End of variables declaration//GEN-END:variables

    private void updateJTable() {
        eventsTableModel.getDataVector().removeAllElements();
        for (int i = events.size() - 1; i > events.size() - 50 && i >= 0; i--) {
            Vector row = new Vector();
            row.add(i + 1);
            row.add(events.get(i).getName());
            switch (exp.getEventMode()) {
                case "ATEND":
                    row.add(timeFormat.format(events.get(i).getEndTime() / 1000d));
                    break;
                case "ATSTART":
                    row.add(timeFormat.format(events.get(i).getStartTime() / 1000d));
                    break;
            }
            eventsTableModel.addRow(row);
        }
        jtEvents.repaint();
    }

    private void checkTrialNameBeforeSave() throws NeedsInterventionException {
        String trialName = tfTrialName.getText();
        for (Trial trial : exp.getTrialList()) {
            if (trialName.equals(trial.getName())) {
                throw new NeedsInterventionException("Trial \"" + trialName + "\" already exists. Please change the name of the trial.");
            }
        }

        if (trialName.length() < 1) {
            throw new NeedsInterventionException("Please specify a name for this Trial");
        } else if (trialName.length() > Trial.NAME_MAX_LENGTH) {
            throw new NeedsInterventionException("Trial's name is too long. Maximum: " + Trial.NAME_MAX_LENGTH + " characters.");
        } else {
            Pattern p = Pattern.compile("([\\/=<>.,:;|?\"*])");
            Matcher m = p.matcher(trialName);
            if (m.find()) {
                throw new NeedsInterventionException("Do not use special characters in the name: \\ / = < > . , : ; | ? \" * are not allowed.");
            }
        }

        String comment = taComment.getText();
        if (comment.length() > Trial.COMMENT_MAX_LENGTH) {
            throw new NeedsInterventionException("Comment's name is too long. Maximum: " + Trial.COMMENT_MAX_LENGTH + " characters.");
        } else {
            Pattern p = Pattern.compile("(;)");
            Matcher m = p.matcher(comment);
            if (m.find()) {
                throw new NeedsInterventionException("Do not use semicolon (;) in the comment.");
            }
        }

    }
}
