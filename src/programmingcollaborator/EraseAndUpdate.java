package programmingcollaborator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * 
 * Programming Collaborator | Useful Tool For Programmers
 *
 * @author Abdullah-Al Masum Khan, ID: 150103020010
 * @author Md. Abu Salek, ID: 150103020012
 * @author Md. Abu Naser, ID: 150103020009
 * @author Md Mahadi Hasan Nahid, nahid@neub.edu.bd
 */
public class EraseAndUpdate extends javax.swing.JFrame implements ActionListener {

    String traversedId, traversedStatusSign, traversedCatagory;

    String copyOfList = "";

    public EraseAndUpdate() {

        initComponents();
        setVisible(true);
        setTitle("Erase And Update --> ProgC");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);

        fullEraserButton.addActionListener(this);
        backButton.addActionListener(this);
        updateButton.addActionListener(this);
        closeButton.addActionListener(this);
        singleProblemEraserButton.addActionListener(this);
        selectedSiteEraserButton.addActionListener(this);
        exitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);
        buttonGroup1.add(uvaRadioButton);
        buttonGroup1.add(lightOjRadioButton);
        buttonGroup1.add(codechefRadioButton);
        buttonGroup1.add(codeforcesRadioButton);
        updateSiteComboBox.addActionListener(this);
        clearButton.addActionListener(this);
        updateSiteComboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fullEraserButton) {
            getConfirmationAndErase();
        }
        if (e.getSource() == singleProblemEraserButton) {
            try {
                eraseSingleProblem();
            } catch (IOException ex) {
                FileHandler.jOptionPane.showMessageDialog(null, "ProgC Is In Trouble", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == selectedSiteEraserButton) {
            try {
                eraseSelectedSiteRelatedAll();
            } catch (FileNotFoundException ex) {
                FileHandler.jOptionPane.showMessageDialog(null, "ProgC Getting Trouble To Handle", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == updateButton) {

            try {
                menageUpdate();
            } catch (IOException ex) {
                FileHandler.jOptionPane.showMessageDialog(null, ".Error !!!");
            }
        }
        if (e.getSource() == backButton) {
            setVisible(false);
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
        if (e.getSource() == clearButton) {

        }
    }

    public void eraseSelectedSiteRelatedAll() throws FileNotFoundException {

        if (buttonGroup1.getSelection() == null) {
            FileHandler.jOptionPane = new JOptionPane("You Forgotten To Select A Site..", JOptionPane.WARNING_MESSAGE);
            final JDialog dialog = FileHandler.jOptionPane.createDialog("");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.setVisible(false);
                }
            }).start();
            dialog.setVisible(true);
        }
        if (buttonGroup1.getSelection() != null) {
            if (uvaRadioButton.isSelected()) {
                FileHandler.fileOutputStreamUva = new FileOutputStream(FileHandler.pathOfUVAFile);
            }
            if (codeforcesRadioButton.isSelected()) {
                FileHandler.fileOutputStreamCodeforces = new FileOutputStream(FileHandler.pathOfCodeforceFile);
            }
            if (lightOjRadioButton.isSelected()) {
                FileHandler.fileOutputStreamLightOj = new FileOutputStream(FileHandler.pathOfLightOjFile);
            }
            if (codechefRadioButton.isSelected()) {
                FileHandler.fileOutputStreamCodechef = new FileOutputStream(FileHandler.pathOfCodeChefFile);
            }
            buttonGroup1.clearSelection();
            FileHandler.jOptionPane = new JOptionPane("EveryThing Related To This Site are just Erased", JOptionPane.PLAIN_MESSAGE);

        }
    }

    public void eraseSingleProblem() throws IOException {

        FileHandler.problemIdInString = toErasedIdTextField.getText();
        Scanner scanner = null;
        BufferedWriter bufferedWriter = null;
        String toErasedProblemPath = null;
        copyOfList = "";
        FileHandler.makeFileToWrite();

        if (uvaRadioButton.isSelected()) {
            scanner = FileHandler.scannerObjOfUvaFile;
            bufferedWriter = FileHandler.bufferedWriterOfUva;
            toErasedProblemPath = FileHandler.pathOfUVAFile;
        }
        if (codeforcesRadioButton.isSelected()) {
            scanner = FileHandler.scannerObjOfCodeForceFile;
            bufferedWriter = FileHandler.bufferedWriterOfCodeforces;
            toErasedProblemPath = FileHandler.pathOfCodeforceFile;
        }
        if (lightOjRadioButton.isSelected()) {
            scanner = FileHandler.scannerObjOfLightOjFile;
            bufferedWriter = FileHandler.bufferedWriterOfLightOj;
            toErasedProblemPath = FileHandler.pathOfLightOjFile;
        }
        if (codechefRadioButton.isSelected()) {
            scanner = FileHandler.scannerObjOfCodechefFile;
            bufferedWriter = FileHandler.bufferedWriterOfCodechef;
            toErasedProblemPath = FileHandler.pathOfCodeChefFile;
        }
        if (buttonGroup1.getSelection() == null || (toErasedIdTextField.getText().equals(""))) {
            FileHandler.jOptionPane = new JOptionPane("Please , Complete The Required Fields", JOptionPane.WARNING_MESSAGE);
            final JDialog dialog = FileHandler.jOptionPane.createDialog("");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.setVisible(false);
                }
            }).start();
            dialog.setVisible(true);
        }
        if ((buttonGroup1.getSelection() != null) && (!toErasedIdTextField.getText().equals(""))) {
            while (scanner.hasNextLine()) {
                Scanner scn = new Scanner(scanner.nextLine());
                while (scn.hasNext()) {
                    traversedId = scn.next();
                    if (traversedId.equals(FileHandler.problemIdInString)) {
                        break;
                    }
                    traversedStatusSign = scn.next();
                    traversedCatagory = scn.next();
                    copyOfList = copyOfList + traversedId + " " + traversedStatusSign + " " + traversedCatagory + "\r\n";
                }
            }
            FileOutputStream fileOutStream = new FileOutputStream(toErasedProblemPath);
            bufferedWriter.write(copyOfList);
            bufferedWriter.close();
        }
        toErasedIdTextField.setText(null);
        buttonGroup1.clearSelection();
    }

    public void getConfirmationAndErase() {

        int response = JOptionPane.showConfirmDialog(null, "Are You Confirmed To Erase Everything ?", "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            eraseAllData();

        } else if (response == JOptionPane.NO_OPTION) {

            FileHandler.jOptionPane = new JOptionPane("Nothing Erased By Your Action: ", JOptionPane.INFORMATION_MESSAGE);
            final JDialog dialog = FileHandler.jOptionPane.createDialog("");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.setVisible(false);
                }
            }).start();
            dialog.setVisible(true);

        } else if (response == JOptionPane.CLOSED_OPTION) {
            setVisible(false);
        }

    }

    public void eraseAllData() {

        PrintWriter printWriter_Uva = null;
        try {
            printWriter_Uva = new PrintWriter(FileHandler.pathOfUVAFile);
            PrintWriter printWriter_Cf = new PrintWriter(FileHandler.pathOfCodeforceFile);
            PrintWriter printWriter_Lo = new PrintWriter(FileHandler.pathOfLightOjFile);
            PrintWriter printWriter_Cc = new PrintWriter(FileHandler.pathOfCodeChefFile);
            printWriter_Uva.close();
            printWriter_Cf.close();
            printWriter_Lo.close();
            printWriter_Cc.close();
            FileHandler.jOptionPane = new JOptionPane("Every Thing Erased \nNo Collaboration With Erased Data \nAnd You Have To Start Newly", JOptionPane.WARNING_MESSAGE);
            final JDialog dialog = FileHandler.jOptionPane.createDialog("");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.setVisible(false);
                }
            }).start();
            dialog.setVisible(true);
        } catch (FileNotFoundException ex) {
            FileHandler.jOptionPane.showMessageDialog(null, "Programming Collaborator Is In Trouble By It ");
        }

    }

    public void menageUpdate() throws IOException {

        FileHandler.problemIdInString = updateTextField.getText();
        int selectedSite = updateSiteComboBox.getSelectedIndex();
        if (updateSiteComboBox.getSelectedItem() == null || (updateTextField.getText().equals(""))) {

            FileHandler.jOptionPane = new JOptionPane("Please , Complete The Required Fields", JOptionPane.WARNING_MESSAGE);
            final JDialog dialog = FileHandler.jOptionPane.createDialog("");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.setVisible(false);
                }
            }).start();
            dialog.setVisible(true);
            updateTextField.setText("");
            updateSiteComboBox.setSelectedIndex(0);
        }

        if (selectedSite == 0) {
            updateProblemToDone(FileHandler.scannerObjOfUvaFile, FileHandler.bufferedWriterOfUva, FileHandler.pathOfUVAFile);
        }
        if (selectedSite == 1) {
            updateProblemToDone(FileHandler.scannerObjOfCodeForceFile, FileHandler.bufferedWriterOfCodeforces, FileHandler.pathOfCodeforceFile);
        }
        if (selectedSite == 2) {
            updateProblemToDone(FileHandler.scannerObjOfLightOjFile, FileHandler.bufferedWriterOfLightOj, FileHandler.pathOfLightOjFile);
        }
        if (selectedSite == 3) {
            updateProblemToDone(FileHandler.scannerObjOfCodechefFile, FileHandler.bufferedWriterOfCodechef, FileHandler.pathOfCodeChefFile);
        }

    }

    public void updateProblemToDone(Scanner scannerObjOfSpecificSite, BufferedWriter bufferedWriter, String pathOfToUpdateSite) throws IOException {

        String toUpdatedId = null, toUpdatedStatus = null, toUpdatedProblemsCatagory = null;
        boolean existForUpdate = false;
        copyOfList = "";
        try {
            FileHandler.makeFileToWrite();
        } catch (IOException ex) {
            FileHandler.jOptionPane.showMessageDialog(null, "Programming Collaborator Is In Trouble By Itself...... ");
        }

        while (scannerObjOfSpecificSite.hasNextLine()) {
            Scanner scanner = new Scanner(scannerObjOfSpecificSite.nextLine());
            while (scanner.hasNext()) {
                traversedId = scanner.next();
                traversedStatusSign = scanner.next(); // statusSign means it is done or not done 
                traversedCatagory = scanner.next();
                if (traversedId.equals(FileHandler.problemIdInString)) {
                    toUpdatedId = traversedId;
                    toUpdatedStatus = traversedStatusSign;
                    toUpdatedProblemsCatagory = traversedCatagory;
                    existForUpdate = true;

                } else {
                    copyOfList = copyOfList + traversedId + " " + traversedStatusSign + " " + traversedCatagory + " \r\n";
                }
            }
        }
        if (existForUpdate == false) {
            FileHandler.jOptionPane = new JOptionPane("No Problem Exist With This Id By The Site", JOptionPane.WARNING_MESSAGE);
            final JDialog dialog = FileHandler.jOptionPane.createDialog("");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dialog.setVisible(false);
                }
            }).start();
            dialog.setVisible(true);
        } else if (toUpdatedStatus.equals("1")) {
            copyOfList = copyOfList + toUpdatedId + " " + 0 + " " + toUpdatedProblemsCatagory + " \r\n";
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(pathOfToUpdateSite);
            } catch (FileNotFoundException ex) {
                FileHandler.jOptionPane.showMessageDialog(null, "Programming Collaborator Faild To Found File For Saving Information");
            }

            bufferedWriter.write(copyOfList);
            bufferedWriter.close();
        } else if (toUpdatedStatus == "0") {
            FileHandler.jOptionPane.showMessageDialog(null, "It's Already Done By Your Saved Information");
        }
        updateSiteComboBox.setSelectedIndex(0);
        updateTextField.setText(null);

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        updateLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        uvaRadioButton = new javax.swing.JRadioButton();
        codeforcesRadioButton = new javax.swing.JRadioButton();
        lightOjRadioButton = new javax.swing.JRadioButton();
        codechefRadioButton = new javax.swing.JRadioButton();
        updateTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        updateSelectLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        updateSiteComboBox = new javax.swing.JComboBox<>();
        eraseSeletingLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        toErasedIdTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        selectedSiteEraserButton = new javax.swing.JButton();
        fullEraserButton = new javax.swing.JButton();
        singleProblemEraserButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        eraseMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        updateButton.setBackground(new java.awt.Color(153, 0, 0));
        updateButton.setFont(new java.awt.Font("Showcard Gothic", 1, 13)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 153));
        updateButton.setText("Update");

        updateLabel.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        updateLabel.setText("Problem Id:");
        updateLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        updateLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        backButton.setBackground(new java.awt.Color(51, 0, 0));
        backButton.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(153, 255, 153));
        backButton.setText("Back");

        closeButton.setBackground(new java.awt.Color(51, 0, 0));
        closeButton.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        closeButton.setForeground(new java.awt.Color(153, 255, 153));
        closeButton.setText("Close");

        uvaRadioButton.setBackground(new java.awt.Color(0, 255, 51));
        uvaRadioButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        uvaRadioButton.setText("UVA");

        codeforcesRadioButton.setBackground(new java.awt.Color(255, 102, 102));
        codeforcesRadioButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        codeforcesRadioButton.setText("Codeforces");
        codeforcesRadioButton.setPreferredSize(new java.awt.Dimension(95, 25));

        lightOjRadioButton.setBackground(new java.awt.Color(0, 102, 102));
        lightOjRadioButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        lightOjRadioButton.setText("LightOj");
        lightOjRadioButton.setPreferredSize(new java.awt.Dimension(75, 25));
        lightOjRadioButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        

        codechefRadioButton.setBackground(new java.awt.Color(102, 102, 0));
        codechefRadioButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        codechefRadioButton.setText("Codechef");
        codechefRadioButton.setPreferredSize(new java.awt.Dimension(81, 25));
        codechefRadioButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        updateTextField.setBackground(new java.awt.Color(153, 255, 153));
        updateTextField.setFont(new java.awt.Font("Baskerville Old Face", 1, 13)); // NOI18N
        updateTextField.setForeground(new java.awt.Color(153, 0, 0));

        jLabel2.setFont(new java.awt.Font("Andalus", 1, 12)); // NOI18N
        jLabel2.setText("To Update A Problem From \" To Be Done \"   To   \" Done \"  Please Select A Site , Enter Id Then Click On --> Update");

        updateSelectLabel.setFont(new java.awt.Font("Showcard Gothic", 1, 11)); // NOI18N
        updateSelectLabel.setText("Select A Site :");

        jLabel4.setText("--------------------");

        updateSiteComboBox.setBackground(new java.awt.Color(153, 255, 153));
        updateSiteComboBox.setFont(new java.awt.Font("Andalus", 3, 14)); // NOI18N
        updateSiteComboBox.setForeground(new java.awt.Color(153, 0, 0));
        updateSiteComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UVA", "CodeForces", "LightOj", "CodeChef" }));

        eraseSeletingLabel.setFont(new java.awt.Font("Showcard Gothic", 1, 11)); // NOI18N
        eraseSeletingLabel.setText("Select A Site ");
        eraseSeletingLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setText("Problem Id:");
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        toErasedIdTextField.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toErasedIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toErasedIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 102, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        selectedSiteEraserButton.setBackground(new java.awt.Color(153, 0, 0));
        selectedSiteEraserButton.setFont(new java.awt.Font("Showcard Gothic", 1, 13)); // NOI18N
        selectedSiteEraserButton.setForeground(new java.awt.Color(255, 255, 153));
        selectedSiteEraserButton.setText("Erase Selected Site's All Information");

        fullEraserButton.setBackground(new java.awt.Color(153, 0, 0));
        fullEraserButton.setFont(new java.awt.Font("Showcard Gothic", 1, 13)); // NOI18N
        fullEraserButton.setForeground(new java.awt.Color(255, 255, 153));
        fullEraserButton.setText("Erase All Saved Information");

        singleProblemEraserButton.setBackground(new java.awt.Color(153, 0, 0));
        singleProblemEraserButton.setFont(new java.awt.Font("Showcard Gothic", 1, 13)); // NOI18N
        singleProblemEraserButton.setForeground(new java.awt.Color(255, 255, 153));
        singleProblemEraserButton.setText("Erase A Single Problem");

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel7.setText("  You Can Just Delete A Specific Problem From A Specific Site .");

        jLabel9.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel9.setText("  You Can Just Delete All Information Related Your Selected Site");

        jLabel10.setFont(new java.awt.Font("Sylfaen", 0, 11)); // NOI18N
        jLabel10.setText("  You Will Lose Your All Saved Data");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectedSiteEraserButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(singleProblemEraserButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fullEraserButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(singleProblemEraserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGap(8, 8, 8)
                .addComponent(selectedSiteEraserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(8, 8, 8)
                .addComponent(fullEraserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addGap(8, 8, 8))
        );

        clearButton.setBackground(new java.awt.Color(51, 0, 0));
        clearButton.setFont(new java.awt.Font("Castellar", 1, 13)); // NOI18N
        clearButton.setForeground(new java.awt.Color(153, 255, 153));
        clearButton.setText("Clear");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(updateSiteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateSelectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(updateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(eraseSeletingLabel)
                                .addGap(290, 290, 290)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codeforcesRadioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lightOjRadioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uvaRadioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codechefRadioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(updateSelectLabel)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateSiteComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(updateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(eraseSeletingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(uvaRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(codeforcesRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lightOjRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(codechefRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        eraseMenuBar.setBackground(new java.awt.Color(204, 102, 0));
        eraseMenuBar.setForeground(new java.awt.Color(0, 51, 153));

        fileMenu.setBackground(new java.awt.Color(153, 0, 0));
        fileMenu.setForeground(new java.awt.Color(255, 255, 204));
        fileMenu.setText("File");

        exitMenuItem.setBackground(new java.awt.Color(153, 0, 0));
        exitMenuItem.setForeground(new java.awt.Color(255, 255, 204));
        exitMenuItem.setText("Exit");
        fileMenu.add(exitMenuItem);

        eraseMenuBar.add(fileMenu);

        helpMenu.setBackground(new java.awt.Color(153, 0, 0));
        helpMenu.setForeground(new java.awt.Color(255, 255, 204));
        helpMenu.setText("Help");

        aboutMenuItem.setBackground(new java.awt.Color(153, 0, 0));
        aboutMenuItem.setForeground(new java.awt.Color(255, 255, 204));
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        eraseMenuBar.add(helpMenu);

        setJMenuBar(eraseMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem aboutMenuItem;
    public javax.swing.JButton backButton;
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JButton clearButton;
    public javax.swing.JButton closeButton;
    public javax.swing.JRadioButton codechefRadioButton;
    public javax.swing.JRadioButton codeforcesRadioButton;
    public javax.swing.JMenuBar eraseMenuBar;
    public javax.swing.JLabel eraseSeletingLabel;
    public javax.swing.JMenuItem exitMenuItem;
    public javax.swing.JMenu fileMenu;
    public javax.swing.JButton fullEraserButton;
    public javax.swing.JMenu helpMenu;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JRadioButton lightOjRadioButton;
    public javax.swing.JButton selectedSiteEraserButton;
    public javax.swing.JButton singleProblemEraserButton;
    public javax.swing.JTextField toErasedIdTextField;
    public javax.swing.JButton updateButton;
    public javax.swing.JLabel updateLabel;
    public javax.swing.JLabel updateSelectLabel;
    public javax.swing.JComboBox<String> updateSiteComboBox;
    public javax.swing.JTextField updateTextField;
    public javax.swing.JRadioButton uvaRadioButton;
    // End of variables declaration//GEN-END:variables

}
