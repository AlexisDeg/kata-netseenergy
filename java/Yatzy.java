import java.util.*;
import java.util.stream.Collectors;

public class Yatzy {

    public static final Integer MISSED_SCORE = 0;
    public static final Integer YATZY_SCORE = 50;

    public static final List<Integer> SMALL_STRAIGHT_VALUES = Arrays.asList(1, 2, 3, 4, 5);
    public static final Integer SMALL_STRAIGHT_SCORE = SMALL_STRAIGHT_VALUES.stream().reduce(0, Integer::sum);
    public static final List<Integer> LARGE_STRAIGHT_VALUES = Arrays.asList(2, 3, 4, 5, 6);
    public static final Integer LARGE_STRAIGHT_SCORE = LARGE_STRAIGHT_VALUES.stream().reduce(0, Integer::sum);

    protected Integer[] dice;

    public static Integer calculateChanceScore(List<Integer> dices) {
        return dices.stream().reduce(0, Integer::sum);
    }

    private static Integer calculateOneNumberScore(List<Integer> dices, Integer number) {
        return dices.stream().filter(d -> d.equals(number)).reduce(0, Integer::sum);
    }

    public static Integer calculateOnesScore(List<Integer> dices) {
        return calculateOneNumberScore(dices, 1);
    }

    public static Integer calculateTwosScore(List<Integer> dices) {
        return calculateOneNumberScore(dices, 2);
    }

    public static Integer calculateThreeScore(List<Integer> dices) {
        return calculateOneNumberScore(dices, 3);
    }

    public static Integer calculateFoursScore(List<Integer> dices) {
        return calculateOneNumberScore(dices, 4);
    }

    public static Integer calculateFivesScore(List<Integer> dices) {
        return calculateOneNumberScore(dices, 5);
    }

    public static Integer calculateSixesScore(List<Integer> dices) {
        return calculateOneNumberScore(dices, 6);
    }

    private static Map<Integer, Integer> populateDiceCountMap(List<Integer> dices) {
        Map<Integer, Integer> diceCountMap = new HashMap<>();
        dices.forEach(dice -> {
            Integer diceCount = diceCountMap.get(dice);
            if (diceCount == null) {
                diceCount = 0;
            }
            diceCount++;
            diceCountMap.put(dice, diceCount);
        });
        return diceCountMap;
    }

    private static Integer calculateNOfAKindScore(List<Integer> dices, Integer n) {
        Map<Integer, Integer> diceCountMap = populateDiceCountMap(dices);
        List<Integer> reversedDices = diceCountMap.keySet().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int score = 0;
        Iterator<Integer> itReversedDices = reversedDices.iterator();
        boolean found = false;
        while (itReversedDices.hasNext() && !found) {
            Integer diceValue = itReversedDices.next();
            Integer nbDices = diceCountMap.get(diceValue);
            found = nbDices != null && nbDices >= n;
            if (found) {
                score = n * diceValue;
            }
        }
        return score;
    }

    public static Integer calculateOnePairScore(List<Integer> dices) {
        return calculateNOfAKindScore(dices, 2);
    }

    public static Integer calculateTwoPairsScore(List<Integer> dices) {
        int[] diceCounts = new int[6];
        dices.stream().forEach(dice -> diceCounts[dice - 1]++);

        int numberOfPairsFound = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (diceCounts[6 - i - 1] >= 2) {
                numberOfPairsFound++;
                score += (6 - i);
            }
        if (numberOfPairsFound == 2)
            return score * 2;
        else
            return 0;
    }

    public static Integer calculateThreeOfAKindScore(List<Integer> dices) {
        return calculateNOfAKindScore(dices, 3);
    }

    public static Integer calculateFourOfAKindScore(List<Integer> dices) {
        return calculateNOfAKindScore(dices, 4);
    }

    public static Integer calculateYatzyScore(List<Integer> dices) {
        return dices.stream().distinct().count() == 1 ? YATZY_SCORE : MISSED_SCORE;
    }

    public static Integer calculateSmallStraightScore(List<Integer> dices) {
        return new HashSet<>(dices).equals(new HashSet<>(SMALL_STRAIGHT_VALUES)) ? SMALL_STRAIGHT_SCORE : MISSED_SCORE;
    }

    public static Integer calculateLargeStraightScore(List<Integer> dices) {
        return new HashSet<>(dices).equals(new HashSet<>(LARGE_STRAIGHT_VALUES)) ? LARGE_STRAIGHT_SCORE : MISSED_SCORE;
    }

    public static Integer calculateFullHouseScore(List<Integer> dices) {
        boolean pairFound = false;
        boolean threeOfAKindFound = false;

        int pairDiceValue = 0;
        int threeOfAKindDiceValue = 0;

        int i;

        int[] diceCounts = new int[6];
        dices.stream().forEach(dice -> diceCounts[dice - 1]++);

        for (i = 0; i != 6; i += 1)
            if (diceCounts[i] == 2) {
                pairFound = true;
                pairDiceValue = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (diceCounts[i] == 3) {
                threeOfAKindFound = true;
                threeOfAKindDiceValue = i + 1;
            }

        if (pairFound && threeOfAKindFound)
            return pairDiceValue * 2 + threeOfAKindDiceValue * 3;
        else
            return 0;
    }
}



