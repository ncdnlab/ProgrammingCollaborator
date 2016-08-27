package programmingcollaborator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.BufferedWriter;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static programmingcollaborator.FileHandler.bufferedWriterOfUva;

/**
 *
 * Programming Collaborator | Useful Tool For Programmers
 *
 * @author Abdullah-Al Masum Khan, ID: 150103020010
 * @author Md. Abu Salek, ID: 150103020012
 * @author Md. Abu Naser, ID: 150103020009
 * @author Md Mahadi Hasan Nahid, nahid@neub.edu.bd
 */
public class InsertionFrame extends javax.swing.JFrame implements ActionListener {

    static int catagory, done, site;

    public InsertionFrame() {

        initComponents();
        setVisible(true);
        setTitle("Insertion Frame --> ProgC");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);
        buttonGroup1.add(dpRadioButton);
        buttonGroup1.add(stringRadioButton);
        buttonGroup1.add(mathRadioButton);
        buttonGroup1.add(numberTheoryRadioButton);
        buttonGroup1.add(graphRadioButton);
        buttonGroup1.add(algorithmicRadioButton);
        backButton.addActionListener(this);
        closeButton.addActionListener(this);
        buttonGroup2.add(doneRadioButton);
        buttonGroup2.add(toBeDoneRadioButton);
        siteComboBox.addActionListener(this);
        idTextField.addActionListener(this);
        insertOkButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == insertOkButton) {
            checkInputCorrectness();
        }
        if (e.getSource() == backButton) {
            setVisible(false);
        }
        if (e.getSource() == clearButton) {
            clear();
        }
        if (e.getSource() == closeButton) {
            setVisible(false);
        }
        if (e.getSource() == exitMenuItem) {
            setVisible(false);
        }
        if (e.getSource() == aboutMenuItem) {
            AboutJFrame aboutFrameObj = new AboutJFrame();
        }

    }

    public void checkInputCorrectness() {

        boolean idVsSiteCorrectness = true, fieldCompletion = true, duplicate = false, idInInt = true;

        getInsertionInformation();

        try {
            FileHandler.problemId = Integer.parseInt(FileHandler.problemIdInString);
        } catch (NumberFormatException e) {
            idInInt = false;     //  for defining id is in string or in int ( related to site )
        }

        if ((buttonGroup1.getSelection() == null) || (buttonGroup2.getSelection() == null)
                || (siteComboBox.getSelectedItem() == null) || (idTextField.getText().equals(""))) {

            FileHandler.jOptionPane = new JOptionPane("Please Complete All The Required Fields..", JOptionPane.WARNING_MESSAGE);
            final JDialog dialog = FileHandler.jOptionPane.createDialog("");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.setVisible(false);
                }
            }).start();
            dialog.setVisible(true);
            fieldCompletion = false;
            clear();
        }

        if (fieldCompletion == true && (((site == 1 || site == 3) && (idInInt == true)) || ((site == 0 || site == 2) && (idInInt == false)))) {

            FileHandler.jOptionPane = new JOptionPane("Its Not A Valid Problem Id For The Selected Owner Site \n Do It Again ..", JOptionPane.WARNING_MESSAGE);
            final JDialog dialog = FileHandler.jOptionPane.createDialog("");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.setVisible(false);
                }
            }).start();
            dialog.setVisible(true);
            idVsSiteCorrectness = false;
            clear();

        }

        if (idVsSiteCorrectness == true) {
            if (duplicate = isItAlreadyInserted() == true) {
                FileHandler.jOptionPane.showMessageDialog(null, "A Problem With This Id Is Already Inserted \n In Your Selected Site You Can Just\n Erase That Problem Or Update It");
                clear();
            }
        }

        if (duplicate == false && idVsSiteCorrectness == true && fieldCompletion == true) {

            try {
                insertProblemNow();

            } catch (IOException ex) {
                FileHandler.jOptionPane.showMessageDialog(null, "Programming Collaborator Is In Trouble By Itself...... ");
            }
        }
    }

    public boolean isItAlreadyInserted() {

        Scanner scannerObj = null;
        String id;
        Boolean duplicate = false;

        if (site == 0) {
            scannerObj = FileHandler.scannerObjOfUvaFile;
        }
        if (site == 1) {
            scannerObj = FileHandler.scannerObjOfCodeForceFile;
        }
        if (site == 2) {
            scannerObj = FileHandler.scannerObjOfLightOjFile;
        }
        if (site == 3) {
            scannerObj = FileHandler.scannerObjOfCodechefFile;
        }
        while (scannerObj.hasNext()) {
            id = scannerObj.next();
            if (id.equals(FileHandler.problemIdInString)) {
                duplicate = true;
                break;
            }
        }
        return duplicate;

    }

    public void getInsertionInformation() {

        FileHandler.problemIdInString = idTextField.getText();
        site = siteComboBox.getSelectedIndex();
        if (doneRadioButton.isSelected()) {
            done = 0;
        }
        if (toBeDoneRadioButton.isSelected()) {
            done = 1;
        }
        if (numberTheoryRadioButton.isSelected()) {
            catagory = 1;
        }
        if (dpRadioButton.isSelected()) {
            catagory = 2;
        }
        if (graphRadioButton.isSelected()) {
            catagory = 3;
        }
        if (stringRadioButton.isSelected()) {
            catagory = 4;
        }
        if (mathRadioButton.isSelected()) {
            catagory = 5;
        }
        if (algorithmicRadioButton.isSelected()) {
            catagory = 6;
        }

    }

    public void insertProblemNow() throws IOException {

        FileHandler.makeFileToWrite();  // For Need Of Making Obj Again And Again We Make A Call To This Method. Becaue Prblm Can Be Inserted In A Site 
        // consecutively More Than One Times And We Just Closed File After One Time Write so......

        if (site == 0) {

            FileHandler.bufferedWriterOfUva.write(FileHandler.problemIdInString + " " + done + " " + catagory);
            FileHandler.bufferedWriterOfUva.newLine();
            FileHandler.bufferedWriterOfUva.close();

        }
        if (site == 1) {
            FileHandler.bufferedWriterOfCodeforces.write(FileHandler.problemIdInString + " " + done + " " + catagory);
            FileHandler.bufferedWriterOfCodeforces.newLine();
            FileHandler.bufferedWriterOfCodeforces.close();

        }
        if (site == 2) {
            FileHandler.bufferedWriterOfLightOj.write(FileHandler.problemIdInString + " " + done + " " + catagory);
            FileHandler.bufferedWriterOfLightOj.newLine();
            FileHandler.bufferedWriterOfLightOj.close();

        }
        if (site == 3) {
            FileHandler.bufferedWriterOfCodechef.write(FileHandler.problemIdInString + " " + done + " " + catagory);
            FileHandler.bufferedWriterOfCodechef.newLine();
            FileHandler.bufferedWriterOfCodechef.close();

        }
        clear();
        insertionConfirmed();

    }

    public void clear() {
        idTextField.setText(null);
        siteComboBox.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }

    public void insertionConfirmed() {

        FileHandler.jOptionPane = new JOptionPane("PROBLEM: " + FileHandler.problemIdInString + "  Is Inserted With All Information ", JOptionPane.INFORMATION_MESSAGE);
        final JDialog dialog = FileHandler.jOptionPane.createDialog("");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dialog.setVisible(false);
            }
        }).start();
        dialog.setVisible(true);

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        buttonGroup2 = new javax.swing.ButtonGroup();
        idLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        siteLabel = new javax.swing.JLabel();
        siteComboBox = new javax.swing.JComboBox<>();
        catagoryLabel = new javax.swing.JLabel();
        numberTheoryRadioButton = new javax.swing.JRadioButton();
        dpRadioButton = new javax.swing.JRadioButton();
        graphRadioButton = new javax.swing.JRadioButton();
        stringRadioButton = new javax.swing.JRadioButton();
        mathRadioButton = new javax.swing.JRadioButton();
        algorithmicRadioButton = new javax.swing.JRadioButton();
        backButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        doneNotDoneLabel = new javax.swing.JLabel();
        doneRadioButton = new javax.swing.JRadioButton();
        toBeDoneRadioButton = new javax.swing.JRadioButton();
        clearButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        insertOkButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        idLabel.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idLabel.setText("Problem ID   :");

        siteLabel.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        siteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        siteLabel.setText("Owner Site :");

        siteComboBox.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        siteComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UVA", "Codeforces", "LightOj", "Codechef" }));

        catagoryLabel.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        catagoryLabel.setText("      Problem Catagory :");

        numberTheoryRadioButton.setText("Number Theory");
        numberTheoryRadioButton.setPreferredSize(new java.awt.Dimension(99, 28));

        dpRadioButton.setText("Dynamic Problem");
        dpRadioButton.setPreferredSize(new java.awt.Dimension(107, 28));
 

        graphRadioButton.setText("Graph Problem");
        graphRadioButton.setPreferredSize(new java.awt.Dimension(95, 28));
 

        stringRadioButton.setText("String Simulation");

        mathRadioButton.setText("Math Problem");
        mathRadioButton.setPreferredSize(new java.awt.Dimension(91, 28));

        algorithmicRadioButton.setText("Special Algorithmic");
        algorithmicRadioButton.setPreferredSize(new java.awt.Dimension(113, 28));

        backButton.setFont(new java.awt.Font("Tempus Sans ITC", 1, 13)); // NOI18N
        backButton.setText("Back");

        closeButton.setFont(new java.awt.Font("Tempus Sans ITC", 3, 13)); // NOI18N
        closeButton.setText("Close");

        doneNotDoneLabel.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        doneNotDoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doneNotDoneLabel.setText("Problem Is :");
        doneNotDoneLabel.setToolTipText("");

        doneRadioButton.setFont(new java.awt.Font("Agency FB", 2, 13)); // NOI18N
        doneRadioButton.setText("Done");

        toBeDoneRadioButton.setFont(new java.awt.Font("Agency FB", 2, 13)); // NOI18N
        toBeDoneRadioButton.setText("To Be Done");

        clearButton.setFont(new java.awt.Font("Tempus Sans ITC", 3, 13)); // NOI18N
        clearButton.setText("Clear");

        jPanel1.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        insertOkButton.setFont(new java.awt.Font("Tempus Sans ITC", 3, 13)); // NOI18N
        insertOkButton.setText("Ok");

        jMenuBar1.setBackground(new java.awt.Color(102, 0, 153));
        jMenuBar1.setForeground(new java.awt.Color(204, 0, 0));

        fileMenu.setBackground(new java.awt.Color(255, 255, 51));
        fileMenu.setForeground(new java.awt.Color(153, 0, 0));
        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        editMenu.setBackground(new java.awt.Color(255, 255, 51));
        editMenu.setForeground(new java.awt.Color(153, 0, 0));
        editMenu.setText("Help");

        aboutMenuItem.setText("About");
        editMenu.add(aboutMenuItem);

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(siteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(siteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(doneNotDoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(doneRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(toBeDoneRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(insertOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(catagoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(stringRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dpRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numberTheoryRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(graphRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(mathRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(algorithmicRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberTheoryRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catagoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addComponent(graphRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doneNotDoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doneRadioButton)
                            .addComponent(toBeDoneRadioButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(stringRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(mathRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(algorithmicRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JRadioButton algorithmicRadioButton;
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel catagoryLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel doneNotDoneLabel;
    private javax.swing.JRadioButton doneRadioButton;
    private javax.swing.JRadioButton dpRadioButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JRadioButton graphRadioButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JButton insertOkButton;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton mathRadioButton;
    private javax.swing.JRadioButton numberTheoryRadioButton;
    private javax.swing.JComboBox<String> siteComboBox;
    private javax.swing.JLabel siteLabel;
    private javax.swing.JRadioButton stringRadioButton;
    private javax.swing.JRadioButton toBeDoneRadioButton;
    // End of variables declaration//GEN-END:variables

}
