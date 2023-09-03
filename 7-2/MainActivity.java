package com.example.asynktaskdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvCounter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCounter = (TextView) findViewById(R.id.tv_counter);

        new CountDownTask().execute();
    }

    public class CountDownTask extends AsyncTask<Void, Integer, Void> {

        protected void onPreExecute() {
            tvCounter.setText("*START*");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 15; i >= 0; i--) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            tvCounter.setText(Integer.toString(values[0].intValue()));
        }

        @Override
        protected void onPostExecute(Void unused) {
            tvCounter.setText("*DONE*");
        }
    }
}