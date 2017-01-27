package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.pascaldierich.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Pascal Dierich on Jan, 2017.
 */
class BackendConnector extends AsyncTask<Void, Void, String> {
    private static final String LOG_TAG = BackendConnector.class.getSimpleName();

    private static MyApi sMyApi = null;

    private BackendResponse response;

    @Override
    protected String doInBackground(Void... params) {
        if (sMyApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    })
                    .setApplicationName("BuildItBigger");

            sMyApi = builder.build();
        }

        try {
            return sMyApi.getJoke().execute().getData();
        } catch (IOException e) {
            Log.d(LOG_TAG, "doInBackground: IOException! return error Message");
            Log.e(LOG_TAG, "doInBackground: StackTrace: ", e.fillInStackTrace());
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        response = new MainActivity();
        response.response(joke);
    }

}

