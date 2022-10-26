import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Welcome {
    private final Pane pane = new Pane();
    private final Button start = new Button("Start");
    private String output;

    public Welcome(){
        pane.getChildren().add(start);
        start.setVisible(true);
        start.setOnMouseClicked(mouseEvent -> output = "PLAY_SHOP");
    }

    public void update(double width, double height){
        start.setTranslateX((width- start.getWidth())/2);
        start.setTranslateY((height-start.getHeight())/2);

    }

    public void clear(){
        output = "";
    }

    public Pane getWelcome() {
        return pane;
    }

    public String getOutput() {
        return output;
    }


}
