package zbc.assignment.picturepalette;

import android.graphics.Bitmap;

public class CallModel {

    public interface View {
        Bitmap bitmapOut();
    }

    FindPixels findPixels = new FindPixels();

    //Hold the view
    private View view;

    public CallModel(View view){
        this.view = view;
    }

    public Bitmap getBitmapOut(){
        return view.bitmapOut();
    }

    public int getPixelColor(){

        return findPixels.findPixels(getBitmapOut());
    }



}
