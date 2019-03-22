package zbc.assignment.picturepalette;

import android.graphics.Bitmap;

import java.util.HashMap;

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

        /*Rect rect = new Rect(0,0,100,100);
        Bitmap bitmaptestred = Bitmap.createBitmap(rect.width(),rect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmaptestred);
        int redpaint = Color.argb(255,66,244,220);
        Paint paint = new Paint();
        paint.setColor(redpaint);
        canvas.drawRect(rect,paint);

        return bitmaptestred;*/

    }

    public HashMap<String, Integer> getPixelColor(){

        return findPixels.findPixels(getBitmapOut());
    }



}
