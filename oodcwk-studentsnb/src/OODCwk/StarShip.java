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
    
    int laserCannons;
    int photonTorpedoes;
    
    public StarShip(String fleetRefNo, String fleetName, int activationFee, int laserCannons, int photonTorpedoes, int fleetStrength, ForceState ForceState){
        
        super(fleetRefNo, fleetName, activationFee, fleetStrength, ForceState);
        this.laserCannons = laserCannons;
        this.photonTorpedoes = photonTorpedoes;
    }
    
    public String toString() {
       return super.toString() + "\n" + "Laser Cannons: " + laserCannons + "\n" 
               + "Photon Torpedoes: " + photonTorpedoes;   
    }

    
}
