// Mario Castelo
// Casino War Card Game

// imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

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
}

class Player {
    String name;
    Card hand[] = new Card[52]; // max possible cards
    int cardCount = 0;

    public Player(String n) {
        name = n;
    }

    void addCard(Card c) {
        hand[cardCount] = c;
        cardCount++;
    }

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

    int cardsLeft() {
        return cardCount;
    }
}

public class CasinoWar implements ActionListener {

    CasinoWar () {
        // declare deck, player 1, and player 2
        Deck deck = new Deck();
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");

        // declare what player 1 and player 2 cards are
        Card p1Card, p2Card;

        // shuffle the deck
        deck.shuffle();

        // add half the deck to player 1
        for (int i = 0; i < 10; i++)
            p1.addCard(deck.cards[i]);

        // add the other half of the deck to player 2
        for (int i = 0; i < 10; i++)
            p2.addCard(deck.cards[i+26]);

        while (p1.cardsLeft() != 0 && p2.cardsLeft() != 0) {
            
            // play cards
            p1Card = p1.playCard();
            p2Card = p2.playCard();
            
            System.out.println("Cards played: ");
            
            p1Card.printCard();
            p2Card.printCard();
            
            if (p1Card.getValue() > p2Card.getValue()) { // if player 1 has the higher card
                System.out.println("Player 1 wins round");
                p1.addCard(p1Card);
                p1.addCard(p2Card);
            }
            else if (p1Card.getValue() < p2Card.getValue()) { // if player 2 has the higher card
                System.out.println("Player 2 wins round");
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
                    if (p1.cardsLeft() < 2 || p2.cardsLeft() < 2) {
                        System.out.println("A player ran out of cards during WAR!");
                        return;
                    }
                
                    // each player puts 1 face down card
                    warPile[warCount++] = p1.playCard();
                    warPile[warCount++] = p2.playCard();
                
                    // each player plays one face-up card
                    Card newP1Card = p1.playCard();
                    Card newP2Card = p2.playCard();
                
                    warPile[warCount++] = newP1Card;
                    warPile[warCount++] = newP2Card;
                
                    System.out.println("WAR cards played:");
                    newP1Card.printCard();
                    newP2Card.printCard();
                
                    // compare
                    if (newP1Card.getValue() > newP2Card.getValue()) { // if player 1 has the higher card
                        System.out.println("Player 1 wins round");
                        for (int i = 0; i < warCount; i++) {
                            p1.addCard(warPile[i]);
                        }
                    
                        warResolved = true;
                    }
                    else if (newP1Card.getValue() < newP2Card.getValue()) { // if player 2 has the higher card
                        System.out.println("Player 2 wins round");
                        for (int i = 0; i < warCount; i++) {
                            p2.addCard(warPile[i]);
                        }
                    
                        warResolved = true;
                    }
                    else { // both cards are equal WAR continues
                        System.out.println("WAR continues");
                    }
                }
            }
            System.out.println("Player 1 cards left: " + p1.cardsLeft());
            System.out.println("Player 2 cards left: " + p2.cardsLeft());
        }

/*
        // Create a new JFrame container.
        JFrame jfrm = new JFrame("War");

        // Specify FlowLayour for the layout manager.
        jfrm.setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(500, 350);
        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display the frame.
        jfrm.setVisible(true);
        */
    }

    public void actionPerformed(ActionEvent ae) {
        
    }

    // main method for output
    public static void main(String args[]) {

        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CasinoWar();
            }
        });
    }
}
