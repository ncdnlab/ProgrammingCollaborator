package programmingcollaborator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
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
class SearchResultServer {

    boolean bool = false, exist = false, exist2 = false, idNull;
    String site = null, doneOrNotDone = null, catagory = null;

    public SearchResultServer() {

        getProblemId();
        if (exist == false && exist2 == false && idNull == false) {
            JOptionPane.showMessageDialog(null, "Problem Not Found");
        }

    }

    public void getProblemId() {

        idNull = false;

        if (FileHandler.problemIdInString.length() == 0) {
            FileHandler.jOptionPane = new JOptionPane("You Did Not Entered Any Id .", JOptionPane.WARNING_MESSAGE);
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
            idNull = true;
        }
        try {
            FileHandler.problemId = Integer.parseInt(FileHandler.problemIdInString);
        } catch (NumberFormatException e) {
            bool = true;
        }

        if (bool == false) {
            try {
                // UVA and LightOj problem id is integer type
                searchFromUva();
            } catch (IOException ex) {
                FileHandler.jOptionPane.showMessageDialog(null, "Programming Collaborator Is In Trouble By Itself...... ");
            }
        }
        if (bool == true) {
            try {
                searchFromCodeForces();     //  Codeforces and CodeChef has String type problem id
                searchFromCodeChef();
            } catch (IOException ex) {
                FileHandler.jOptionPane.showMessageDialog(null, "Programming Collaborator Is In Trouble By Itself...... ");
            }
        }

    }

    public void searchFromUva() throws IOException {

        int traverseCounter = 0, problemIdTraverser = 1, statusCounter = 0, catagoryCounter = 0, numberSign;
        exist = false;
        FileHandler.makeFileToWrite();
        while (FileHandler.scannerObjOfUvaFile.hasNextInt()) {

            traverseCounter++;
            numberSign = FileHandler.scannerObjOfUvaFile.nextInt();

            if (traverseCounter == problemIdTraverser && exist == false) {
                if (FileHandler.problemId == numberSign) {

                    exist = true;
                    site = "UVA";
                    statusCounter += traverseCounter + 1;
                    catagoryCounter += statusCounter + 1;
                }
                problemIdTraverser += 3;
            }
            if (traverseCounter == statusCounter) //  if problem exist then only have chance to fullill this condition
            {
                if (numberSign == 1) {
                    doneOrNotDone = "Still To Be Done";
                }
                if (numberSign == 0) {
                    doneOrNotDone = "Done";
                }
            }
            if (traverseCounter == catagoryCounter) //  if problem exist then only have chance to fullill this condition
            {
                catagory = setCatagoryOfSearchedProblem(numberSign);
                break;
            }

        }
        if (exist == true) {
            FileHandler.jOptionPane.showMessageDialog(null, "Owner Site :  " + site + "\nStatus :  " + doneOrNotDone + "\nCatagory :  " + catagory, "Search Result", 0);
        }
        searchFromLightOj();
    }

    public String setCatagoryOfSearchedProblem(int numberSign) {

        if (numberSign == 1) {
            catagory = "Number Theory  Problem";
        }
        if (numberSign == 2) {
            catagory = "Dynamic Problem";
        }
        if (numberSign == 3) {
            catagory = "Graph Problem";
        }
        if (numberSign == 4) {
            catagory = "String Problem";
        }
        if (numberSign == 5) {
            catagory = "Simulation Problem";
        }
        if (numberSign == 6) {
            catagory = "Special Algorithmic Problem";
        }
        return catagory;

    }

