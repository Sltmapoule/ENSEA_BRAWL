import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
    private final Image cardImg;
    private final int offsetX;
    private final int offsetY;
    private final int sizeX;
    private final int sizeY;
    private ImageView cardImgView;



    public Card(String filePath, int offsetX, int offsetY, int sizeX, int sizeY) {

        this.cardImg = new Image("file:"+filePath);
        cardImgView = new ImageView(cardImg);
        this.offsetX=offsetX;
        this.offsetY=offsetY;
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        cardImgView.setViewport(new Rectangle2D(offsetX,offsetY,sizeX,sizeY));

        /*cardImgView.setEffect(new Shadow(1, Color.BLACK));*/

    }


    public ImageView getCardView() {
        return cardImgView;
    }





}
