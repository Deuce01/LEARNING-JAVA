import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();
        List<Card> playerHand = new ArrayList<>();
        List<Card> dealerHand = new ArrayList<>();

        // Deal initial cards
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());

        // Player's turn
        while (true) {
            System.out.println("Your hand: " + playerHand);
            System.out.println("Dealer's hand: [" + dealerHand.get(0) + ", ??]");
            System.out.print("Hit or stand? (h/s): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("h")) {
                playerHand.add(deck.drawCard());
                if (getHandValue(playerHand) > 21) {
                    System.out.println("Busted! You lose.");
                    break;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        // Dealer's turn
        while (getHandValue(dealerHand) < 17) {
            dealerHand.add(deck.drawCard());
        }

        // Display hands
        System.out.println("Your hand: " + playerHand + " (" + getHandValue(playerHand) + ")");
        System.out.println("Dealer's hand: " + dealerHand + " (" + getHandValue(dealerHand) + ")");

        // Determine winner
        int playerValue = getHandValue(playerHand);
        int dealerValue = getHandValue(dealerHand);
        if (playerValue > 21 || (dealerValue <= 21 && dealerValue > playerValue)) {
            System.out.println("Dealer wins!");
        } else if (dealerValue > 21 || playerValue > dealerValue) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    private static int getHandValue(List<Card> hand) {
        int value = 0;
        int numAces = 0;
        for (Card card : hand) {
            if (card.getValue() == 1) {
                numAces++;
                value += 11;
            } else if (card.getValue() >= 10) {
                value += 10;
            } else {
                value += card.getValue();
            }
        }
        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }
        return value;
    }
}

class Card {
    private final String suit;
    private final int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        return values[value - 1] + " of " + suit;
    }
}

class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int value = 1; value <= 13; value++) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }
}
