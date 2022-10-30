import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.ArrayList;


public class Shop {

    private final ArrayList<Card> shop = new ArrayList<>();
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
        player.fillBoard();
        player.fillHand();
        timerShop.getTime().setFont(new Font("Comic sans MS",20));
        timerShop.getTime().setPrefSize(45,20);
        timerShop.getTime().setEditable(false);
        this.shop.add(new Card("img/testCards.png",0,0,50,50));
        shop.add(new Card("img/testCards.png",60,0,50,50));
        shop.add(new Card("img/testCards.png",120,0,50,50));
        shop.add(new Card("img/testCards.png",180,0,50,50));
        shop.add(new Card("img/testCards.png",240,0,50,50));
        shop.add(new Card("img/testCards.png",300,0,50,50));
        shop.add(new Card("img/testCards.png",360,0,50,50));

    }

    public void update(double width, double height, State state){
        if (timerShop.getBool() && state==State.PLAY_SHOP){this.output = "PLAY_FIGHT";}
        lose.setTranslateX(10);
        lose.setTranslateY(10);
        fight.setTranslateX((width- fight.getWidth())/2);
        fight.setTranslateY((height-fight.getHeight())/2);
        timerShop.getTime().setTranslateX(width-timerShop.getTime().getWidth()-15);
        timerShop.getTime().setTranslateY(height-timerShop.getTime().getHeight()-39);

        for (int i = 0; i < shop.size(); i++) {
            if (shop.get(i).isBoolBuy()){
                shop.get(i).clear();
                player.getHand().add(shop.get(i));
                shop.remove(i);

            }
        }

        for (Card card: shop) {
            if  (!pane.getChildren().contains(card.getCardView())){
                pane.getChildren().add(card.getCardView());
                pane.getChildren().add(card.getBuy());
            }
        }
        for (Card card: player.getBoard()) {
            if  (!pane.getChildren().contains(card.getCardView())){ pane.getChildren().add(card.getCardView());}
        }
        for (Card card: player.getHand()) {
            if (!pane.getChildren().contains(card.getCardView())){ pane.getChildren().add(card.getCardView());}
        }
        player.placeCards(width,height,shop,true);

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
