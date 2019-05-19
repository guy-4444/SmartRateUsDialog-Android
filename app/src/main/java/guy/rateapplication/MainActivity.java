package guy.rateapplication;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import guy4444.smartrate.SmartRate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmartRate.Rate(MainActivity.this
                        , "Rate Us"
                        , "Tell others what you think about this app"
                        , "Continue"
                        , "Please take a moment and rate us on Google Play"
                        , "click here"
                        , "Ask me later"
                        , "Never ask again"
                        , "Thanks for the feedback"
                        , Color.parseColor("#2196F3")
                        , 4
                        , 1
                        , 24
                );

//                SmartRate.Rate(MainActivity.this
//                        , "Rate Us"
//                        , "Tell others what you think about this app"
//                        , "Continue"
//                        , "Please take a moment and rate us on Google Play"
//                        , "click here"
//                        , "Cancel"
//                        , "Thanks for the feedback"
//                        , Color.parseColor("#2196F3")
//                        , 4
//                );
//
//                SmartRate.Rate(MainActivity.this
//                        , "Rate Us"
//                        , "Tell others what you think about this app"
//                        , "Continue"
//                        , "Please take a moment and rate us on Google Play"
//                        , "click here"
//                        , "Cancel"
//                        , "Thanks for the feedback"
//                        , Color.parseColor("#2196F3")
//                        , 4
//                        , new SmartRate.CallBack_UserRating() {
//                            @Override
//                            public void userRating(int rating) {
//                                // Do something
//                                // from now disable this option
//                            }
//                        }
//                );

//                SmartRate.Rate(MainActivity.this
//                        , "דרג אותנו"
//                        , "שתף עם אחרים מה אתה חושב עלינו"
//                        , "המשך"
//                        , "בבקשה דרג אותנו גם בחנות גוגל"
//                        , "לחץ כאו"
//                        , "ביטול"
//                        , "תודה על הדירוג"
//                        , Color.parseColor("#E44643")
//                        , 4
//                );
            }
        });
    }


}
