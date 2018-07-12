/**
 * Card class
 *
 * Represents a card from a deck
 */
public class Card implements Comparable {

    private String suit;
    private String rank;
    private String symbol;
    private int value;
    private boolean hidden;

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public boolean getHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    Card(String suit, String rank, int value, boolean hidden) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.hidden = hidden;

        symbol = getSuitSymbol(suit);
    }

    private String getSuitSymbol(String suit) {
        switch(suit.toUpperCase()) {
            case "SPADES": return "♠";
            case "DIAMONDS": return "♦";
            case "HEARTS": return "♥";
            case "CLUBS": return "♣";
            default: return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if(!hidden) {
            if(!rank.equals("10")) {
                sb.append("┌─────────┐\n");
                sb.append(String.format("│%s       │\n", rank));
                sb.append("│        │\n");
                sb.append("│        │\n");
                sb.append(String.format("│   %s    │\n", symbol));
                sb.append("│        │\n");
                sb.append("│        │\n");
                sb.append(String.format("│       %s│\n", rank));
                sb.append("└─────────┘\n");
            }
            else {
                sb.append("┌─────────┐\n");
                sb.append(String.format("│%s      │\n", rank));
                sb.append("│        │\n");
                sb.append("│        │\n");
                sb.append(String.format("│   %s    │\n", symbol));
                sb.append("│        │\n");
                sb.append("│        │\n");
                sb.append(String.format("│      %s│\n", rank));
                sb.append("└─────────┘\n");
            }
            return sb.toString();
        }
        else {
            sb.append("┌─────────┐\n");

            for(int i = 0; i < 7; i++) {
            sb.append("│########│\n");
            }

            sb.append("└─────────┘\n");

            return sb.toString();
        }


    }

    @Override
    public int compareTo(Object o) {
        if(((Card) o).getValue() > this.value)
            return -1;
        else if(((Card) o).getValue() == this.value)
            return 0;
        else
            return 1;
    }
}
