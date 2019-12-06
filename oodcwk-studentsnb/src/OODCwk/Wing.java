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
public class Wing extends Force {
    
    private int strikers; 
    
    public Wing(String forceRefNo, String forceName, int activationFee, int forceStrength, ForceState forceState, int strikers) {
        super(forceRefNo, forceName, activationFee, forceStrength, forceState);
        this.strikers = strikers;
    }

    public int getStrikers() {
        return strikers;
    }

    public void setStrikers(int strikers) {
        this.strikers = strikers;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Strikers: " + getStrikers();
    }
    
}
