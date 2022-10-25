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
                if (input == "PLAY_FIGHT")
                { state = State.PLAY_FIGHT;}
                if (input == "LOST")
                { state = State.LOST;}
                else {state = State.PLAY_SHOP;}
                break;
            case PLAY_FIGHT:
                if(input == "PLAY_SHOP")
                { state = State.PLAY_SHOP;}
                if (input == "LOST")
                { state = State.LOST;}
                else {state = State.PLAY_FIGHT;}
                break;
            case LOST:
                if(input == "WELCOME")
                { state = State.WELCOME;}
                else {state = State.LOST;}
                break;
            case WIN:
                if(input == "WELCOME")
                { state = State.WELCOME;}
                else {state = State.WIN;}
                break;

        }
    }

}

