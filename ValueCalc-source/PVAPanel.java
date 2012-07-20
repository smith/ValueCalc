/***********************************
 *	Class: PVAPanel		   *
 *	Project: ValueCalcApplet   *
 *	Author: Nathan Smith	   *
 *	Date: July 31, 2002	   *
 ***********************************/

import java.awt.*;
import java.awt.event.*;
    
public class PVAPanel extends Panel 
                     implements ActionListener {

    private final TextField principalTF = new TextField(15);
    private final TextField periodsTF = new TextField(3);
    private final TextField interestRateTF = new TextField(3);
    private final Button computeBtn = new Button("Compute");
    
    private final TextField resultTF = new TextField(15);
    
    public PVAPanel() {
        
        // set element properties
        resultTF.setEditable(false);
        
        // add actionlisteners
        computeBtn.addActionListener(this);
        
        // set main panel layout
        setLayout(new GridLayout(5,1));

        // add elements to panel
        Panel a = new Panel();
        a.add(new Label("The present value of a series of"));
        
        Panel b = new Panel();
        b.add(new Label("$"));
        b.add(principalTF);
        b.add(new Label("cash flows"));
        
        Panel c = new Panel(); 
        c.add(new Label("over"));
        c.add(periodsTF);
        c.add(new Label("periods"));
        
        Panel d = new Panel();
        d.add(new Label("at an interest rate of"));
        d.add(interestRateTF);
        d.add(new Label("%"));
        
        Panel e = new Panel();
        e.add(new Label("is $"));
        e.add(resultTF);
        e.add(computeBtn);

        add(a);
        add(b);
        add(c);
        add(d);
        add(e);


    }
    
   public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(computeBtn.getActionCommand())) {
            try {
                // get data
                double p = Double.parseDouble(principalTF.getText());
                double r = Double.parseDouble(interestRateTF.getText())/100;
                double n = Double.parseDouble(periodsTF.getText());
    
                // check for negatives
                if(p<0 || r<0 || n<0) 
                    ValueCalcApplet.console.ta.append("Numbers must be positive\n");
                
                // make calculation 
                double d = Factors.presentValueAnnuity(p,r,n);
                    
                // round to format of XXX.XX
                d = Math.rint(100 * d) / 100;
                
                // change textfield
                resultTF.setText(Double.toString(d));
            } catch (NumberFormatException n) {
                ValueCalcApplet.console.ta.append(
                "All fields must have proper numbers\n");
            }
        }
    }
}
