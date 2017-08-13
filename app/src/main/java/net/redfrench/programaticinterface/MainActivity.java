package net.redfrench.programaticinterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        // CREATE LAYOUT
        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.BLUE);


        // CREATE BUTTON
        Button myBtn = new Button(this);
        myBtn.setBackgroundColor(Color.GREEN);
        myBtn.setText("Click Here");


        // create layout rule for positioning button
        RelativeLayout.LayoutParams buttonPosition =
                new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        buttonPosition.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonPosition.addRule(RelativeLayout.CENTER_VERTICAL);

//        myBtn.setLayoutParams(buttonPosition);
//        myLayout.addView(myBtn);

        myLayout.addView(myBtn, buttonPosition);  // does same as 2 lines above


        // CREATE INPUT
        EditText userName = new EditText(this);

        myBtn.setId(1);
        userName.setId(2);

        // create layout rule for userName input
        RelativeLayout.LayoutParams userNamePosition =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        userNamePosition.addRule(RelativeLayout.ABOVE, myBtn.getId());  // position username above the button
        userNamePosition.addRule(RelativeLayout.CENTER_HORIZONTAL);

        Resources r = getResources();  // method is used to get resources associated with device

        // convert dp to px
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());  // params: unit to translate, #units to translate, display metrics
        userName.setWidth(px);  // setWidth only accepts px values, so dp to px conversion is done above to keep things consistent

        userNamePosition.setMargins(0, 0, 0, 50);


        // DISPLAY PROGRAMMED UI
        myLayout.addView(userName, userNamePosition);
        setContentView(myLayout);

    }

}
