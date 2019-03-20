package zbc.assignment.picturepalette;

import android.graphics.Bitmap;

import java.util.HashMap;

public class FindPixels {

    HashMap<String,Integer> hexmap = new HashMap<>();


    int[] findPixels(Bitmap bitmap) {


        for (int x = 0; x <= bitmap.getWidth() - 1; x++) {
            for (int y = 0; y <= bitmap.getHeight() - 1; y++) {
                int pixel = bitmap.getPixel(x,y);
                String hexcode = String.format(String.format("#%02x%02x%02x",pixel));
                if (hexmap.containsKey(hexcode)){
                    //Add to Value

                }
                else{
                    //Add to map
                }
            }
        }


        int[] colorvalues = new int[9];

        return colorvalues;

    }


}
