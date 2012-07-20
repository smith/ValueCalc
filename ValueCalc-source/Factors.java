/***********************************
 *	Class: Factors		   *
 *	Project: ValueCalcApplet   *
 *	Author: Nathan Smith	   *
 *	Date: July 31, 2002	   *
 ***********************************/
 
// All of these class methods take principal (p), 
// interest rate (r), and number of periods (n)
// and return an appropriate double value.
// The calculations herein can be explained 
// either in the documentation distributed
// with this software or in any accounting
// textbook. 
public class Factors {

    // FV accumulation factor
    public static double futureValue(double p, double r, double n) {
        return p * Math.pow(1+r, n);
    }
    
    // FV discount factor
    public static double futureValueAnnuity(double p, double r, double n) {
        return p * ((Math.pow(1+r, n) - 1) / r);
    }
    
    // PV accumulation factor
    public static double presentValue(double p, double r, double n) {
        return p * (1 / (Math.pow(1+r, n)));
    }
    
    // PV discount factor
    public static double presentValueAnnuity(double p, double r, double n) {
        return p * ((1 / r)*(1 - (1 / Math.pow(1+r, n))));
    }
}
