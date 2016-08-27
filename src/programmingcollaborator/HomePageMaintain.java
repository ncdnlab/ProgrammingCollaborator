package programmingcollaborator;

/**
 *
 * Programming Collaborator | Useful Tool For Programmers
 *
 * @author Abdullah-Al Masum Khan, ID: 150103020010
 * @author Md. Abu Salek, ID: 150103020012
 * @author Md. Abu Naser, ID: 150103020009
 * @author Md Mahadi Hasan Nahid, nahid@neub.edu.bd
 */
public class HomePageMaintain {

    static void goToWantedSiteHomePage(String selectedSiteUrl) {
        if (!java.awt.Desktop.isDesktopSupported()) {
            System.exit(1);
        }
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        if (!desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
            System.exit(1);
        }
        try {
            java.net.URI uri = new java.net.URI(selectedSiteUrl);
            desktop.browse(uri);
        } catch (Exception e) {
            FileHandler.jOptionPane.showMessageDialog(null, " Something Gone Wrong !", "ProgC Is In Unexpected Trouble", FileHandler.jOptionPane.ERROR_MESSAGE);
        }
    }

}
