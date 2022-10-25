import java.util.ArrayList;

public class Player {

    private ArrayList<Card> board = new ArrayList<>();
    private ArrayList<Card> hand = new ArrayList<>();


    public void fillBoard (){
        board.add(new Card("img/testCards.png",0,0,50,50));
        board.add(new Card("img/testCards.png",60,0,50,50));
        board.add(new Card("img/testCards.png",120,0,50,50));
        board.add(new Card("img/testCards.png",180,0,50,50));
        board.add(new Card("img/testCards.png",240,0,50,50));
        board.add(new Card("img/testCards.png",300,0,50,50));
        board.add(new Card("img/testCards.png",360,0,50,50));
    }
    public void fillHand(){
        hand.add(new Card("img/testCards.png",240,0,50,50));
        hand.add(new Card("img/testCards.png",120,0,50,50));
        hand.add(new Card("img/testCards.png",240,0,50,50));
    }

    public ArrayList<Card> getBoard() {
        return board;
    }
    public ArrayList<Card> getHand() {return hand;}

    public void placeCards(double totalWidth, double totalHeight, Player enemy){
        int pasHorizontalBoardPlayer = (int)(totalWidth/(2*this.board.size()+1));
        int pasVertical = (int)(totalHeight/7);
        for (int i = 0; i<this.board.size(); i++) {
            this.board.get(i).getCardView().setX((2*i+1) * pasHorizontalBoardPlayer);
            this.board.get(i).getCardView().setY(4*pasVertical);
        }
        int pasHorizontalHandPlayer = (int)(totalWidth/(2*this.hand.size()+1));
        for (int i = 0; i<this.hand.size(); i++) {
            this.hand.get(i).getCardView().setX((2 * i + 1) * pasHorizontalHandPlayer);
            this.hand.get(i).getCardView().setY(6 * pasVertical);
        }
        int pasHorizontalBoardEnemy = (int)(totalWidth/(2*enemy.board.size()+1));
        for (int i = 0; i<enemy.board.size(); i++) {
            enemy.board.get(i).getCardView().setX((2 * i + 1) * pasHorizontalBoardEnemy);
            enemy.board.get(i).getCardView().setY(2 * pasVertical);
        }

    }



}
