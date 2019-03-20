package zbc.assignment.picturepalette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class pictureactivity extends AppCompatActivity implements CallModel.View {

    ImageView imageView;
    Bitmap bmp;
    CallModel callModel;
    TextView firstMostColourTextView;
    TextView secondMostColourTextView;
    TextView thirdMostColourTextView;
    TextView fourthMostColourTextView;
    TextView fifthMostColourTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictureactivity);
        imageView = findViewById(R.id.imageView);
        firstMostColourTextView = findViewById(R.id.FirstMostColour);
        secondMostColourTextView = findViewById(R.id.SecondMostColour);
        thirdMostColourTextView = findViewById(R.id.ThirdMostColour);
        fourthMostColourTextView = findViewById(R.id.FourthMostColour);
        fifthMostColourTextView = findViewById(R.id.FifthMostColour);
        callModel = new CallModel(this);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imageView.setImageBitmap(bmp);

        int first = callModel.getPixelColor()[callModel.getPixelColor().length - 1];
        int second = callModel.getPixelColor()[callModel.getPixelColor().length - 2];
        int third = callModel.getPixelColor()[callModel.getPixelColor().length - 3];
        int fourth = callModel.getPixelColor()[callModel.getPixelColor().length - 4];
        int fifth = callModel.getPixelColor()[callModel.getPixelColor().length - 5];

        firstMostColourTextView.setText(Integer.toString(first));
        secondMostColourTextView.setText(Integer.toString(second));
        thirdMostColourTextView.setText(Integer.toString(third));
        fourthMostColourTextView.setText(Integer.toString(fourth));
        fifthMostColourTextView.setText(Integer.toString(fifth));
    }


    @Override
    public Bitmap bitmapOut() {
        return bmp;
    }
}
