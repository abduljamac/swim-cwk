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
    private boolean canSkirmish;
    private boolean canAmbush;
    private boolean canFight;

    public Force(String forceRefNo, String forceName, int activationFee, int forceStrength, ForceState forceState,  boolean canSkirmish, boolean canAmbush, boolean canFight) {
        this.forceRefNo = forceRefNo;
        this.forceName = forceName;
        this.activationFee = activationFee;
        this.forceStrength = forceStrength;
        this.forceState = forceState;
        this.canSkirmish = canSkirmish;
        this.canAmbush = canAmbush;
        this.canFight = canFight;
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
    
    public boolean isCanSkirmish() {
        return canSkirmish;
    }

    public void setCanSkirmish(boolean canSkirmish) {
        this.canSkirmish = canSkirmish;
    }

    public boolean isCanAmbush() {
        return canAmbush;
    }

    public void setCanAmbush(boolean canAmbush) {
        this.canAmbush = canAmbush;
    }

    public boolean isCanFight() {
        return canFight;
    }

    public void setCanFight(boolean canFight) {
        this.canFight = canFight;
    }
    
    public boolean isCorrectBattleType(Battle battle, Force force) {
        if ((battle.getType().equals(BattleType.FIGHT) && force.canFight) ||
            (battle.getType().equals(BattleType.SKIRMISH) && force.canSkirmish) ||
            (battle.getType().equals(BattleType.AMBUSH) && force.canAmbush)) {
            return true;
        }
        return false;
    }


    public String toString(){
        return "Reference: " + getForceRefNo() + 
                "\n" + "Fleet Name: " + getForceName() +
                "\n" +"Activation Fee: " + getActivationFee() +  
                "\n" + "Strength: " + getForceStrength()+  
                "\n" + "Force State: " + getForceState();
    }
    
}