    public void searchFromLightOj() throws IOException {

        boolean exist2 = false;

        int traverseCounter = 0, problemIdTraverser = 1, statusCounter = 0, catagoryCounter = 0, numberSign;
        FileHandler.makeFileToWrite();

        while (FileHandler.scannerObjOfLightOjFile.hasNextInt()) {

            traverseCounter++;
            numberSign = FileHandler.scannerObjOfLightOjFile.nextInt();

            if (traverseCounter == problemIdTraverser && exist2 == false) {
                if (FileHandler.problemId == numberSign) {

                    exist2 = true;
                    site = "LightOj";
                    statusCounter += traverseCounter + 1;
                    catagoryCounter += statusCounter + 1;
                }
                problemIdTraverser += 3;
            }
            if (traverseCounter == statusCounter) //  if problem exist then only have chance to fullill this condition
            {
                if (numberSign == 1) {
                    doneOrNotDone = "Still To Be Done";
                }
                if (numberSign == 0) {
                    doneOrNotDone = "Done";
                }
            }
            if (traverseCounter == catagoryCounter) //  if problem exist then only have chance to fullill this condition
            {
                catagory = setCatagoryOfSearchedProblem(numberSign);
                break;
            }

        }
        if (exist2 == true && exist == false) {
            FileHandler.jOptionPane.showMessageDialog(null, "Owner Site :  " + site + "\nStatus :  " + doneOrNotDone + "\nCatagory :  " + catagory, "Search Result", 0);
        }
        if (exist == true && exist2 == true) {
            FileHandler.jOptionPane.showMessageDialog(null, "A Problem With This ID Also Found in :  " + site + "\nStatus :  " + doneOrNotDone + "\nCatagory :  " + catagory, "Search Result", 0);
        }

    }

    public void searchFromCodeForces() throws FileNotFoundException, IOException {

        int status;
        exist = false;
        FileHandler.makeFileToWrite();
        while (FileHandler.scannerObjOfCodeForceFile.hasNextLine()) {
            Scanner scannerLineObj = new Scanner(FileHandler.scannerObjOfCodeForceFile.nextLine());
            while (scannerLineObj.hasNext()) {
                String str = scannerLineObj.next();
                if (!str.equals(FileHandler.problemIdInString)) {

                    break;
                }
                if (str.equals(FileHandler.problemIdInString)) {

                    exist = true;
                    site = "Codeforces";
                    if ((status = Integer.parseInt(doneOrNotDone = scannerLineObj.next())) == 1) {
                        doneOrNotDone = "Still To Be Done";
                    } else {
                        doneOrNotDone = "Solved";
                    }
                    catagory = scannerLineObj.next();
                    int catagorySign = Integer.parseInt(catagory);
                    catagory = setCatagoryOfSearchedProblem(catagorySign);
                    break;
                }

            }

            if (exist == true) {
                break;
            }
        }
        if (exist == true) {
            FileHandler.jOptionPane.showMessageDialog(null, "Owner Site :  " + site + "\nStatus :  " + doneOrNotDone + "\nCatagory :  " + catagory, " Search Result ", 0);
        }

    }

    public void searchFromCodeChef() throws IOException {

        int status;
        exist2 = false;
        FileHandler.makeFileToWrite();
        while (FileHandler.scannerObjOfCodechefFile.hasNextLine()) {
            Scanner scannerLineObj = new Scanner(FileHandler.scannerObjOfCodechefFile.nextLine());
            while (scannerLineObj.hasNext()) {
                String str = scannerLineObj.next();
                if (!str.equals(FileHandler.problemIdInString)) {

                    break;
                }
                if (str.equals(FileHandler.problemIdInString)) {

                    exist2 = true;
                    site = "CodeChef";
                    if ((status = Integer.parseInt(doneOrNotDone = scannerLineObj.next())) == 1) {
                        doneOrNotDone = "Still To Be Done";
                    } else {
                        doneOrNotDone = "Solved";
                    }
                    catagory = scannerLineObj.next();
                    int catagorySign = Integer.parseInt(catagory);
                    catagory = setCatagoryOfSearchedProblem(catagorySign);
                    break;
                }
            }
            if (exist2 == true) {
                break;
            }
        }
        if (exist2 == true && exist == false) {
            FileHandler.jOptionPane.showMessageDialog(null, "Owner Site: " + site + "\nStatus :  " + doneOrNotDone + "\nCatagory :  " + catagory, " Search Result ", 0);
        }
        if (exist == true && exist2 == true) {
            FileHandler.jOptionPane.showMessageDialog(null, "A Problem With This ID Also Found in :  " + site + "\nStatus :  " + doneOrNotDone + "\nCatagory :  " + catagory, " Search Result ", 0);
        }

    }

}
