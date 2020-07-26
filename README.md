# SmartRateUsDialog-Android
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/vlad1m1r990/Lemniscate/blob/master/LICENSE)
[![](https://jitpack.io/v/guy-4444/SmartRateUsDialog-Android.svg)](https://jitpack.io/#guy-4444/SmartRateUsDialog-Android)
[![API](https://img.shields.io/badge/API-18%2B-green.svg?style=flat)]()

A library for simple implementation of smart ranking.
The user will see a dialog every x time.
If the user gives a high score, he will be transferred to the Google store. If he gives a low score, he will only receive a thank you toast message.

<img src="https://raw.githubusercontent.com/guy-4444/SmartRateUsDialog-Android/master/sc_1.png" width="288">
<img src="https://raw.githubusercontent.com/guy-4444/SmartRateUsDialog-Android/master/sc_2.png" width="288">

<img src="https://raw.githubusercontent.com/guy-4444/SmartRateUsDialog-Android/master/sc_5.png" width="512">
<img src="https://raw.githubusercontent.com/guy-4444/SmartRateUsDialog-Android/master/sc_6.png" width="512">

## Setup
Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
	maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency:

```
dependencies {
	implementation 'com.github.guy-4444:SmartRateUsDialog-Android:1.00.08'
}
```
## Usage

###### StepProgress Constructor:
```java

// For continual calls - 
// first call after 3 days, the dialog will appear every 2 days until the user rates the app / or clicks on NEVER ASK AGAIN button
// the number 4 represents the minimum stars to be shown
// the 48 represents 48h and is going to be shown after 2 days
// the 72 represents 72h delay and the dialog is going to be shown after 3 days more
SmartRate.Rate(MainActivity.this
        , "Rate Us"
        , "Tell others what you think about this app"
        , "Continue"
        , "Please take a moment and rate us on Google Play"
        , "click here"
        , "Ask me later"
        , "Never ask again"
        , "Cancel"
        , "Thanks for the feedback"
        , Color.parseColor("#2196F3")
        , 4
        , 48
        , 72
);

// For one time call
// it will appear after 3 days by default
// the number 4 represents the minimum stars to be shown
SmartRate.Rate(MainActivity.this
        , "Rate Us"
        , "Tell others what you think about this app"
        , "Continue"
        , "Please take a moment and rate us on Google Play"
        , "click here"
        , "Cancel"
        , "Thanks for the feedback"
        , Color.parseColor("#2196F3")
        , 4
);

// With Call Back:
// it will appear after 3 days
// the number 4 represents the minimum stars to be shown
SmartRate.Rate(MainActivity.this
        , "Rate Us"
        , "Tell others what you think about this app"
        , "Continue"
        , "Please take a moment and rate us on Google Play"
        , "click here"
        , "Cancel"
        , "Thanks for the feedback"
        , Color.parseColor("#2196F3")
        , 4
        , new SmartRate.CallBack_UserRating() {
            @Override
            public void userRating(int rating) {
                // Do something
                // maybe from now disable this button
            }
        }
);

// Self implement without link to google play store:
// -1 on stars
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

```

![device-2018-06-06-144912](https://github.com/guy-4444/SmartRateUsDialog-Android/blob/master/desc.png?raw=true)

## What's new
1.1.0.0:
1. Upgraded to AndroidX
2. Added basic documentation

## License

    Copyright 2019 Guy Isakov

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

## Credits

5 stars icon:
Icon made by Flat Icons (www.flat-icons.com) from www.flaticon.com
Google play icon:
Icon made by Flat Icons (www.flat-icons.com) from www.flaticon.com

