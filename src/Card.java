import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Card {
    private final ImageView cardImgView;
    private boolean bool = false ;
    private final Button button = new Button("Acheter");
    private int action = 0;



    public Card(String filePath, int offsetX, int offsetY, int sizeX, int sizeY) {
        button.setVisible(false);
        Image cardImg = new Image("file:" + filePath);
        cardImgView = new ImageView(cardImg);
        cardImgView.setViewport(new Rectangle2D(offsetX,offsetY,sizeX,sizeY));
        cardImgView.setOnMouseClicked(mouseEvent -> {
            if (bool) {
                cardImgView.setEffect(null);
                button.setVisible(false);
            } else {
                cardImgView.setEffect(new Shadow(1, Color.BLACK));
                button.setVisible(true);

            }

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
}
