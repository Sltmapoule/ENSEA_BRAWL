import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    double width;
    double height;
    Stage stage = new Stage();
    GameEngine gameEngine = new GameEngine();
    Welcome welcome = new Welcome();
    Scene welcomeScene = new Scene(welcome.getWelcome());
    Shop shop = new Shop();
    Scene shopScene = new Scene(shop.getShop());
    Fight fight = new Fight();
    Scene fightScene = new Scene(fight.getFight());

    public Main(){
        stage.setTitle("ENSEA BRAWL !");
        stage.show();
    }


    public void start(Stage stage) throws Exception{
        at.start();
    }


    AnimationTimer at = new AnimationTimer() {
        @Override
        public void handle(long l) {
            width = stage.getWidth();
            height = stage.getHeight();
            gameEngine.update(l,welcome.getOutput());
            gameEngine.update(l,shop.getOutput());
            gameEngine.update(l,fight.getOutput());
            welcome.clear();
            shop.clear();
            fight.clear();
            welcome.update(width,height);
            shop.update(width,height);
            fight.update(width,height);
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
            case PLAY_FIGHT:
                if (stage.getScene() != fightScene)
                {
                    stage.setMaximized(true);
                    stage.setScene(fightScene);

                }
                break;
        }



    }



}