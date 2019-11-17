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
public class WarBird extends Force{
    
    boolean cloakingDevice = false;
    
    public WarBird(String fleetRefNo, String fleetName, int activationFee, int fleetStrength, boolean cloakingDevice, ForceState ForceState){
        
        super(fleetRefNo, fleetName, activationFee, fleetStrength, ForceState);
        this.cloakingDevice = cloakingDevice;
    }
    
    public String toString() {
       return super.toString() + "\n" + "Cloaking Device: " + cloakingDevice;  
    }
}
