# SmartRateUsDialog-Android
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/vlad1m1r990/Lemniscate/blob/master/LICENSE)
[![](https://jitpack.io/v/guy-4444/SmartRateUsDialog-Android.svg)](https://jitpack.io/#guy-4444/SmartRateUsDialog-Android)
[![API](https://img.shields.io/badge/API-18%2B-green.svg?style=flat)]()

A library for simple implementation of smart ranking.
The user will see a dialog every x time.
If the user gives a high score, he will be transferred to the Google store. If he gives a low score, he will only receive a thank you toast message.

![device-2018-06-06-144912](https://github.com/guy-4444/SmartRateUsDialog-Android/blob/master/screen%20shot.png?raw=true)
![device-2018-06-06-144912](https://github.com/guy-4444/SmartRateUsDialog-Android/blob/master/screen%20shot%202.png?raw=true)

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
	        implementation 'com.github.guy-4444:SmartRateUsDialog-Android:1.00.03'
}
```
## Usage

###### StepProgress Constructor:
```java

    // For one time call
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

    // For continual calls - 
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
    	, 48
    	, 72
    );
```

![device-2018-06-06-144912](https://github.com/guy-4444/SmartRateUsDialog-Android/blob/master/desc.png?raw=true)


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


