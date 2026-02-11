import org.code.theater.*;
import org.code.media.*;

public class ImagePlus extends Image {

  private Pixel[][] pixels;

  public ImagePlus(String filename) {
    super(filename);
    pixels = getPixelsFromImage();
  }

  public Pixel[][] getImagePixels() {
    return pixels;
  }

  private Pixel[][] getPixelsFromImage() {
    Pixel[][] temp = new Pixel[getHeight()][getWidth()];

    for (int r = 0; r < temp.length; r++) {
      for (int c = 0; c < temp[0].length; c++) {
        temp[r][c] = getPixel(c, r);
      }
    }
    return temp;
  }
}
