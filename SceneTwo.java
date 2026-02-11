import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  private String[][] images = {
    {"download-(17).jpeg", "download-(18).jpeg"},
    {"download-(19).jpeg", "images-(2).jpeg"}
  };

  public void drawScene() {

    int filterIndex = 0;

    for (int r = 0; r < images.length; r++) {
      for (int c = 0; c < images[0].length; c++) {

        ImageFilter img = new ImageFilter(images[r][c]);

        // Show original
        clear("red");
        drawText("My main charactor", 120, 30);
        drawImage(img, 120, 100, 150);
        pause(1);

        // Apply filter
        if (filterIndex == 0){
          img.pixelate(12);
        }else if (filterIndex == 1){
          img.grayscale();
        }else if (filterIndex == 2){
          img.invert();
        }else if (filterIndex == 3){ 
          img.brighten(40);
        }

          
        // Show filtered
        clear("yellow");
        drawText("My main charactor", 120, 30);
        drawImage(img, 120, 100, 150);
        pause(1);

        clear("yellow");

        filterIndex++;
      }
    }
  }
}


