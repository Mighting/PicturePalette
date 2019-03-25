package zbc.assignment.picturepalette;

import android.graphics.Bitmap;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindPixels {

    private HashMap<String, Integer> hexmap = new HashMap<>();
    String hexcode;


    // Make it run on a new Thread instead of Raping the Main Thread
    HashMap<String, Integer> findPixels(Bitmap bitmap) {

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


        hexmap = (HashMap<String, Integer>) sortByValue(hexmap);


        return hexmap;

    }


    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(HashMap<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue());


        Map<K, V> result = new LinkedHashMap<>();
        for (int i = list.size()-1; i > list.size() - 6; i --) {
            if(result.containsKey("#ffffff")){
                result.remove(list.get(i));
            }
            else if(result.containsKey("#000000")){
                result.remove(list.get(i));
            }
            result.put(list.get(i).getKey(), list.get(i).getValue());
        }

        return result;
    }


}
