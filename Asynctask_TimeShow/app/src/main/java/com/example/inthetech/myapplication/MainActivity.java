package com.example.inthetech.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private AsyncTask<Void, Void, Void> mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        ShowTimeMethod();
    }

    public void ShowTimeMethod()
    {
        mTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                while (true)
                {
                    try
                    {
                        publishProgress();
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
            @Override
            protected void onProgressUpdate(Void... progress)
            {
                textView.setText(DateFormat.getDateTimeInstance().format(new Date()));
            }
        };
        mTask.execute();
    }
}
