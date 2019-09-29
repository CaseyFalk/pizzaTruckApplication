package com.grizzhacks.pizzatruck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StopActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        buttonStop = (Button) findViewById(R.id.buttonStop);

        //attaching listener to button
        buttonStop.setOnClickListener(this);
    }

    private void onButtonStop() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("172.20.10.4/gpio/1"));
        startActivity(browserIntent);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonStop) {
            onButtonStop();
        }
    }

}
