/***********************************
 *	Class: FVPanel		   *
 *	Project: ValueCalcApplet   *
 *	Author: Nathan Smith	   *
 *	Date: July 31, 2002	   *
 ***********************************/

import java.awt.*;
import java.awt.event.*;
    
public class FVPanel extends Panel 
                     implements ActionListener {

    private TextField principalTF = new TextField(15);
    private TextField periodsTF = new TextField(3);
    private TextField interestRateTF = new TextField(3);
    private TextField resultTF = new TextField(15);
    private Button computeBtn = new Button("Compute");

    
    public FVPanel() {
        
        // set element properties
        resultTF.setEditable(false);
        
        // add actionlisteners
        computeBtn.addActionListener(this);
        
        // set layout of main panel
        setLayout(new GridLayout(4,1));
        
        // add elements to panels
        Panel a = new Panel();
        a.add(new Label("The future value of: $"));
        a.add(principalTF);
        
        Panel b = new Panel();
        b.add(new Label("compounded over"));
        b.add(periodsTF);
        b.add(new Label("periods"));
        
        Panel c = new Panel();
        c.add(new Label("at an interest rate of"));
        c.add(interestRateTF);
        c.add(new Label("%"));
        
        Panel d = new Panel();
        d.add(new Label("is"));
        d.add(new Label("$"));
        d.add(resultTF);
        d.add(computeBtn);
        
        add(a);
        add(b);
        add(c);
        add(d);

    
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
                double d = Factors.futureValue(p,r,n);
                    
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
