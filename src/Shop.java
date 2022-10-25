import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Shop {

    Player shop = new Player();
    Player player = new Player();
    Pane pane = new Pane();
    Button fight = new Button("Passer au combat");
    String output;

    public Shop(){
        pane.getChildren().add(fight);
        fight.setVisible(true);
        fight.setOnMouseClicked(mouseEvent -> output = "PLAY_FIGHT");
        shop.fillBoard();
        player.fillBoard();
        player.fillHand();
    }

    public void update(double width,double height){
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

    public Pane getShop() {
        return pane;
    }

}
