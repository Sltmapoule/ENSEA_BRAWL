import javafx.scene.effect.Shadow;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Player {

    private final ArrayList<Card> board = new ArrayList<>();
    private final ArrayList<Card> hand = new ArrayList<>();


    public void fillBoard() {
        board.add(new Card("img/testCards.png", 0, 0, 50, 50));
        board.add(new Card("img/testCards.png", 60, 0, 50, 50));
        board.add(new Card("img/testCards.png", 120, 0, 50, 50));
        board.add(new Card("img/testCards.png", 180, 0, 50, 50));
        board.add(new Card("img/testCards.png", 240, 0, 50, 50));
        board.add(new Card("img/testCards.png", 300, 0, 50, 50));
        board.add(new Card("img/testCards.png", 360, 0, 50, 50));
    }

    public void fillHand() {
        hand.add(new Card("img/testCards.png", 240, 0, 50, 50));
        hand.add(new Card("img/testCards.png", 120, 0, 50, 50));
        hand.add(new Card("img/testCards.png", 240, 0, 50, 50));
    }


    public ArrayList<Card> getBoard() {
        return board;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void placeCards(double totalWidth, double totalHeight, ArrayList<Card> enemy, boolean shopPhase) {
        int pasHorizontalBoardPlayer = (int) (totalWidth / (2 * this.board.size() + 1));
        int pasVertical = (int) (totalHeight / 7);
        for (int i = 0; i < this.board.size(); i++) {
            this.board.get(i).getCardView().setX((2 * i + 1) * pasHorizontalBoardPlayer);
            this.board.get(i).getCardView().setY(4 * pasVertical);
            this.board.get(i).getButton().setTranslateX((2 * i + 1) * pasHorizontalBoardPlayer);
            this.board.get(i).getButton().setTranslateY(4 * pasVertical + 60);
        }
        int pasHorizontalHandPlayer = (int) (totalWidth / (2 * this.hand.size() + 1));
        for (int i = 0; i < this.hand.size(); i++) {
            this.hand.get(i).getCardView().setX((2 * i + 1) * pasHorizontalHandPlayer);
            this.hand.get(i).getCardView().setY(6 * pasVertical);
            this.hand.get(i).getButton().setTranslateX((2 * i + 1) * pasHorizontalHandPlayer);
            this.hand.get(i).getButton().setTranslateY(6 * pasVertical + 60);
        }
        int pasHorizontalBoardEnemy = (int) (totalWidth / (2 * enemy.size() + 1));
        for (int i = 0; i < enemy.size(); i++) {
            enemy.get(i).getCardView().setX((2 * i + 1) * pasHorizontalBoardEnemy);
            enemy.get(i).getCardView().setY(2 * pasVertical);
            enemy.get(i).getButton().setTranslateX((2 * i + 1) * pasHorizontalBoardEnemy);
            enemy.get(i).getButton().setTranslateY(2 * pasVertical + 60);
        }

        if (shopPhase) {
            for (int i = 0; i < this.board.size(); i++) {
                for (int j = i + 1; j < this.board.size(); j++)
                    if (this.board.get(i).isBool() && this.board.get(j).isBool()) {
                        Card cardTampon = this.board.get(i);
                        this.board.set(i, this.board.get(j));
                        this.board.set(j, cardTampon);
                        this.board.get(i).clear();
                        this.board.get(i).setNewBool(false);
                        this.board.get(j).clear();
                        this.board.get(j).setNewBool(false);
                    }
            }

            for (Card card : enemy) {
                if (card.isBool()) {
                    card.getButton().setVisible(true);
                    card.getCardView().setEffect(new Shadow(1, Color.BLACK));
                    card.getButton().setText("Buy");
                }
            }
            for (Card card : this.hand) {
                if (card.isBool()) {
                    card.getButton().setVisible(true);
                    card.getCardView().setEffect(new Shadow(1, Color.BLACK));

                    card.getButton().setText("Put");
                }
            }
            for (Card card : this.board) {
                if (card.isBool()) {
                    card.getButton().setVisible(true);
                    card.getCardView().setEffect(new Shadow(1, Color.BLACK));
                    card.getButton().setText("Sell");
                }
            }

            ArrayList<Card> tamp = new ArrayList<>();
            tamp.addAll(this.hand);
            tamp.addAll(this.board);
            tamp.addAll(enemy);
            for ( Card card : tamp){
                if (card.isNewBool()){
                    for (Card card0 : enemy) {
                        card0.clear();
                    }
                    for (Card card0 : this.hand) {
                        card0.clear();
                    }
                    for (Card card0 : this.board) {
                        card0.clear();
                    }
                    card.setNewBool(false);
                    card.setBool(true);
                }

            }

        }

    }

}


