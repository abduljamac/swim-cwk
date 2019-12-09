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
public class WarBird extends Force {

    boolean cloakingDevice = false;
    
    public WarBird(String forceRefNo, String forceName, int activationFee, int forceStrength, ForceState forceState, boolean canSkirmish, boolean canAmbush, boolean canFight, boolean cloakingDevice) {
        super(forceRefNo, forceName, activationFee, forceStrength, forceState,  canSkirmish, canAmbush, canFight);
        this.cloakingDevice = cloakingDevice;
    }

    public boolean getCloakingDevice() {
        return cloakingDevice;
    }

    public void setCloakingDevice(boolean cloakingDevice) {
        this.cloakingDevice = cloakingDevice;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Cloaking Device: " + getCloakingDevice();
    }
}
