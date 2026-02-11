package War;

// player class to save what cards a player has
class Player {
    String name;
    Card hand[] = new Card[52]; // max possible cards
    int cardCount = 0;

    // constructor
    public Player(String n) {
        name = n;
    }

    // adds card to player hand
    void addCard(Card c) {
        hand[cardCount] = c;
        cardCount++;
    }

    // plays top card from player hand
    Card playCard() {
        if (cardCount == 0) return null;

        Card top = hand[0];

        // shift cards left after playing
        for (int i = 0; i < cardCount - 1; i++) {
            hand[i] = hand[i + 1];
        }

        cardCount--;
        return top;
    }

    // returns number of cards left in player hands
    int cardsLeft() {
        return cardCount;
    }
}