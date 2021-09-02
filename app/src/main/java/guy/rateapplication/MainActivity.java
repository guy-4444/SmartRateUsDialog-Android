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

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import guy4444.smartrate.SmartRate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // first call after 3 days, the dialog will appear every 2 days until the user rates the app / or clicks on NEVER ASK AGAIN button
//                SmartRate.Rate(MainActivity.this
//                        , "Rate Us"
//                        , "Tell others what you think about this app"
//                        , "Continue"
//                        , "Please take a moment and rate us on Google Play"
//                        , "click here"
//                        , "Ask me later"
//                        , "Never ask again"
//                        , "Cancel"
//                        , "Thanks for the feedback"
//                        , Color.parseColor("#0878D1")
//                        , 4
//                        , 0
//                        , 0
//                );

                SmartRate.Rate(MainActivity.this
                        , Color.parseColor("#E44643")
                        , -1
                        , new SmartRate.CallBack_UserRating() {
                            @Override
                            public void userRating(int rating) {
                                Toast.makeText(MainActivity.this, "Rating: " + rating + " Stars", Toast.LENGTH_LONG).show();
                                //saveUserRating(rating);
                            }
                        }
                );

//                SmartRate.Rate(MainActivity.this
//                        , "Rate Us"
//                        , "Tell others what you think about this app"
//                        , "Continue"
//                        , "Please take a moment and rate us on Google Play"
//                        , "click here"
//                        , "Cancel"
//                        , "Thanks for the feedback"
//                        , Color.parseColor("#E44643")
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
//                        , Color.parseColor("#0878D1")
//                        , 4
//                        , new SmartRate.CallBack_UserRating() {
//                            @Override
//                            public void userRating(int rating) {
//                                // Do something
//                                // maybe from now disable this button
//                            }
//                        }
//                );
//
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
