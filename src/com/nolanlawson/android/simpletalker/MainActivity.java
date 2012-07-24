package com.nolanlawson.android.simpletalker;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnInitListener, OnClickListener {

    public static final String EXTRA_TEXT = "text";
    
    
    private TextView textView;
    private TextToSpeech textToSpeech;
    private Button playAgainButton;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(android.R.id.text1);
        playAgainButton = (Button) findViewById(android.R.id.button1);
        playAgainButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onInit(int status) {
	speak();
    }
    
    @Override
    public void onResume() {
	super.onResume();
	
        String text = getIntent() != null && getIntent().hasExtra(EXTRA_TEXT) 
        	? getIntent().getStringExtra(EXTRA_TEXT) : getString(R.string.default_text);
        	
        textView.setText(text);
        
        textToSpeech = new TextToSpeech(this, this);
    }

    @Override
    public void onClick(View v) {
	// play it again clicked
	speak();
    }
    
    private void speak() {
	String text = textView.getText().toString();
	textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    
}
