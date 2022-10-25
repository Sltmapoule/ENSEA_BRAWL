import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Welcome {
    Pane pane = new Pane();
    Button start = new Button("Start");
    String output = new String();

    public Welcome(){
        pane.getChildren().add(start);
        start.setVisible(true);
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                output = "PLAY_SHOP";
            }
        });
    }

    public void update(double width,double height){
        start.setTranslateX(width/2);
        start.setTranslateY(height/2);

    }

    public Pane getWelcome() {
        return pane;
    }
}
