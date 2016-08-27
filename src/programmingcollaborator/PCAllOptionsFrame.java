package programmingcollaborator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
public class PCAllOptionsFrame extends javax.swing.JFrame implements ActionListener {

    public PCAllOptionsFrame() {

        initComponents();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Programming Collaborator");
        setLocationRelativeTo(null);
        insertButton.addActionListener(this);
        searchButton.addActionListener(this);
        eraseUpdateButton.addActionListener(this);
        toDoListButton.addActionListener(this);
        catagorizedListButton.addActionListener(this);
        statisticsButton.addActionListener(this);
        exitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);
        closeButton.addActionListener(this);
        uvaHomeButton.addActionListener(this);
        codechefHomeButton.addActionListener(this);
        codeforcesHomeButton.addActionListener(this);
        lightOjHomeButtonButton.addActionListener(this);
        passChangeMenuItem.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == insertButton) {
            InsertionFrame insertFrameObj = new InsertionFrame();
        }
        if (e.getSource() == searchButton) {

            FileHandler.problemIdInString = searchIdTextField.getText();
            searchIdTextField.setText("");
            SearchResultServer searchResultserverObj = new SearchResultServer();
        }
        if (e.getSource() == statisticsButton) {
            StatisticsViewer myStatistics = new StatisticsViewer();
        }
        if (e.getSource() == toDoListButton) {

            ToDoListFrame toDoListFrameObj = new ToDoListFrame();
        }
        if (e.getSource() == catagorizedListButton) {

            CatagoryFrame catagoryFrameObj = new CatagoryFrame();
        }
        if (e.getSource() == eraseUpdateButton) {

            EraseAndUpdate eraseAndUpdate = new EraseAndUpdate();
        }
        if (e.getSource() == exitMenuItem) {
            System.exit(0);
        }
        if (e.getSource() == aboutMenuItem) {
            AboutJFrame aboutFrameObj = new AboutJFrame();
        }
        if (e.getSource() == closeButton) {
            setVisible(false);
        }
        if (e.getSource() == uvaHomeButton) {
            HomePageMaintain.goToWantedSiteHomePage("https://uva.onlinejudge.org/");
        }
        if (e.getSource() == codeforcesHomeButton) {
            HomePageMaintain.goToWantedSiteHomePage("http://codeforces.com/");
        }
        if (e.getSource() == lightOjHomeButtonButton) {
            HomePageMaintain.goToWantedSiteHomePage("http://www.lightoj.com/");
        }
        if (e.getSource() == codechefHomeButton) {
            HomePageMaintain.goToWantedSiteHomePage("https://www.codechef.com/");
        }
        if (e.getSource() == passChangeMenuItem) {
            FileHandler.jOptionPane = new JOptionPane("Sorry ProgC Is Not Able To Help You By This\nThis Function Is Still In Process \n\n But You Will get Pass with any 6 Length Of String", JOptionPane.WARNING_MESSAGE);
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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        insertButton = new javax.swing.JButton();
        toDoListButton = new javax.swing.JButton();
        catagorizedListButton = new javax.swing.JButton();
        eraseUpdateButton = new javax.swing.JButton();
        codeforcesHomeButton = new javax.swing.JButton();
        uvaHomeButton = new javax.swing.JButton();
        codechefHomeButton = new javax.swing.JButton();
        lightOjHomeButtonButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchIdTextField = new javax.swing.JTextField();
        closeButton = new javax.swing.JButton();
        statisticsButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        allOptionsMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        passChangeMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        insertButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 16)); // NOI18N
        insertButton.setText("Insert New Problem");
        insertButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        insertButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        toDoListButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 16)); // NOI18N
        toDoListButton.setText("Full To Do List");
        toDoListButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toDoListButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        toDoListButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        catagorizedListButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 16)); // NOI18N
        catagorizedListButton.setText("Catagorized To Do List");
        catagorizedListButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        eraseUpdateButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 16)); // NOI18N
        eraseUpdateButton.setText("Erase & Update");
        eraseUpdateButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        codeforcesHomeButton.setBackground(new java.awt.Color(204, 255, 102));
        codeforcesHomeButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        codeforcesHomeButton.setText("Codeforces Home Page");

        uvaHomeButton.setBackground(new java.awt.Color(0, 204, 51));
        uvaHomeButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        uvaHomeButton.setText("UVA Home Page ");


        codechefHomeButton.setBackground(new java.awt.Color(255, 153, 153));
        codechefHomeButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        codechefHomeButton.setText("CodeChef Home Page");

        lightOjHomeButtonButton.setBackground(new java.awt.Color(0, 204, 153));
        lightOjHomeButtonButton.setFont(new java.awt.Font("SimSun-ExtB", 1, 14)); // NOI18N
        lightOjHomeButtonButton.setText("LightOj Home Page");

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("           ProgC  Is  Fully  Fortunate  With  You");

        closeButton.setBackground(new java.awt.Color(51, 0, 0));
        closeButton.setFont(new java.awt.Font("Showcard Gothic", 1, 12)); // NOI18N
        closeButton.setForeground(new java.awt.Color(204, 204, 204));
        closeButton.setText("Close");
       

        statisticsButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 16)); // NOI18N
        statisticsButton.setText("My Statistics");
        statisticsButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jPanel4.setBackground(new java.awt.Color(51, 0, 0));

        jLabel2.setBackground(new java.awt.Color(51, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Problem Id :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 0, 0));

        searchButton.setBackground(new java.awt.Color(51, 0, 0));
        searchButton.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 17)); // NOI18N
        searchButton.setForeground(new java.awt.Color(204, 204, 204));
        searchButton.setText("Search");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(searchIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(catagorizedListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(toDoListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(eraseUpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                                    .addComponent(statisticsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))))
                                        .addGap(200, 200, 200))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(closeButton)
                                        .addGap(89, 89, 89)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(codeforcesHomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lightOjHomeButtonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(codechefHomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(uvaHomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(uvaHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(131, 131, 131)))
                        .addComponent(codeforcesHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lightOjHomeButtonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codechefHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(toDoListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(catagorizedListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(eraseUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(statisticsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        allOptionsMenuBar.setBackground(new java.awt.Color(255, 102, 0));
        allOptionsMenuBar.setForeground(new java.awt.Color(102, 0, 0));

        fileMenu.setBackground(new java.awt.Color(153, 0, 0));
        fileMenu.setForeground(new java.awt.Color(255, 255, 255));
        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        fileMenu.add(exitMenuItem);

        passChangeMenuItem.setText("Change Password");
        fileMenu.add(passChangeMenuItem);

        allOptionsMenuBar.add(fileMenu);

        helpMenu.setBackground(new java.awt.Color(153, 0, 0));
        helpMenu.setForeground(new java.awt.Color(255, 255, 255));
        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        allOptionsMenuBar.add(helpMenu);

        setJMenuBar(allOptionsMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuBar allOptionsMenuBar;
    private javax.swing.JButton catagorizedListButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton codechefHomeButton;
    private javax.swing.JButton codeforcesHomeButton;
    private javax.swing.JButton eraseUpdateButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton insertButton;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton lightOjHomeButtonButton;
    private javax.swing.JMenuItem passChangeMenuItem;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchIdTextField;
    private javax.swing.JButton statisticsButton;
    private javax.swing.JButton toDoListButton;
    private javax.swing.JButton uvaHomeButton;
    // End of variables declaration//GEN-END:variables

}
