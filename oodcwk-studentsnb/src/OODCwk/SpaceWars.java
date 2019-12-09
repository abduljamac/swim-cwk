package OODCwk;
import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from a SWIM
 * system as required for 6COM1037 - Nov 2019
 *
 * @author A.A.Marczyk
 * @version 25/10/2019
 */


public class SpaceWars implements SWIM,Serializable
{
    // fields
    private ArrayList<Battle> allBattles;
    private ArrayList<Force> allForces;
    private String admiral;
    private int bitCoin = 1000;

//**************** SWIM **************************
    /** Constructor requires the name of the admiral
     * @param admiral the name of the admiral
     */
    public SpaceWars(String admiral )
    {
        this.admiral = admiral;
        allBattles = new ArrayList<>();
        allForces = new ArrayList<>();
        setupForces();
        setupBattles();
    }
    
    public SpaceWars(String admiral, String fileName )
    {
        this.admiral = admiral;
        setupForces();
        setupBattles();
        readBattles(fileName);
    }
    
    public SpaceWars(String admiral, ArrayList<Force> allForces, ArrayList<Battle> allBattles, int bitCoin){
        this.admiral = admiral;
        this.allForces = allForces;
        this.allBattles = allBattles;
        this.bitCoin = bitCoin;
    }

    /**Returns a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * active Star Fleet(ASF),(or, "No forces" if Star Fleet is empty)
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Star Fleet,(or, "No forces" if Star Fleet is empty)
     **/
    public String toString()
    {
        StringBuilder spaceWarString = new StringBuilder();
        spaceWarString.append("Admiral Name: " + getAdmiral() + "\n");
        spaceWarString.append("War Chest Balance: " + getWarchest() + "\n");
        spaceWarString.append("Admiral is Defeated: " + isDefeated() + "\n");
        spaceWarString.append(getASFleet());
        return spaceWarString.toString();
    }

    public String getAdmiral() {
        return admiral;
    }

    public void setAdmiral(String admiral) {
        this.admiral = admiral;
    }

    /** returns true if war chest <=0 and the active Star Fleet(ASF) has no
     * forces which can be recalled.
     * @returns true if war chest <=0 and the active Star Fleet(ASF) has no
     * forces which can be recalled.
     */
    public boolean isDefeated()
    {   

        for (Force force : allForces) {
            if (force.getForceState().equals(ForceState.ACTIVE)) {
                return false;
            }
        }

        if (getWarchest() > 0) {
            return false;
        }

        return true;
    }


    /** returns the number of bit coins in the war chest
     * @returns the number of bit coins in the war chest
     */
    public int getWarchest()
    {
        return bitCoin;
    }

    /**Returns true if force is in the United Forces Fleet(UFF), else false
     * @param ref reference of the force
     * @return a String representation of all forces in the United Forces Fleet(UFF)??/
     **/
    public boolean isInUFFleet(String ref)
    {
        for( Force force: allForces){
            if(force.getForceRefNo().equals(ref)){
                return true;
            }
        }
        return false;
    }

    /**Returns a String representation of all forces in the United Forces Fleet(UFF)
     * @return a String representation of all forces in the United Forces Fleet(UFF)
     **/
    public String getUFFleet()
    {
        StringBuilder UFFleet = new StringBuilder();
        for( Force force: allForces ){
//            UFFleet.append(force).append("\n****\n");
            if(force.getForceState().equals(ForceState.DOCKED)){
                  UFFleet.append(force).append("\n****\n");
//                UFFleet.append(force + "\n" + "\n");

            }
            
        }
        return UFFleet.toString();
    }

    /** Returns details of the force in the game with the given reference code
     * @return details of the force in the game with the given reference code
     **/
    public String getForce(String ref)
    {
        for( Force force: allForces ){
            if( force.getForceRefNo().equals(ref) ){
                return force.toString();
            }
        }
        return "No such force"; //not sure this return is needed
    }


 // ***************** active Star Fleet Forces ************************
    /** Allows a force to be activated into the active Star Fleet(ASF), but
     * only if there are enough resources for the activation fee.The force's
     * state is set to "active"
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the UFF
      * 2 if not enough money, 3 if no such force
     **/
    public int activateForce(String ref)
    {
        for( Force force: allForces){
            if( force.getForceRefNo().equals(ref) ){
               if( force.getActivationFee() > getWarchest() ){
                    return 2;
               } else if (!force.getForceState().equals(ForceState.DOCKED)){
                   return 1;
               } else {
                    force.setForceState(ForceState.ACTIVE);
                    bitCoin = bitCoin - force.getActivationFee();
                    return 0;
               }
            } 
        }
               
        return 3;
    }


