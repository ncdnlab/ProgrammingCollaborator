package programmingcollaborator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * Programming Collaborator | Useful Tool For Programmers
 *
 * @author Abdullah-Al Masum Khan, ID: 150103020010
 * @author Md. Abu Salek, ID: 150103020012
 * @author Md. Abu Naser, ID: 150103020009
 * @author Md Mahadi Hasan Nahid, nahid@neub.edu.bd
 */
public class CatagoryFrame extends javax.swing.JFrame implements ActionListener {

    String catagorizedToDoList;

    public CatagoryFrame() {

        initComponents();
        setVisible(true);
        setTitle("Catagorized List --> ProgC");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);

        backButton.addActionListener(this);
        closeButton.addActionListener(this);
        exitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);
        numberTheoryButton.addActionListener(this);
        dpButton.addActionListener(this);
        graphButton.addActionListener(this);
        stringButton.addActionListener(this);
        mathButton.addActionListener(this);
        algorithmButton.addActionListener(this);
        //catagorizedToDoListArea.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
        if (e.getSource() == numberTheoryButton) {
            getWantedCatagorizedProblems("1");
            showGeneratedList();
        }
        if (e.getSource() == dpButton) {
            getWantedCatagorizedProblems("2");
            showGeneratedList();
        }
        if (e.getSource() == graphButton) {
            getWantedCatagorizedProblems("3");
            showGeneratedList();
        }
        if (e.getSource() == stringButton) {
            getWantedCatagorizedProblems("4");
            showGeneratedList();
        }
        if (e.getSource() == mathButton) {
            getWantedCatagorizedProblems("5");
            showGeneratedList();
        }
        if (e.getSource() == algorithmButton) {
            getWantedCatagorizedProblems("6");
            showGeneratedList();
        }

    }

    public void getWantedCatagorizedProblems(String wantedCatagorySign) {

        int count = 0;
        String problemId = null, statusSign = null, catagorySign = null;
        catagorizedToDoList = "";

        try {
            FileHandler.makeFileToWrite();
        } catch (IOException ex) {
            FileHandler.jOptionPane.showMessageDialog(null, "Programming Collaborator Is In Trouble By Itself...... ");
        }

        while (FileHandler.scannerObjOfUvaFile.hasNextLine()) {
            Scanner scanner = new Scanner(FileHandler.scannerObjOfUvaFile.nextLine());
            while (scanner.hasNext()) {
                problemId = scanner.next();
                statusSign = scanner.next();
                catagorySign = scanner.next();
                if (statusSign.equals("1") && catagorySign.equals(wantedCatagorySign)) {
                    count++;
                    catagorizedToDoList += "  " + count + ".  " + problemId + "  ----->  " + "UVA\n\n";

                } else {
                    break;
                }
            }
        }

        while (FileHandler.scannerObjOfCodeForceFile.hasNextLine()) {
            Scanner scanner = new Scanner(FileHandler.scannerObjOfCodeForceFile.nextLine());
            while (scanner.hasNext()) {
                problemId = scanner.next();
                statusSign = scanner.next();
                catagorySign = scanner.next();
                if (statusSign.equals("1") && catagorySign.equals(wantedCatagorySign)) {
                    count++;
                    catagorizedToDoList += "  " + count + ".  " + problemId + "  ----->  " + "CodeForces\n\n";

                } else {
                    break;
                }
            }
        }

        while (FileHandler.scannerObjOfLightOjFile.hasNextLine()) {
            Scanner scanner = new Scanner(FileHandler.scannerObjOfLightOjFile.nextLine());
            while (scanner.hasNext()) {
                problemId = scanner.next();
                statusSign = scanner.next();
                catagorySign = scanner.next();
                if (statusSign.equals("1") && catagorySign.equals(wantedCatagorySign)) {
                    count++;
                    catagorizedToDoList += "  " + count + ".  " + problemId + "  ----->  " + "LightOj\n\n";
                } else {
                    break;
                }
            }
        }

        while (FileHandler.scannerObjOfCodechefFile.hasNextLine()) {
            Scanner scanner = new Scanner(FileHandler.scannerObjOfCodechefFile.nextLine());
            while (scanner.hasNext()) {
                problemId = scanner.next();
                statusSign = scanner.next();
                catagorySign = scanner.next();
                if (statusSign.equals("1") && catagorySign.equals(wantedCatagorySign)) {
                    count++;
                    catagorizedToDoList += "  " + count + ".  " + problemId + "  ----->  " + "CodeChef\n\n";
                } else {
                    break;
                }
            }
        }

    }

    private void showGeneratedList() {

        // All Specific Catagorized Problem To Do Are Listed In catagorizedToDoList  And Maiden For Listed Output 
        catagorizedToDoListArea.setText(" Problem Id    Owner Site\n\n" + catagorizedToDoList);
        catagorizedToDoListArea.setVisible(true);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        numberTheoryButton = new javax.swing.JButton();
        dpButton = new javax.swing.JButton();
        graphButton = new javax.swing.JButton();
        stringButton = new javax.swing.JButton();
        mathButton = new javax.swing.JButton();
        algorithmButton = new javax.swing.JButton();
        catagoryInstructionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        catagorizedToDoListArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        closeButton.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        closeButton.setText("Close");

        backButton.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        backButton.setText("Back");

        numberTheoryButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 12)); // NOI18N
        numberTheoryButton.setText("Number Theory Problem");

        dpButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 12)); // NOI18N
        dpButton.setText("Dynamic Theory Problem");

        graphButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 12)); // NOI18N
        graphButton.setText("Graph Problem ");

        stringButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 12)); // NOI18N
        stringButton.setText("String Processing Problem");

        mathButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 12)); // NOI18N
        mathButton.setText("Math Problem");

        algorithmButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 12)); // NOI18N
        algorithmButton.setText("Special Algorithmic Problem");

        catagoryInstructionLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        catagoryInstructionLabel.setText("Please Select A Catagory To See Catagorized To Do List");

        catagorizedToDoListArea.setBackground(new java.awt.Color(204, 255, 204));
        catagorizedToDoListArea.setColumns(20);
        catagorizedToDoListArea.setFont(new java.awt.Font("Nyala", 1, 15)); // NOI18N
        catagorizedToDoListArea.setRows(5);
        jScrollPane1.setViewportView(catagorizedToDoListArea);

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(catagoryInstructionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                        .addGap(131, 131, 131))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(algorithmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numberTheoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(graphButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stringButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mathButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(catagoryInstructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(numberTheoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(graphButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stringButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(algorithmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton algorithmButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea catagorizedToDoListArea;
    private javax.swing.JLabel catagoryInstructionLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton dpButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton graphButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mathButton;
    private javax.swing.JButton numberTheoryButton;
    private javax.swing.JButton stringButton;
    // End of variables declaration//GEN-END:variables
}
