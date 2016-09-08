package com.example.kyle.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private FactBook mFactBook = new FactBook();
    //    Declare our view variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

//        Assign th Views from the layout file to the corresponding variables
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactBook.getFact();
                int color = mColorWheel.getColor();
                //update the screen with our dynamic fact
                mFactTextView.setText(fact);
                //change background color
                mRelativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
            }
        };
        mShowFactButton.setOnClickListener(listener);
//        Toast.makeText(FunFactsActivity.this, "Yeah Toast!", Toast.LENGTH_LONG).show();
        Log.d(TAG, "We're logging from the onCreate mthd");
    }
}
