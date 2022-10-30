import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Fight {

    Player player2 = new Player();
    Player player = new Player();
    private final Pane pane = new Pane();
    Button win = new Button("Win");
    Button lose = new Button("Lose");
    Button shop = new Button("Shop");
    private String output;
    private final Counter timerFight = new Counter();

    public Fight(){
        pane.getChildren().add(win);
        pane.getChildren().add(lose);
        pane.getChildren().add(shop);
        pane.getChildren().add(timerFight.getTime());
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

    public void update(double width,double height,State state){
        if (timerFight.getBool() && state == State.PLAY_FIGHT){this.output = "PLAY_SHOP";}
        win.setTranslateX((2*width-win.getWidth())/5);
        win.setTranslateY((height-win.getHeight())/2);
        lose.setTranslateX((3*width-win.getWidth())/5);
        lose.setTranslateY((height-win.getHeight())/2);
        shop.setTranslateX((width- shop.getWidth())/2);
        shop.setTranslateY((height-shop.getHeight())/2);
        timerFight.getTime().setFont(new Font("Comic sans MS",20));
        timerFight.getTime().setPrefSize(45,20);
        timerFight.getTime().setEditable(false);
        timerFight.getTime().setTranslateX(width-timerFight.getTime().getWidth()-15);
        timerFight.getTime().setTranslateY(height-timerFight.getTime().getHeight()-39);

        for (Card card: player2.getBoard()) {
            if  (!pane.getChildren().contains(card.getCardView())){pane.getChildren().add(card.getCardView());}
        }
        for (Card card: player.getBoard()) {
            if  (!pane.getChildren().contains(card.getCardView())){pane.getChildren().add(card.getCardView());}
        }
        for (Card card: player.getHand()) {
            if (!pane.getChildren().contains(card.getCardView())){pane.getChildren().add(card.getCardView());}
        }
        player.placeCards(width,height,player2.getBoard(),false);

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

    public Counter getTimerFight() {
        return timerFight;
    }
}
