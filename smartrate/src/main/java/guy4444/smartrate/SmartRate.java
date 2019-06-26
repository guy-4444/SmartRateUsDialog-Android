package guy4444.smartrate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SmartRate {

    public interface CallBack_UserRating {
        void userRating(int rating);
    }

    private static final long DONT_ASK_AGAIN_VALUE = -1;
    private static final String SP_LIBRARY_NAME = "SP_RATE_LIBRARY";
    private static final String SP_KEY_LAST_ASK_TIME = "SP_KEY_LAST_ASK_TIME";
    private static final String SP_KEY_INIT_TIME = "SP_KEY_INIT_TIME";
    private static int selectedStar = 1;
    private static final long DEFAULT_TIME_BETWEEN_DIALOG_MS = 1000l * 60 * 60 * 24 * 6; // 3 days
    private static final long DEFAULT_DELAY_TO_ACTIVATE_MS = 1000l * 60 * 60 * 24 * 3; // 3 days
    private static String DEFAULT_TEXT_TITLE = "Rate Us";
    private static String DEFAULT_TEXT_CONTENT = "Tell others what you think about this app";
    private static String DEFAULT_TEXT_CONTINUE = "Continue";
    private static String DEFAULT_TEXT_GOOGLE_PLAY = "Please take a moment and rate us on Google Play";
    private static String DEFAULT_TEXT_CLICK_HERE = "click here";
    private static String DEFAULT_TEXT_LATER = "Ask me later";
    private static String DEFAULT_TEXT_STOP = "Never ask again";
    private static String DEFAULT_TEXT_CANCEL = "Cancel";
    private static String DEFAULT_TEXT_THANKS = "Thanks for the feedback";

    private static boolean continueClicked = false;

    public static void Rate(
            final Activity activity
            , final int mainColor
            , final int openStoreFromXStars
            , final CallBack_UserRating callBack_userRating
    ) {
        Rate(activity
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , ""
                , mainColor
                , openStoreFromXStars
                , callBack_userRating);
    }

    public static void Rate(
            final Activity activity
            , final String _title
            , final String _content
            , final String _continue_text
            , final String _googlePlay_text
            , final String _clickHere_text
            , final String _cancel_text
            , final String _thanksForFeedback
            , final int mainColor
            , final int openStoreFromXStars
    ) {
        Rate(activity
                , _title
                , _content
                , _continue_text
                , _googlePlay_text
                , _clickHere_text
                , ""
                , ""
                , _cancel_text
                , _thanksForFeedback
                , mainColor
                , openStoreFromXStars
                , -1
                , -1);
    }

    public static void Rate(
            final Activity activity
            , final String _title
            , final String _content
            , final String _continue_text
            , final String _googlePlay_text
            , final String _clickHere_text
            , final String _cancel_text
            , final String _thanksForFeedback
            , final int mainColor
            , final int openStoreFromXStars
            , CallBack_UserRating callBack_userRating
    ) {
        Rate(activity
                , _title
                , _content
                , _continue_text
                , _googlePlay_text
                , _clickHere_text
                , ""
                , ""
                , _cancel_text
                , _thanksForFeedback
                , mainColor
                , openStoreFromXStars
                , -1
                , -1
                , callBack_userRating);
    }

    public static void Rate(
            final Activity activity
            , final String _title
            , final String _content
            , final String _continue_text
            , final String _googlePlay_text
            , final String _clickHere_text
            , final String _later_text
            , final String _stop_text
            , final String _cancel_text
            , final String _thanksForFeedback
            , final int mainColor
            , final int openStoreFromXStars
            , final int _hoursBetweenCalls
            , final int _hoursDelayToActivate
    ) {
        Rate(activity
                , _title
                , _content
                , _continue_text
                , _googlePlay_text
                , _clickHere_text
                , _later_text
                , _stop_text
                , _cancel_text
                , _thanksForFeedback
                , mainColor
                , openStoreFromXStars
                , _hoursBetweenCalls
                , _hoursDelayToActivate
                , null);
    }

    public static void Rate(
            final Activity activity
            , final String _title
            , final String _content
            , final String _continue_text
            , final String _googlePlay_text
            , final String _clickHere_text
            , final String _later_text
            , final String _stop_text
            , final String _cancel_text
            , final String _thanksForFeedback
            , final int mainColor
            , final int openStoreFromXStars
            , final int _hoursBetweenCalls
            , final int _hoursDelayToActivate
            , final CallBack_UserRating callBack_userRating
    ) {

        final String title = (_title != null && !_title.equals("")) ? _title : DEFAULT_TEXT_TITLE;
        final String content = (_content != null && !_content.equals("")) ? _content : DEFAULT_TEXT_CONTENT;
        final String continue_text = (_continue_text != null && !_continue_text.equals("")) ? _continue_text : DEFAULT_TEXT_CONTINUE;
        final String googlePlay_text = (_googlePlay_text != null && !_googlePlay_text.equals("")) ? _googlePlay_text : DEFAULT_TEXT_GOOGLE_PLAY;
        final String clickHere_text = (_clickHere_text != null && !_clickHere_text.equals("")) ? _clickHere_text : DEFAULT_TEXT_CLICK_HERE;
        final String later_text = (_later_text != null && !_later_text.equals("")) ? _later_text : DEFAULT_TEXT_LATER;
        final String stop_text = (_stop_text != null && !_stop_text.equals("")) ? _stop_text : DEFAULT_TEXT_STOP;
        final String cancel_text = (_cancel_text != null && !_cancel_text.equals("")) ? _cancel_text : DEFAULT_TEXT_CANCEL;
        final String thanksForFeedback = (_thanksForFeedback != null && !_thanksForFeedback.equals("")) ? _thanksForFeedback : DEFAULT_TEXT_THANKS;
        final long timeBetweenCalls_Ms = (_hoursBetweenCalls >= 0 && _hoursBetweenCalls < 366 * 24) ? 1000l * 60 * 60 * _hoursBetweenCalls : DEFAULT_TIME_BETWEEN_DIALOG_MS;
        final long timeDelayToActivate_Ms = (_hoursDelayToActivate >= 0 && _hoursDelayToActivate < 366 * 24) ? 1000l * 60 * 60 * _hoursDelayToActivate : DEFAULT_DELAY_TO_ACTIVATE_MS;
//        final long timeBetweenCalls_Ms = 0;
//        final long timeDelayToActivate_Ms = 0;

        continueClicked = false;
        boolean hideNeverAskAgain = false;

        if (_hoursBetweenCalls != -1 && _hoursDelayToActivate != -1) {
            // no force asking mode
            long initTime = getInitTime(activity);
            if (initTime == 0) {
                initTime = System.currentTimeMillis();
                setInitTime(activity, initTime);
            }
            if (System.currentTimeMillis() < initTime + timeDelayToActivate_Ms) {
                return;
            }

            if (getLastAskTime(activity) == 0) {
                // first time asked
                hideNeverAskAgain = true;
            }

            if (getLastAskTime(activity) == DONT_ASK_AGAIN_VALUE) {
                // user already rate or click on never ask button
                return;
            }
            if (System.currentTimeMillis() < getLastAskTime(activity) + timeBetweenCalls_Ms) {
                // There was not enough time between the calls.
                return;
            }
        }

        setLastAskTime(activity, System.currentTimeMillis());

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_rate, null);
        dialogBuilder.setView(dialogView);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);

        final RelativeLayout alert_LAY_back = dialogView.findViewById(R.id.alert_LAY_back);
        final AppCompatButton alert_BTN_ok = dialogView.findViewById(R.id.alert_BTN_ok);
        final Button alert_BTN_later = dialogView.findViewById(R.id.alert_BTN_later);
        final Button alert_BTN_stop = dialogView.findViewById(R.id.alert_BTN_stop);
        final TextView alert_LBL_title = dialogView.findViewById(R.id.alert_LBL_title);
        final TextView alert_LBL_content = dialogView.findViewById(R.id.alert_LBL_content);
        final TextView alert_LBL_google = dialogView.findViewById(R.id.alert_LBL_google);
        final View alert_LAY_stars = dialogView.findViewById(R.id.alert_LAY_stars);
        final ImageView alert_IMG_google = dialogView.findViewById(R.id.alert_IMG_google);
        final ImageButton alert_BTN_star_1 = dialogView.findViewById(R.id.alert_BTN_star_1);
        final ImageButton alert_BTN_star_2 = dialogView.findViewById(R.id.alert_BTN_star_2);
        final ImageButton alert_BTN_star_3 = dialogView.findViewById(R.id.alert_BTN_star_3);
        final ImageButton alert_BTN_star_4 = dialogView.findViewById(R.id.alert_BTN_star_4);
        final ImageButton alert_BTN_star_5 = dialogView.findViewById(R.id.alert_BTN_star_5);
        final ImageButton[] stars = new ImageButton[]{alert_BTN_star_1, alert_BTN_star_2, alert_BTN_star_3, alert_BTN_star_4, alert_BTN_star_5};


        alert_LBL_google.setVisibility(View.GONE);
        alert_IMG_google.setVisibility(View.GONE);
        alert_LAY_back.setBackgroundColor(mainColor);
        alert_BTN_ok.getBackground().setColorFilter(mainColor, PorterDuff.Mode.MULTIPLY);
        alert_LBL_title.setTextColor(mainColor);
        alert_LBL_content.setTextColor(mainColor);
        alert_BTN_later.setTextColor(Color.parseColor(shadeColor(String.format("#%06X", 0xFFFFFF & mainColor), -33)));
        alert_BTN_stop.setTextColor(Color.parseColor(shadeColor(String.format("#%06X", 0xFFFFFF & mainColor), -33)));


        final int drawable_active = R.drawable.ic_star_active;
        final int drawable_deactive = R.drawable.ic_star_deactive;

        View.OnClickListener starsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedIndex = -1;
                for (int i = 0; i < stars.length; i++) {
                    if (stars[i].getId() == v.getId()) {
                        clickedIndex = i;
                        break;
                    }
                }

                if (clickedIndex != -1) {
                    for (int i = 0; i <= clickedIndex; i++) {
                        stars[i].setImageResource(drawable_active);
                    }
                    for (int i = clickedIndex + 1; i < stars.length; i++) {
                        stars[i].setImageResource(drawable_deactive);
                    }
                }

                alert_BTN_ok.setEnabled(true);
                alert_BTN_ok.setText((clickedIndex + 1) + "/5\n" + continue_text);
                selectedStar = clickedIndex + 1;
            }
        };

        alert_BTN_star_1.setOnClickListener(starsClickListener);
        alert_BTN_star_2.setOnClickListener(starsClickListener);
        alert_BTN_star_3.setOnClickListener(starsClickListener);
        alert_BTN_star_4.setOnClickListener(starsClickListener);
        alert_BTN_star_5.setOnClickListener(starsClickListener);


        alert_LBL_title.setText(title);
        alert_LBL_content.setText(content);


        if (continue_text != null && !continue_text.equals("")) {
            alert_BTN_ok.setText(continue_text);
            alert_BTN_ok.setText("?/5\n" + continue_text);
            alert_BTN_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int _openStoreFrom_Stars = openStoreFromXStars;
                    if (openStoreFromXStars < 1 || openStoreFromXStars > 5) {
                        _openStoreFrom_Stars = 4;
                    }

                    if (continueClicked) {
                        setLastAskTime(activity, DONT_ASK_AGAIN_VALUE);


                        if (selectedStar >= _openStoreFrom_Stars) {
                            launchMarket(activity);
                        } else {
                            Toast.makeText(activity, thanksForFeedback, Toast.LENGTH_SHORT).show();
                        }
                        alertDialog.dismiss();
                    } else {
                        if (openStoreFromXStars != -1 && selectedStar >= _openStoreFrom_Stars) {
                            continueClicked = true;

                            alert_LBL_title.setVisibility(View.GONE);
                            alert_LBL_content.setVisibility(View.GONE);
                            alert_LAY_stars.setVisibility(View.GONE);
                            alert_BTN_stop.setVisibility(View.GONE);
                            alert_LBL_google.setVisibility(View.VISIBLE);
                            alert_IMG_google.setVisibility(View.VISIBLE);
                            alert_LBL_google.setText(googlePlay_text);
                            alert_BTN_ok.setText(clickHere_text);
                            alert_BTN_later.setText(cancel_text);

                            //String text = googlePlay_text + "\n(" + clickHere_text + ")";
                            //Spannable span = new SpannableString(text);
                            //span.setSpan(new RelativeSizeSpan(0.7f), 0, googlePlay_text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            //span.setSpan(new RelativeSizeSpan(0.4f), googlePlay_text.length(), text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            //alert_BTN_ok.setText(span);
                        } else {
                            alertDialog.dismiss();
                            Toast.makeText(activity, thanksForFeedback, Toast.LENGTH_SHORT).show();
                        }
                    }

                    if (callBack_userRating != null) {
                        callBack_userRating.userRating(selectedStar);
                    }

                }
            });
        } else {
            alert_BTN_ok.setVisibility(View.INVISIBLE);
        }
        alert_BTN_ok.setEnabled(false);

        if (hideNeverAskAgain) {
            alert_BTN_stop.setVisibility(View.GONE);
        }

        if (later_text != null && !later_text.equals("")) {
            alert_BTN_later.setText(later_text);
            alert_BTN_later.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    alertDialog.dismiss();
                }
            });
        } else {
            alert_BTN_later.setVisibility(View.INVISIBLE);
        }

        if (stop_text != null && !stop_text.equals("")) {
            alert_BTN_stop.setText(stop_text);
            alert_BTN_stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setLastAskTime(activity, DONT_ASK_AGAIN_VALUE);
                    alertDialog.dismiss();
                }
            });
        } else {
            alert_BTN_stop.setVisibility(View.GONE);
        }


        if (_hoursBetweenCalls == -1 && _hoursDelayToActivate == -1) {
            // force asking mode
            alert_BTN_later.setText(cancel_text);
            alert_BTN_stop.setVisibility(View.GONE);
        }

        alertDialog.show();
    }

    private static void launchMarket(Activity activity) {
        Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            activity.startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, " unable to find google play app", Toast.LENGTH_LONG).show();
        }
    }

    private static long getLastAskTime(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SP_LIBRARY_NAME, Context.MODE_PRIVATE);
        long val = sharedPreferences.getLong(SP_KEY_LAST_ASK_TIME, 0);
        return val;
    }

    private static void setLastAskTime(Activity activity, long time) {
        SharedPreferences.Editor editor = activity.getSharedPreferences(SP_LIBRARY_NAME, Context.MODE_PRIVATE).edit();
        editor.putLong(SP_KEY_LAST_ASK_TIME, time);
        editor.apply();
    }

    private static long getInitTime(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SP_LIBRARY_NAME, Context.MODE_PRIVATE);
        long val = sharedPreferences.getLong(SP_KEY_INIT_TIME, 0);
        return val;
    }

    private static void setInitTime(Activity activity, long time) {
        SharedPreferences.Editor editor = activity.getSharedPreferences(SP_LIBRARY_NAME, Context.MODE_PRIVATE).edit();
        editor.putLong(SP_KEY_INIT_TIME, time);
        editor.apply();
    }

    private static String shadeColor(String color, int percent) {

        int R = Integer.parseInt(color.substring(1, 3), 16);
        int G = Integer.parseInt(color.substring(3, 5), 16);
        int B = Integer.parseInt(color.substring(5, 7), 16);

        R = R * (100 + percent) / 100;
        G = G * (100 + percent) / 100;
        B = B * (100 + percent) / 100;

        R = (R < 255) ? R : 255;
        G = (G < 255) ? G : 255;
        B = (B < 255) ? B : 255;

        String RR = (Integer.toString(R, 16).length() == 1) ? "0" + Integer.toString(R, 16) : Integer.toString(R, 16);
        String GG = (Integer.toString(G, 16).length() == 1) ? "0" + Integer.toString(G, 16) : Integer.toString(G, 16);
        String BB = (Integer.toString(B, 16).length() == 1) ? "0" + Integer.toString(B, 16) : Integer.toString(B, 16);

        return "#" + RR + GG + BB;
    }
}
