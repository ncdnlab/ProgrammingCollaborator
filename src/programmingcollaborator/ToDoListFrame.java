package programmingcollaborator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * Programming Collaborator | Useful Tool For Programmers
 *
 * @author Abdullah-Al Masum Khan, ID: 150103020010
 * @author Md. Abu Salek, ID: 150103020012
 * @author Md. Abu Naser, ID: 150103020009
 * @author Md Mahadi Hasan Nahid, nahid@neub.edu.bd
 */
public class ToDoListFrame extends javax.swing.JFrame implements ActionListener {

    static String fullToDoListString, notDoneSign;

    public ToDoListFrame() {

        initComponents();
        setVisible(true);
        setTitle("To Do Listed Problems");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(1);
        toDoCloseButton.addActionListener(this);
        toDoBackButton.addActionListener(this);
        aboutMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        searchButton.addActionListener(this);
        searchIdTextField.addActionListener(this);
        fullToDoListString = setCompleteToDoList();
        toDoListArea.setText(fullToDoListString);
        toDoListArea.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toDoBackButton) {
            setVisible(false);
        }
        if (e.getSource() == toDoCloseButton) {
            setVisible(false);
        }
        if (e.getSource() == exitMenuItem) {
            setVisible(false);
        }
        if (e.getSource() == aboutMenuItem) {
            AboutJFrame aboutJFrame = new AboutJFrame();
        }
        if (e.getSource() == searchButton) {

            FileHandler.problemIdInString = searchIdTextField.getText();
            searchIdTextField.setText("");
            SearchResultServer searchResultServer = new SearchResultServer();
        }
    }

    public String setCompleteToDoList() {

        notDoneSign = "1";
        fullToDoListString = " ID      Owner Site\n\n";
        try {
            FileHandler.makeFileToWrite();
        } catch (IOException ex) {
            FileHandler.jOptionPane.showMessageDialog(null, "Sorry , ProgC Is In Trouble To Fill Up Your Wants ", " Error ", JOptionPane.ERROR_MESSAGE);
        }
        generateListFromUva();
        generateListFromCodeforces();
        generateListFromLightOj();
        generateListFromCodechef();
        return fullToDoListString;

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        toDoListArea = new javax.swing.JTextArea();
        toDoListLabel = new javax.swing.JLabel();
        toDoCloseButton = new javax.swing.JButton();
        toDoBackButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        searchIdTextField = new javax.swing.JTextField();
        problemIdLabel = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toDoListArea.setColumns(20);
        toDoListArea.setFont(new java.awt.Font("Monotype Corsiva", 3, 14)); // NOI18N
        toDoListArea.setRows(5);
        jScrollPane1.setViewportView(toDoListArea);

        toDoListLabel.setFont(new java.awt.Font("Algerian", 3, 18)); // NOI18N
        toDoListLabel.setText("To Do Listed Problems:");

        toDoCloseButton.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        toDoCloseButton.setText("Close");

        toDoBackButton.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        toDoBackButton.setText("Back");

        searchButton.setFont(new java.awt.Font("Arabic Typesetting", 1, 19)); // NOI18N
        searchButton.setText("Search");

        problemIdLabel.setFont(new java.awt.Font("Arabic Typesetting", 1, 18)); // NOI18N
        problemIdLabel.setText("Problem Id:");
        problemIdLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toDoListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(searchIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(toDoBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(toDoCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(problemIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(toDoListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(problemIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(toDoCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toDoBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel problemIdLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchIdTextField;
    private javax.swing.JButton toDoBackButton;
    private javax.swing.JButton toDoCloseButton;
    private javax.swing.JTextArea toDoListArea;
    private javax.swing.JLabel toDoListLabel;
    // End of variables declaration//GEN-END:variables

    public void generateListFromUva() {

        while (FileHandler.scannerObjOfUvaFile.hasNextLine()) {
            Scanner scanner = new Scanner(FileHandler.scannerObjOfUvaFile.nextLine());
            while (scanner.hasNext()) {

                String problemId = scanner.next();
                String sign = scanner.next();
                if (sign.equals(notDoneSign)) {
                    fullToDoListString = fullToDoListString + " " + problemId + "\tUVA\n";
                }
                break;
            }
        }
    }

    public void generateListFromCodeforces() {
        while (FileHandler.scannerObjOfCodeForceFile.hasNextLine()) {
            Scanner scanner = new Scanner(FileHandler.scannerObjOfCodeForceFile.nextLine());
            while (scanner.hasNext()) {

                String problemId = scanner.next();
                String sign = scanner.next();
                if (sign.equals(notDoneSign)) {
                    fullToDoListString = fullToDoListString + " " + problemId + "\tCodeForces\n";
                }
                break;
            }
        }
    }

    public void generateListFromLightOj() {

        while (FileHandler.scannerObjOfLightOjFile.hasNextLine()) {
            Scanner scanner = new Scanner(FileHandler.scannerObjOfLightOjFile.nextLine());
            while (scanner.hasNext()) {

                String problemId = scanner.next();
                String sign = scanner.next();
                if (sign.equals(notDoneSign)) {
                    fullToDoListString = fullToDoListString + " " + problemId + "\tLightOj\n";
                }
                break;
            }
        }
    }

    public void generateListFromCodechef() {

        while (FileHandler.scannerObjOfCodechefFile.hasNextLine()) {
            Scanner scanner = new Scanner(FileHandler.scannerObjOfCodechefFile.nextLine());
            while (scanner.hasNext()) {

                String problemId = scanner.next();
                String sign = scanner.next();
                if (sign.equals(notDoneSign)) {
                    fullToDoListString = fullToDoListString + " " + problemId + "\tCodeChef\n";
                }
                break;
            }
        }
    }

}
