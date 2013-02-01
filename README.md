SimpleTalker
=========

Speak some text aloud using the Android TTS (text-to-speech) engine.  Designed to be used from the command line, since the text is immediately
spoken when the main activity starts up, and then the app closes afterwards.

Optionally, may also play a song from the phone storage after speaking the text.

Author
-------
Nolan Lawson

License
--------
[WTFPL][1], although attribution would be nice.

Download
--------

[Direct APK download link][3]

Usage
---------
This app is intended to be used from the command line.  For instance, we use it at my office to notify us when someone breaks the Jenkins build, and then speak aloud the person who broke the build and the broken module. ([Video demonstration.][2])

Can be used via ```adb``` (from the [Android SDK][4]) like so:

```
adb shell am start -n com.nolanlawson.android.simpletalker/.MainActivity \
    -e text "This is my text" \
    -e song "/sdcard/someSong.mp3" \
    -e songDuration 60
```

Arguments:

* **text** - The text to speak, in English.
* **song** (optional) - Full file path of a song on the Android device to play.
* **songDuration** (optional) - Number of seconds after which to stop playing the song.  Defaults to 10.

[1]: http://sam.zoy.org/wtfpl/
[2]: http://www.youtube.com/watch?v=xc4bI5aBwf4&feature=share&list=PLwCo1rtJj6B9T1MbJKUJ16d0xB6E6o2hE
[3]: http://nolanlawson.s3.amazonaws.com/dist/com.nolanlawson.android.simpletalker/release/1.0/Simple-Talker.apk
[4]: http://developer.android.com/sdk/index.html
