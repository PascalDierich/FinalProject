package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import org.junit.Test;

/**
 * Created by Pascal Dierich on Jan, 2017.
 */
public class AsyncTask extends AndroidTestCase implements BackendConnector.JokesReady {
    private static final String LOG_TAG = AsyncTask.class.getSimpleName();

    @Test
    public void verify_Joke_From_AsyncTask_Not_Null() {
        BackendConnector backendConnector = new BackendConnector(this);
        backendConnector.execute();
    }

    @Override
    public void response(String joke) {
        assertTrue(joke != null);
    }
}
