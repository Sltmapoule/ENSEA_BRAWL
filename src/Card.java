import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
    private final ImageView cardImgView;
    private boolean bool = false ;
    private final Button button = new Button("Buy");
    private int action = 0;
    private boolean newBool = false;



    public Card(String filePath, int offsetX, int offsetY, int sizeX, int sizeY) {
        button.setVisible(false);
        Image cardImg = new Image("file:" + filePath);
        cardImgView = new ImageView(cardImg);
        cardImgView.setViewport(new Rectangle2D(offsetX,offsetY,sizeX,sizeY));
        cardImgView.setOnMouseClicked(mouseEvent -> {
            newBool = true;
            bool = !bool;
        });

        button.setOnMouseClicked(mouseEvent -> action += 1);

    }


    public ImageView getCardView() {
        return cardImgView;
    }

    public boolean isBool() {
        return bool;
    }

    public void clear() {
        this.bool = false;
        this.cardImgView.setEffect(null);
        button.setVisible(false);
    }

    public Button getButton() {
        return button;
    }

    public int getAction() {
        return action;
    }

    public boolean isNewBool() {
        return newBool;
    }

    public void setNewBool(boolean newBool) {
        this.newBool = newBool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
