import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Win {
    private final Pane pane = new Pane();
    private final Button welcome = new Button("Welcome");
    private String output;

    public Win(){
        pane.getChildren().add(welcome);
        welcome.setVisible(true);
        welcome.setOnMouseClicked(mouseEvent -> output = "WELCOME");
    }

    public void update(double width,double height){
        welcome.setTranslateX((width- welcome.getWidth())/2);
        welcome.setTranslateY((height-welcome.getHeight())/2);

    }

    public void clear(){
        output = "";
    }

    public Pane getWin() {
        return pane;
    }

    public String getOutput() {
        return output;
    }


}
