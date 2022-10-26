import java.time.Clock;

public class Counter {
    private final Clock clock =Clock.systemDefaultZone();
    private int time1 = (int)clock.millis()/1000;
    private int time2;
    private Boolean bool = false;


    public void update(){
        time2 = (int)clock.millis()/1000;
        if ( time2-time1 == 1){ //ici pour régler le temps de chaque scène
            bool = true;
        }
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }
    public void clear(){
        time1 = (int)clock.millis()/1000;
        time2 = 0;
        bool = false;
    }
}
