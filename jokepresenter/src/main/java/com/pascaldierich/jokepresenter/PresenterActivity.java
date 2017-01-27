package com.pascaldierich.jokepresenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PresenterActivity extends AppCompatActivity {
    Intent jokeIntent;
    TextView jokeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presenter);

        jokeIntent = getIntent();
        jokeView = (TextView) findViewById(R.id.jokeView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // show Joke
        try {
            String joke = jokeIntent.getStringExtra(getString(R.string.intent_key));
            jokeView.setText(joke);
        } catch (NullPointerException e) {
            jokeView.setText(R.string.error_message);
        }
    }
}
