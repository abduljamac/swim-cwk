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
    
    private String forceRefNo;
    private String forceName; 
    private int activationFee;
    private int fleetStrength;
    private ForceState ForceState;
    
    public Force(String forceRefNo, String forceName, int activationFee, int fleetStrength, ForceState ForceState ){
        
        this.forceRefNo = forceRefNo;
        this.forceName = forceName;
        this.activationFee = activationFee;
        this.fleetStrength = fleetStrength;
        this.ForceState = ForceState;
 
    }
    
    public void setForceRefNo(String forceRefNo) {
        this.forceRefNo = forceRefNo;
    }
   
    public String getForceRefNo(){
        return forceRefNo;
    }
    
    public void setForceName(String forceName) {
        this.forceName = forceName;
    }
    
    public String getForceName(){
        return forceName;
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
        return "Reference: " + forceRefNo + "\n" + "Fleet Name: " + forceName + "\n" +
              "Activation Fee: " + activationFee +  "\n" + "Strength: " + fleetStrength;
    }
    
}
