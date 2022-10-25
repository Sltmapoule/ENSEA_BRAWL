import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    Player player1 = new Player();
    Player player2 = new Player();
    double width;
    double height;
    Stage stage = new Stage();
    Group root = new Group();
    GameEngine gameEngine = new GameEngine();
    Welcome welcome = new Welcome();
    Scene welcomeScene = new Scene(welcome.getWelcome());
    Shop shop = new Shop();
    Scene shopScene = new Scene(shop.getShop());



    public Main(){
        stage.setTitle("ENSEA BRAWL !");
        stage.show();
        player1.fillHand();
        player1.fillBoard();
        player2.fillBoard();
        player2.getBoard().remove(3);


    }


    public void start(Stage stage) throws Exception{
        at.start();
    }


    AnimationTimer at = new AnimationTimer() {
        @Override
        public void handle(long l) {
            width = stage.getWidth();
            height = stage.getHeight();
            player1.placeCards(width, height, player2);
            gameEngine.update(l,welcome.output);
            welcome.update(width,height);
            shop.update(width,height);
            render(l);
        }
    };

    public void render(long l){

        switch (gameEngine.getState()) {
            case WELCOME:
                if (stage.getScene() != welcomeScene)
                {
                    stage.setWidth(300);
                    stage.setHeight(800);
                    stage.centerOnScreen();
                    stage.setScene(welcomeScene);

                }
                break;
            case PLAY_SHOP:
                if (stage.getScene() != shopScene)
                {
                    stage.setMaximized(true);
                    stage.setScene(shopScene);

                }
                break;
        }



    }



}