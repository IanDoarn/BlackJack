public class Game {

    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.shuffle();

        for(Card c : deck.draw(2)) {
            c.setHidden(false);
            System.out.println(c);
        }
    }

}
