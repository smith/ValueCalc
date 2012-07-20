/***********************************
 *	Class: ConsolePanel	   *
 *	Project: ValueCalcApplet   *
 *	Author: Nathan Smith	   *
 *	Date: July 31, 2002	   *
 ***********************************/

import java.awt.*;

public class ConsolePanel extends Panel {
    
    static String helpMessage = "Use the buttons above to\n"
                              + "make these calulations:\n\n"
                              + "FV: Future value\n"
                              + "PV: Present value\n"
                              + "FV (Annuity):\n"
                              + "Future value of an annuity\n"
                              + "PV (Annuity):\n"
                              + "Present value of an annuity\n\n"
                              + "Press the \"Compute\" button when\n"
                              + "all values are entered.\n\n"
                              + "\n\"?\" shows this message.\n\n";
                              
    static TextArea ta = new TextArea(15, 30);
    
    public ConsolePanel() {
        ta.setEditable(false);
    
        ta.append(helpMessage);
        add(ta);
    }
        
}
