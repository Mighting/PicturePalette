package zbc.assignment.picturepalette;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPixels {

    private HashMap<String, Integer> hexmap = new HashMap<>();
    String hexcode;


    // Make it run on a new Thread instead of Raping the Main Thread
    Integer[] findPixels(Bitmap bitmap) {

        for (int x = 0; x <= bitmap.getWidth() - 1; x++) {
            for (int y = 0; y <= bitmap.getHeight() - 1; y++) {
                int pixel = bitmap.getPixel(x, y);
                int red = Color.red(pixel);
                int blue = Color.blue(pixel);
                int green = Color.green(pixel);

                hexcode = String.format(String.format("#%02x%02x%02x", red, green, blue));
                if (hexmap.containsKey(hexcode)) {
                    //Add to Value
                    hexmap.put(hexcode, hexmap.get(hexcode) + 1);
                } else {
                    //Add to map
                    hexmap.put(hexcode, 1);
                }
            }
        }


        //Create a loop to add the hexcodes from the MAP to the ARRAY instead of this shit.
        Integer[] colourCount;
        String[] hexcodeinMap;


        colourCount = hexmap.values().toArray(new Integer[hexmap.size()]);
        Arrays.sort(colourCount);







        return colourCount;

    }
    //Learn to override my Equals method so that i can sort after biggest Value is nmy map

    // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object o) {
        HexAndValueHolder hexAndValueHolder;

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof HexAndValueHolder)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        HexAndValueHolder c = (HexAndValueHolder) o;

        // Compare the data members and return accordingly
        return Double.compare(re, c.re) == 0
                && Double.compare(im, c.im) == 0;
    }
}

    public HexAndValueHolder[] combined(HashMap<String, Integer> hexmap) {

        HexAndValueHolder[] hexAndValueHoldersArray = new HexAndValueHolder[hexmap.size()];

        for (Map.Entry<String, Integer> entry : hexmap.entrySet()) {
            int i = 0;
            HexAndValueHolder hexAndValueHolder = new HexAndValueHolder(entry.getKey(), entry.getValue());
            hexAndValueHoldersArray[i] = hexAndValueHolder;
            i++;
        }




        return hexAndValueHoldersArray;

    }


}
