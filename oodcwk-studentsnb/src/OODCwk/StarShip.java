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
public class StarShip extends Force {
    
    private int laserCannons;
    private int photonTorpedoes;

    public StarShip(String forceRefNo, String forceName, int activationFee, int forceStrength, ForceState forceState, int laserCannons, int photonTorpedoes) {
        super(forceRefNo, forceName, activationFee, forceStrength, forceState);
        this.laserCannons = laserCannons;
        this.photonTorpedoes = photonTorpedoes;
    }

    public int getLaserCannons() {
        return laserCannons;
    }

    public void setLaserCannons(int laserCannons) {
        this.laserCannons = laserCannons;
    }

    public int getPhotonTorpedoes() {
        return photonTorpedoes;
    }

    public void setPhotonTorpedoes(int photonTorpedoes) {
        this.photonTorpedoes = photonTorpedoes;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Laser Cannons: " + getLaserCannons() + "\n"
                + "Photon Torpedoes: " + getPhotonTorpedoes();
    }  
}
