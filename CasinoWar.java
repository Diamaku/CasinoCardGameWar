package War;
// Mario Castelo
// Casino War Card Game

// imports
import java.util.Scanner;

public class CasinoWar {
    // main method for output
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        // declare players
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Dealer");

        // welcome and instructions
        System.out.println("Welcome to WAR!");
        System.out.println("\nHow to play: ");
        System.out.println("- The goal is to be the first player to win all 52 cards.");
        System.out.println("- A deck of cards is shuffled and each half goes to each player face down.");
        System.out.println("- During each round, both players draw the top card and the player with the higher card takes both cards and puts them face down on the bottom of the stack.");
        System.out.println("- If both cards are equal, WAR begins!");
        System.out.println("- Each player draws one card face down and one card face up.");
        System.out.println("- The player with the higher face up card takes both piles.");
        System.out.println("- If the turned-up cards are again the same rank, repeat the process.");
        System.out.println("- The player with the higher card takes all the cards in the pile.");

        System.out.println("\nGetting deck...");
        // declare deck
        Deck deck = new Deck();

        // declare what player 1 and player 2 cards are
        Card p1Card, p2Card;

        System.out.println("\nShuffling deck...");
        // shuffle the deck
        deck.shuffle();

        System.out.println("\nGiving players cards...");
        // alternate giving players cards from the deck
        for(int i = 0; i < deck.cards.length; i++) {
            if(i % 2 == 0) { p1.addCard(deck.cards[i]); }
            else { p2.addCard(deck.cards[i]); }
        }

/* Old for loops giving players cards
        System.out.println("\nGiving " + p1.name + " cards...");
        // add half the deck to player 1
        for (int i = 0; i < 26; i++)
            p1.addCard(deck.cards[i]);

        System.out.println("\nGiving " + p2.name + " cards...");
        // add the other half of the deck to player 2
        for (int i = 0; i < 26; i++)
            p2.addCard(deck.cards[i+26]);
*/
        System.out.println("\nReady to play!");

        while (p1.cardsLeft() != 0 && p2.cardsLeft() != 0) {
            
            System.out.println("\nPress ENTER to play next round...");
            input.nextLine();  // waits for user input

            // play cards
            p1Card = p1.playCard();
            p2Card = p2.playCard();
            
            System.out.println("Cards played: ");
            System.out.println(p1.name + ": ");
            p1Card.printCard();
            System.out.println(p2.name + ": ");
            p2Card.printCard();
            
            if (p1Card.getValue() > p2Card.getValue()) { // if player 1 has the higher card
                System.out.println(p1.name + " wins round");
                p1.addCard(p1Card);
                p1.addCard(p2Card);
            }
            else if (p1Card.getValue() < p2Card.getValue()) { // if player 2 has the higher card
                System.out.println(p2.name + " wins round");
                p2.addCard(p1Card);
                p2.addCard(p2Card);
            }
            else { // if both cards are equal WAR
                System.out.println("WAR!");
                Card warPile[] = new Card[52];
                int warCount = 0;
            
                // add the tied cards
                warPile[warCount++] = p1Card;
                warPile[warCount++] = p2Card;
            
                boolean warResolved = false;
            
                while (!warResolved) {
                    // check if players have enough cards
                    if (p1.cardsLeft() < 2) {
                        System.out.println(p1.name + " ran out of cards during WAR");
                        System.out.println(p2.name + " wins the game!");
                        return;
                    }
                    else if (p2.cardsLeft() < 2) {
                        System.out.println(p2.name + " ran out of cards during WAR");
                        System.out.println(p1.name + " wins the game!");
                        return;
                    }

                    System.out.println("\nPress ENTER to play face down card...");
                    input.nextLine();
                
                    // each player puts 1 face down card
                    warPile[warCount++] = p1.playCard();
                    System.out.println(p1.name + " played a face down card");
                    warPile[warCount++] = p2.playCard();
                    System.out.println(p2.name + " played a face down card");
                
                    System.out.println("\nPress ENTER to play face up card...");
                    input.nextLine();

                    // each player plays one face-up card
                    Card newP1Card = p1.playCard();
                    Card newP2Card = p2.playCard();
                
                    warPile[warCount++] = newP1Card;
                    warPile[warCount++] = newP2Card;
                
                    System.out.println("WAR cards played:");
                    System.out.println(p1.name + ": ");
                    newP1Card.printCard();
                    System.out.println(p2.name + ": ");
                    newP2Card.printCard();
                
                    // compare
                    if (newP1Card.getValue() > newP2Card.getValue()) { // if player 1 has the higher card
                        System.out.println(p1.name + " wins round");
                        for (int i = 0; i < warCount; i++) {
                            p1.addCard(warPile[i]);
                        }
                    
                        warResolved = true;
                    }
                    else if (newP1Card.getValue() < newP2Card.getValue()) { // if player 2 has the higher card
                        System.out.println(p2.name + " wins round");
                        for (int i = 0; i < warCount; i++) {
                            p2.addCard(warPile[i]);
                        }
                    
                        warResolved = true;
                    }
                    else { // both cards are equal WAR continues
                        System.out.println("WAR continues");
                    }
                    
                    System.out.println("War pile: " + warCount);
                }
            }
            System.out.println(p1.name + " cards left: " + p1.cardsLeft());
            System.out.println(p2.name + " cards left: " + p2.cardsLeft());

            if (p1.cardsLeft() == 0) {
                System.out.println(p2.name + " wins the game!");
            }
            else if (p2.cardsLeft() == 0) {
                System.out.println(p1.name + " wins the game!");
            }
        }
    }
}
