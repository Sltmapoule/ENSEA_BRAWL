import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Card {
    private final ImageView cardImgView;
    private boolean bool = false ;
    private final Button buy = new Button("Acheter");
    private boolean boolBuy = false;




    public Card(String filePath, int offsetX, int offsetY, int sizeX, int sizeY) {
        buy.setVisible(false);
        Image cardImg = new Image("file:" + filePath);
        cardImgView = new ImageView(cardImg);
        cardImgView.setViewport(new Rectangle2D(offsetX,offsetY,sizeX,sizeY));
        cardImgView.setOnMouseClicked(mouseEvent -> {
            if (bool) {
                cardImgView.setEffect(null);
            } else {
                cardImgView.setEffect(new Shadow(1, Color.BLACK));
            }
            bool = !bool;
        });

        buy.setOnMouseClicked(mouseEvent -> boolBuy = true);

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
        buy.setVisible(false);
    }

    public void setBuy(){
        buy.setVisible(true);
    }

    public boolean isBoolBuy() {
        return boolBuy;
    }

    public Button getBuy() {
        return buy;
    }

}
