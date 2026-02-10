package War;

// deck class to put all 52 cards of a deck
class Deck {
    // create a deck of cards
    Card cards[] = new Card[52];
    {
        int i;
        // create Spade suit
        for (i = 0; i < 9; i++) {
            cards[i] = new Card("Spade", Integer.toString(i+2), i+1);
        }
        cards[i] = new Card("Spade", "Jack", 10);
        i++;
        cards[i] = new Card("Spade", "Queen", 11);
        i++;
        cards[i] = new Card("Spade", "King", 12);
        i++;
        cards[i] = new Card("Spade", "Ace", 13);

        // create Club suit
        for (i = 0; i < 9; i++) {
            cards[i+13] = new Card("Club", Integer.toString(i+2), i+1);
        }
        cards[i+13] = new Card("Club", "Jack", 10);
        i++;
        cards[i+13] = new Card("Club", "Queen", 11);
        i++;
        cards[i+13] = new Card("Club", "King", 12);
        i++;
        cards[i+13] = new Card("Club", "Ace", 13);

        // create Heart suit
        for (i = 0; i < 9; i++) {
            cards[i+26] = new Card("Heart", Integer.toString(i+2), i+1);
        }
        cards[i+26] = new Card("Heart", "Jack", 10);
        i++;
        cards[i+26] = new Card("Heart", "Queen", 11);
        i++;
        cards[i+26] = new Card("Heart", "King", 12);
        i++;
        cards[i+26] = new Card("Heart", "Ace", 13);

        // create Diamond suit
        for (i = 0; i < 9; i++) {
            cards[i+39] = new Card("Diamond", Integer.toString(i+2), i+1);
        }
        cards[i+39] = new Card("Diamond", "Jack", 10);
        i++;
        cards[i+39] = new Card("Diamond", "Queen", 11);
        i++;
        cards[i+39] = new Card("Diamond", "King", 12);
        i++;
        cards[i+39] = new Card("Diamond", "Ace", 13);
    }

    // shuffle method
    void shuffle() {
        for (int i = cards.length - 1; i > 0; i--) {

            int j = (int)(Math.random() * (i + 1));

            // swap cards[i] and cards[j]
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    // show deck method
    void showDeck() {
        System.out.println("Showing deck");
        for (int i = 0; i < cards.length; i++) {
            cards[i].printCard();
        }
    }
}