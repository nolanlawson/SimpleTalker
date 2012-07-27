SimpleTalker
=========

Author
======
Nolan Lawson

License
=======
[WTFPL][1], although attribution would be nice.


Overview
========
Simple application, intended to be used from the command line to speak aloud some text.  Can be used via adb like so:

```
adb shell am start -n com.nolanlawson.android.simpletalker/.MainActivity \
    -e text "This is my text" \
    -e song "/sdcard/someSong.mp3" \
    -e songDuration 60
```

[1]: http://sam.zoy.org/wtfpl/
