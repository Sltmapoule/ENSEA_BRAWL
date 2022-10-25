import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Welcome {
    Pane pane = new Pane();
    Button start = new Button("Start");

    public Welcome(){
        pane.getChildren().add(start);
        start.setVisible(true);
    }

    public void update(double width,double height){
        start.setTranslateX(width/2);
        start.setTranslateY(height/2);
    }

    public Pane getWelcome() {
        return pane;
    }
}
