import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chanceScoresSumOfAllDice() {
        assertEquals(Integer.valueOf(15), Yatzy.calculateChanceScore(Arrays.asList(2, 3, 4, 5, 1)));
        assertEquals(Integer.valueOf(16), Yatzy.calculateChanceScore(Arrays.asList(3, 3, 4, 5, 1)));
    }

    @Test
    public void onesScoresSumOfAllOnes() {
        assertEquals(Integer.valueOf(1), Yatzy.calculateOnesScore(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(Integer.valueOf(2), Yatzy.calculateOnesScore(Arrays.asList(1, 2, 1, 4, 5)));
        assertEquals(Integer.valueOf(0), Yatzy.calculateOnesScore(Arrays.asList(6, 2, 2, 4, 5)));
        assertEquals(Integer.valueOf(4), Yatzy.calculateOnesScore(Arrays.asList(1, 2, 1, 1, 1)));
    }

    @Test
    public void twosScoresSumOfAllTwos() {
        assertEquals(Integer.valueOf(4), Yatzy.calculateTwosScore(Arrays.asList(1, 2, 3, 2, 6)));
        assertEquals(Integer.valueOf(10), Yatzy.calculateTwosScore(Arrays.asList(2, 2, 2, 2, 2)));
    }

    @Test
    public void threesScoresSumOfAllThrees() {
        assertEquals(Integer.valueOf(6), Yatzy.calculateThreeScore(Arrays.asList(1, 2, 3, 2, 3)));
        assertEquals(Integer.valueOf(12), Yatzy.calculateThreeScore(Arrays.asList(2, 3, 3, 3, 3)));
    }

    @Test
    public void foursScoresSumOfAllFours() {
        assertEquals(Integer.valueOf(12), Yatzy.calculateFoursScore(Arrays.asList(4, 4, 4, 5, 5)));
        assertEquals(Integer.valueOf(8), Yatzy.calculateFoursScore(Arrays.asList(4, 4, 5, 5, 5)));
        assertEquals(Integer.valueOf(4), Yatzy.calculateFoursScore(Arrays.asList(4, 5, 5, 5, 5)));
    }

    @Test
    public void fivesScoresSumOfAllFives() {
        assertEquals(Integer.valueOf(10), Yatzy.calculateFivesScore(Arrays.asList(4, 4, 4, 5, 5)));
        assertEquals(Integer.valueOf(15), Yatzy.calculateFivesScore(Arrays.asList(4, 4, 5, 5, 5)));
        assertEquals(Integer.valueOf(20), Yatzy.calculateFivesScore(Arrays.asList(4, 5, 5, 5, 5)));
    }

    @Test
    public void sixesScoresSumOfAllSixes() {
        assertEquals(Integer.valueOf(0), Yatzy.calculateSixesScore(Arrays.asList(4, 4, 4, 5, 5)));
        assertEquals(Integer.valueOf(6), Yatzy.calculateSixesScore(Arrays.asList(4, 4, 6, 5, 5)));
        assertEquals(Integer.valueOf(18), Yatzy.calculateSixesScore(Arrays.asList(6, 5, 6, 6, 5)));
    }

    @Test
    public void onePairScoresSumOfHighestPair() {
        assertEquals(Integer.valueOf(6), Yatzy.calculateOnePairScore(Arrays.asList(3, 4, 3, 5, 6)));
        assertEquals(Integer.valueOf(10), Yatzy.calculateOnePairScore(Arrays.asList(5, 3, 3, 3, 5)));
        assertEquals(Integer.valueOf(12), Yatzy.calculateOnePairScore(Arrays.asList(5, 3, 6, 6, 5)));
    }

    @Test
    public void twoPairsScoresSumOfTwoHighestPairs() {
        assertEquals(Integer.valueOf(16), Yatzy.calculateTwoPairsScore(Arrays.asList(3, 3, 5, 4, 5)));
        assertEquals(Integer.valueOf(16), Yatzy.calculateTwoPairsScore(Arrays.asList(3, 3, 5, 5, 5)));
    }

    @Test
    public void threeOfAKindScoresSumOfThreeIdenticalDices() {
        assertEquals(Integer.valueOf(9), Yatzy.calculateThreeOfAKindScore(Arrays.asList(3, 3, 3, 4, 5)));
        assertEquals(Integer.valueOf(15), Yatzy.calculateThreeOfAKindScore(Arrays.asList(5, 3, 5, 4, 5)));
        assertEquals(Integer.valueOf(9), Yatzy.calculateThreeOfAKindScore(Arrays.asList(3, 3, 3, 3, 5)));
        assertEquals(Integer.valueOf(9), Yatzy.calculateThreeOfAKindScore(Arrays.asList(3, 3, 3, 3, 3)));
    }

    @Test
    public void fourOfAKindScoresSumOfFourIdenticalDices() {
        assertEquals(Integer.valueOf(12), Yatzy.calculateFourOfAKindScore(Arrays.asList(3, 3, 3, 3, 5)));
        assertEquals(Integer.valueOf(20), Yatzy.calculateFourOfAKindScore(Arrays.asList(5, 5, 5, 4, 5)));
    }

    @Test
    public void yatzyScores50() {
        assertEquals(Integer.valueOf(50), Yatzy.calculateYatzyScore(Arrays.asList(4, 4, 4, 4, 4)));
        assertEquals(Integer.valueOf(50), Yatzy.calculateYatzyScore(Arrays.asList(6, 6, 6, 6, 6)));
        assertEquals(Integer.valueOf(0), Yatzy.calculateYatzyScore(Arrays.asList(6, 6, 6, 6, 3)));
    }

    @Test
    public void smallStraightScores15() {
        assertEquals(Integer.valueOf(15), Yatzy.calculateSmallStraightScore(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(Integer.valueOf(15), Yatzy.calculateSmallStraightScore(Arrays.asList(2, 3, 4, 5, 1)));
        assertEquals(Integer.valueOf(0), Yatzy.calculateSmallStraightScore(Arrays.asList(1, 2, 2, 4, 5)));
    }

    @Test
    public void largeStraightScores20() {
        assertEquals(Integer.valueOf(20), Yatzy.calculateLargeStraightScore(Arrays.asList(6, 2, 3, 4, 5)));
        assertEquals(Integer.valueOf(20), Yatzy.calculateLargeStraightScore(Arrays.asList(2, 3, 4, 5, 6)));
        assertEquals(Integer.valueOf(0), Yatzy.calculateLargeStraightScore(Arrays.asList(1, 2, 2, 4, 5)));
    }

    @Test
    public void fullHouseScoresSumOfAllDices() {
        assertEquals(Integer.valueOf(18), Yatzy.calculateFullHouseScore(Arrays.asList(6, 2, 2, 2, 6)));
        assertEquals(Integer.valueOf(0), Yatzy.calculateFullHouseScore(Arrays.asList(2, 3, 4, 5, 6)));
    }
}
