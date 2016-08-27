package programmingcollaborator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
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
public class FileHandler {

    static String folderPath = "c:" + File.separator + "Programming Collaborator",
            pathOfUVAFile = "C:" + File.separator + "Programming Collaborator" + File.separator + "UVA.txt",
            pathOfCodeforceFile = "C:" + File.separator + "Programming Collaborator" + File.separator + "CodeForces.txt",
            pathOfLightOjFile = "C:" + File.separator + "Programming Collaborator" + File.separator + "LightOj.txt",
            pathOfCodeChefFile = "C:" + File.separator + "Programming Collaborator" + File.separator + "CodeChef.txt";

    static File uva, codeForce, codeChef, lightOj;
    static Scanner scannerObjOfUvaFile, scannerObjOfCodeForceFile, scannerObjOfLightOjFile, scannerObjOfCodechefFile;
    static int problemId;
    static JOptionPane jOptionPane;
    static String problemIdInString;
    static Scanner scannerObj = new Scanner(System.in);
    static FileWriter uvaWriter, codeforceWriter, lightOjWriter, codechefWriter;
    static BufferedWriter bufferedWriterOfUva, bufferedWriterOfCodeforces, bufferedWriterOfLightOj, bufferedWriterOfCodechef;
    static FileOutputStream fileOutputStreamUva, fileOutputStreamCodeforces, fileOutputStreamLightOj, fileOutputStreamCodechef;

    static void fileCreator() throws IOException {

//        File Creation > Different File For Different Site 
        try {

            boolean successbool = (new File(folderPath)).mkdirs();
            uva = new File(pathOfUVAFile);
            codeForce = new File(pathOfCodeforceFile);
            lightOj = new File(pathOfLightOjFile);
            codeChef = new File(pathOfCodeChefFile);

            uva.createNewFile();
            codeForce.createNewFile();
            lightOj.createNewFile();
            codeChef.createNewFile();

        } catch (Exception e) {

        }
    }

    static void makeFileToWrite() throws IOException {
        scannerObjOfUvaFile = new Scanner(uva);
        scannerObjOfCodeForceFile = new Scanner(codeForce);
        scannerObjOfLightOjFile = new Scanner(lightOj);
        scannerObjOfCodechefFile = new Scanner(codeChef);
        // FileWriter Object For Every File .

        uvaWriter = new FileWriter(pathOfUVAFile, true);
        codeforceWriter = new FileWriter(pathOfCodeforceFile, true);
        codechefWriter = new FileWriter(pathOfCodeChefFile, true);
        lightOjWriter = new FileWriter(pathOfLightOjFile, true);

        // BufferedWriter Object For Every FileWriter based on Specific File 
        bufferedWriterOfUva = new BufferedWriter(uvaWriter);
        bufferedWriterOfCodeforces = new BufferedWriter(codeforceWriter);
        bufferedWriterOfLightOj = new BufferedWriter(lightOjWriter);
        bufferedWriterOfCodechef = new BufferedWriter(codechefWriter);
    }
}
