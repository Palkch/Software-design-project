import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a deck of playing cards with 52 cards in total, made up of 4 suits.
 */
public class Deck {

    private final List<Card> cards = new ArrayList<Card>();

    /**
     * Constructs a deck by creating all possible combinations of ranks and suits.
     */
    Deck() {
        createDeck();
    }

    private void createDeck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(r, s));
            }
        }
    }

    /**
     * Shuffles the deck to randomize the card order.
     */
    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    /**
     * Retrieves the list of cards in the deck.
     *
     * @return List of cards in the deck.
     */
    public List<Card> getCards() {
        return this.cards;
    }

    /**
     * Gets the number of cards left in the deck.
     *
     * @return Number of cards remaining in the deck.
     */
    public int getCardsCount() {
        return this.cards.size();
    }

    /**
     * Deals a card from the top of the deck, removing it from the deck.
     *
     * @return The card from the top of the deck.
     * @throws IllegalStateException if no more cards are left.
     */
    public Card dealCard() {
        if (this.cards.isEmpty()) {
            throw new IllegalStateException("No more cards left in the deck.");
        }
        return this.cards.remove(this.cards.size() - 1);
    }

    /**
     * Adds a card to the bottom of the deck.
     *
     * @param c The card to be added to the bottom of the deck.
     */
    public void addCard(Card c) {
        this.cards.add(0, c);
    }

    /**
     * Provides a string representation of all the cards in the deck.
     *
     * @return A string containing all the cards in order.
     */
    @Override
    public String toString() {
        return this.cards.toString();
    }
}
