
    chance = function(d1, d2, d3, d4, d5) {
        var score = 0;
        score += d1;
        score += d2;
        score += d3;
        score += d4;
        score += d5;
        return score;
    }

    nValueScore = function(d1, d2, d3, d4, d5, n) {
        var score = 0;
        if (d1 == n) score+=n;
        if (d2 == n) score+=n;
        if (d3 == n) score+=n;
        if (d4 == n) score+=n;
        if (d5 == n) score+=n;
        return score;
    }

    ones = function(d1, d2, d3, d4, d5) {
        return nValueScore(d1, d2, d3, d4, d5, 1);
    }

   twos = function(d1, d2, d3, d4, d5) {
        return nValueScore(d1, d2, d3, d4, d5, 2);
    }

    threes = function(d1, d2, d3, d4, d5) {
        return nValueScore(d1, d2, d3, d4, d5, 3);
    }

    fours = function(d1, d2, d3, d4, d5) {
        return nValueScore(d1, d2, d3, d4, d5, 4);
    }

    fives = function(d1, d2, d3, d4, d5) {
        return nValueScore(d1, d2, d3, d4, d5, 5);
    }

    sixes = function(d1, d2, d3, d4, d5) {
        return nValueScore(d1, d2, d3, d4, d5, 6);
    }

    yatzy = function() {
        var diceCounts = [0, 0, 0, 0, 0, 0];
        for (var i = 0; i != arguments.length; ++i) {
            var dice = arguments[i];
            diceCounts[dice-1]++;
        }
        for (i = 0; i < 6; i++) {
            if (diceCounts[i] == 5)
                return 50;
        }
        return 0;
    }

    populateDiceCounts = function(d1, d2, d3, d4, d5) {
        var diceCounts = [0, 0, 0, 0, 0, 0];
        diceCounts[d1-1]++;
        diceCounts[d2-1]++;
        diceCounts[d3-1]++;
        diceCounts[d4-1]++;
        diceCounts[d5-1]++;
        return diceCounts;
    }

    score_pair = function(d1, d2, d3, d4, d5) {
        var diceCounts = populateDiceCounts(d1, d2, d3, d4, d5);
        var index;
        for (index = 0; index != 6; index++)
            if (diceCounts[6-index-1] >= 2)
                return (6-index)*2;
        return 0;
    }

    two_pair = function(d1, d2, d3, d4, d5) {
        var diceCounts = populateDiceCounts(d1, d2, d3, d4, d5);
        var numberOfPairs = 0;
        var score = 0;
        for (i = 0; i < 6; i += 1)
            if (diceCounts[6-i-1] >= 2) {
                numberOfPairs++;
                score += (6-i);
            }
        if (numberOfPairs == 2)
            return score * 2;
        else
            return 0;
    }

    nOfAKindScore = function(d1, d2, d3, d4, d5, n) {
        var diceCounts = populateDiceCounts(d1, d2, d3, d4, d5);
        for (i = 0; i < 6; i++)
            if (diceCounts[i] >= n)
                return (i+1) * n;
        return 0;
    }

    threeOfAKind = function(d1, d2, d3, d4, d5) {
        return nOfAKindScore(d1, d2, d3, d4, d5, 3);
    }

    fourOfAKind = function(d1, d2, d3, d4, d5) {
        return nOfAKindScore(d1, d2, d3, d4, d5, 4);
    }

    smallStraight = function(d1, d2, d3, d4, d5) {
        var diceCounts = populateDiceCounts(d1, d2, d3, d4, d5);
        if (diceCounts[0] == 1 &&
            diceCounts[1] == 1 &&
            diceCounts[2] == 1 &&
            diceCounts[3] == 1 &&
            diceCounts[4] == 1)
            return 15;
        return 0;
    }

    largeStraight = function(d1, d2, d3, d4, d5) {
        var diceCounts = populateDiceCounts(d1, d2, d3, d4, d5);
        if (diceCounts[1] == 1 &&
            diceCounts[2] == 1 &&
            diceCounts[3] == 1 &&
            diceCounts[4] == 1 &&
            diceCounts[5] == 1)
            return 20;
        return 0;
    }

    fullHouse = function(d1, d2, d3, d4, d5) {
        var diceCounts = populateDiceCounts(d1, d2, d3, d4, d5);
        var pairFound = false;
        var pairValue = 0;
        var threeOfAKindFound = false;
        var threeOfAKindValue = 0;
        var index;

        for (index = 0; index < 6; index += 1)
            if (diceCounts[index] == 2) {
                pairFound = true;
                pairValue = index+1;
            }

        for (index = 0; index < 6; index += 1)
            if (diceCounts[index] == 3) {
                threeOfAKindFound = true;
                threeOfAKindValue = index+1;
            }

        if (pairFound && threeOfAKindFound)
            return pairValue * 2 + threeOfAKindValue * 3;
        else
            return 0;
    }
