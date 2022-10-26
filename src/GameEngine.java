import java.util.Objects;

enum State{WELCOME, PLAY_SHOP, PLAY_FIGHT, WIN, LOST}

public class GameEngine {
    private State state=State.WELCOME;
    public GameEngine(){

    }

    public State getState(){
        return state;
    }

    public void update(String input){
        switch (state){
            case WELCOME :
                if(Objects.equals(input, "PLAY_SHOP"))
                { state = State.PLAY_SHOP;}
                break;
            case PLAY_SHOP :
                if (Objects.equals(input, "PLAY_FIGHT"))
                { state = State.PLAY_FIGHT;}
                if (Objects.equals(input, "LOST"))
                { state = State.LOST;}
                break;
            case PLAY_FIGHT:
                if(Objects.equals(input, "PLAY_SHOP"))
                { state = State.PLAY_SHOP;}
                if (Objects.equals(input, "WIN"))
                { state = State.WIN;}
                if (Objects.equals(input, "LOST"))
                { state = State.LOST;}
                break;
            case LOST:
            case WIN:
                if(Objects.equals(input, "WELCOME"))
                { state = State.WELCOME;}
                break;

        }
    }

}

