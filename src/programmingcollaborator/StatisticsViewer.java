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
public class StatisticsViewer extends javax.swing.JFrame implements ActionListener {

    int toDo, done, uvaDone, codeForcesDone, codeChefDone, lightOjDone, uvaToDo,
            codeForcesToDo, codeChefToDo, lightOjToDo;
    String gotStatistics;

    public StatisticsViewer() {

        initComponents();
        setVisible(true);
        setTitle(" My Statistics --> ProgC");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        closeButton.addActionListener(this);
        exitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);
        myStatisticsTextArea.setVisible(true);
        try {

            getSiteBasedStatistics();

        } catch (IOException ex) {
            FileHandler.jOptionPane.showMessageDialog(null, "ProgC is In Trouble By Itself", "ProgC", FileHandler.jOptionPane.ERROR);
        }

        myStatisticsTextArea.setVisible(true);
    }

    public void actionPerformed(ActionEvent eve) {
        if (eve.getSource() == closeButton) {
            setVisible(false);
        }
        if (eve.getSource() == exitMenuItem) {
            setVisible(false);
        }
        if (eve.getSource() == aboutMenuItem) {
            AboutJFrame aboutFrame = new AboutJFrame();
        }

    }

    public void getSiteBasedStatistics() throws IOException {

        uvaDone = 0;
        codeForcesDone = 0;
        codeChefDone = 0;
        lightOjDone = 0;
        uvaToDo = 0;
        codeForcesToDo = 0;
        codeChefToDo = 0;
        lightOjToDo = 0;

        FileHandler.makeFileToWrite();
        getItForEverySite(FileHandler.scannerObjOfUvaFile);
        uvaToDo = toDo;
        uvaDone = done;
        getItForEverySite(FileHandler.scannerObjOfCodeForceFile);
        codeForcesToDo = toDo;
        codeForcesDone = done;
        getItForEverySite(FileHandler.scannerObjOfLightOjFile);
        lightOjToDo = toDo;
        lightOjDone = done;
        getItForEverySite(FileHandler.scannerObjOfCodechefFile);
        codeChefToDo = toDo;
        codeChefDone = done;
        int totalDone = codeChefDone + lightOjDone + codeForcesDone + uvaDone;
        int totalToDo = uvaToDo + codeForcesToDo + lightOjToDo + codeChefToDo;
        gotStatistics = " Every Measurment Based On Your Total \nListed Problems\n\n Owner Site      Left          Done\n\n UVA" + "                  " + uvaToDo + "                "
                + uvaDone + "\n CodeForces" + "       " + codeForcesToDo + "                " + codeForcesDone
                + "\n LightOj" + "             " + lightOjToDo + "                " + lightOjDone + "\n CodeChef" + "          " + codeChefToDo + "                " + codeChefDone;
        gotStatistics = gotStatistics + "\n\nTotal No: Of To Do Problems:   " + totalToDo;
        gotStatistics = gotStatistics + "\n\nTotal No: Of accepted Problems:   " + totalDone;
        myStatisticsTextArea.setText(gotStatistics);

    }

    public void getItForEverySite(Scanner scn) throws IOException {

        toDo = 0;
        done = 0;

        while (scn.hasNextLine()) {
            Scanner scnObj = new Scanner(scn.nextLine());
            String i = scnObj.next();
            String status = scnObj.next();
            if (status.equals("0")) {
                done++;
            }
            if (status.equals("1")) {
                toDo++;
            }

        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        myStatisticsTextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        closeButton.setBackground(new java.awt.Color(255, 255, 204));
        closeButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 15)); // NOI18N
        closeButton.setForeground(new java.awt.Color(102, 0, 0));
        closeButton.setText("Close");

        myStatisticsTextArea.setColumns(20);
        myStatisticsTextArea.setFont(new java.awt.Font("Andalus", 3, 14)); // NOI18N
        myStatisticsTextArea.setRows(5);
        jScrollPane2.setViewportView(myStatisticsTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 51, 51));

        jMenu1.setBackground(new java.awt.Color(102, 0, 0));
        jMenu1.setForeground(new java.awt.Color(255, 255, 204));
        jMenu1.setText("File");

        exitMenuItem.setText("Exit");
        jMenu1.add(exitMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(102, 0, 0));
        jMenu2.setForeground(new java.awt.Color(255, 255, 204));
        jMenu2.setText("Edit");

        aboutMenuItem.setText("About");
        jMenu2.add(aboutMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem aboutMenuItem;
    public javax.swing.JButton closeButton;
    public javax.swing.JMenuItem exitMenuItem;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea myStatisticsTextArea;
    // End of variables declaration//GEN-END:variables
}
