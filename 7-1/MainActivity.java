package com.example.newthread;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView0;
    ProgressBar bar;
//    Handler handler;
    ProgressHandler handler;
//    ProgressRunnable runnable;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView0 = (TextView) findViewById(R.id.TextView01);
        bar = (ProgressBar) findViewById(R.id.progress);

        handler = new ProgressHandler();
//        runnable = new ProgressRunnable();
    }

    @Override
    protected void onStart() {
        super.onStart();
        bar.setProgress(0);
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    for (int i=0; i<20 && isRunning; i++){
                        Thread.sleep(1000);
//                        handler.post(runnable);
                        Message msg = handler.obtainMessage();
                        handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    Log.e("MainActivity", "Exception in processing Message.", e);
                }
            }
        });
        isRunning = true;
        thread1.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
    }

    public class ProgressHandler extends Handler {
        public void handleMessage(Message msg){
            bar.incrementProgressBy(5);
            if (bar.getProgress() == bar.getMax()){
                textView0.setText("DONE!");
            }else {
                textView0.setText("WORKING..." + bar.getProgress());
            }
        }
    }

    private class ProgressRunnable implements Runnable {
        @Override
        public void run() {
            bar.incrementProgressBy(5);

            if (bar.getProgress() == bar.getMax()){
                textView0.setText("DONE!");
            }else {
                textView0.setText("WORKING..." + bar.getProgress());
            }
        }
    }
}

