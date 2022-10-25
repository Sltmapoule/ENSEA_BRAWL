import javafx.scene.layout.Pane;

import java.util.ArrayList;

enum State{WELCOME, PLAY_SHOP, PLAY_FIGHT, WIN, LOST};

public class GameEngine {
    private State state=State.WELCOME;
    public GameEngine(){

    }

    public State getState(){
        return state;
    }

    public void update(long time, ArrayList<String> input, Pane pane){
        System.out.println(state);
        switch (state){
            case WELCOME :
                if(!input.isEmpty())
                {   state = State.WELCOME;

                }
                break;
            case PLAY_SHOP :


                break;

        }
    }

}

