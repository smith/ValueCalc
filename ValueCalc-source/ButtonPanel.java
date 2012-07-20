/***********************************
 *	Class: ButtonPanel	   *
 *	Project: ValueCalcApplet   *
 *	Author: Nathan Smith	   *
 *	Date: July 31, 2002	   *
 ***********************************/
 
import java.awt.*;

public class ButtonPanel extends Panel {

    static final Button fvBtn = new Button("FV");
    static final Button fvaBtn = new Button("FV (Annuity)");
    static final Button pvBtn = new Button("PV");
    static final Button pvaBtn = new Button("PV (Annuity)");
    static final Button helpBtn = new Button("?");
    
    private final Panel p1 = new Panel();
    private final Panel p2 = new Panel();
    
    public ButtonPanel() {
        // place buttons on subpanel
        p1.setLayout(new GridLayout(2,2));
        p1.add(fvBtn);
        p1.add(pvBtn);
        p1.add(fvaBtn);
        p1.add(pvaBtn);
        
        // put ? button on separate panel
        p2.add(helpBtn);

        // add subpanels
        add(p1);
        add(p2);
    }
}