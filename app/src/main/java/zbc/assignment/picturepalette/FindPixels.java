package zbc.assignment.picturepalette;

import android.graphics.Bitmap;
import android.graphics.Color;

public class FindPixels {

    int findPixels(Bitmap bitmap){
        int pixel = bitmap.getPixel(bitmap.getWidth() - 1,bitmap.getHeight() - 1);
        int redValue = Color.red(pixel);
        return redValue;
        //int blueValue = Color.blue(pixel);
        //int greenValue = Color.green(pixel);

    }


}