    /** Returns true if the force with the reference code is in
     * the active Star Fleet(ASF), false otherwise.
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the active Star Fleet(ASF), false otherwise.
     **/
    public boolean isInASFleet(String ref)
    {
        for( Force force: allForces){
            if(force.getForceRefNo().equals(ref)){
                if(force.getForceState().equals(ForceState.ACTIVE)){
                    return true;
                }
            }
        }
        return false;
    }


    /** Recalls a force from the Star Fleet(ASF) back to the UFF dock, but only
     * if they are in the active Star Fleet(ASF)
     * pre-condition: isInASFleet(ref)
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref)
    {
         if(isInASFleet(ref)){
            for( Force force: allForces){
                if(force.getForceRefNo().equals(ref)){
                    force.setForceState(ForceState.DOCKED);
                    bitCoin = bitCoin + force.getRefund();
                }
            }
        }
    }




    /**Returns a String representation of the forces in the active
     * Star Fleet(ASF), or the message "No forces activated"
     * @return a String representation of the forces in the active
     * Star Fleet, or the message "No forces activated"
     **/
    public String getASFleet() {
        StringBuilder ASFleet = new StringBuilder();
        for (Force force : allForces) {
            if (isInASFleet(force.getForceRefNo())){
                ASFleet.append(force).append("\n****\n");
//                ASFleet.append(force + "\n" + "\n");
            }
        }
        if (ASFleet.length() == 0) {
            return "No Forces Activated";
        }
        return ASFleet.toString();
    }


//**********************Battles*************************
    /** returns true if the number represents a battle
     * @param num is the number of the required battle
     * @returns true if the number represents a battle
     **/
     public boolean isBattle(int num)
     {
        if( getBattle(num).equals("No such battle")){
            return false;
        }
        return true;
     }


    /** Provides a String representation of a battle given by
     * the battle number
     * @param num the number of the battle
     * @return returns a String representation of a battle given by
     * the battle number
     **/
    public String getBattle(int num)
    {
        for (Battle battle : allBattles){
            if(battle.getBattleNo() == num){
                return battle.toString();
            }
        }
        return "No such battle";
    }

    /** Provides a String representation of all battles
     * @return returns a String representation of all battles
     **/
    public String getAllBattles()
    {
        StringBuilder Battles = new StringBuilder();
        for(Battle battle: allBattles ){
            Battles.append(battle).append("\n****\n");
//            Battles.append(battle + "\n" + "\n" );


        }
        return Battles.toString();
    }


    /** Retrieves the battle represented by the battle number.Finds
      * a force from the active Star Fleet which can engage in the battle.The
      * results of battle will be one of the following:
      * 0 - Battle won, battle gains added to the warchest,
      * 1 - Battle lost as no suitable force available, battle losses
      * deducted from warchest
      * 2 - Battle lost on battle strength , battle losses
      * deducted from warchest and destroy the force
      * 3 - If a battle is lost and admiral completely defeated (no resources and
      * no forces to recall)
      * -1 - no such battle
      * @param battleNo is the number of the battle
      * @return an int showing the result of the battle
      */
//    public int doBattle(int battleNo) {
//       for (Battle battle: allBattles) {
//         if (battle.getBattleNo() == (battleNo)) {
//             for (Force force: allForces) {
//                 if (isInASFleet(force.getForceRefNo())) {
//                     // checks if force can do a battle
//                     if (force.isCorrectBattleType(battle, force)) {
//                         if (battle.getEnemyStrength() < force.getForceStrength()) {
//                             bitCoin = bitCoin + battle.getGains();
//                             return 0;
//                         } else if (battle.getEnemyStrength() > force.getForceStrength()) {
//                             if (getWarchest() <= 0) {
//                                 return 3;
//                             } else {
//                                 bitCoin = bitCoin - battle.getLosses();
//                                 force.setForceState(ForceState.DESTROYED);
//                                 return 2;
//                             }
//
//                         }
//                     }
//                 } else if (!isInASFleet(force.getForceRefNo())) {
//                     bitCoin = bitCoin - battle.getLosses();
//                     return 1;
//                 }
//             }
//         }
//     }
//
//     return -1;
//    }
    
