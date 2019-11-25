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
    
  public int battleNo;
  public BattleType Type;
  public String enemy;
  public int enemyStrength;
  public int losses;
  public int gains;

  public Battle(int battleNo, BattleType Type, String enemy,
                int enemyStrength, int losses, int gains){

    this.battleNo = battleNo;
    this.Type = Type;
    this.enemy = enemy;
    this.enemyStrength = enemyStrength;
    this.losses = losses;
    this.gains = gains;
  }

  public int getBattleNo(){
    return battleNo;
  }

  public BattleType getType(){
    return Type;
  }

  public String getEnemy(){
    return enemy;
  }

  public int getEnemyStrength(){
    return enemyStrength;
  }

  public int getLosses(){
    return losses;
  }

  public int getGains(){
    return gains;
  }
  
  public String toString(){ 
    
    return "Battle Number: " + battleNo + "\n" + "Type: " + Type + "\n" +
            "Enemy: " + enemy +  "\n" + "Enemy Strength: " + enemyStrength + "\n" +
            "Losses: " + losses + "\n" + "Gains " + gains;
  }  
    
}
