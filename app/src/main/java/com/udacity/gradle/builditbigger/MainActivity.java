package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.pascaldierich.jokepresenter.PresenterActivity;


public class MainActivity extends AppCompatActivity implements BackendConnector.JokesReady {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    

    @Override
    public void response(String joke) {
        Intent jokeIntent = new Intent(this, PresenterActivity.class);
        if (joke == null) joke = getString(R.string.emergency_joke); // Emergency Joke :D

        jokeIntent.putExtra(getString(R.string.intent_key), joke);

        startActivity(jokeIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

//        this.jokeDB = new com.example.MyClass();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        BackendConnector backendConnector = new BackendConnector(this);
        backendConnector.execute();

//        String joke = jokeDB.getJoke();
//        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }


}
