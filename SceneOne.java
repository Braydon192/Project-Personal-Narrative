import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

  private String[][] images = {
    {"download-(16).jpeg", "download-(14).jpeg"},
    {"download-(15).jpeg", "download-(13).jpeg"}
  };

  public void drawScene() {

    int filterIndex = 0;

    for (int r = 0; r < images.length; r++) {
      for (int c = 0; c < images[0].length; c++) {

        ImageFilter img = new ImageFilter(images[r][c]);

        // Show original image
        clear("blue");
        drawText("Games I played", 120, 30);
        drawImage(img, 120, 100, 150);
        pause(1);

        // Apply filter after showing original
        if (filterIndex == 0){ 
          img.pixelate(12);
        }else if (filterIndex == 1){
          img.grayscale();
        }else if (filterIndex == 2){
          img.invert();
        }else if (filterIndex == 3){
          img.brighten(40);
        }

        // Show filtered image
        clear("purple");
        drawText("Games I played", 120, 30);
        drawImage(img, 120, 100, 150);
        pause(1);

        // Clear before next image
        clear("pink");

        filterIndex++;
      }
    }
  }
}
