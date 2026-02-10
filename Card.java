package War;

// card class to represent a single playing card
class Card {
    // instance variables
    String suit; 
    String rank;
    int value;

    // initialize instance variables
    public Card (String s, String r, int v) {
        suit = s;
        rank = r;
        value = v;
    }

    // access variables
    String getSuit() {
        return suit;
    }

    String getRank() {
        return rank;
    }

    int getValue() {
        return value;
    }

    // display card information
    void printCard() {
        System.out.println("Suit: " + suit);
        System.out.println("Rank: " + rank);
        System.out.println("Value: " + value);
        System.out.println();
    }
}