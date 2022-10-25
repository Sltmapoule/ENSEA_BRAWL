import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Shop {

    Player shop = new Player();
    Player player = new Player();
    private final Pane pane = new Pane();
    Button fight = new Button("Passer au combat");
    Button lose = new Button("Lose");
    private String output;

    public Shop(){
        pane.getChildren().add(fight);
        pane.getChildren().add(lose);
        fight.setVisible(true);
        fight.setOnMouseClicked(mouseEvent -> output = "PLAY_FIGHT");
        lose.setVisible(true);
        lose.setOnMouseClicked(mouseEvent -> output = "LOST");
        shop.fillBoard();
        player.fillBoard();
        player.fillHand();
    }

    public void update(double width,double height){
        lose.setTranslateX(10);
        lose.setTranslateY(10);
        fight.setTranslateX((width- fight.getWidth())/2);
        fight.setTranslateY((height-fight.getHeight())/2);
        for (Card card: shop.getBoard()) {
            if  (!pane.getChildren().contains(card.getCardView())){ pane.getChildren().add(card.getCardView());}
        }
        for (Card card: player.getBoard()) {
            if  (!pane.getChildren().contains(card.getCardView())){ pane.getChildren().add(card.getCardView());}
        }
        for (Card card: player.getHand()) {
            if (!pane.getChildren().contains(card.getCardView())){ pane.getChildren().add(card.getCardView());}
        }
        player.placeCards(width,height,shop);

    }

    public void clear(){
        output = "";
    }

    public Pane getShop() {
        return pane;
    }

    public String getOutput() {
        return output;
    }
}
