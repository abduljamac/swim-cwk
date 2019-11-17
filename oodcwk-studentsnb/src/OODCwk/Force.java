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
public class Force {
    
    private String fleetRefNo;
    private String fleetName; 
    private int activationFee;
    private int fleetStrength;
    private ForceState ForceState;
    
    public Force(String fleetRefNo, String fleetName, int activationFee, int fleetStrength, ForceState ForceState ){
        
        this.fleetRefNo = fleetRefNo;
        this.fleetName = fleetName;
        this.activationFee = activationFee;
        this.fleetStrength = fleetStrength;
        this.ForceState = ForceState;
 
    }
    
    public void setFleetRefNo(String fleetRefNo) {
        this.fleetRefNo = fleetRefNo;
    }
   
    public String getFleetRefNo(){
        return fleetRefNo;
    }
    
    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }
    
    public String getFleetName(){
        return fleetName;
    }
    
    public void setActivationfee(int activationfee) {
        this.activationFee = activationfee;
    }
    
    public int getActivationFee(){
        return activationFee;
    }
    
    public int getRefund(){
        return activationFee / 2;
    }
    
    public void setFleetStrength(int fleetStrength) {
        this.fleetStrength = fleetStrength;
    }
    
    public int getFleetStrength(){
        return fleetStrength;
    }
    
    public void setForceState(ForceState ForceState) {
        this.ForceState = ForceState;
    }
    
    public ForceState getForceState() {
        return ForceState;
    }
    
    public String toString(){
        return "Reference: " + fleetRefNo + "\n" + "Fleet Name: " + fleetName + "\n" +
              "Activation Fee: " + activationFee +  "\n" + "Strength: " + fleetStrength;
    }
    
}
