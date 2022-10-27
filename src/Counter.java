import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.Clock;

public class Counter {
    private final Clock clock =Clock.systemDefaultZone();
    private int time1 = (int)clock.millis()/1000;
    private int time2;
    private Boolean bool = false;
    private final TextField time = new TextField();


    public Counter(){

    }


    public void update(double width,double height){
        time2 = (int)clock.millis()/1000;
        if ( time2-time1 == 10){ //ici pour régler le temps de chaque scène
            bool = true;
        }
        time.setText(String.valueOf(10-(time2-time1)));

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

    public TextField getTime() {
        return time;
    }
}
