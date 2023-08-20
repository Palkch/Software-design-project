/**
 * Representation of a single playing card (from a standard 52 card deck).
 * A card consists of a suit value, a rank value, and card value. Once instantiated, the
 * Card object cannot change.
 */
public class Card implements Comparable<Card> {

    private final Rank rank;
    private final Suit suit;
    private final String card;

    /**
     * Constructs a Card object with a given rank and suit.
     *
     * @param rank The rank of the card.
     * @param suit The suit of the card.
     */
    Card(Rank rank, Suit suit) {
        if (rank == null || suit == null) {
            throw new NullPointerException();
        }
        this.rank = rank;
        this.suit = suit;
        this.card = String.format("%s%s", rank.toString(), suit.getSymbol());
    }

    /**
     * Gets the suit of the card.
     *
     * @return Enum value representing the suit.
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * Gets the shorthand representation of the suit.
     *
     * @return Shorthand symbol of the suit.
     */
    public String getSuitLetter() {
        return this.suit.getSymbol();
    }

    /**
     * Gets the rank of the card.
     *
     * @return Enum value representing the rank.
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Gets the shorthand representation of the rank.
     *
     * @return Shorthand symbol of the rank.
     */
    public String getRankLetter() {
        return this.rank.toString();
    }

    /**
     * Gets the points associated with the card.
     *
     * @return Integer value indicating the card's point value.
     */
    public Integer getCardPoints() {
        return this.rank.getPointValue();
    }

    /**
     * Gets the shorthand representation of the card.
     *
     * @return Shorthand representation of the card.
     */
    public String getCard() {
        return this.card;
    }

    /**
     * Compares two cards based on their point values.
     *
     * @param other The card to compare to.
     * @return 1 if this card is greater, -1 if lesser, 0 if equal.
     */
    public int compareTo(Card other) {
        return this.getCardPoints().compareTo(other.getCardPoints());
    }

    /**
     * Checks if two cards have the same suit.
     *
     * @param other The card to compare to.
     * @return True if the suits are the same, otherwise false.
     */
    public boolean isSameSuit(Card other) {
        return this.suit.equals(other.suit);
    }

    /**
     * Checks if two cards have the same rank.
     *
     * @param other The card to compare to.
     * @return True if the ranks are the same, otherwise false.
     */
    public boolean isSameRank(Card other) {
        return this.rank.equals(other.rank);
    }

    /**
     * Compares two cards for equality.
     *
     * @param obj The object to compare to.
     * @return True if the cards are equal, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Card.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Card other = (Card) obj;
        return this.suit == other.suit && this.rank == other.rank;
    }

    /**
     * Returns a human-readable representation of the card.
     *
     * @return Full written name of the card.
     */
    @Override
    public String toString() {
        return this.rank.getRankName() + " of " + this.suit.getSuitName();
    }

}
