package ru.vsu.cs.util.steblev_d_v;

import org.junit.Test;
import static org.junit.Assert.*;


public class DiceTest {

    @Test
    public void diceSumTest(){
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();


        boolean diceResultIsInRange = true;
        for (int i = 0; i < 1000; i++) {
            dice1.throwDice();
            dice2.throwDice();
            int diceResult = dice1.getDiceResult() + dice2.getDiceResult();
            if(diceResult < 2 || diceResult > 12) {
                diceResultIsInRange = false;
            }
        }
        assertTrue(diceResultIsInRange);
    }

    @Test
    public void diceTest(){
        Dice dice = new Dice();
        boolean isInRange = true;
        for (int i = 0; i < 1000; i++) {
            dice.throwDice();
            if(dice.getDiceResult() < 1 || dice.getDiceResult() > 6) {
                isInRange = false;
            }
        }
        assertTrue(isInRange);
    }
}
