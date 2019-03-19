package zbc.assignment.picturepalette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class pictureactivity extends AppCompatActivity implements CallModel.View {

    ImageView imageView;
    Bitmap bmp;
    CallModel callModel;
    TextView redcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictureactivity);
        imageView = findViewById(R.id.imageView);
        redcolor = findViewById(R.id.RedColourValue);
        callModel = new CallModel(this);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imageView.setImageBitmap(bmp);

        int red = callModel.getPixelColor();

        redcolor.setText(Integer.toString(red));
    }


    @Override
    public Bitmap bitmapOut() {
        return bmp;
    }
}
