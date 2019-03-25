package zbc.assignment.picturepalette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class pictureactivity extends AppCompatActivity implements CallModel.View {

    ImageView imageView;
    Bitmap bmp;
    CallModel callModel;
    TextView firstMostColourTextView;
    TextView secondMostColourTextView;
    TextView thirdMostColourTextView;
    TextView fourthMostColourTextView;
    TextView fifthMostColourTextView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

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
        button1 = findViewById(R.id.ColourShower1);
        button2 = findViewById(R.id.ColourShower2);
        button3 = findViewById(R.id.ColourShower3);
        button4 = findViewById(R.id.ColourShower4);
        button5 = findViewById(R.id.ColourShower5);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);

        callModel = new CallModel(this);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imageView.setImageBitmap(bmp);

        HashMap<String, Integer> hexmap = callModel.getPixelColor();
        String[] hexcodes = hexmap.keySet().toArray(new String[5]);

        firstMostColourTextView.setText(Integer.toString(hexmap.get(hexcodes[0])));
        secondMostColourTextView.setText(Integer.toString(hexmap.get(hexcodes[1])));
        thirdMostColourTextView.setText(Integer.toString(hexmap.get(hexcodes[2])));
        fourthMostColourTextView.setText(Integer.toString(hexmap.get(hexcodes[3])));
        fifthMostColourTextView.setText(Integer.toString(hexmap.get(hexcodes[4])));

        button1.setBackgroundColor(Color.parseColor(hexcodes[0]));
        button2.setBackgroundColor(Color.parseColor(hexcodes[1]));
        button3.setBackgroundColor(Color.parseColor(hexcodes[2]));
        button4.setBackgroundColor(Color.parseColor(hexcodes[3]));
        button5.setBackgroundColor(Color.parseColor(hexcodes[4]));
    }


    @Override
    public Bitmap bitmapOut() {
        return bmp;
    }
}
