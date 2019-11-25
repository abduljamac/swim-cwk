/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

/**
 *
 * @author abdul
 */
public class Wings extends Force {
    
    int strikers;
    
    public Wings(String fleetRefNo, String fleetName, int activationFee, int strickers, int fleetStrength, ForceState ForceState){
        
        super(fleetRefNo, fleetName, activationFee, fleetStrength, ForceState);
        this.strikers = strickers;
    }
    
       public String toString() {
       return super.toString() + "\n" + "Strikers: " + strikers;   
     }

}
