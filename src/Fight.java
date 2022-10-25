import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Fight {

    Player player2 = new Player();
    Player player = new Player();
    private Pane pane = new Pane();
    Button win = new Button("Win");
    Button lose = new Button("Lose");
    Button shop = new Button("Shop");
    private String output;

    public Fight(){
        pane.getChildren().add(win);
        pane.getChildren().add(lose);
        pane.getChildren().add(shop);
        win.setVisible(true);
        win.setOnMouseClicked(mouseEvent -> output = "WIN");
        lose.setVisible(true);
        lose.setOnMouseClicked(mouseEvent -> output = "LOST");
        shop.setVisible(true);
        shop.setOnMouseClicked(mouseEvent -> output = "PLAY_SHOP");
        player2.fillBoard();
        player.fillBoard();
        player.fillHand();
    }

    public void update(double width,double height){
        win.setTranslateX((2*width-win.getWidth())/5);
        win.setTranslateY((height-win.getHeight())/2);
        lose.setTranslateX((3*width-win.getWidth())/5);
        lose.setTranslateY((height-win.getHeight())/2);
        shop.setTranslateX((width- shop.getWidth())/2);
        shop.setTranslateY((height-shop.getHeight())/2);
        for (Card card: player2.getBoard()) {
            if  (!pane.getChildren().contains(card.getCardView())){pane.getChildren().add(card.getCardView());}
        }
        for (Card card: player.getBoard()) {
            if  (!pane.getChildren().contains(card.getCardView())){pane.getChildren().add(card.getCardView());}
        }
        for (Card card: player.getHand()) {
            if (!pane.getChildren().contains(card.getCardView())){pane.getChildren().add(card.getCardView());}
        }
        player.placeCards(width,height,player2);

    }

    public void clear(){
        output = "";
    }

    public Pane getFight() {
        return pane;
    }

    public String getOutput() {
        return output;
    }
}
