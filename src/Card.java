import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
    private final ImageView cardImgView;



    public Card(String filePath, int offsetX, int offsetY, int sizeX, int sizeY) {

        Image cardImg = new Image("file:" + filePath);
        cardImgView = new ImageView(cardImg);
        cardImgView.setViewport(new Rectangle2D(offsetX,offsetY,sizeX,sizeY));

        /*cardImgView.setEffect(new Shadow(1, Color.BLACK));*/

    }


    public ImageView getCardView() {
        return cardImgView;
    }






}
