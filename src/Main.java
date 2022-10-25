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
    Win win = new Win();
    Scene winScene = new Scene(win.getWin());
    Lose lose = new Lose();
    Scene loseScene = new Scene(lose.getLose());

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
            gameEngine.update(welcome.getOutput());
            gameEngine.update(shop.getOutput());
            gameEngine.update(fight.getOutput());
            gameEngine.update(lose.getOutput());
            gameEngine.update(win.getOutput());
            welcome.clear();
            shop.clear();
            fight.clear();
            win.clear();
            lose.clear();
            welcome.update(width,height);
            shop.update(width,height);
            fight.update(width,height);
            win.update(width,height);
            lose.update(width,height);
            render();
        }
    };


    public void render(){

        switch (gameEngine.getState()) {
            case WELCOME:
                if (stage.getScene() != welcomeScene)
                {
                    stage.setWidth(300);
                    stage.setHeight(800);
                    stage.setMaximized(false);
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
            case WIN:
                if (stage.getScene() != winScene)
                {
                    stage.setWidth(500);
                    stage.setHeight(400);
                    stage.setMaximized(false);
                    stage.centerOnScreen();
                    stage.setScene(winScene);
                }
                break;
            case LOST:
                if (stage.getScene() != loseScene)
                {
                    stage.setWidth(500);
                    stage.setHeight(400);
                    stage.setMaximized(false);
                    stage.centerOnScreen();
                    stage.setScene(loseScene);
                }
                break;
        }
    }



}