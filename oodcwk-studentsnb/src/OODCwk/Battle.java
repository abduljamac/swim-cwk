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
public class Battle {
    
    private int battleNo;
    private BattleType Type;
    private String enemy;
    private int enemyStrength;
    private int losses;
    private int gains;

    public Battle(int battleNo, BattleType Type, String enemy, int enemyStrength, int losses, int gains) {
        this.battleNo = battleNo;
        this.Type = Type;
        this.enemy = enemy;
        this.enemyStrength = enemyStrength;
        this.losses = losses;
        this.gains = gains;
    }

    public int getBattleNo() {
        return battleNo;
    }

    public void setBattleNo(int battleNo) {
        this.battleNo = battleNo;
    }

    public BattleType getType() {
        return Type;
    }

    public void setType(BattleType Type) {
        this.Type = Type;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public int getEnemyStrength() {
        return enemyStrength;
    }

    public void setEnemyStrength(int enemyStrength) {
        this.enemyStrength = enemyStrength;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGains() {
        return gains;
    }

    public void setGains(int gains) {
        this.gains = gains;
    }

    @Override
    public String toString() {
        return "Battle Number: " + battleNo + "\n" + "Type: " + Type + "\n" +
                "Enemy: " + enemy +  "\n" + "Enemy Strength: " + enemyStrength + "\n" +
                "Losses: " + losses + "\n" + "Gains " + gains;
    }
    
    

}
