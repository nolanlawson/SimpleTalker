package com.nolanlawson.android.simpletalker;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, OnInitListener, OnUtteranceCompletedListener {

    public static final String EXTRA_TEXT = "text";
    
    
    private TextView textView;
    private Button playAgainButton;
    private TextToSpeech textToSpeech;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(android.R.id.text1);
        playAgainButton = (Button) findViewById(android.R.id.button1);
        playAgainButton.setOnClickListener(this);
        
        String text = getIntent() != null && getIntent().hasExtra(EXTRA_TEXT) 
        	? getIntent().getStringExtra(EXTRA_TEXT) : getString(R.string.default_text);
        	
        textView.setText(text);
        
        textToSpeech = new TextToSpeech(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onInit(int status) {
        textToSpeech.setOnUtteranceCompletedListener(this);
	speak();
    }
    
    @Override
    public void onClick(View v) {
	// play it again clicked
	speak();
    }
    
    private void speak() {
	String text = textView.getText().toString();
	
	HashMap<String, String> params = new HashMap<String, String>();
	params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "meaninglessString");
	textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, params);
	
    }

    @Override
    public void onUtteranceCompleted(String arg0) {
	finish();
    }
}
