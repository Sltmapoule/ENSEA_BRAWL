import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    Player player1 = new Player();
    Player player2 = new Player();
    double width;
    double height;
    Stage stage = new Stage();
    Group root = new Group();
    GameEngine gameEngine = new GameEngine();
    Welcome welcome = new Welcome();


    public Main(){
        Pane pane = new Pane(root);
        Scene theScene = new Scene(pane);
        stage.setTitle("ENSEA BRAWL !");
        stage.setScene(theScene);
        stage.show();
        /*stage.setScene(new Scene(welcome.getWelcome()));*/
        stage.setMaximized(true);

        player1.fillHand();
        player1.fillBoard();
        player2.fillBoard();
        player2.getBoard().remove(3);

    }


    public void start(Stage stage) throws Exception{at.start();}


    AnimationTimer at = new AnimationTimer() {
        @Override
        public void handle(long l) {
            width = stage.getWidth();
            height = stage.getHeight();
            player1.placeCards(width, height, player2);
            gameEngine.update(l,new ArrayList<String>(),welcome.getWelcome());
            welcome.update(width,height);
            render(l);
        }
    };

    public void render(long l){
        for (Card card: player1.getBoard()) {
            if  (!root.getChildren().contains(card.getCardView())){ root.getChildren().add(card.getCardView());}
        }
        for (Card card: player1.getHand()) {
            if (!root.getChildren().contains(card.getCardView())){ root.getChildren().add(card.getCardView());}
        }
        for (Card card: player2.getBoard()) {
            if (!root.getChildren().contains(card.getCardView())){ root.getChildren().add(card.getCardView());}
        }


    }



}