import javafx.scene.layout.Pane;

import java.util.ArrayList;

enum State{WELCOME, PLAY_SHOP, PLAY_FIGHT, WIN, LOST}

public class GameEngine {
    private State state=State.WELCOME;
    public GameEngine(){

    }

    public State getState(){
        return state;
    }

    public void update(long time,String input){
        System.out.println(state);
        switch (state){
            case WELCOME :
                if(input == "PLAY_SHOP")
                { state = State.PLAY_SHOP;}
                else { state = State.WELCOME;}
                break;
            case PLAY_SHOP :


                break;

        }
    }

}

