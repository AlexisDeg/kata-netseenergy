var assert = require("assert");
var Yatzy = require("../lib/yatzy");


describe('Chance', function() {
    it('scores sum of all dice', function(){
        assert.equal(15, chance(2, 3, 4, 5, 1));
        assert.equal(16, chance(3, 3, 4, 5, 1));
    });
});

describe("Ones", function() {
    it("scores the sum of 1s", function() {
        assert.equal(1, ones(1,2,3,4,5));
        assert.equal(2, ones(1,2,1,4,5));
        assert.equal(0, ones(6,2,2,4,5));
        assert.equal(4, ones(1,2,1,1,1));
    });
});

describe("Twos", function() {
    it("scores the sum of 2s", function() {
        assert.equal(4, twos(1,2,3,2,6));
        assert.equal(10, twos(2,2,2,2,2));
    });
});

describe("Threes", function() {
    it("scores the sum of 3s", function() {
        assert.equal(6, threes(1,2,3,2,3));
        assert.equal(12, threes(2,3,3,3,3));
    });
});

describe("Fours", function() {
    it("scores the sum of 4s", function() {
        assert.equal(12, fours(4,4,4,5,5));
        assert.equal(8, fours(4,4,5,5,5));
        assert.equal(4, fours(4,5,5,5,5));
    });
});

describe("Fives", function() {
    it("scores the sum of fives", function() {
        assert.equal(10, fives(4,4,4,5,5));
        assert.equal(15, fives(4,4,5,5,5));
        assert.equal(20, fives(4,5,5,5,5));
    });
});

describe("Sixes", function() {
    it("scores the sum of sixes", function() {
        assert.equal(0, sixes(4,4,4,5,5));
        assert.equal(6, sixes(4,4,6,5,5));
        assert.equal(18, sixes(6,5,6,6,5));
    });
});


describe("One pair", function() {
    it("scoress the sum of the highest pair", function() {
        assert.equal(6, score_pair(3,4,3,5,6));
        assert.equal(10, score_pair(5,3,3,3,5));
        assert.equal(12, score_pair(5,3,6,6,5));
    });
});

describe("Two pair", function() {
    it("scores the sum of the two pairs", function() {
        assert.equal(16, two_pair(3,3,5,4,5));
        assert.equal(16, two_pair(3,3,5,5,5));
    });
});

describe("Three of a kind", function() {
    it("scores the sum of the three of the kind", function() {
        assert.equal(9, threeOfAKind(3,3,3,4,5));
        assert.equal(15, threeOfAKind(5,3,5,4,5));
        assert.equal(9, threeOfAKind(3,3,3,3,5));
    });
});

describe("Four of a kind", function() {
    it("scores the sum of the four of the kind", function() {
        assert.equal(12, fourOfAKind(3,3,3,3,5));
        assert.equal(20, fourOfAKind(5,5,5,4,5));
        assert.equal(12, fourOfAKind(3,3,3,3,3));
    });
});

describe("Yatzy", function() {
    it("scores 50", function() {
        assert.equal(50, yatzy(4,4,4,4,4));
        assert.equal(50, yatzy(6,6,6,6,6));
        assert.equal(0, yatzy(6,6,6,6,3));
    });
});

describe("Small straight", function() {
    it("scores 15", function() {
        assert.equal(15, smallStraight(1,2,3,4,5));
        assert.equal(15, smallStraight(2,3,4,5,1));
        assert.equal(0, smallStraight(1,2,2,4,5));
    });
});

describe("Large straight", function() {
    it("scores 20", function() {
        assert.equal(20, largeStraight(6,2,3,4,5));
        assert.equal(20, largeStraight(2,3,4,5,6));
        assert.equal(0, largeStraight(1,2,2,4,5));
    });
});

describe("Full house", function() {
    it("scores the sum of the three of a kind and the pair", function() {
        assert.equal(18, fullHouse(6,2,2,2,6));
        assert.equal(0, fullHouse(2,3,4,5,6));
    });
});
