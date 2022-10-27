import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Shop {

    Player shop = new Player();
    Player player = new Player();
    private final Pane pane = new Pane();
    Button fight = new Button("Passer au combat");
    Button lose = new Button("Lose");
    private String output;
    private final Counter timerShop = new Counter();

    public Shop(){
        pane.getChildren().add(fight);
        pane.getChildren().add(lose);
        pane.getChildren().add(timerShop.getTime());
        fight.setVisible(true);
        fight.setOnMouseClicked(mouseEvent -> output = "PLAY_FIGHT");
        lose.setVisible(true);
        lose.setOnMouseClicked(mouseEvent -> output = "LOST");
        shop.fillBoard();
        player.fillBoard();
        player.fillHand();
        timerShop.getTime().setFont(new Font("Comic sans MS",20));
        timerShop.getTime().setPrefSize(45,20);
        timerShop.getTime().setEditable(false);

    }

    public void update(double width, double height, State state){
        if (timerShop.getBool() && state==State.PLAY_SHOP){this.output = "PLAY_FIGHT";}
        lose.setTranslateX(10);
        lose.setTranslateY(10);
        fight.setTranslateX((width- fight.getWidth())/2);
        fight.setTranslateY((height-fight.getHeight())/2);
        timerShop.getTime().setTranslateX(width-timerShop.getTime().getWidth()-15);
        timerShop.getTime().setTranslateY(height-timerShop.getTime().getHeight()-39);


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

    public Counter getTimerShop() {
        return timerShop;
    }
}
