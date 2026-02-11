import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter(String filename) {
    super(filename);
  }

  public void grayscale() {
    Pixel[][] pixels = getImagePixels();
    for (Pixel[] row : pixels) {
      for (Pixel p : row) {
        int avg = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
        p.setRed(avg);
        p.setGreen(avg);
        p.setBlue(avg);
      }
    }
  }

  public void invert() {
    Pixel[][] pixels = getImagePixels();
    for (Pixel[] row : pixels) {
      for (Pixel p : row) {
        p.setRed(255 - p.getRed());
        p.setGreen(255 - p.getGreen());
        p.setBlue(255 - p.getBlue());
      }
    }
  }

  public void brighten(int amount) {
    Pixel[][] pixels = getImagePixels();
    for (Pixel[] row : pixels) {
      for (Pixel p : row) {
        p.setRed(Math.min(255, p.getRed() + amount));
        p.setGreen(Math.min(255, p.getGreen() + amount));
        p.setBlue(Math.min(255, p.getBlue() + amount));
      }
    }
  }

  public void pixelate(int size) {
    Pixel[][] pixels = getImagePixels();

    for (int r = 0; r < pixels.length; r += size) {
      for (int c = 0; c < pixels[0].length; c += size) {

        Pixel base = pixels[r][c];

        for (int i = r; i < r + size && i < pixels.length; i++) {
          for (int j = c; j < c + size && j < pixels[0].length; j++) {
            pixels[i][j].setColor(base.getColor());
          }
        }
      }
    }
  }
}

