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
    private int forceStrength;
    private ForceState forceState;

    public Force(String forceRefNo, String forceName, int activationFee, int forceStrength, ForceState forceState ){

        this.forceRefNo = forceRefNo;
        this.forceName = forceName;
        this.activationFee = activationFee;
        this.forceStrength = forceStrength;
        this.forceState = forceState;

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

    public void setForceStrength(int forceStrength) {
        this.forceStrength = forceStrength;
    }

    public int getForceStrength(){
        return forceStrength;
    }

    public void setForceState(ForceState ForceState) {
        this.forceState = ForceState;
    }

    public ForceState getForceState() {
        return forceState;
    }

    public String toString(){
        return "Reference: " + getForceRefNo() + 
                "\n" + "Fleet Name: " + getForceName() +
                "\n" +"Activation Fee: " + getActivationFee() +  
                "\n" + "Strength: " + getForceStrength()+  
                "\n" + "Force State: " + getForceState();
    }
    
}
