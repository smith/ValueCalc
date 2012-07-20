/***********************************
 *	Class: ValueCalcApplet	   *
 *	Project: ValueCalcApplet   *
 *	Author: Nathan Smith	   *
 *	Date: July 31, 2002	   *
 ***********************************/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class ValueCalcApplet extends Applet 
                             implements ActionListener {

    static ConsolePanel console = new ConsolePanel();
    ButtonPanel buttons = new ButtonPanel();
    
    public void init() {
    
        // register actions for buttons
        buttons.fvBtn.addActionListener(this);
        buttons.fvaBtn.addActionListener(this);
        buttons.pvBtn.addActionListener(this);
        buttons.pvaBtn.addActionListener(this);
        buttons.helpBtn.addActionListener(this);
        
        // add button and console panels
        setLayout(new BorderLayout());
        add(buttons, BorderLayout.NORTH);
        add(console, BorderLayout.EAST);

        add(new FVPanel(), BorderLayout.CENTER);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(
        buttons.fvBtn.getActionCommand())) {
            removeAll();
            invalidate();
            add(new FVPanel(), BorderLayout.CENTER);
            add(buttons, BorderLayout.NORTH);
            add(console, BorderLayout.EAST);
            validate();
        } else if(e.getActionCommand().equals(
          buttons.fvaBtn.getActionCommand())) {
            removeAll();
            invalidate();
            add(new FVAPanel(), BorderLayout.CENTER);
            add(buttons, BorderLayout.NORTH);
            add(console, BorderLayout.EAST);
            validate();
        } else if(e.getActionCommand().equals(
          buttons.pvBtn.getActionCommand())) {
            removeAll();
            invalidate();
            add(new PVPanel(), BorderLayout.CENTER);
            add(console, BorderLayout.EAST);
            add(buttons, BorderLayout.NORTH);
            validate();
        } else if(e.getActionCommand().equals(
          buttons.pvaBtn.getActionCommand())) {
            removeAll();
            invalidate();
            add(new PVAPanel(), BorderLayout.CENTER);
            add(console, BorderLayout.EAST);
            add(buttons, BorderLayout.NORTH);
            validate();
        } else if(e.getActionCommand().equals(
          buttons.helpBtn.getActionCommand())) {
            // print help message to console panel
            console.ta.append(console.helpMessage);
        }
    }
}
