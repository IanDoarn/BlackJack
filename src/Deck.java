import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Deck {
    private final int SHUFFLE_DEFAULT_N = 10;
    private final boolean SHUFFLE_DEFAULT_BOOL = true;
    
    private Stack<Card> cards = new Stack<>();

    public Stack<Card> getCards() {
        return cards;
    }

    /**
     * Create a card deck and automatically shuffle it
     */
    public Deck() {
        makeDeck(SHUFFLE_DEFAULT_BOOL);
    }

    /**
     * Create a card deck and allows use to disable initial shuffle
     */
    public Deck(boolean autoShuffle){
        makeDeck(autoShuffle);
    }

    /**
     * Shuffle the deck
     */
    public void shuffle() {
        _shuffle(SHUFFLE_DEFAULT_N, cards);
    }

    /**
     * Shuffle the deck
     *
     * @param n Number of times to shuffle the deck, DEFAULT 10
     */
    public void shuffle(int n) {
        _shuffle(n, cards);
    }

    /**
     * Private method to shuffle the deck
     *
     * @param n Number of times to shuffle the deck, DEFAULT 10
     */
    private void _shuffle(int n, List<?> collection) {
        for (int i = 0; i < n; i++) {
            Collections.shuffle(collection);
        }
    }

    /**
     * Build initial deck of card in suite order
     * of HEARTS, CLUBS, DIAMONDS, SPADES
     */
    private void makeDeck(boolean autoShuffle) {

        String[] suits = new String[]{
                "HEARTS",
                "CLUBS",
                "DIAMONDS",
                "SPADES"
        };

        for(String s: suits) {
            cards.push(new Card(s, "A", 1, true));
            cards.push(new Card(s, "2", 2, true));
            cards.push(new Card(s, "3", 3, true));
            cards.push(new Card(s, "4", 4, true));
            cards.push(new Card(s, "5", 5, true));
            cards.push(new Card(s, "6", 6, true));
            cards.push(new Card(s, "7", 7, true));
            cards.push(new Card(s, "8", 8, true));
            cards.push(new Card(s, "9", 9, true));
            cards.push(new Card(s, "10", 10, true));
            cards.push(new Card(s, "J", 10, true));
            cards.push(new Card(s, "Q", 10, true));
            cards.push(new Card(s, "K", 10, true));
        }

        if(autoShuffle) {
            _shuffle(SHUFFLE_DEFAULT_N, cards);
        }

    }

    /**
     * Draw a card from the deck
     *
     * @return Card
     */
    public Card draw() {
        if(cards.isEmpty())
            makeDeck(SHUFFLE_DEFAULT_BOOL);
        return cards.pop();
    }

    /**
     * Draw a card from the deck
     *
     * @param n Number of cards to draw
     * @return Card[]
     */
    public Card[] draw(int n) {
        if(cards.isEmpty())
            makeDeck(SHUFFLE_DEFAULT_BOOL);

        Card[] hand = new Card[n];
        for (int i = 0; i < n; i++)
            if(!cards.isEmpty())
                hand[i] = cards.pop();
            else {
                makeDeck(SHUFFLE_DEFAULT_BOOL);
                hand[i] = cards.pop();
            }

        return hand;
    }
}