    public int doBattle(int battleNo)
    {
        // select battle from given battleNo
        Battle chosenBattleNumber = null;
        
        if (!isBattle(battleNo)) {
            return -1; // battle not found
        }
        
        Force forceToDestroy = null; // assigned one force that will be destroyed if battle lost
        
        for (Battle battle : allBattles) {
            if (battle.getBattleNo() == battleNo) {
                chosenBattleNumber = battle;
                // See if we can win battle
                for (Force force: allForces) {
                    if (force.getForceState().equals(ForceState.ACTIVE) && force.isCorrectBattleType(chosenBattleNumber, force)) {
                        if (force.getForceStrength() >= chosenBattleNumber.getEnemyStrength()) {
//                            warChest.setBitcoins(warChest.getBitcoins() + battleFromNumber.getGains());
                            bitCoin = getWarchest() + battle.getGains();
                            return 0; //battle won
                        }

                        forceToDestroy = force; //assign new force to be destroyed (not currently destroyed)
                    }
                }
                // no force found that can do the battle
                break;
            }
        }
        
        // Battle has to be loss, due to previous return 
//        warChest.setBitcoins(warChest.getBitcoins() - selectedBattle.getLosses());
        bitCoin = getWarchest() - chosenBattleNumber.getLosses();
        
        if (forceToDestroy == null) {
            return 1; // No force can do battle so lose coins but dont destroyed force
        }
        
        // destroy force
//        forceToDestroy.setStatus(DESTROYED);
        forceToDestroy.setForceState(ForceState.DESTROYED);
        if (isDefeated()) {
            return 3; // game over
        }
        
        return 2; // force lost but game continues
        
    }
    

    //*******************************************************************************
    private void setupForces()
    {
        Force IW1 = new Wing("IW1", "Twisters",  200, 200, ForceState.DOCKED, true, true, false, 10);
        Force SS2 = new StarShip("SS2", "Enterprise", 300, 200, ForceState.DOCKED, true, false, true, 10 ,20);
        Force WB3 = new WarBird("WB3", "Droop",  300, 100,  ForceState.DOCKED, false, false, true, false);
        Force IW4 = new Wing("IW4", "Wingers",  200, 400, ForceState.DOCKED, true, true, false, 20);
        Force WB5 = new WarBird("WB5", "Hang",   400, 300,   ForceState.DOCKED,  false, true, true, true);
        Force SS6 = new StarShip("SS6", "Voyager",    450, 200, ForceState.DOCKED, true, false, true, 15, 10);
        Force SS7 = new StarShip("SS7", "Explorer",   120,  65,  ForceState.DOCKED,true, false, true,  4, 5);
        Force WB9 = new WarBird("WB9", "Hover",  300, 400,  ForceState.DOCKED, false, false, true, false);
        Force IW10 = new Wing("IW10", "Flyers", 200, 150, ForceState.DOCKED, true, true, false, 5);


        allForces.add(IW1);
        allForces.add(SS2);
        allForces.add(WB3);
        allForces.add(IW4);
        allForces.add(WB5);
        allForces.add(SS6);
        allForces.add(SS7);
        allForces.add(WB9);
        allForces.add(IW10);
    }

    private void setupBattles()
    {
        Battle b1 = new Battle(1, BattleType.FIGHT , "Borg", 200, 300, 100);
        Battle b2 = new Battle(2, BattleType.SKIRMISH , "Kardassians", 700, 200, 120);
        Battle b3 = new Battle(3, BattleType.AMBUSH , "Ferengi", 100, 400, 150);
        Battle b4 = new Battle(4, BattleType.FIGHT , "Ewoks", 600, 600, 200);
        Battle b5 = new Battle(5, BattleType.AMBUSH , "Borg", 500, 400, 90);
        Battle b6 = new Battle(6, BattleType.SKIRMISH , "Groaners", 150, 100, 100);
        Battle b7 = new Battle(7, BattleType.FIGHT , "Borg", 150, 500, 300);
        Battle b8 = new Battle(8, BattleType.AMBUSH , "Wallers", 300, 300, 300);


        allBattles.add(b1);
        allBattles.add(b2);
        allBattles.add(b3);
        allBattles.add(b4);
        allBattles.add(b5);
        allBattles.add(b6);
        allBattles.add(b7);
        allBattles.add(b8);
    }


    //*******************************************************************************
    //*******************************************************************************

//These methods are not needed until Task 4.4
    // ***************   file write/read  *********************
    /** Writes whole game to the specified file
    * @param fname name of file storing requests
    */
    public void saveGame(String fname)
    {
    }

    /** reads all information about the game from the specified file
    * and returns a SWIM object
    * @param fname name of file storing the game
    * @return the game (as a SWIM object)
    */
    public SWIM restoreGame(String fname)
    {
        return null;
    }

    private void readBattles(String fname)
    {
    }
}



